package com.example.pruebaap;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import java.util.ArrayList;

public class MatchesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches);

        recyclerView = findViewById(R.id.rvmatches);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new AdapterReciclerView(this, getlistmatches);
        recyclerView.setAdapter(adapter);
    }
    private ArrayList<MItem> getlistmatches(){
        ArrayList<MItem> mlistItem = new ArrayList<>();
        mlistItem.add(new MItem("sábado 15", "0-2", R.drawable.argentina,R.drawable.colombia));
        mlistItem.add(new MItem("sábado 15", "0-2", R.drawable.argentina,R.drawable.colombia));
        mlistItem.add(new MItem("sábado 15", "0-2", R.drawable.argentina,R.drawable.colombia));
        mlistItem.add(new MItem("sábado 15", "0-2", R.drawable.argentina,R.drawable.colombia));
        mlistItem.add(new MItem("sábado 15", "0-2", R.drawable.argentina,R.drawable.colombia));
        mlistItem.add(new MItem("sábado 15", "0-2", R.drawable.argentina,R.drawable.colombia));
        mlistItem.add(new MItem("sábado 15", "0-2", R.drawable.argentina,R.drawable.colombia));
        mlistItem.add(new MItem("sábado 15", "0-2", R.drawable.argentina,R.drawable.colombia));
        mlistItem.add(new MItem("sábado 15", "0-2", R.drawable.argentina,R.drawable.colombia));

            return mlistItem;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logomenu, menu);
        return true;
    }
}

