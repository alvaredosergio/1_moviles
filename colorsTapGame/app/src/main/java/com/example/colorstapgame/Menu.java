package com.example.colorstapgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
        btn_leaderboard.setOnClickListener(view -> cambiarLeaderboard());
    }
    public void cambiarJuego() {
        android.content.Intent starter = new android.content.Intent(this, Juego.class);
        startActivity(starter);
    }
    public void cambiarLeaderboard() {
        android.content.Intent starter = new android.content.Intent(this, Leaderboard.class);
        startActivity(starter);
    }
}