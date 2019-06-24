package com.ryg.chapter_2.demo2;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class AsyncTaskLoaderData implements LoaderManager.LoaderCallbacks<String> {
    private static final String TAG = "AsyncTaskLoaderData";

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle args) {
        Log.d(TAG, "[loadInBac1] mGithubJson  onCreateLoader");

        return new AsyncTaskLoader<String>(MyApplication.getMyApplicationContext()) {
            String mGithubJson;

            @Override
            protected void onStartLoading() {
                //首次进入时执行
//                if (args == null) {
//                    return;
//                }

                //首次mGithubJson为空，forceLoad执行。
                if (mGithubJson != null) {
                    Log.d(TAG, "[loadInBac1] mGithubJson" + mGithubJson);
                    deliverResult(mGithubJson);
                } else {
                    forceLoad();
                }
            }

            @Nullable
            @Override
            public String loadInBackground() {
//                assert args != null;
                String searchQueryUrlString = "http://cache.video.iqiyi.com/jp/avlist/202861101/1/?callback=jsonp9";
                try {
                    URL githubUrl = new URL(searchQueryUrlString);
                    Log.d(TAG, "NetworkUtils.getResponseFromHttpUrl:" + NetworkUtils.getResponseFromHttpUrl(githubUrl));

                    return NetworkUtils.getResponseFromHttpUrl(githubUrl);
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            //分发loadInBackground（）方法返回的结果
            @Override
            public void deliverResult(@Nullable String githubJson) {
                mGithubJson = githubJson;
                super.deliverResult(githubJson);
            }
        };
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {
        if (s == null) {
            Log.d(TAG, "not get data");
        }

        Log.d(TAG, "the data is :" + getJson());
        parseJSONWithGSON(getJson());

    }

    /**
     * 处理json字符串(截取，插入，去空格)
     *
     * @param s
     */
    private String CutOutString(String s) {
        String keystring = "\\[\\{(.*?)\\}\\]";
        String cutstring = (new RegexUtil()).getSubUtil(s, keystring).toString();
        StringBuffer stringBuffer = new StringBuffer(cutstring);
        stringBuffer.insert(1, '{');
        String finalstring = stringBuffer.toString().replace(" ", "");
        shoutLog(finalstring);
        return finalstring;
    }

    /**
     * 解决log太长无法全部打印的问题
     *
     * @param msg
     */
    private void shoutLog(String msg) {
        int max_str_length = 2001 - TAG.length();
        //大于4000时
        while (msg.length() > max_str_length) {
            Log.d(TAG, msg.substring(0, max_str_length));
            msg = msg.substring(max_str_length);
        }
        //剩余部分
        Log.i(TAG, msg);

    }

    private void parseJSONWithGSON(String jsonData) {
        Gson gson = new Gson();
        List<MovieBean> movies = gson.fromJson(jsonData, new TypeToken<List<MovieBean>>() {
        }.getType());
        for (MovieBean bean : movies) {
            Log.d(TAG, bean.getShortTitle());
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }


    public String getJson() {
        //将json数据变成字符串
        InputStream is = AsyncTaskLoaderData.this.getClass().getClassLoader().getResourceAsStream("assets/" + "movie.json");
        InputStreamReader streamReader = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(streamReader);
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while ((line = reader.readLine()) != null) {
                // stringBuilder.append(line);
                stringBuilder.append(line);
            }
            reader.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


}
