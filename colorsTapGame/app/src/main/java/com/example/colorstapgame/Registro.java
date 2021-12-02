package com.example.colorstapgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {
    private EditText nombre, color;
    private Button btn;
    private DatabaseReference mDatabase;

    public static int punt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = findViewById(R.id.editTextName);
        color = findViewById(R.id.editTextTextColor);
        btn = findViewById(R.id.regBot);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomb = nombre.getText().toString();
                String col = color.getText().toString();
                if(!nomb.isEmpty() && !col.isEmpty()) {

                    Map<String, Object> datosUsuario = new HashMap<>();
                    datosUsuario.put("nombre", nomb);
                    datosUsuario.put("color", col);
                    datosUsuario.put("puntuacion", punt);

                    mDatabase.child("Usuario").push().setValue(datosUsuario);
                    startActivity(new Intent(Registro.this, Leer.class));
                }else{
                    Toast.makeText(Registro.this, "Debes completar todos los campos.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}