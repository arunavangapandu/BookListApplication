package com.example.vijayavangapandu.booklistapplication;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by vijayavangapandu on 8/8/17.
 */

// Loads a list of books by using an AsyncTask to perform the network request
// to the given url.

public class BookListLoader extends AsyncTaskLoader<List<Book>> {

    // Tag for log messages
    private static final String LOG_TAG = BookListLoader.class.getName();

    // Query URL
    private String mUrl;

    // Constructs a new BookListLoader
    // Context of the activity
    // Url to load data from
    public BookListLoader(Context context,String url){
        super(context);
        mUrl = url;

    }

    @Override
    protected void onStartLoading() {
        forceLoad();     // Loads asynchronous data
    }

    // This is on a background thread
    @Override
    public List<Book> loadInBackground() {

        if(mUrl == null) {
            return null;
        }
        // Perform the network request, parse the response, and extract a list of books.
        List<Book> books = QueryUtils.fetchBookData(mUrl);
        return books;
    }
}
