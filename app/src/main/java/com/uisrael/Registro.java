package com.uisrael;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    Bundle recibirUsuario;
    TextView usuario, pagoMensual;
    EditText nombre, montoInicial;
    Button calcular, guardar;
    double TotalCurso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        usuario = findViewById(R.id.tvUsuario);
        recibirUsuario = getIntent().getExtras();
        String recibirDato = recibirUsuario.getString("usuarioEnviado");
        usuario.setText(recibirDato);

        //Ingresar nombre y montoinicial
        nombre = findViewById(R.id.etNombre);
        montoInicial = findViewById(R.id.etPagoInicial);
        pagoMensual = findViewById(R.id.tvPagoMensual);
        //Boton Calcular
        calcular = findViewById(R.id.btnCalcular);
        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculoPagoMensual();
            }
        });

        //Boton Guardar
        guardar = findViewById(R.id.btnGuardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarDatos();
            }
        });
    }

    public void CalculoPagoMensual(){
        double totalCurso, montoPagado, montoDeuda, interes, pagoMes, pagoMesTotal ;
        totalCurso = 1800;
        interes = totalCurso*0.05;
        montoPagado = Double.parseDouble(montoInicial.getText().toString());
        montoDeuda = totalCurso - montoPagado;
        pagoMes = montoDeuda/3;
        if(montoPagado == 1800){
            pagoMesTotal = 0;
        }else{
            pagoMesTotal = pagoMes+interes;
        }

        pagoMensual.setText(String.format("%.2f",pagoMesTotal));
        TotalCurso =  pagoMesTotal*3 + montoPagado;
    }

    public  void enviarDatos(){
        Intent intentEnvio = new Intent(this, Encuesta.class);
        intentEnvio.putExtra("DatosEnviados", nombre.getText().toString() + "," + usuario.getText().toString()+ ","+String.format("%.2f",TotalCurso));
        Toast.makeText(getApplicationContext(), "Elemento guardado con éxito", Toast.LENGTH_LONG).show();
        startActivity(intentEnvio);
    }
}
