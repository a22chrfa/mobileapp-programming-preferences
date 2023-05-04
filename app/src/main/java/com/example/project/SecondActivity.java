package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private Button vSaveButton;
    private EditText vSecondEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        vSecondEditText = findViewById(R.id.secondEditText);
        //Assigning vSaveButton and setting up an onClickListener to open mainactivty, and terminate current activity.
        vSaveButton = findViewById(R.id.save_button);
        vSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Get text from Edit and convert to string. Store in "text".
                String text = vSecondEditText.getText().toString();
                //retrieve/create instance of SharedPreferences called "sharedPrefs"
                SharedPreferences sharedPref = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
                //Retrieve/create editor instance in sharedPref
                SharedPreferences.Editor editor = sharedPref.edit();
                //add value of "text" to editor
                editor.putString("stringKey", text);
                //apply to save changes to editor
                editor.apply();

                //Testing if sharedPref has stored the value correctly
                String test = sharedPref.getString("stringKey", "");
                Log.d("==>>", "Value: " + test);

                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}