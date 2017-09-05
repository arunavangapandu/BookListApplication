package com.example.vijayavangapandu.booklistapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchActivity extends AppCompatActivity {

    private String searchKeyWord = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        // Find the Button with ID find_book
        Button booKSearch = (Button) findViewById(R.id.find_book);

        // Add onClickListener
        booKSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Find the EditText with ID type_text
                EditText searchName = (EditText) findViewById(R.id.type_text);

                // Get the user input from the edit text
                searchKeyWord = searchName.getText().toString();

                // send an intent to the specified component
                Intent intent = new Intent(getApplicationContext(), BookListActivity.class);

                // Add data to the inent
                intent.putExtra("input", searchKeyWord);

                // start the Intent
                startActivity(intent);

            }
        });
    }
}