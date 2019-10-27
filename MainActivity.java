package com.example.myapplicationnews;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<MyNews>> {

    RecyclerView recyclerView;

    LoaderAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new LoaderAdapter(this,new ArrayList<MyNews>());
        recyclerView.setAdapter(adapter);

        getSupportLoaderManager().initLoader(0,null,this);
    }


    @Override
    public Loader<List<MyNews>> onCreateLoader(int id,  Bundle args) {
        return new MyLoader(MainActivity.this);
    }

    @Override
    public void onLoadFinished( Loader<List<MyNews>> loader, List<MyNews> data) {

        adapter = new LoaderAdapter(this,data);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onLoaderReset( Loader<List<MyNews>> loader) {

    }
}
