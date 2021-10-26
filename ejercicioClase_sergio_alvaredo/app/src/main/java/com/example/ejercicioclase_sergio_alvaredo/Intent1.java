package com.example.ejercicioclase_sergio_alvaredo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Intent1 extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent1);

        btn = findViewById(R.id.btn1);
        btn.setOnClickListener(view -> cambiarCalculadora());

        btn = findViewById(R.id.btn2);
        btn.setOnClickListener(view -> cambiarFormulario());

    }

    public void cambiarCalculadora() {
        android.content.Intent starter = new android.content.Intent(this, Calculadora.class);
        startActivity(starter);
    }

    public void cambiarFormulario() {
        android.content.Intent starter = new android.content.Intent(this, Formulario.class);
        startActivity(starter);
    }


}