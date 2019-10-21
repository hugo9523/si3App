package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class ejercicioSubCategoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_sub_categoria);

        Intent intent = getIntent();
        ArrayList<foo> fooArrayList = intent.getExtras().getParcelableArrayList("foo");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        //textView.setText(a.a);
    }
}
