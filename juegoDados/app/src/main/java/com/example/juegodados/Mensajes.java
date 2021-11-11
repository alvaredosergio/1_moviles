package com.example.juegodados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Mensajes extends AppCompatActivity {

    TextView texto;
    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajes);

        boton = findViewById(R.id.compartir);
        texto = findViewById(R.id.texto);

        Intent i = getIntent();

        String estado = i.getStringExtra("estado");
        String color = i.getStringExtra("color");


        if (estado.equals("1")) {
            boton.setVisibility(View.VISIBLE);
            texto.setVisibility(View.GONE);
        } else {
            texto.setText(estado);
            if (color.equals("verde")) {
                texto.setTextColor(Color.GREEN);
            } else {
                texto.setTextColor(Color.RED);
            }
        }

        boton.setOnClickListener(view -> Toast.makeText(this, "Has conseguido una puntuanción mayor de 40. Enhorabuena", Toast.LENGTH_SHORT).show());
    }
}