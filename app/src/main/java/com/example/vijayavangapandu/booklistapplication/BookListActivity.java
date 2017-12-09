package com.example.vijayavangapandu.booklistapplication;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookListActivity extends AppCompatActivity
            implements LoaderManager.LoaderCallbacks<List<Book>>{

    private BookAdapter bookAdapter = null;

    private String BOOK_SEARCH_URL = null;

    private String searchKeyWord = null;

    /**
     * Constant value for the earthquake loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int EARTHQUAKE_LOADER_ID = 1;

    /** Adapter for the list of earthquakes */
    private BookAdapter mAdapter;

    /** TextView that is displayed when the list is empty */
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        // Find the ListView with ID book_list_view
        ListView bookListView = (ListView)findViewById(R.id.book_list_view);

        // Find the Button with ID find_book
        Button booKSearch = (Button)findViewById(R.id.find_book);


        Bundle bundle = getIntent().getExtras();

        // get the data from the bundle
        searchKeyWord = bundle.getString("input");

        // Append the search keyword to the url
        BOOK_SEARCH_URL =  "https://www.googleapis.com/books/v1/volumes?q=" + searchKeyWord +"&maxResults=20";


        Log.i("url", BOOK_SEARCH_URL);

        // Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get details on the currently active default data network
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        // If there is a network connection, fetch data
        if (networkInfo != null && networkInfo.isConnected()) {
            // Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();

            // Initialize the loader. Pass in the int ID constant defined above and pass in null for
            // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
            // because this activity implements the LoaderCallbacks interface).
            loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, BookListActivity.this);
        } else {
            // Otherwise, display error
            // First, hide loading indicator so error message will be visible
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);

            // Update empty state with no connection error message
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
            bookListView.setEmptyView(mEmptyStateTextView);

            // Create a new adapter that takes an empty list of books as input
            mAdapter = new BookAdapter(this, new ArrayList<Book>());

            // Set the adapter on the {@link ListView}
            // so the list can be populated in the user interface
            bookListView.setAdapter(mAdapter);

           // Set an item click listener on the ListView, which sends an intent to a web browser
            // to open a website with more information about the selected book.
            bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                    // Find the current book that was clicked on
                    Book currentBook = mAdapter.getItem(position);

                    // Convert the String URL into a URI object (to pass into the Intent constructor)
                    Uri bookUri = Uri.parse(currentBook.getmPreviewLink());

                    // Create a new intent to view the earthquake URI
                    Intent websiteIntent = new Intent(Intent.ACTION_VIEW, bookUri);

                    // Send the intent to launch a new activity
                    startActivity(websiteIntent);
                }
            });

        }

        @Override
        public Loader<List<Book>> onCreateLoader(int i, Bundle bundle) {
            // Create a new loader for the given URL
            return new BookListLoader(this, BOOK_SEARCH_URL);
        }

        @Override
        public void onLoadFinished(Loader<List<Book>> loader, List<Book> books) {
            // Hide loading indicator because the data has been loaded
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);

            // Set empty state text to display "No earthquakes found."
            mEmptyStateTextView.setText(R.string.no_books);

            // Clear the adapter of previous earthquake data
            mAdapter.clear();

            // If there is a valid list of {@link Book}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (books != null && !books.isEmpty()) {
                mAdapter.addAll(books);
            }
        }

        @Override
        public void onLoaderReset(Loader<List<Book>> loader) {
            // Loader reset, so we can clear out our existing data.
            mAdapter.clear();
        }
    }

