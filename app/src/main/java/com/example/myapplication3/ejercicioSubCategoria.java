package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;
import com.example.myapplication3.model.model_ejercicioSubCategoria;
import com.example.myapplication3.utilUI.UtilTable;
import java.util.ArrayList;


public class ejercicioSubCategoria extends AppCompatActivity {

    ArrayList<model_ejercicioSubCategoria> Array_ejerciciosSub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio_sub_categoria);

        Intent intent = getIntent();
        Array_ejerciciosSub = intent.getExtras().getParcelableArrayList("model_ejercicioSubCategoria");
        CreateSubMenu();

        //ArrayList<foo> fooArrayList = intent.getExtras().getParcelableArrayList("foo");

        // Capture the layout's TextView and set the string as its text
        //TextView textView = findViewById(R.id.textView);
        //textView.setText(a.a);
    }
    void CreateSubMenu()
    {
        TableLayout tl= (TableLayout) findViewById(R.id.tbl_layout);



        for(int i=0;i<Array_ejerciciosSub.size();i++)
        {
            model_ejercicioSubCategoria mejercicio= Array_ejerciciosSub.get(i);

            UtilTable ut=new UtilTable();
            ut.CreateTableRow(this,tl,mejercicio.idImagen,mejercicio.descripcion,null);
        }


    }
}
