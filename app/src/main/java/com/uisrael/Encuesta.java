package com.uisrael;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Encuesta extends AppCompatActivity {

    Bundle recibirDatos;
    TextView usuario, nombre;
    EditText respuesta;
    CheckBox cbOpcion1, cbOpcion2, cbOpcion3;
    RadioButton rbOpcion1, rbOpcion2;
    Button enviar;
    String Total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuesta);
        usuario = findViewById(R.id.tvUsuario);
        nombre = findViewById(R.id.tvNombre);
        recibirDatos = getIntent().getExtras();
        String recibirDato = recibirDatos.getString("DatosEnviados");
        String[] datos = recibirDato.split(",");
        nombre.setText(datos[0]);
        usuario.setText(datos[1]);
        Total = datos[2];

        //Respuesta pregunta 1
        respuesta = findViewById(R.id.etRespuesta);

        //Opciones pregunta 2
        cbOpcion1 = findViewById(R.id.cbOpcion1);
        cbOpcion2 = findViewById(R.id.cbOpcion2);
        cbOpcion3 = findViewById(R.id.cbOpcion3);

        //Opciones pregunta 3
        rbOpcion1 = findViewById(R.id.rbOpcion1);
        rbOpcion2 = findViewById(R.id.rbOpcion2);

        enviar = findViewById(R.id.btnEnviar);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarSeleccionPreguntas();
            }
        });
    }

    public void verificarSeleccionPreguntas(){
        String seleccionPregunta1="";
        //Seleccion pregunta 2
        if(cbOpcion1.isChecked()==true)
            seleccionPregunta1 = seleccionPregunta1 + " " + cbOpcion1.getText().toString() + " ";
        if(cbOpcion2.isChecked()==true)
            seleccionPregunta1 = seleccionPregunta1 + " " + cbOpcion2.getText().toString() + " ";
        if(cbOpcion3.isChecked()==true)
            seleccionPregunta1 = seleccionPregunta1 + " " + cbOpcion3.getText().toString() + " ";

        //Seleccion preguntas 3
        String seleccionPregunta2="";
        if(rbOpcion1.isChecked()==true)
            seleccionPregunta2 = rbOpcion1.getText().toString();
        else
        if(rbOpcion2.isChecked()==true)
            seleccionPregunta2 =  rbOpcion2.getText().toString() ;
        else
            seleccionPregunta2 = "NO HAS SELECCIONADO NINGUNA";

        Intent intentEnvio = new Intent(this, Resumen.class);
        intentEnvio.putExtra("respuestasYdatosEnviados", respuesta.getText().toString() + ","
                + seleccionPregunta1 + "," + seleccionPregunta2 + ","
                + nombre.getText().toString() + ","+ usuario.getText().toString() + "," + Total);
        startActivity(intentEnvio);

    }
}
