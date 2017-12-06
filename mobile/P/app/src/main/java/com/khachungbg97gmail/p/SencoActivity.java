package com.khachungbg97gmail.p;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.khachungbg97gmail.p.R.layout.activity_senco;

public class SencoActivity extends AppCompatActivity {


    private final String TAG = getClass().getSimpleName();
    ListView lvtt;
    ArrayList<ThongTin> arrayList;
    ThongTinAdapter adapter;
    String user;
   // String pass;
    String url = "http://172.16.78.49/androidwebservice/thongtin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_senco);
        lvtt = (ListView) findViewById(R.id.lvtt);
        arrayList = new ArrayList<>();
        Intent intent = getIntent();
        user = intent.getStringExtra("user");
        //pass = intent.getStringExtra("pass");
//        adapter=new SachAdapter(this,R.layout.row,arrayList);
//        lvSach.setAdapter(adapter);
    //     Toast.makeText(SencoActivity.this,user,Toast.LENGTH_LONG).show();
        PutUser(user,url);
        GetData(url);


    }

    private void GetData(String url) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {


                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                arrayList.add(new ThongTin(
                                        jsonObject.getString("NgayQuaHan"),
                                        jsonObject.getString("TenSach"),
                                        jsonObject.getString("TacGia"),
                                        jsonObject.getString("TrangThai")

                               ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        // adapter.notifyDataSetChanged();
                        adapter = new ThongTinAdapter(SencoActivity.this, R.layout.row2, arrayList);
                        lvtt.setAdapter(adapter);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SencoActivity.this, "lỗi", Toast.LENGTH_LONG).show();

            }
        }
        );
        requestQueue.add(jsonArrayRequest);
    }
    public void PutUser(final String user, String url){
        RequestQueue request= Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SencoActivity.this, "lỗi server", Toast.LENGTH_SHORT).show();

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params=new HashMap<>();
                params.put("user",user);

                return params;
            }
        };
        request.add(stringRequest);
    }
}
