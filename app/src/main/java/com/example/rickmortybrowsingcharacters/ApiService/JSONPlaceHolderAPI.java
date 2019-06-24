package com.example.rickmortybrowsingcharacters.ApiService;

public interface JSONPlaceHolderAPI {

    @GET("api/character")
    Call<Character> getCharacters(
            @Query("page") int page
    );

}
