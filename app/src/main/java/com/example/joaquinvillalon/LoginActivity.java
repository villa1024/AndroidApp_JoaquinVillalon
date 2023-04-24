package com.example.joaquinvillalon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Referencias a los inputs y botones
        EditText inputUsername = findViewById(R.id.idInputUsername);
        EditText inputPassword = findViewById(R.id.idInputPassword);
        Button btnLogin = findViewById(R.id.idBtnSalir);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Obtenemos los datos ingresados por el usuario
                String username = inputUsername.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                // Campos no vacios
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Por favor ingrese el usuario y/o la contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Nombre de usuario al menos de 3 caracteres
                if (username.length() < 3) {
                    Toast.makeText(getApplicationContext(), "El nombre de usuario debe tener al menos 3 caracteres", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Password al menos de 8 caracteres
                if (password.length() < 8) {
                    Toast.makeText(getApplicationContext(), "La contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Enviarlo a la nueva pantalla con la variable de username
                Intent intent = new Intent(LoginActivity.this, AppActivity.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }
}