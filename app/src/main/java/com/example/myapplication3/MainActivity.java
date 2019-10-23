package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication3.model.ex;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.Response;
import com.android.volley.Request;

import org.json.*;

import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import com.example.myapplication3.utilUI.*;
import com.example.myapplication3.model.model_ejercicioSubCategoria;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    public static final String EXTRA_MESSAGE = "com.example.myapplication3.MESSAGE";
    clickPierna clickListernerPierna;
    clickTorso clickListenerTorso;
    clickArm clickListenerBrazo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UtilTable mtable= new UtilTable();
        //mtable.CreateTableRow((TableLayout) findViewById(R.id.tbl_layout01),R.drawable.leg02,"las cbablab",this);
        initClickListeners();
        CreateMenuEjercicios();
        //CreateTableRow((TableLaut) findViewById(R.id.tbl_layout01),R.drawable.leg02,"las cosas te ayudan a blablablab");

//        requestQueue = Volley.newRequestQueue(this);
//
        int a=2;
    }
    void initClickListeners()
    {
        this.clickListenerBrazo= new clickArm(this);
        this.clickListenerTorso= new clickTorso(this);
        this.clickListernerPierna= new clickPierna(this);
    }
   /* View.OnClickListener onclickBrazo;
    View.OnClickListener onclickTorso;
    View.OnClickListener onclickPierna;
    public void initClickListeners()
    {
        onclickPierna= new View.OnClickListener(){
            public void onClick(View v){
                //nos va a iniciar una actividad
                goToPiernaSub();
            }
        };
        onclickBrazo= new View.OnClickListener(){
            public void onClick(View v){
                //nos va a iniciar una actividad
                goToBrazoSub();
            }
        };
        onclickTorso= new View.OnClickListener(){
            public void onClick(View v){
                //nos va a iniciar una actividad
                goToTorsoSub();
            }
        };

    }
    public void clickReq(View v)
    {
        int a =1;
       goToSubCategory();
        //makeJsonRequest();
    }
    protected void goToSubCategory()
    {

        foo mfoo= new foo();
        foo mfoo2= new foo();
        mfoo2.a="bbb";
        ArrayList<foo> fooArrayList = new ArrayList<foo>();

        fooArrayList.add(mfoo);
        fooArrayList.add(mfoo2);

        TextView editText = (TextView) findViewById(R.id.idtext);
        String message = editText.getText().toString();

        Intent intent = new Intent(this, ejercicioSubCategoria.class);
        intent.putExtra("foo", fooArrayList);

        startActivity(intent);

    }
    void goToPiernaSub()
    {

        ArrayList<model_ejercicioSubCategoria> Array_Ejercicios_Pierna= new ArrayList<model_ejercicioSubCategoria>
                (
                        Arrays.asList (new model_ejercicioSubCategoria("Extensión de piernas patada de mula",
                                        "Te pones en la maquina es fea y das patadas como mula...",0),
                                new model_ejercicioSubCategoria("las ligas esas",
                                        "Levantas una pierna en lateral y dejas la otra en el piso...",0))

                );


        _startActivity(Array_Ejercicios_Pierna,ejercicioSubCategoria.class,"model_ejercicioSubCategoria");
    }

    void _startActivity(ArrayList<?>_array , Class<?>Actividad_A_Iniciar, String nombreClaseDeParametros)
    {
        Intent intent = new Intent(this, Actividad_A_Iniciar);
        intent.putExtra(nombreClaseDeParametros, _array);

        startActivity(intent);
    }
   */
    void CreateMenuEjercicios()
    {
        //clickPierna cp= new clickPierna(this);
        TableLayout tl= (TableLayout) findViewById(R.id.tbl_layout01);
        CreateTableRow(tl,R.drawable.leg02,"Ejercicios para piernas belllas",this.clickListernerPierna);
        CreateTableRow(tl,R.drawable.torso02,"Ejercicios para reafirmar el torso",this.clickListenerTorso);
        CreateTableRow(tl,R.drawable.arm01,"Ejercicios para brazos fuertes",this.clickListenerBrazo);

    }
    protected void CreateTableRow(TableLayout ptr_tblLayout, int img_src , String Texto, View.OnClickListener clickListen)
    {
        TableRow row= new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        lp.setMargins(100, 100, 0, 0);


        row.setBackgroundColor(Color.parseColor("#FFFFFF"));

        ImageView img_view= new ImageView(this);
        TextView descripcion = new TextView(this);
        img_view.setImageDrawable(getResources().getDrawable(img_src, getApplicationContext().getTheme()));
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

        /*img_view.setImageResource(R.drawable.arm01);
        myImgView.setBackgroundResource(R.drawable.monkey);
         myImgView.setImageDrawable(getResources().getDrawable(R.drawable.monkey));
*/
        descripcion.setText(Texto);


        row.addView(img_view);
        row.addView(descripcion);


        ptr_tblLayout.addView(row);
    }
    protected  void makeJsonRequest()
    {
        final TextView txt = findViewById(R.id.idtext);
        try {


            //String url = "https://jsonplaceholder.typicode.com/todos/1";
            String url2="http://158.69.48.190/LTI/jsonresponseTest.php";

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, url2, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            txt.setText("Response: " + response.toString());
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO: Handle error
                            txt.setText(error.getMessage());
                        }
                    });



