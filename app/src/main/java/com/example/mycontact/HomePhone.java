package com.example.mycontact;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.mycontact.databinding.ListMenuItemBinding;

import java.util.ArrayList;

public class HomePhone extends AppCompatActivity {
    ListMenuItemBinding binding;
    TextView tv ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ListMenuItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        tv = (TextView) findViewById(R.id.item_nguoiThan);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS},0);
        }
        ContentResolver contentResolver = getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = contentResolver.query(uri, null, null, null, null);
        Log.i("CONTACT_PROVIDER_DEMO","TOTAL # OF CONTACTST :::" + Integer.toString(cursor.getCount()));
        ArrayList<UserPhone> userArrayList = new ArrayList<>();
        String[] ten = new String[0];
        String[] sodienThoai = new String[0];
        if(cursor.getCount() > 1) {
            while(cursor.moveToNext()){
                @SuppressLint("Range") String contactName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                @SuppressLint("Range") String contactNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                UserPhone user = new UserPhone(contactName,contactNumber);
                userArrayList.add(user);
                sodienThoai = new String[]{contactNumber};
            }
            ListAdapter listAdapter = new ListAdapter(HomePhone.this,userArrayList);
            binding.listview.setAdapter(listAdapter);
            binding.listview.setClickable(true);
            binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i = new Intent(HomePhone.this, DetailUserPhone.class);
                    i.putExtra("name",userArrayList.get(position).name);
                    i.putExtra("phone",userArrayList.get(position).phoneNumber);

                    startActivity(i);

                }
            });

        }
    }
}
