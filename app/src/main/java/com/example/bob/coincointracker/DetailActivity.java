package com.example.bob.coincointracker;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    final static String DETAIL_BUNDLE = "Details Activity --- ";
    final static String RESULT_BUNDLE = "RESULT";
    private ImageView imageViewRHM;

    /**
     * bundle code used as a way to retrieve the resulting information from launched activity
     */
    static final int PICK_FEEDBACK_REQUEST = 1;  // The request code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //1 - Configuring Toolbar
        this.configureToolbar();
        this.configureImageView();

    }

    private void configureToolbar(){
        //Get the toolbar (Serialise)
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Set the toolbar
        setSupportActionBar(toolbar);
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();
        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }


    private void configureImageView(){
        // Serialise ImageView
        this.imageViewRHM = (ImageView) this.findViewById(R.id.activity_detail_imageView);
        // Set OnClick Listener on it
        imageViewRHM.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                //Launch FeedBack Activity
                launchFeedBackActivity();
            }
        });
    }

    /**
     * A method to launch an activity passing an Intent and waiting for a feedback once over !
     * @see https://developer.android.com/training/basics/intents/result
     */
    private void launchFeedBackActivity(){
        Intent myIntent = new Intent(DetailActivity.this, FeedBackActivity.class);
        this.startActivityForResult(myIntent, PICK_FEEDBACK_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == PICK_FEEDBACK_REQUEST) {

            String result = data.getStringExtra(RESULT_BUNDLE);
            Log.i(DETAIL_BUNDLE,"Feedback received from activity ! " + result);
            Toast.makeText(this, "Just Received feedback from other activity...", Toast.LENGTH_LONG).show();

        }
    }


}
