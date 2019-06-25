package com.example.rickmortybrowsingcharacters;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.rickmortybrowsingcharacters.Models.Result;
import com.example.rickmortybrowsingcharacters.Paging.CharacterViewModel;
import com.example.rickmortybrowsingcharacters.Paging.ItemAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //For grid view (need to adjust xml styles for grid view)
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        CharacterViewModel characterViewModel = ViewModelProviders.of(this).get(CharacterViewModel.class);
        final ItemAdapter adapter = new ItemAdapter(this);

        characterViewModel.characterPagedList.observe(this, new Observer<PagedList<Result>>() {
            @Override
            public void onChanged(@Nullable PagedList<Result> results) {
                adapter.submitList(results);
            }
        });

        recyclerView.setAdapter(adapter);

    }
}
