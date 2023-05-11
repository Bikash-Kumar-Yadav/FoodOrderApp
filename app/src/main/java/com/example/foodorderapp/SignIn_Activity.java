package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn_Activity extends AppCompatActivity {
    TextView txtCreate;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtCreate = findViewById(R.id.txtCreate);
        signIn = findViewById(R.id.btnsignin);
        
        txtCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignIn_Activity.this, "Want to create account has been clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignIn_Activity.this, SignUp_Activity.class);
                startActivity(intent);
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignIn_Activity.this, "signIn button has been clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignIn_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}