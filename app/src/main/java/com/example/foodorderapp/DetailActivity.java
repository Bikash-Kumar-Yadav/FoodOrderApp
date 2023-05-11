package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        final DBHelper helper = new DBHelper(this);
        if (getIntent().getIntExtra("type", 0) == 1) {

        final int image = getIntent().getIntExtra("image", 0);
        final int price = Integer.parseInt(getIntent().getStringExtra("price"));
        final String description = getIntent().getStringExtra("desc");
        final String name = getIntent().getStringExtra("name");

        binding.detailImage.setImageResource(image);
        binding.priceLbl.setText(String.format("%d", price));
        binding.detailDescription.setText(description);
        binding.nameBox.setText(name);


        binding.insertbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = helper.insertOrder(
                        binding.nameBox.getText().toString(),
                        binding.phoneBox.getText().toString(),
                        price,
                        image,
                        name,
                        description,
                        Integer.parseInt(binding.quantity.getText().toString())
                );
                if (isInserted) {
                    Toast.makeText(DetailActivity.this, "Ordered Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DetailActivity.this, "error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    } else {
 int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);
//            Toast.makeText(this, cursor.getString(1), Toast.LENGTH_SHORT).show();
            final int image = cursor.getInt(4);
            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d", cursor.getInt(3)));
            binding.foodName.setText(cursor.getString(6));
            binding.detailDescription.setText(cursor.getString(5));
            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.insertbtn.setText("Update Now");
            binding.insertbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
            boolean isUpdated =  helper.updateOrder(
                     binding.nameBox.getText().toString(),
                     binding.phoneBox.getText().toString(),
                     Integer.parseInt(binding.priceLbl.getText().toString()),
                     image,
                     binding.detailDescription.getText().toString(),
                     binding.foodName.getText().toString(),
                     1,
                     id
                     );
             if(isUpdated){
                 Toast.makeText(DetailActivity.this, "Updated data", Toast.LENGTH_SHORT).show();
             }
             else{
                 Toast.makeText(DetailActivity.this, "Update failed", Toast.LENGTH_SHORT).show();
             }
                }
            });


        }
    }
}