package com.example.rickmortybrowsingcharacters;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rickmortybrowsingcharacters.Models.Result;
import com.example.rickmortybrowsingcharacters.Paging.CharacterViewModel;
import com.example.rickmortybrowsingcharacters.Paging.ItemAdapter;
import com.example.rickmortybrowsingcharacters.Utils.InternetCheck;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button btRetry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkInternet();

        btRetry = findViewById(R.id.bt_retry);
        btRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInternet();
            }
        });

    }

    public void initList(){

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //For grid view (need to adjust xml styles for grid view)
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        CharacterViewModel characterViewModel = ViewModelProviders.of(MainActivity.this).get(CharacterViewModel.class);
        final ItemAdapter adapter = new ItemAdapter(MainActivity.this);

        characterViewModel.characterPagedList.observe(this, new Observer<PagedList<Result>>() {
            @Override
            public void onChanged(@Nullable PagedList<Result> results) {
                adapter.submitList(results);
            }
        });

        recyclerView.setAdapter(adapter);

    }

    private void checkInternet(){
        new InternetCheck(new InternetCheck.Consumer() {
            @Override
            public void accept(Boolean internet) {
                if(internet){
                    initList();
                    btRetry.setVisibility(View.GONE);
                } else{
                    Toast.makeText(MainActivity.this, "Connection issue, please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
