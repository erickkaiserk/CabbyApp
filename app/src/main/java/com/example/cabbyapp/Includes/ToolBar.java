package com.example.cabbyapp.Includes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.cabbyapp.R;

public class ToolBar {

    public static void show(AppCompatActivity activity, String tittle, boolean upButton){

        Toolbar toolbar=activity.findViewById(R.id.toolbar);
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setTitle(tittle);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
