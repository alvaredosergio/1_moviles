package com.example.colorstapgame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Juego extends AppCompatActivity {
    ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private TextView temp;
    private TextView textSeg;
    private int puntuacion;
    private TextView textoPuntos;
    private CountDownTimer cdt;
    private long timeLeftInMilliseconds = 11000; // 11 segundos
    private boolean timeRunning;

    final int rojo = R.drawable.boton_redondo_rojo;
    final int rojoClaro = R.drawable.boton_redondo_rojo_claro;
    final int azul = R.drawable.boton_redondo_azul;
    final int azulClaro = R.drawable.boton_redondo_azul_claro;
    final int verde = R.drawable.boton_redondo_verde;
    final int verdeClaro = R.drawable.boton_redondo_verde_claro;
    final int amarillo = R.drawable.boton_redondo_amarillo;
    final int amarilloClaro = R.drawable.boton_redondo_amarillo_claro;

    int ultimoColor = -1;

    public void startStop() {
        if (timeRunning) {
            stopTimer();
        } else {
            startTimer();
        }
    }

    public void startTimer() {
        cdt = new CountDownTimer(timeLeftInMilliseconds, 100) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        timeRunning = true;
    }

    public void stopTimer() {
        cdt.cancel();
        timeRunning = false;
    }

    public void updateTimer() {
        int seconds = (int) timeLeftInMilliseconds / 1000;
        String timeLeftText;
        timeLeftText = "" + seconds;
        temp.setText(timeLeftText);
        if (timeLeftText.equals("0")) {
            btn1.setEnabled(false);
            btn2.setEnabled(false);
            btn3.setEnabled(false);
            btn4.setEnabled(false);
            btn5.setEnabled(false);
            btn6.setEnabled(false);
            btn7.setEnabled(false);
            btn8.setEnabled(false);
            btn9.setEnabled(false);
            temp.setText("PERDISTE");
            temp.setTextColor(Color.rgb(168,0,0));
            textSeg.setVisibility(View.INVISIBLE);

        }
    }

    public void sumarPuntos() {
        puntuacion++;
        String n = String.valueOf(puntuacion);
        textoPuntos.setText(n);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        startStop();

        temp = findViewById(R.id.temporizador);
        textSeg = findViewById(R.id.textSeg);

        btn1 = findViewById(R.id.b1);
        btn2 = findViewById(R.id.b2);
        btn3 = findViewById(R.id.b3);
        btn4 = findViewById(R.id.b4);
        btn5 = findViewById(R.id.b5);
        btn6 = findViewById(R.id.b6);
        btn7 = findViewById(R.id.b7);
        btn8 = findViewById(R.id.b8);
        btn9 = findViewById(R.id.b9);
        textoPuntos = findViewById(R.id.puntos);

        btn1.setOnClickListener(view -> {
            sumarPuntos();
            cdt.start();
            shuffleButtons();
        });

    }

    public void shuffleButtons(){
        Random rn = new Random((new Date()).getTime());
        int r = rn.nextInt(4);
        List<ImageButton> botones = Arrays.asList(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);

        if(r == ultimoColor){
            if(r != 4){
                r = 0;
            }else{
                r++;
            }
        }

        if (r == 0) {
            //Amarillo
            colorChange(botones,amarillo,amarilloClaro);

        } else if (r == 1) {
            //Rojo
            colorChange(botones,rojo,rojoClaro);

        } else if (r == 2) {
            //Verde
            colorChange(botones,verde,verdeClaro);

        } else if (r == 3) {
            //Azul
            colorChange(botones,azul,azulClaro);
        }
        ultimoColor = r;
    }

    public void colorChange(List <ImageButton> colores, int colorComun, int colorCorrecto){
        Collections.shuffle(colores);
        colores.get(0).setImageResource(colorCorrecto);
        colores.get(1).setImageResource(colorComun);
        colores.get(2).setImageResource(colorComun);
        colores.get(3).setImageResource(colorComun);
        colores.get(4).setImageResource(colorComun);
        colores.get(5).setImageResource(colorComun);
        colores.get(6).setImageResource(colorComun);
        colores.get(7).setImageResource(colorComun);
        colores.get(8).setImageResource(colorComun);
    }
}