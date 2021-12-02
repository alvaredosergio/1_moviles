package com.example.colorstapgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {
    private EditText nombre, correo;
    private Button btn;
    private DatabaseReference mDatabase;

    public static int punt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = findViewById(R.id.editTextName);
        correo = findViewById(R.id.editTextTextEmail);
        btn = findViewById(R.id.regBot);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomb = nombre.getText().toString();
                String email = correo.getText().toString();

                Map<String,Object> datosUsuario = new HashMap<>();
                datosUsuario.put("nombre",nomb);
                datosUsuario.put("email",email);
                datosUsuario.put("puntuacion",punt);

                mDatabase.child("Usuario").push().setValue(datosUsuario);
                startActivity(new Intent(Registro.this, Leaderboard.class));

            }
        });
    }
}