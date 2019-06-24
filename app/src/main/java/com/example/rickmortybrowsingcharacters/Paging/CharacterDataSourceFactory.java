package com.example.rickmortybrowsingcharacters.Paging;

import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

import com.example.rickmortybrowsingcharacters.ApiService.Result;

public class CharacterDataSourceFactory extends DataSource.Factory {

    private MutableLiveData<PageKeyedDataSource<Integer, Result>> characterLiveDataSource = new MutableLiveData<>();


    @Override
    public DataSource create() {
        CharacterDataSource characterDataSource = new CharacterDataSource();
        characterLiveDataSource.postValue(characterDataSource);
        return characterDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, Result>> getCharacterLiveDataSource() {
        return characterLiveDataSource;
    }
}