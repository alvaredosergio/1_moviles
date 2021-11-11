package com.example.juegodados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class dicesGame extends AppCompatActivity {
    // Botones
    Button jugar, generar;

    // TextViews
    TextView d1, d2, d3, d4, resultado;

    // Valor en int de los dados
    int dice1, dice2, dice3, dice4, comprobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicesgame);

        // Obtener id de Botones
        jugar = findViewById(R.id.button1);
        generar = findViewById(R.id.button2);

        // Obtener id de TextViews de los dados
        d1 = findViewById(R.id.dado1);
        d2 = findViewById(R.id.dado2);
        d3 = findViewById(R.id.dado3);
        d4 = findViewById(R.id.dado4);

        // Pasar a int las Views de los dados
        dice1 = 0;
        dice2 = 0;
        dice3 = 0;
        dice4 = 0;
        comprobar = 0;

        // View del resultado de la suma de los dados
        resultado = findViewById(R.id.result);

        // OnClickListeners
        generar.setOnClickListener(view -> {
            pintar(d1, d2, d3, d4);
            sumar(dice1, dice2, dice3, dice4);
        });
        jugar.setOnClickListener(view -> comprobacion());
    }

    public void pintar(TextView d1, TextView d2, TextView d3, TextView d4) {
        dice1 = dado1Random();
        dice2 = dado2Random();
        dice3 = dado3Random();
        dice4 = dado4Random();

        d1.setText(Integer.toString(dice1));
        d2.setText(Integer.toString(dice2));
        d3.setText(Integer.toString(dice3));
        d4.setText(Integer.toString(dice4));
    }

    public int dado1Random() {
        Random r = new Random();
        int n = r.nextInt(12) + 1;
        return n;
    }

    public int dado2Random() {
        Random r = new Random();
        int n = r.nextInt(4) + 1;
        return n;
    }

    public int dado3Random() {
        Random r = new Random();
        int n = r.nextInt(20) + 1;
        return n;
    }

    public int dado4Random() {
        Random r = new Random();
        int n = r.nextInt(8) + 1;
        return n;
    }

    public void sumar(int n1, int n2, int n3, int n4) {
        int operacion;
        operacion = n1 + n2 + n3 + n4;
        resultado.setText(Integer.toString(operacion));
        comprobar = Integer.parseInt(resultado.getText().toString());
    }

    public void comprobacion() {
        Intent i = new Intent(this, Mensajes.class);
        if (comprobar == 0) return;
        if (comprobar > 0 && comprobar <= 20) {
            i.putExtra("estado", "YOU DIED");
            i.putExtra("color", "rojo");
            startActivity(i);

        } else if (comprobar >= 21 && comprobar <= 39) {
            i.putExtra("estado", "YOU WIN");
            i.putExtra("color", "verde");
            startActivity(i);

        } else if (comprobar > 40) {
            i.putExtra("estado", "1");
            i.putExtra("color", "amarillo");
            startActivity(i);
        }
    }


}