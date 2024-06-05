package com.example.retrofit;

// MarvelApi.java
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MarvelApi {
    @GET("https://simplifiedcoding.net/demos/marvel/")
    Call<List<MarvelCharacter>> getMarvelCharacters();
}

