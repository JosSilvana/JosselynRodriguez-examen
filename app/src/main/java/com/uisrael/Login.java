package com.uisrael;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText usuario, contraseña;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario = findViewById(R.id.etUsuario);
        contraseña = findViewById(R.id.etContraseña);
        login = findViewById(R.id.btnLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login(){
        if(usuario.getText().toString().equals("estudiante2020") && contraseña.getText().toString().equals("uisrael2020")){
            Intent intentEnvio = new Intent(this, Registro.class);
            intentEnvio.putExtra("usuarioEnviado", usuario.getText().toString());
            Toast.makeText(getApplicationContext(), "Inicio de sesión exitoso", Toast.LENGTH_LONG).show();
            startActivity(intentEnvio);
        }else{
            Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecto..!!", Toast.LENGTH_LONG).show();
        }
    }
}
