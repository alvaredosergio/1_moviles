package com.example.colorstapgame;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
//import de google firebase
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import models.User;


public class MostrarColores extends AppCompatActivity {
    LinearLayout ll;
    List<User> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer);
        ll = findViewById(R.id.liner);

        FirebaseDatabase fdb = FirebaseDatabase.getInstance();

        DatabaseReference myRef = fdb.getReference("Usuario");

        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                usuarios = new ArrayList<>();
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    User u = child.getValue(User.class);
                    usuarios.add(u);
                }
                mostrarDatos(ll);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.e("ERROR FIREBASE", error.getMessage());
            }

        });
    }

    public void mostrarDatos(LinearLayout liner1) {
        User u = usuarios.get(0);
        TextView tv = new TextView(this);
        tv.setText(u.toString());
        tv.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        if (u.getColor().equals("rojo")) {
            tv.setTextColor(Color.RED);
        } else if (u.getColor().equals("azul")) {
            tv.setTextColor(Color.BLUE);
        } else if (u.getColor().equals("verde")) {
            tv.setTextColor(Color.GREEN);
        } else if (u.getColor().equals("amarillo")) {
            tv.setTextColor(Color.YELLOW);
        }
        liner1.addView(tv);
    }

}