package com.example.colorstapgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import models.User;

public class Leaderboard extends AppCompatActivity {

    private TextView mTextViewDataNombre,mTextViewDataCorreo,mTextViewDataScore;
    private DatabaseReference mDatabase;
    private Button btn;

    private ArrayList<User> mMensajesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        mTextViewDataNombre = (TextView) findViewById(R.id.textViewName);
        mTextViewDataCorreo = (TextView) findViewById(R.id.textViewEmail);
        mTextViewDataScore = (TextView) findViewById(R.id.textViewScore);
        btn = (Button) findViewById(R.id.button1);

        btn.setOnClickListener(view -> cambiarMenu());

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mDatabase.child("Usuario").child("MpsSGQkZHgG5pxUmBio").child("nombre").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String correo = dataSnapshot.child("email").getValue().toString();
                    String nombre = dataSnapshot.child("nombre").getValue().toString();
                    String puntuacion = dataSnapshot.child("puntuacion").getValue().toString();
                    mTextViewDataNombre.setText("Nombre: " + nombre);
                    mTextViewDataCorreo.setText("Correo: " + correo);
                    mTextViewDataScore.setText("Puntuación: " + puntuacion);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });



    }

    public void cambiarMenu() {
        android.content.Intent starter = new android.content.Intent(this, Menu.class);
        startActivity(starter);
    }

    private void getDatos(){
        mDatabase.child("Usuario").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for (DataSnapshot ds: dataSnapshot.getChildren()) {
                        String name = ds.child("nombre").getValue().toString();
                        String correo = ds.child("email").getValue().toString();
                        String score = ds.child("puntuacion").getValue().toString();

                        mMensajesList.add(new User(name,correo,score));
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}