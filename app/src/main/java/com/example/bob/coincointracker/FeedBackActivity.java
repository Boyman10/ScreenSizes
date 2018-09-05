package com.example.bob.coincointracker;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple class to cover the observer pattern which is already configured within Android system
 */
public class FeedBackActivity extends AppCompatActivity {

    private Button myBtn;
    private TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        this.configureFeedBack();
    }


    /**
     * Generate a new Intent to pass back to launching activity and finish it !
     */
    protected void configureFeedBack() {

        this.myBtn = findViewById(R.id.feedback_Btn);

        this.myBtn.setOnClickListener(new View.OnClickListener() {

            private TextView txtView;

            @Override
            public void onClick(View v) {

                this.txtView = findViewById(R.id.activity_feedback_editView);

                Intent returnIntent = new Intent();
                returnIntent.putExtra(DetailActivity.RESULT_BUNDLE,this.txtView.getText().toString());
                Log.d("FEEDBACK --- ", this.txtView.getText().toString());

                setResult(DetailActivity.PICK_FEEDBACK_REQUEST,returnIntent);
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {

        Log.i("Feedback--- ", " Closing - destroying activity");

        super.onDestroy();
    }
}
