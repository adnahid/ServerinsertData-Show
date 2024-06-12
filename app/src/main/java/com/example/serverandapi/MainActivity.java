package com.example.serverandapi;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.ResponseCache;
import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {

   // ListView listView;

    CardView VolleyHomeWork;




    //ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    //HashMap<String,String> hashMap = new HashMap<>();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //listView = findViewById(R.id.listView);
        VolleyHomeWork= findViewById(R.id.VolleyHomeWork);





        VolleyHomeWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,VolleyHomeWork01.class);
                startActivity(intent);
            }
        });





/*
        LoadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                progressBar.setVisibility(View.GONE);
                                try {
                                    JSONObject jsonObject = new JSONObject(response);

                                    text.setText(jsonObject.toString());

                                    //String name = jsonObject.getString("Name");
                                    //String gen = jsonObject.getString("Gen");
                                    //String email = jsonObject.getString("Email");

                                    tvName.setText(name.toString());
                                    //tvEmail.setText(email.toString());
                                   // tvGen.setText(gen.toString());




                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }


                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressBar.setVisibility(View.GONE);
                        text.setText("That didn't work!");
                    }
                });

// Add the request to the RequestQueue.
                queue.add(stringRequest);

            }
        });

 */


//        LoadData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,"https://hedgier-oars.000webhostapp.com/apps/file.json",
//                        null, new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject jsonObject) {
//                        progressBar.setVisibility(View.GONE);
//                        Log.d("ServerRs",jsonObject.toString());
//                        text.setText(jsonObject.toString());
//
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError volleyError) {
//                        progressBar.setVisibility(View.GONE);
//                        text.setText(volleyError.toString());
//                    }
//                });
//
//                RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
//                requestQueue.add(jsonObjectRequest);
//            }
//        });










/*

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://hedgier-oars.000webhostapp.com/apps/file.json", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                progressBar.setVisibility(View.GONE);
               // Log.d("ServerRs",jsonArray.toString());

                try {
                    for (int x=0; x<jsonArray.length(); x++) {

                        JSONObject object = jsonArray.getJSONObject(x);
                        String title = object.getString("title");
                        String video_Id = object.getString("videoId");
                        textView.append(x+"."+title+"\n"+video_Id+"\n"+"\n");

                    }


                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                progressBar.setVisibility(View.GONE);
                textView.setText(volleyError.toString());
            }
        });

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
        queue.add(jsonArrayRequest);

 */








        // Adapter adapter = new Adapter();
       // listView.setAdapter(adapter);





    }

    /*
    private class Adapter extends BaseAdapter{

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
           View Myview =  inflater.inflate(R.layout.video_item,null,false);
            CardView cardView = Myview.findViewById(R.id.cardView);
            TextView tvText = Myview.findViewById(R.id.tvText);
            ImageView imageView = Myview.findViewById(R.id.imageView);




            return Myview;
        }
    }

    private class Listener {

    }

     */
}