package com.example.shared_prefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button subbtn, savebtn;
    private EditText textip;
    private TextView textop;
    private Switch switch1;

    private String text;
    private Boolean switchonoff;


    public static final String SHARED_PREFS = "shared_prefs";
    public static final String TEXT = "text";
    public static final String SWITCH1 = "switch1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textip = (EditText) findViewById(R.id.text_input);
        textop = (TextView) findViewById(R.id.textop);
        subbtn = (Button) findViewById(R.id.subbtn);
        savebtn = (Button) findViewById(R.id.savebtn);
        switch1 = (Switch) findViewById(R.id.switch1);

        subbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textop.setText(textip.getText().toString());
            }
        });

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedate();
            }
        });

        loaddata();
        updteviews();

    }

    public void savedate(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(TEXT, textop.getText().toString());
        editor.putBoolean(SWITCH1, switch1.isChecked());

        editor.apply();
        Toast.makeText(this, "Data saved!", Toast.LENGTH_SHORT).show();

    }

    public void loaddata(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "");
        switchonoff = sharedPreferences.getBoolean(SWITCH1, false);

    }

    public void updteviews(){
        textop.setText(text);
        switch1.setChecked(switchonoff);

    }
}