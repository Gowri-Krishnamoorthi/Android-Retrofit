package com.example.retrofit;

// MainActivity.java
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MarvelCharacterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://simplifiedcoding.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MarvelApi marvelApi = retrofit.create(MarvelApi.class);

        Call<List<MarvelCharacter>> call = marvelApi.getMarvelCharacters();

        call.enqueue(new Callback<List<MarvelCharacter>>() {
            @Override
            public void onResponse(Call<List<MarvelCharacter>> call, Response<List<MarvelCharacter>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<MarvelCharacter> characters = response.body();
                    adapter = new MarvelCharacterAdapter(MainActivity.this, characters);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to retrieve data", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<MarvelCharacter>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

