package com.example.bob.coincointracker;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
    }

    public String getUserToken() {
        SharedPreferences prefs = getSharedPreferences("userToken", MODE_PRIVATE);

        return "IncredibleToken";
    }
}
