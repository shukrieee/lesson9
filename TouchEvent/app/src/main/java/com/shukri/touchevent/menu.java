package com.shukri.touchevent;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

            }

    public void play(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
    public void playFour(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

    }


