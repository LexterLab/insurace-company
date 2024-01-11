package com.example.insurance_company;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.civil).setOnClickListener(view -> startActivity(new Intent(this, CivilActivity.class)));
        findViewById(R.id.home).setOnClickListener(view -> startActivity(new Intent(this, HomeActivity.class)));
        findViewById(R.id.life).setOnClickListener(view -> startActivity(new Intent(this, LifeActivity.class)));
    }
}