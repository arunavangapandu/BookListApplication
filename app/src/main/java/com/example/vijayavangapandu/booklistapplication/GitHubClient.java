package com.example.vijayavangapandu.booklistapplication;

import java.util.List;

import model.GitHubRepo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by aruna on 12/5/17.
 */

public interface GitHubClient {
    @GET("/users/{user}/repos")

    Call<List<GitHubRepo>> reposForUser(
            @Path("user") String user
            );

}
