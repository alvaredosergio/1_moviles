package com.example.colorstapgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    Button btn_jugar, btn_leaderboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_jugar = findViewById(R.id.jugar);
        btn_jugar.setOnClickListener(view -> cambiarJuego());

        btn_leaderboard = findViewById(R.id.leaderboard);
        btn_leaderboard.setOnClickListener(view -> cambiarLeer());
    }
    public void cambiarJuego() {
        android.content.Intent starter = new android.content.Intent(this, Juego2.class);
        startActivity(starter);
    }
    public void cambiarLeer() {
        android.content.Intent starter = new android.content.Intent(this, Leer.class);
        startActivity(starter);
    }
}