package com.example.mycontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mycontact.databinding.DetailItemBinding;
public class DetailUserPhone extends AppCompatActivity {
    DetailItemBinding binding;

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DetailItemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        imageView = (ImageView) findViewById(R.id.id_comback_home);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DirectionalLogin();
            }
        });
        Intent intent = this.getIntent();

        if (intent != null){

            String name = intent.getStringExtra("name");
            String phone = intent.getStringExtra("phone");

            binding.idName.setText(name);
            binding.idPhone.setText(phone);
        }

    }
    public void DirectionalLogin(){
        Intent intent = new Intent(DetailUserPhone.this, HomePhone.class);
        startActivity(intent);
    }
}
