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

// Registro Activity
public class Registro extends AppCompatActivity {
    private EditText nombre, email;
    private Button btn;
    private DatabaseReference mDatabase;
    public static int punt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // findViewById's
        nombre = findViewById(R.id.editTextName);
        email = findViewById(R.id.editTextEmail);
        btn = findViewById(R.id.regBot);

        // Database instance
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // onClickListener
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomb = nombre.getText().toString();
                String mail = email.getText().toString();

                if(!nomb.isEmpty() && !mail.isEmpty()) {
                    Map<String, Object> datosUsuario = new HashMap<>();
                    datosUsuario.put("nombre", nomb);
                    datosUsuario.put("email", mail);
                    datosUsuario.put("puntuacion", punt);

                    mDatabase.child("Usuario").push().setValue(datosUsuario);
                    startActivity(new Intent(Registro.this, Leaderboard.class));
                }else{
                    Toast.makeText(Registro.this, "Debes completar todos los campos.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}