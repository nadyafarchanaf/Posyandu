package com.example.nadya.posyandu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nadya.posyandu.Adapter.SessionManager;

public class ProfilIbu extends AppCompatActivity {

    Button btn_logout;
    SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_ibu);
        btn_logout = findViewById(R.id.btn_logout);

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionManager.logout();
            }
        });
    }
}




