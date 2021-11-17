package com.example.listas_fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button f_btn = findViewById(R.id.add_btn);
        f_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_holder, new BlankFragment())
                        .addToBackStack(null)
                        .commit();
            }
        }
    }
}