package com.example.ejercicioclase_sergio_alvaredo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnSuma,btnResta,btnMulti,btnDiv,btnC,btnDel,btnComa,btnIgual,btnPorc;
    TextView texto;

    float valor1;
    float valor2;
    float resultado;
    char operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        btn0 = findViewById(R.id.id0);
        btn1 = findViewById(R.id.id1);
        btn2 = findViewById(R.id.id2);
        btn3 = findViewById(R.id.id3);
        btn4 = findViewById(R.id.id4);
        btn5 = findViewById(R.id.id5);
        btn6 = findViewById(R.id.id6);
        btn7 = findViewById(R.id.id7);
        btn8 = findViewById(R.id.id8);
        btn9 = findViewById(R.id.id9);
        btnSuma = findViewById(R.id.idsuma);
        btnResta = findViewById(R.id.idresta);
        btnMulti = findViewById(R.id.idmulti);
        btnDiv = findViewById(R.id.iddivision);
        btnC = findViewById(R.id.idc);
        btnDel = findViewById(R.id.idborrar);
        btnComa = findViewById(R.id.idcoma);
        btnIgual = findViewById(R.id.idigual);
        btnPorc = findViewById(R.id.idporcentaje);

        texto = findViewById(R.id.result);

        btn0.setOnClickListener(view -> pintar(0));
        btn1.setOnClickListener(view -> pintar(1));
        btn2.setOnClickListener(view -> pintar(2));
        btn3.setOnClickListener(view -> pintar(3));
        btn4.setOnClickListener(view -> pintar(4));
        btn5.setOnClickListener(view -> pintar(5));
        btn6.setOnClickListener(view -> pintar(6));
        btn7.setOnClickListener(view -> pintar(7));
        btn8.setOnClickListener(view -> pintar(8));
        btn9.setOnClickListener(view -> pintar(9));


        btnSuma.setOnClickListener(view -> clickOperador('+'));
        btnResta.setOnClickListener(view -> clickOperador('-'));
        btnMulti.setOnClickListener(view -> clickOperador('*'));
        btnDiv.setOnClickListener(view -> clickOperador('/'));
        btnPorc.setOnClickListener(view -> clickOperador('%'));

        btnIgual.setOnClickListener(view -> calcular());

        btnC.setOnClickListener(view -> borrar());
    }

    public void pintar(int numero){
        texto.append(Integer.toString(numero));
    }

    public float sumar(float valor1,float valor2){
        float operacion;
        operacion = valor1 + valor2;
        return operacion;
    }

    public float restar(float valor1,float valor2){
        float operacion;
        operacion = valor1 - valor2;
        return operacion;
    }

    public float multiplicar(float valor1,float valor2){
        float operacion;
        operacion = valor1 * valor2;
        return operacion;
    }

    public float dividir(float valor1,float valor2){
        float operacion;
        operacion = valor1 / valor2;
        return operacion;
    }

    public float porcentaje(float valor1,float valor2){
        float operacion;
        operacion = valor1 % valor2;
        return operacion;
    }

    public void clickOperador(char operador){
        valor1 = Float.parseFloat(texto.getText().toString());
        this.operador = operador;
        texto.setText("");
    }

    public void calcular(){
        valor2 = Float.parseFloat(texto.getText().toString());
        switch (operador) {
            case '+':
                resultado = sumar(valor1, valor2);
                break;
            case '-':
                resultado = restar(valor1, valor2);
                break;
            case '*':
                resultado = multiplicar(valor1, valor2);
                break;
            case '/':
                resultado = dividir(valor1, valor2);
                break;
            case '%':
                resultado = porcentaje(valor1, valor2);
                break;
            default: texto.setText("ERROR");
            return;
        }
        texto.setText(Float.toString(resultado));
    }

    public void borrar(){
        texto.setText("");
    }




}