package com.example.colorstapgame;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

// Game Activity
public class Game extends AppCompatActivity {
    // class variables
    ImageButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private TextView temp, textSeg, textoPuntos;
    public static int puntuacion;
    private CountDownTimer cdt;
    private long timeLeftInMilliseconds = 6000; // 6 seconds
    private boolean timeRunning;

    // Colors drawables references
    final int rojo = R.drawable.boton_redondo_rojo;
    final int rojoClaro = R.drawable.boton_redondo_rojo_claro;
    final int azul = R.drawable.boton_redondo_azul;
    final int azulClaro = R.drawable.boton_redondo_azul_claro;
    final int verde = R.drawable.boton_redondo_verde;
    final int verdeClaro = R.drawable.boton_redondo_verde_claro;
    final int amarillo = R.drawable.boton_redondo_amarillo;
    final int amarilloClaro = R.drawable.boton_redondo_amarillo_claro;
    final int marron = R.drawable.boton_redondo_marron;
    final int marronClaro = R.drawable.boton_redondo_marron_claro;
    final int naranja = R.drawable.boton_redondo_naranja;
    final int naranjaClaro = R.drawable.boton_redondo_naranja_claro;
    final int rosa = R.drawable.boton_redondo_rosa;
    final int rosaClaro = R.drawable.boton_redondo_rosa_claro;
    final int verd = R.drawable.boton_redondo_verd;
    final int verdClaro = R.drawable.boton_redondo_verd_claro;

    // to know what colors was the last one
    int ultimoColor = -1;

    // Thread of the CountDown timer
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

    // update timer function to change the crono, and end the process when player loss the game
    public void updateTimer() {
        int seconds = (int) timeLeftInMilliseconds / 1000;
        String timeLeftText;
        timeLeftText = "" + seconds;
        temp.setText(timeLeftText);
        if (timeLeftText.equals("0")) {
            Registro.punt = puntuacion;
            turnOffButtons();
            temp.setText("PERDISTE");
            temp.setTextColor(Color.rgb(168,0,0));
            textSeg.setVisibility(View.INVISIBLE);
            startActivity(new Intent(Game.this,Registro.class));
        }
    }

    // function for increment the score
    public void sumarPuntos() {
        puntuacion++;
        String n = String.valueOf(puntuacion);
        textoPuntos.setText(n);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        // Start the Crono
        startStop();

        // findViewById's
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

        turnOffButtons();

        // All buttons onClickListener's
        btn1.setOnClickListener(view -> {
            sumarPuntos();
            cdt.start();
            shuffleButtons();
        });
        btn2.setOnClickListener(view -> {
            sumarPuntos();
            cdt.start();
            shuffleButtons();
        });
        btn3.setOnClickListener(view -> {
            sumarPuntos();
            cdt.start();
            shuffleButtons();
        });
        btn4.setOnClickListener(view -> {
            sumarPuntos();
            cdt.start();
            shuffleButtons();
        });
        btn5.setOnClickListener(view -> {
            sumarPuntos();
            cdt.start();
            shuffleButtons();
        });
        btn6.setOnClickListener(view -> {
            sumarPuntos();
            cdt.start();
            shuffleButtons();
        });
        btn7.setOnClickListener(view -> {
            sumarPuntos();
            cdt.start();
            shuffleButtons();
        });
        btn8.setOnClickListener(view -> {
            sumarPuntos();
            cdt.start();
            shuffleButtons();
        });
        btn9.setOnClickListener(view -> {
            sumarPuntos();
            cdt.start();
            shuffleButtons();
        });
        shuffleButtons();

    }

    // function to shuffle the buttons and mix the colors
    public void shuffleButtons(){
        Random rn = new Random((new Date()).getTime());
        int r = rn.nextInt(8);
        List<ImageButton> botones = Arrays.asList(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9);

        if(r == ultimoColor){
            if(r > 7){
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
        } else if (r == 4) {
            //Rojo
            colorChange(botones,marron,marronClaro);
        } else if (r == 5) {
            //Rojo
            colorChange(botones,naranja,naranjaClaro);
        } else if (r == 6) {
            //Rojo
            colorChange(botones,rosa,rosaClaro);
        } else if (r == 7) {
            //Rojo
            colorChange(botones,verd,verdClaro);
        }
        ultimoColor = r;
    }

    // Function to establish the colors
    public void colorChange(List <ImageButton> colores, int colorComun, int colorCorrecto){
        turnOffButtons();
        Collections.shuffle(colores);
        colores.get(0).setImageResource(colorCorrecto);
        colores.get(0).setEnabled(true);
        colores.get(1).setImageResource(colorComun);
        colores.get(2).setImageResource(colorComun);
        colores.get(3).setImageResource(colorComun);
        colores.get(4).setImageResource(colorComun);
        colores.get(5).setImageResource(colorComun);
        colores.get(6).setImageResource(colorComun);
        colores.get(7).setImageResource(colorComun);
        colores.get(8).setImageResource(colorComun);
    }

    // Place buttons off to dont let player keep clicking
    public void turnOffButtons(){
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }
}