package com.example.rickmortybrowsingcharacters.Paging;

import android.arch.paging.PageKeyedDataSource;
import android.support.annotation.NonNull;

import com.example.rickmortybrowsingcharacters.Models.Character;
import com.example.rickmortybrowsingcharacters.Models.Result;
import com.example.rickmortybrowsingcharacters.ApiService.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CharacterDataSource extends PageKeyedDataSource<Integer, Result> {

    private static final int FIRST_PAGE = 1;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Result> callback) {

        RetrofitClient.getInstance()
                .getApi()
                .getCharacters(FIRST_PAGE)
                .enqueue(new Callback<Character>() {
                    @Override
                    public void onResponse(Call<Character> call, Response<Character> response) {

                        if(response.body() != null){
                            callback.onResult(response.body().getResults(), null, FIRST_PAGE+1);
                        }

                    }

                    @Override
                    public void onFailure(Call<Character> call, Throwable t) {

                    }
                });

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Result> callback) {

        RetrofitClient.getInstance()
                .getApi()
                .getCharacters(params.key)
                .enqueue(new Callback<Character>() {
                    @Override
                    public void onResponse(Call<Character> call, Response<Character> response) {

                        Integer key = (params.key > 1) ? params.key - 1 : null;

                        if(response.body() != null){

                            callback.onResult(response.body().getResults(), key);

                        }

                    }

                    @Override
                    public void onFailure(Call<Character> call, Throwable t) {

                    }
                });

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Result> callback) {

        RetrofitClient.getInstance()
                .getApi()
                .getCharacters(params.key)
                .enqueue(new Callback<Character>() {
                    @Override
                    public void onResponse(Call<Character> call, Response<Character> response) {


                        if(response.body() != null) {

                            String hasNext = response.body().getInfo().getNext();
                            Integer key = !hasNext.equals("") ? params.key + 1 : null;
                            callback.onResult(response.body().getResults(), key);

                        }


                    }

                    @Override
                    public void onFailure(Call<Character> call, Throwable t) {

                    }
                });

    }
}