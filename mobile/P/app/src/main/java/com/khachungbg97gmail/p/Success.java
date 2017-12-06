package com.khachungbg97gmail.p;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

import static com.khachungbg97gmail.p.R.layout.activity_success;

public class Success extends AppCompatActivity {

        private final String TAG = getClass().getSimpleName();
        ListView lvSach;
        ArrayList<Sach> arrayList;
        SachAdapter adapter;
        String user;
        String pass;
        String urlGetData="http://172.16.78.49/androidwebservice/getdata.php";
        String url="http://172.16.78.49/androidwebservice/XuLyMuonSach.php";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(activity_success);
            lvSach = (ListView) findViewById(R.id.lvketquatk);
            arrayList=new ArrayList<>();
            Intent intent=getIntent();
            user=intent.getStringExtra("user");
            pass=intent.getStringExtra("pass");
//        adapter=new SachAdapter(this,R.layout.row,arrayList);
//        lvSach.setAdapter(adapter);
            //Toast.makeText(Success.this,user+""+pass,Toast.LENGTH_LONG).show();;
            GetData(urlGetData);


        }
        private void GetData(String url) {
            RequestQueue requestQueue= Volley.newRequestQueue(this);
            JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONArray>() {


                        @Override
                        public void onResponse(JSONArray response) {
                            for(int i=0;i<response.length();i++){
                                try {
                                    JSONObject jsonObject=response.getJSONObject(i);
                                    arrayList.add(new Sach(
                                            jsonObject.getInt("SachID"),
                                            jsonObject.getInt("LoaiSachID"),
                                            jsonObject.getInt("NgonNguID"),
                                            jsonObject.getString("NhaXB"),
                                            jsonObject.getString("TenSach"),
                                            jsonObject.getString("TacGia"),
                                            jsonObject.getString("NgayNhap"),
                                            jsonObject.getString("GiaTien"),
                                            jsonObject.getInt("SoLuong"),
                                            jsonObject.getInt("SoLuongCon")
                                    ));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            // adapter.notifyDataSetChanged();
                            adapter=new SachAdapter(Success.this,R.layout.row,arrayList);
                            lvSach.setAdapter(adapter);


                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(Success.this,"lỗi",Toast.LENGTH_LONG).show();

                }
            }
            );
            requestQueue.add(jsonArrayRequest);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.option, menu);
            SearchView searchView=(SearchView)menu.findItem(R.id.menuSearch).getActionView();
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    adapter.filter(newText.trim());
                    return false;
                }
            });
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId()) {

                case R.id.tkphieumuon:
                    DiagRegister();
                    break;
                case R.id.tkXem:
                    Intent intent = new Intent(Success.this,SencoActivity.class);
                    intent.putExtra("user",user);
                    startActivity(intent);

            }
            return super.onOptionsItemSelected(item);
        }
        private void DiagRegister(){
            final Dialog dialog=new Dialog(this);
            dialog.setContentView(R.layout.dialogdk);
            final EditText edtMaSach=(EditText)dialog.findViewById(R.id.editmaSachMuon) ;
            final EditText edtNgayMuon=(EditText)dialog.findViewById(R.id.editngaymuon);
            Button btnDk=(Button)dialog.findViewById(R.id.btthemnv);
            Button btnHuy=(Button)dialog.findViewById(R.id.bthuy);
            btnDk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final String editMaSach=edtMaSach.getText().toString();
                    final String editNgayMuon=edtNgayMuon.getText().toString();
                    RequestQueue requestQueue=Volley.newRequestQueue(Success.this);
                    StringRequest stringRequest= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if(response.trim().equals("success")) {
                                Toast.makeText(Success.this,"Đăng ký thành công",Toast.LENGTH_LONG).show();

                            }
                            else {
                                Toast.makeText(Success.this,"lỗi",Toast.LENGTH_LONG).show();
                            }
                        }
                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(Success.this,"Lỗi bên server",Toast.LENGTH_LONG).show();
                                }
                            }
                    ){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params=new HashMap<>();
                            params.put("user",user);
                            params.put("pass",pass);
                            params.put("masach",editMaSach);
                            params.put("date",editNgayMuon);
                            return params;
                        }
                    };
                    requestQueue.add(stringRequest);
                }



            });
            btnHuy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });
            dialog.show();
        }


}
