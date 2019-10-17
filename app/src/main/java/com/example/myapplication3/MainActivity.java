package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    public static final String EXTRA_MESSAGE = "com.example.myapplication3.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CreateTableRow((TableLayout) findViewById(R.id.tbl_layout01),R.drawable.leg02,"las cosas te ayudan a blablablab");

//        requestQueue = Volley.newRequestQueue(this);
//
        int a=2;
    }
    View.OnClickListener onclickBrazo;
    View.OnClickListener onclickTorso;
    View.OnClickListener onclickPierna;
    public void initClickLIsteners()
    {
        onclickPierna= new View.OnClickListener(){
            public void onClick(View v){
                /*nos va a iniciar una actividad*/
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
        Intent intent = new Intent(this, ejercicioSubCategoria.class);
        TextView editText = (TextView) findViewById(R.id.idtext);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    protected void CreateTableRow(TableLayout ptr_tblLayout, int img_src , String Texto)
    {
        TableRow row= new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        lp.setMargins(100, 100, 0, 0);


        row.setBackgroundColor(Color.parseColor("#FFFFFF"));

        ImageView img_view= new ImageView(this);
        TextView descripcion = new TextView(this);
        img_view.setImageDrawable(getResources().getDrawable(img_src, getApplicationContext().getTheme()));
        img_view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

            }
        });
        row.setLayoutParams(lp);
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
