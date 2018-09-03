package com.example.bob.coincointracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

/**
 * @see https://material.io/tools/icons/
 * @see vectorDrawable...
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // configure the toolbar - Material design take over Action bar
        this.configureToolbar();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //2 - Inflate the menu and add it to the Toolbar
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }


    private void configureToolbar(){
        // Get the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        // Sets the Toolbar
        setSupportActionBar(toolbar);
    }
}
