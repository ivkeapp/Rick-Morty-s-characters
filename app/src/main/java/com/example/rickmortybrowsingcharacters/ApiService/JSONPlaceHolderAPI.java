package com.example.rickmortybrowsingcharacters.ApiService;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface JSONPlaceHolderAPI {

    @GET("api/character")
    Call<Character> getCharacters(
            @Query("page") int page
    );

}
