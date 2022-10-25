package com.example.mycontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter {

    public ListAdapter(Context context, ArrayList<UserPhone> phoneArrayList) {
        super(context,R.layout.list_item, phoneArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        UserPhone user = (UserPhone) getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        TextView name = convertView.findViewById(R.id.item_nguoiThan);
        name.setText(user.name);
        return convertView;
    }
}
