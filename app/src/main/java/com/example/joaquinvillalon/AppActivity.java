package com.example.joaquinvillalon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class AppActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        String username = getIntent().getStringExtra("username");
        TextView textUsername = findViewById(R.id.idTextUsername);
        Button btnSalir = findViewById(R.id.idBtnSalir);

        textUsername.setText(username);

        btnSalir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finishAffinity();
            }
        });
    }
}