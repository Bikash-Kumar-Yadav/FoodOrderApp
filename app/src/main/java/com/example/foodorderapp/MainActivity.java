package com.example.foodorderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodorderapp.Adapters.MainAdapter;
import com.example.foodorderapp.Models.MainModel;
import com.example.foodorderapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.burgerr, "Burger", "50", "Burger is a quality food"));
        list.add(new MainModel(R.drawable.samosaa, "Samosaa","15", "You can eat Samosa by taking good taste"));
        list.add(new MainModel(R.drawable.icecream, "IceCream", "40", "IceCream can mady your dinner "));
        list.add(new MainModel(R.drawable.pasta, "Pasta", "80", "Pasta is good food in evening"));
        list.add(new MainModel(R.drawable.paneertika, "Paneertika", "100", "Paneertika is goood vegetable"));
        list.add(new MainModel(R.drawable.noodles, "Noodles", "90", "Noodles is good in evening"));
        list.add(new MainModel(R.drawable.pizza, "Pizza", "200", "you are able to eat pizza"));
        list.add(new MainModel(R.drawable.kfcc, "KFC Food", "150", "Food is enjoyed in KFC"));
        list.add(new MainModel(R.drawable.biryani, "Biryani", "150", "Biryani is non-veg"));
        MainAdapter adapter = new MainAdapter(list, this);
        binding.recyclerview.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerview.setLayoutManager(layoutManager);
    }

public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
}

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.orders:
                startActivity(new Intent(MainActivity.this, OrderActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


