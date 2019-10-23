package com.example.myapplication3.utilUI;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class UtilTable {
    public UtilTable(){}
    public void CreateTableRow(Context con,TableLayout ptr_tblLayout, int img_src , String Texto, View.OnClickListener clickListen)
    {
        TableRow row= new TableRow(con);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
        lp.setMargins(100, 100, 0, 0);


        row.setBackgroundColor(Color.parseColor("#FFFFFF"));

        ImageView img_view= new ImageView(con);
        TextView descripcion = new TextView(con);
        descripcion.setMaxLines(4);

        descripcion.setWidth(700);
        img_view.setImageDrawable(con.getResources().getDrawable(img_src, con.getApplicationContext().getTheme()));
        img_view.setOnClickListener(clickListen);
        descripcion.setOnClickListener(clickListen);
        /*img_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToSubCategory();
            }
        });*/
        row.setLayoutParams(lp);
        row.setOnClickListener(clickListen);
        descripcion.setLayoutParams(lp);


        descripcion.setText(Texto);


        row.addView(img_view);
        row.addView(descripcion);


        ptr_tblLayout.addView(row);
    }

   /* public void CreateTableRow(TableLayout ptr_tblLayout, int img_src , String Texto, Context con)
    {
        TableRow row= new TableRow(con);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        lp.setMargins(100, 100, 0, 0);


        row.setBackgroundColor(Color.parseColor("#FFFFFF"));

        ImageView img_view= new ImageView(con);
        TextView descripcion = new TextView(con);
        img_view.setImageDrawable(con.getResources().getDrawable(img_src, con.getApplicationContext().getTheme()));
        img_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
        row.setLayoutParams(lp);
        descripcion.setLayoutParams(lp);

        //img_view.setImageResource(R.drawable.arm01);
        //myImgView.setBackgroundResource(R.drawable.monkey);
         //myImgView.setImageDrawable(getResources().getDrawable(R.drawable.monkey));

        descripcion.setText(Texto);


        row.addView(img_view);
        row.addView(descripcion);


        ptr_tblLayout.addView(row);
    }*/
}
