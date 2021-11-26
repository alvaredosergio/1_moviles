package com.example.ejercicioclase_sergio_alvaredo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Listas extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);

        btn = findViewById(R.id.btn11);
        FragmentManager fm =  getSupportFragmentManager();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.beginTransaction().replace(R.id.fragmentContainerView4,BlankFragment.class,null).setReorderingAllowed(true).addToBackStack("blackFragment").commit();
            }
        });
    }
}