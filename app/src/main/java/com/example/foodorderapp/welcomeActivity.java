package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class welcomeActivity extends AppCompatActivity {
Button login, register;
TextView txtSkip;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
  txtSkip = findViewById(R.id.txtSkip);
  login = findViewById(R.id.btnlogin);
  register = findViewById(R.id.btnsignUp);

  login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(welcomeActivity.this, "Login has been clicked", Toast.LENGTH_SHORT).show();
          Intent intent = new Intent(welcomeActivity.this, SignIn_Activity.class);
          startActivity(intent);

      }
  });
  register.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          Toast.makeText(welcomeActivity.this, "register has been clicked", Toast.LENGTH_SHORT).show();
          Intent intent = new Intent(welcomeActivity.this, SignUp_Activity.class);
          startActivity(intent);
      }
  });

txtSkip.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(welcomeActivity.this, "Skip button has been clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(welcomeActivity.this, MainActivity.class);
        startActivity(intent);
    }
});
    }
}