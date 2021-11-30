package com.example.colorstapgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Juego extends AppCompatActivity {
    ImageButton btn1,btn2,btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        int rojo = R.drawable.boton_redondo_rojo;
        int rojoClaro = R.drawable.boton_redondo_rojo_claro;
        int azul = R.drawable.boton_redondo_azul;
        int azulClaro = R.drawable.boton_redondo_azul_claro;
        int verde = R.drawable.boton_redondo_verde;
        int verdeClaro = R.drawable.boton_redondo_verde_claro;
        int amarillo = R.drawable.boton_redondo_amarillo;
        int amarilloClaro = R.drawable.boton_redondo_amarillo_claro;



        btn1 = findViewById(R.id.boton1);
        btn2 = findViewById(R.id.boton2);
        btn3 = findViewById(R.id.boton3);
        btn4 = findViewById(R.id.boton4);

        List<Integer> listaColores = Arrays.asList(amarillo,azul,rojo,verde);
        List<ImageButton> listaBotones = Arrays.asList(btn1,btn2,btn3,btn4);

        Random rn = new Random();
        int r = listaColores.get(rn.nextInt(listaColores.size()));
        System.out.println(r);

        if(r == 2131165335){
            //Amarillo
            Random rn1 = new Random();
            ImageButton r1 = listaBotones.get(rn.nextInt(listaBotones.size()));
            btn1.setImageResource(r);
            btn2.setImageResource(r);
            btn3.setImageResource(amarilloClaro);
            btn4.setImageResource(r);
        }else if(r == 2131165333){
            //Rojo
            btn1.setImageResource(r);
            btn2.setImageResource(r);
            btn3.setImageResource(rojoClaro);
            btn4.setImageResource(r);
        }else if(r == 2131165334){
            //Verde
            btn1.setImageResource(r);
            btn2.setImageResource(r);
            btn3.setImageResource(verdeClaro);
            btn4.setImageResource(r);
        }else if(r == 2131165332){
            //Azul
            btn1.setImageResource(r);
            btn2.setImageResource(r);
            btn3.setImageResource(azulClaro);
            btn4.setImageResource(r);
        }
    }
}