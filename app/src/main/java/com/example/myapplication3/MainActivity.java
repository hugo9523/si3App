package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);

    }
    public void clickReq(View v)
    {
        int a =1;
        makeJsonRequest();
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
