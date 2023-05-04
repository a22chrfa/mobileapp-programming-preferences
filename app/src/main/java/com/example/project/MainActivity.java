package com.example.project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Button vOpenButton;
    private TextView vTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        vTextView = findViewById(R.id.mainTextview);

        //Assigning vOpenButton and setting up an onClickListener to open the second activity
        vOpenButton = findViewById(R.id.openSecondButton);
        vOpenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        //retrieve sharedPrefs and store in "mainSharedPrefs"
        SharedPreferences mainSharedPrefs = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        //retrieve value of stringKey from mainSharedPrefs and store in "displayText"
        String displayText = mainSharedPrefs.getString("stringKey", "");

        //set value of "displayText" in vTextView (R.id.mainTextview) with setText
        vTextView.setText(displayText);
    }

}
