package com.example.ejercicioclase_sergio_alvaredo;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent1);

        btn = findViewById(R.id.btn1);
        btn.setOnClickListener(view -> cambiarCalculadora());

        btn = findViewById(R.id.btn2);
        btn.setOnClickListener(view -> cambiarFormulario());

        btn = findViewById(R.id.btn3);
        btn.setOnClickListener(view -> cambiarDados());

    }

    public void cambiarCalculadora() {
        android.content.Intent starter = new android.content.Intent(this, Calculadora.class);
        startActivity(starter);
    }

    public void cambiarFormulario() {
        android.content.Intent starter = new android.content.Intent(this, Formulario.class);
        startActivity(starter);
    }

    public void cambiarDados() {
        android.content.Intent starter = new android.content.Intent(this, Dados.class);
        startActivity(starter);
    }


}