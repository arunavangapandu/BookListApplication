package com.example.vijayavangapandu.booklistapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import model.GitHubRepo;
import model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class GsonActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gson);

        final ListView retrofitView = (ListView)findViewById(R.id.retrofitListView);

        String API_BASE_URL = "https://api.github.com/";

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit = builder.build();

        GitHubClient client = retrofit.create(GitHubClient.class);

       // Call<List<GitHubRepo>> call = client.reposForUser("fs-opensource");

        Call<List<GitHubRepo>> call = client.reposForUser("arunavangapandu");

        // since we are using activity, making an asynchronous call, so we use enquueue

        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response)
            {
                Toast.makeText(GsonActivity.this, "asynchronous network call is " +
                                "successs", Toast.LENGTH_SHORT).show();

              //  List<GitHubRepo> repos = response.body();
                GsonAdapter adapter = new GsonAdapter(GsonActivity.this, response.body());

                // set the adapter to the ListView
                retrofitView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {


                Toast.makeText(GsonActivity.this, "asynchronous network call " +
                                "failed", Toast.LENGTH_SHORT).show();

            }
        });


        /*
        // To do the JAVA - JSON serialization, need a GSON object, which handles the
        // conversion

        // Create a user object
        User user = new User("Aruna", 34,
                "aruna5798@gmail.com", true);

        Gson gson = new Gson();

        // call toJson() to convert it to json

        String userString = gson.toJson(user);

        Log.i("Display userJsonString", userString);



        // To do the JSON - JAVA deserialization, need a GSON object, which handles the
        // conversion

        String userJsonString = "{'age':34, 'name':'Aruna', 'email':'aruna5798@gmail.com', 'isDeveloper': true }";

        User userObject = gson.fromJson(userJsonString, User.class);

        Log.i("display user", userObject.toString()); */


    }


}
