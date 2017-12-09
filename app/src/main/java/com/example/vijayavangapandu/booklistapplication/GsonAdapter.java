package com.example.vijayavangapandu.booklistapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import model.GitHubRepo;

/**
 * Created by aruna on 12/8/17.
 */

public class GsonAdapter extends ArrayAdapter<GitHubRepo> {

    // constructs an adapter object
    public GsonAdapter(@NonNull Context context,  List<GitHubRepo> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, inflate a new list item layout.
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.user_list_item_layout, parent, false);
        }

        // Returns the user at the given position
        GitHubRepo gitHubRepo = getItem(position);

        // Find the TextView with ID name
        TextView bookIdView = (TextView) listItemView.findViewById(R.id.name);
        bookIdView.setText(gitHubRepo.getName());


        return listItemView;
    }

}
