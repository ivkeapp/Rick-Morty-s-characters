package com.example.rickmortybrowsingcharacters.Paging;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;

import com.example.rickmortybrowsingcharacters.ApiService.Result;

public class CharacterViewModel extends ViewModel {

    public LiveData<PagedList<Result>> characterPagedList;
    LiveData<PageKeyedDataSource<Integer, Result>> liveDataSource;

    public CharacterViewModel(){

        CharacterDataSourceFactory characterDataSourceFactory = new CharacterDataSourceFactory();
        liveDataSource = characterDataSourceFactory.getCharacterLiveDataSource();

        PagedList.Config config =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(20)
                        .build();

        characterPagedList = (new LivePagedListBuilder(characterDataSourceFactory, config)).build();

    }

}