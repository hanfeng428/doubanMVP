package com.ryg.chapter_2.demo2;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


/**
 * These utilities will be used to communicate with the network.
 */
public class NetworkUtils {
    private static final String TAG = "NetworkUtils";

    final static String GITHUB_BASE_URL =
            "https://api.github.com/search/repositories";
    final static String PARAM_QUERY = "q";
    final static String PARAM_SORT = "sort";
    final static String sortBy = "stars";


    public static URL buildUrl(String githubSearchQuery) {
        Uri builtUri = Uri.parse(GITHUB_BASE_URL).buildUpon()
                .appendQueryParameter(PARAM_QUERY, githubSearchQuery)
                .appendQueryParameter(PARAM_SORT, sortBy)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
    }


    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            Log.d(TAG,"scanner.hasNext():"+"10");
            InputStream in = urlConnection.getInputStream();
            Log.d(TAG,"scanner.hasNext():"+"11");

            BufferedReader reader=null;
            reader=new BufferedReader(new InputStreamReader( in) );
            StringBuilder response=new StringBuilder();
            String line;
            while ((line=reader.readLine())!=null){
                response.append(line);
            }

            return  response.toString();

//
//            Scanner scanner = new Scanner(in);
//            scanner.useDelimiter("\\A");



//            boolean hasInput = scanner.hasNext();
//            if (hasInput) {
//                Log.d(TAG,"scanner.next():"+scanner.next());
//                return scanner.next();
//            } else {
//                return null;
//            }
        } finally {
            urlConnection.disconnect();
        }
    }

    // end
}