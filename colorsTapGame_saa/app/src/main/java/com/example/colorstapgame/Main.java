package com.example.colorstapgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

// Main Activity
public class Main extends AppCompatActivity {
    // Buttons to change between activities
    Button btn_jugar, btn_leaderboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // findViewById's
        btn_jugar = findViewById(R.id.jugar);
        btn_leaderboard = findViewById(R.id.leaderboard);

        // onCLickListener's
        btn_jugar.setOnClickListener(view -> toGame());
        btn_leaderboard.setOnClickListener(view -> toLeaderboard());
    }

    // Functions
    public void toGame() {
        android.content.Intent starter = new android.content.Intent(this, Game.class);
        startActivity(starter);
    }
    public void toLeaderboard() {
        android.content.Intent starter = new android.content.Intent(this, Leaderboard.class);
        startActivity(starter);
    }
}