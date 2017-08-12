package com.example.vijayavangapandu.booklistapplication;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vijayavangapandu on 8/4/17.
 */

public class BookAdapter extends ArrayAdapter<Book> {

    // Constructs a new Adapter object
    public BookAdapter(Context context, List<Book> books) {
        super(context, 0, books);
    }

    // Returns the list item view that displays information about the book at the given position
    // in the list of books.
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {

        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, inflate a new list item layout.
        View listItemView = convertView;
        if(listItemView == null){
           listItemView = LayoutInflater.from(getContext()).inflate(
                   R.layout.list_item_layout, parent, false);
        }

        // Returns the book at the given position in the list of books.
        Book book = getItem(position);

        // Find the TextView with ID book_id
        TextView bookIdView = (TextView) listItemView.findViewById(R.id.book_id);
        bookIdView.setText(book.getmId());

        // Find the TextView with ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(book.getmTitle());

        // Find the TextView with ID author
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);
        authorView.setText(book.getmAuthor());

        // Find the TextView with ID publisher
        TextView publisherView = (TextView) listItemView.findViewById(R.id.publisher);
        publisherView.setText(book.getmPublisher());

        return listItemView;
    }
}
