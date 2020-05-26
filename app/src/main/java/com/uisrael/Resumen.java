package com.uisrael;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resumen extends AppCompatActivity {
    Bundle recibirRepuestasYDatos;
    TextView usuario, nombre, totalApagar, resp1, resp2, resp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        resp1 = findViewById(R.id.tvRespuesta1);
        resp2 = findViewById(R.id.tvRespuesta2);
        resp3 = findViewById(R.id.tvRespuesta3);
        nombre = findViewById(R.id.tvNombre);
        usuario = findViewById(R.id.tvUsuario);
        totalApagar = findViewById(R.id.tvTotalPagar);
        recibirRepuestasYDatos = getIntent().getExtras();
        String recibirDato = recibirRepuestasYDatos.getString("respuestasYdatosEnviados");
        String[] respuestasYDatos = recibirDato.split(",");
        resp1.setText(respuestasYDatos[0]);
        resp2.setText(respuestasYDatos[1]);
        resp3.setText(respuestasYDatos[2]);
        nombre.setText(respuestasYDatos[3]);
        usuario.setText(respuestasYDatos[4]);
        totalApagar.setText(respuestasYDatos[5]);
    }
}
