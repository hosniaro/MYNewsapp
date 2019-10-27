package com.example.myapplicationnews;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Source;

public class MyLoader extends AsyncTaskLoader<List<MyNews>> {
    List<MyNews> myNewsList = new ArrayList<>();
    public MyLoader(@NonNull Context context) {
        super(context);
    }

    @Nullable
    @Override
    public List<MyNews> loadInBackground() {

        try {
            URL url = new URL("https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=de1c79d772344630b57a1e477a6a4832");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            InputStream inputStream = con.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }

            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("articles");
            for (int i = 0;i < jsonArray.length(); i++){
                MyNews myNews = new MyNews((Source) jsonArray.getJSONObject(i).get("source"),
                        jsonArray.getJSONObject(i).getString("author"),
                        jsonArray.getJSONObject(i).getString("title"),
                        jsonArray.getJSONObject(i).getString("description"),
                        jsonArray.getJSONObject(i).getString("url"),
                        jsonArray.getJSONObject(i).getString("urlToImage"),
                        jsonArray.getJSONObject(i).getString("publishedAt"),
                        jsonArray.getJSONObject(i).getString("content"));
                myNewsList.add(myNews);
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return myNewsList;
    }
}
