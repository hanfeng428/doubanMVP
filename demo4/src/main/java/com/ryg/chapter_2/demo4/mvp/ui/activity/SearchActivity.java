package com.ryg.chapter_2.demo4.mvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iflytek.cloud.ErrorCode;
import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.RecognizerListener;
import com.iflytek.cloud.RecognizerResult;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechRecognizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import com.ryg.chapter_2.demo4.di.component.DaggerSearchComponent;
import com.ryg.chapter_2.demo4.mvp.contract.SearchContract;
import com.ryg.chapter_2.demo4.mvp.model.entity.BookSearchBean;
import com.ryg.chapter_2.demo4.mvp.model.entity.KeDaBean;
import com.ryg.chapter_2.demo4.mvp.presenter.SearchPresenter;

import com.ryg.chapter_2.demo4.R;
import com.ryg.chapter_2.demo4.mvp.ui.adapter.SearchBookAdapter;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 08/22/2019 17:41
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */
public class SearchActivity extends BaseActivity<SearchPresenter> implements SearchContract.View {
    private static final String TAG = "SearchActivity";
    @BindView(R.id.search_edittext)
    EditText searchEdit;
    @BindView(R.id.voice_search)
    ImageButton voiceSearch;
    @BindView(R.id.text_search)
    Button textSearch;
    @BindView(R.id.search_rv)
    RecyclerView searchrv;
    @BindView(R.id.search_pb)
    ProgressBar searchpb;
    BookSearchBean totalSearchBean;
    SearchBookAdapter adapter;
    private LinearLayoutManager mLayoutManager;
    private int lastVisibleItem;
    private boolean notshake;  //防止recyclerview短时间多次刷新，造成数据重复加载。
    static String resultJson = "[";

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerSearchComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_search; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "hf_SearchActivity_initData  isApkInstalled:" + isApkInstalled(RecognizerIntent.ACTION_RECOGNIZE_SPEECH));
        SpeechUtility.createUtility(this, SpeechConstant.APPID + "=5d5f840d");
        mLayoutManager = new LinearLayoutManager(this);
        searchrv.setLayoutManager(mLayoutManager);
        initListener();
        scrollRecycleView();

    }

    public void startVoice() {

    }


    /**
     * 交互动画
     */
    public void listenUI() {
        resultJson = "[";
        RecognizerDialog iatDialog = new RecognizerDialog(this, mInitListener);

        // 2.设置听写参数，详见《科大讯飞MSC API手册(Android)》SpeechConstant类
        iatDialog.setParameter(SpeechConstant.DOMAIN, "iat");
        iatDialog.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
        iatDialog.setParameter(SpeechConstant.ACCENT, "mandarin");

        iatDialog.setListener(recognizerDialogListener);

        iatDialog.show();
    }

    private RecognizerDialogListener recognizerDialogListener = new RecognizerDialogListener() {

        @Override
        public void onResult(RecognizerResult results, boolean isLast) {
            Log.d(TAG, "hf_SearchActivity_onResult  results:" + results.getResultString());
            if (!isLast) {
                resultJson += results.getResultString() + ",";
            } else {
                resultJson += results.getResultString() + "]";
            }

            if (isLast) {
                //解析语音识别后返回的json格式的结果
                Gson gson = new Gson();
                Log.d(TAG, "hf_SearchActivity_onResult  resultJson:" + resultJson);

                List<KeDaBean> resultList = gson.fromJson(resultJson,
                        new TypeToken<List<KeDaBean>>() {
                        }.getType());
                String result = "";
                for (int i = 0; i < resultList.size() - 1; i++) {
                    for (int k = 0; k < resultList.get(i).getWs().size(); k++) {
                        for (int j = 0; j < resultList.get(i).getWs().get(k).getCw().size(); j++) {
                            result += resultList.get(i).getWs().get(k).getCw().get(j).getW();

                        }
                    }
                }
                searchEdit.setText(result);
                searchpb.setVisibility(View.VISIBLE);
                Log.d(TAG, "hf_SearchActivity_onResult  result:" + result);
                Log.d(TAG, "hf_SearchActivity_onResult  searchEdit:" + searchEdit.getText());

                if (TextUtils.isEmpty(searchEdit.getText())) {
                    Toast.makeText(SearchActivity.this, "请输入内容！", Toast.LENGTH_SHORT).show();
                } else {
                    searchpb.setVisibility(View.VISIBLE);
                    mPresenter.getBook("0", searchEdit.getText().toString(), false);

                }
            }
        }

        @Override
        public void onError(SpeechError arg0) {
            Toast.makeText(SearchActivity.this, "识别错误：" + arg0, Toast.LENGTH_LONG).show();

        }
    };


    private InitListener mInitListener = new InitListener() {

        @Override
        public void onInit(int arg0) {
            if (arg0 != ErrorCode.SUCCESS) {
                Toast.makeText(SearchActivity.this, "初始化失败，错误码：" + arg0, Toast.LENGTH_LONG).show();
            }
        }
    };


    private void initListener() {
        searchEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchEdit.setFocusable(true);
                searchEdit.setFocusableInTouchMode(true);
                searchEdit.requestFocus();
                searchEdit.findFocus();
                InputMethodManager imm = (InputMethodManager) SearchActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(searchEdit, InputMethodManager.SHOW_FORCED);
            }
        });
        voiceSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                Log.d(TAG, "hf_SearchActivity_initListener  voiceSearch");
