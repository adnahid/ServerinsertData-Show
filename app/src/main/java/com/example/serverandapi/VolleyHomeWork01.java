package com.example.serverandapi;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

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

import java.util.ArrayList;
import java.util.HashMap;

public class VolleyHomeWork01 extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;


    ProgressBar progressBar;
    EditText edName,edEmail,edMobile;

    Button LoadData;

    ListView listView;

    HashMap<String,String> hashMap = new HashMap<>();
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();


    final String url = "https://hedgier-oars.000webhostapp.com/apps/file.json";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.volleyhomework01);
        progressBar = findViewById(R.id.progressBar);
        //text = findViewById(R.id.text);
        edName = findViewById(R.id.edName);
        edEmail = findViewById(R.id.edEmail);
        edMobile = findViewById(R.id.edMobile);
        LoadData = findViewById(R.id.LoadData);
        listView  = findViewById(R.id.listView);
        RequestQueue requestQueue = Volley.newRequestQueue(VolleyHomeWork01.this);
        loadData();




       LoadData.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              String Name = edName.getText().toString();
              String Email = edEmail.getText().toString();
              String Mobile = edMobile.getText().toString();
              String url = "https://hedgier-oars.000webhostapp.com/apps/data.php?n="+Name+"&m="+ Mobile +"&e=" +Email;




              progressBar.setVisibility(View.VISIBLE);
               StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                   @Override
                   public void onResponse(String s) {
                       progressBar.setVisibility(View.GONE);
                       loadData();

                   }
               }, new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError volleyError) {
                       LoadData.setText(""+volleyError);

                   }
               });

              if (edName.length()>0 & edEmail.length()>0 && edMobile.length()>0){
                  requestQueue.add(stringRequest);
                  new AlertDialog.Builder(VolleyHomeWork01.this)
                          .setTitle("Server Response")
                          .setMessage("connect to database\n" +
                                  "Query Successfull")
                          .show();
              }else {
                  Toast.makeText(VolleyHomeWork01.this, "Data Not Save", Toast.LENGTH_SHORT).show();
                  progressBar.setVisibility(View.GONE);
              }





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


         LoadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,"https://hedgier-oars.000webhostapp.com/apps/file.json",
                        null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        progressBar.setVisibility(View.GONE);
                        Log.d("ServerRs",jsonObject.toString());
                        //text.setText(jsonObject.toString());
                        try {
                            String name = jsonObject.getString("Name");
                            String gen = jsonObject.getString("Gen");
                            String email = jsonObject.getString("Email");

                            tvName.setText(name);
                            tvMobile.setText(gen);
                            tvEmail.setText(email);

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        progressBar.setVisibility(View.GONE);
                        //text.setText(volleyError.toString());
                    }
                });

                requestQueue.add(jsonObjectRequest);
            }
        });






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







    }


    //////////Adapter

    public class Myadapter extends BaseAdapter{

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
            LayoutInflater layoutInflater = getLayoutInflater();

            View myView = layoutInflater.inflate(R.layout.item_layout,null);
            TextView tvId = myView.findViewById(R.id.tvId);
            TextView tvName = myView.findViewById(R.id.tvName);
            TextView tvEmail = myView.findViewById(R.id.tvEmail);
            TextView tvMobile = myView.findViewById(R.id.tvMobile);
            Button update = myView.findViewById(R.id.update);
            Button delete = myView.findViewById(R.id.delete);

            hashMap = arrayList.get(position);
            String id = hashMap.get("id");
            String name = hashMap.get("name");
            String email = hashMap.get("email");
            String mobile = hashMap.get("mobile");

            tvId.setText(id);
            tvName.setText(name);
            tvEmail.setText(email);
            tvMobile.setText(mobile);


            update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name = edName.getText().toString();
                    String email = edEmail.getText().toString();
                    String mobile = edMobile.getText().toString();
                    String url = "https://hedgier-oars.000webhostapp.com/apps/update.php?id="+id+ "&name="+name+ "&email="+email+ "&mobile="+mobile;


                    progressBar.setVisibility(View.VISIBLE);
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            progressBar.setVisibility(View.GONE);
                            new AlertDialog.Builder(VolleyHomeWork01.this)
                                    .setTitle("Server Response")
                                    .setMessage(s)
                                    .show();
                            loadData();

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            Log.d("update",volleyError.toString());

                        }
                    });
                    RequestQueue requestQueue = Volley.newRequestQueue(VolleyHomeWork01.this);
                    requestQueue.add(stringRequest);





                }
            });


            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = "https://hedgier-oars.000webhostapp.com/apps/delete.php?id="+id;


                    progressBar.setVisibility(View.VISIBLE);
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            progressBar.setVisibility(View.GONE);
                            new AlertDialog.Builder(VolleyHomeWork01.this)
                                    .setTitle("Server Response")
                                    .setMessage(s)
                                    .show();
                            loadData();

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            Log.d("update",volleyError.toString());

                        }
                    });
                    RequestQueue requestQueue = Volley.newRequestQueue(VolleyHomeWork01.this);
                    requestQueue.add(stringRequest);





                }
            });




            return myView;
        }
    }

    private void loadData(){



        arrayList = new ArrayList<>();
        progressBar.setVisibility(View.VISIBLE);
        RequestQueue requestQueue = Volley.newRequestQueue(VolleyHomeWork01.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, "https://hedgier-oars.000webhostapp.com/apps/get.php", null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                progressBar.setVisibility(View.GONE);

                for (int x=1; x<response.length();x++){

                    try {
                        JSONObject jsonObject = response.getJSONObject(x);
                        String id = jsonObject.getString("id");
                        String name = jsonObject.getString("name");
                        String email = jsonObject.getString("email");
                        String mobile = jsonObject.getString("mobile");

                        hashMap = new HashMap<>();
                        hashMap.put("id",id);
                        hashMap.put("name",name);
                        hashMap.put("email",email);
                        hashMap.put("mobile",mobile);
                        arrayList.add(hashMap);

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                }

                if (arrayList.size()>0){
                    Myadapter myadapter = new Myadapter();
                    listView.setAdapter(myadapter);
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                progressBar.setVisibility(View.GONE);

            }
        });
        requestQueue.add(jsonArrayRequest);

    }












}