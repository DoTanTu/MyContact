package com.example.mycontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private List<Contact> listContact;
    private LayoutInflater inInflater;
    private Context context;


    public ContactAdapter(List<Contact> listContact, LayoutInflater inInflater, Context context) {
        this.listContact = listContact;
        this.inInflater = inInflater;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listContact.size();
    }

    @Override
    public Contact getItem(int potition) {
        return listContact.get(potition);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        RecyclerView.ViewHolder viewHolder;

        if(view == null){
            view = inInflater.inflate(R.layout.list_item)

        }
        return null;
    }
}
