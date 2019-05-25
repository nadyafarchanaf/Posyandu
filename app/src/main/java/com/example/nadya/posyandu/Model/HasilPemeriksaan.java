package com.example.nadya.posyandu.Model;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.nadya.posyandu.BerandaIbu;
import com.example.nadya.posyandu.Util.AppController;
import com.example.nadya.posyandu.Util.ServerAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HasilPemeriksaan {
    Double beratBadan, tinggiBadan;
    String imunisasi;
    int anak_id;

    public HasilPemeriksaan(){}

    public HasilPemeriksaan(Double beratBadan, Double tinggiBadan, String imunisasi, int anak_id){
        this.beratBadan = beratBadan;
        this.tinggiBadan = tinggiBadan;
        this.imunisasi = imunisasi;
        this.anak_id = anak_id;
    }

    public Double getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(Double beratBadan) {
        this.beratBadan = beratBadan;
    }

    public Double getTinggiBadan() {
        return tinggiBadan;
    }

    public void setTinggiBadan(Double tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    public String getImunisasi() {
        return imunisasi;
    }

    public void setImunisasi(String imunisasi) {
        this.imunisasi = imunisasi;
    }

    public int getAnak_id() {
        return anak_id;
    }

    public void setAnak_id(int anak_id) {
        this.anak_id = anak_id;
    }

    public static void getHasilPemeriksaan(final int id, final Context context, final TextView textView1) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, ServerAPI.URL_DATA_PEMERIKSAAN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("volley","response : " + response.toString());

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("read");

                            if (success.equals("1")){

                                for (int i =0; i < jsonArray.length(); i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    int intId = object.getInt("id");
                                    Double beratBadan = object.getDouble("berat_badan");
                                    Double tinggiBadan = object.getDouble("tinggi_badan");
                                    String strImunisasi = object.getString("imunisasi").trim();

                                    HasilPemeriksaan hasilPemeriksaan = new HasilPemeriksaan(beratBadan,tinggiBadan,strImunisasi,intId);
                                    textView1.setText(Double.toString(beratBadan));
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(context, "Error Reading Detail "+e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context, "Error Reading Detail "+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams(){
                Map<String, String > params = new HashMap<>();
                params.put("id", Integer.toString(id));
                return params;
            }
        };

        AppController.getInstance().addToRequestQueue(stringRequest);
    }
}