// Add the request to the RequestQueue.
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            txt.setText(e.getMessage());

            int b;
        }
    }
    protected void makeRequest() {
        try {


            String url = "http://www.google.com";
            final TextView txt = findViewById(R.id.idtext);

// Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Display the first 500 characters of the response string.
                            txt.setText("Response is: " + response.substring(0, 500));
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    txt.setText(error.getMessage());
                }
            });

// Add the request to the RequestQueue.
            requestQueue.add(stringRequest);
        } catch (Exception e) {
        String msg= e.getMessage();
        int b;
        }
    }
}
abstract class clickInterface implements View.OnClickListener {
    model_ejercicioSubCategoria ejerciciosSub;
    public clickInterface(Context con)
    {
        this.con= con;

    }
    protected Context con;
    @Override
    public void onClick(View v) {
        goToPage();
    }
    /*esta clase se sobrescribe en cada hijo*/

    abstract  ArrayList<?> setIntent();

    final void goToPage()
    {

        Intent intent = new Intent(con, ejercicioSubCategoria.class );
         String str_ejerciciossub= ejercicioSubCategoria.class.toString();
        intent.putExtra("model_ejercicioSubCategoria", setIntent());
        con.startActivity(intent);
    }
}
class clickTorso extends  clickInterface{
    public clickTorso(Context con)
    {
        super(con);
    }
    @Override
    ArrayList<?> setIntent() {
        ArrayList<model_ejercicioSubCategoria>array_ejerciosTorsoSub = new ArrayList<model_ejercicioSubCategoria>
                (
                        Arrays.asList(new model_ejercicioSubCategoria("abdominales en banquillo",
                                "en un banquillo pon tus pies en el amrco y utiliza el abdomen para flexionar...",
                                R.drawable.torso01_01) )
                );
        return array_ejerciosTorsoSub;
    }
}
class clickArm extends  clickInterface{
    public clickArm(Context con){super(con);}
    @Override
    ArrayList<?> setIntent() {
        ArrayList<model_ejercicioSubCategoria> array_ejerciciosBrazoSub= new ArrayList<model_ejercicioSubCategoria>
                (
                        Arrays.asList(  new model_ejercicioSubCategoria("Biceps con mancuerna","con una mancuerna y el brazo flexionado..",
                                R.drawable.arm01))
                );
        return  array_ejerciciosBrazoSub;
    }
}

class clickPierna extends clickInterface {

    public clickPierna(Context con)
    {
        super(con);
    }
    @Override
    ArrayList<?> setIntent() {

        ArrayList<model_ejercicioSubCategoria> Array_Ejercicios_Brazo = new ArrayList<model_ejercicioSubCategoria>
                (
                        Arrays.asList (new model_ejercicioSubCategoria("Extensión de tríceps con mancuerna",
                                        "Posición de sentadilla, con los pies algo separados y rodillas ligeramente flexionadas...",R.drawable.leg01_01),
                                new model_ejercicioSubCategoria("Elevación lateral de hombros",
                                        "De pie, con las manos a los lados, y las piernas ligeramente flexionadas, toma una mancuerna de 2 kilos en cada una...",R.drawable.leg01_02),
                                new model_ejercicioSubCategoria("'Curl' de bíceps al unísono",
                                        "De pie, con los pies algo separados y rodillas ligeramente flexionadas, agarra una mancuerna de 2 kg con cada mano...",R.drawable.leg01_03),
                                new model_ejercicioSubCategoria("Triceps con mancuerna",
                                        "De pie, con los pies algo separados y rodillas ligeramente flexionadas, sostén las mancuernas con los brazos elevados a la altura de los hombros. ",R.drawable.leg01_04)
                        )
                );


        return Array_Ejercicios_Brazo;
    }



}
