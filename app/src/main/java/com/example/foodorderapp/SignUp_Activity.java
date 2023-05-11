package com.example.foodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp_Activity extends AppCompatActivity {
    TextView txtAccount;
    Button register;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setTitle("Sign Up");
 txtAccount = findViewById(R.id.txtCreate);
 register = findViewById(R.id.btnsignin);
txtAccount.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(SignUp_Activity.this, "Already have account? Login  has been clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SignUp_Activity.this, SignIn_Activity.class);
        startActivity(intent);
    }
});
register.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(SignUp_Activity.this, "Register has been done", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SignUp_Activity.this, SignIn_Activity.class);
        startActivity(intent);
    }
});
    }
}