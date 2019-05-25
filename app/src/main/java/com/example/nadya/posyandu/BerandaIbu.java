package com.example.nadya.posyandu;

import android.app.ProgressDialog;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.nadya.posyandu.Model.Anak;
import com.example.nadya.posyandu.Model.Ibu;
import com.example.nadya.posyandu.Util.AppController;
import com.example.nadya.posyandu.Util.ServerAPI;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BerandaIbu extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    RecyclerView mRecyclerview;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    List<Ibu> mItems = new ArrayList<Ibu>();
    ProgressDialog pd;
    TextView nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda_ibu);

        //Menerima Data Ibu dari LOGIN
        Ibu dataDiterima = getIntent().getParcelableExtra("DATAIBU");

        pd = new ProgressDialog(BerandaIbu.this);
        mItems = new ArrayList<Ibu>();
        nama = findViewById(R.id.nama_anak);

        //Memuat Data Anak dari DB
        loadJson(dataDiterima.getId());

        loadFragment(new HomeFragment());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bn_beranda);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem ) {
        Fragment fragment=null;
        switch (menuItem.getItemId()) {
            case R.id.profil_menu:
                fragment= new ProfilFragment();
                break;
            case R.id.posyandu_menu:
                fragment= new PosyanduFragment();
                break;
            case R.id.home_menu:
                fragment= new HomeFragment();
                break;
        }
       return loadFragment(fragment);
    }

    //Mengambil Data Anak dari DB
    private void loadJson(final int id) {
        pd.setMessage("Mengambil Data");
        pd.setCancelable(false);
        pd.show();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, ServerAPI.URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.dismiss();
                        Log.d("volley","response : " + response.toString());
                        Log.d("tolol","respones :"+ mItems.isEmpty());

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("read");

                            if (success.equals("1")){

                                for (int i =0; i < jsonArray.length(); i++){

                                    JSONObject object = jsonArray.getJSONObject(i);

                                    int intId = object.getInt("id");
                                    String strNama = object.getString("nama").trim();


                                    Anak md = new Anak();
                                    md.setId(intId);
                                    md.setNama(strNama);

                                    nama.setText(md.getNama());
                                }
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            pd.dismiss();
                            Toast.makeText(BerandaIbu.this, "Error Reading Detail "+e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.dismiss();
                        Toast.makeText(BerandaIbu.this, "Error Reading Detail "+error.toString(), Toast.LENGTH_SHORT).show();
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