//                VoiceSearch();
                listenUI();

            }
        });
        textSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
                Log.d(TAG, "hf_SearchActivity_initListener  textSearch:" + searchEdit.getText());
                notshake = true;
                if (TextUtils.isEmpty(searchEdit.getText())) {
                    Toast.makeText(SearchActivity.this, "请输入内容！", Toast.LENGTH_SHORT).show();
                } else {
                    searchpb.setVisibility(View.VISIBLE);
                    mPresenter.getBook("0", searchEdit.getText().toString(), false);

                }
            }
        });

    }

    public boolean isApkInstalled(String strIntent) {
        PackageManager packageManager = this.getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(new Intent(strIntent), 0);

        return activities != null && !activities.isEmpty();
    }

    private void VoiceSearch() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ZH-CN");
        // 语言模式和自由模式的语音识别
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        // 提示语音开始
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "开始语音");
        // 开始语音识别
        try {
            startActivityForResult(intent, 200);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "找不到语音设备", Toast.LENGTH_SHORT).show();
            e.printStackTrace();

        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == RESULT_OK) {
            ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            for (String ss : results) {
                Log.d(TAG, "hf_SearchActivity_onActivityResult  ss:" + ss);

            }
        }
    }

    @Override
    public void setBookDataList(BookSearchBean dataList, boolean ismore) {
        if (dataList != null) {
            searchpb.setVisibility(View.GONE);
        }
        for (int i = 0; i < dataList.getBooks().size(); i++) {
            Log.d(TAG, "hf_SearchActivity_setBookDataList  getTitle:" + dataList.getBooks().get(i).getTitle());
        }
        if (ismore) {
            totalSearchBean.getBooks().addAll(dataList.getBooks());
            adapter.notifyDataSetChanged();

        } else {
            totalSearchBean = dataList;
            adapter = new SearchBookAdapter(this, totalSearchBean.getBooks());
            Log.d(TAG, "hf_SearchActivity_setDataList  recyclerview1  is:" + searchrv);
            searchrv.setAdapter(adapter);
        }
    }

    public void scrollRecycleView() {
        searchrv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
                    Log.d(TAG, "hf_SearchActivity_scrollRecycleView  mLayoutManager.getItemCount()  is:" + mLayoutManager.getItemCount());

                    Log.d(TAG, "hf_SearchActivity_scrollRecycleView  lastVisibleItem  is:" + lastVisibleItem);
                    if (lastVisibleItem >= 10000) {
                        if (adapter != null) {
                            adapter.updateLoadStatus(adapter.LOAD_NONE);
                        }
                        return;
                    }
                    if (notshake) {
                        notshake = false;
                        if (lastVisibleItem + 1 == mLayoutManager.getItemCount()) {
                            if (adapter != null) {
                                adapter.updateLoadStatus(adapter.LOAD_PULL_TO);
                                // isLoadMore = true;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        adapter.updateLoadStatus(adapter.LOAD_MORE);
                                    }
                                }, 200);
                            }

                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                notshake = true;
                                if (TextUtils.isEmpty(searchEdit.getText())) {
                                    Toast.makeText(SearchActivity.this, "请输入内容！", Toast.LENGTH_SHORT).show();
                                } else {
                                    mPresenter.getBook("0", searchEdit.getText().toString(), true);

                                }
                            }
                        }, 1000);

                    }
                }

            }
        });
    }

}


