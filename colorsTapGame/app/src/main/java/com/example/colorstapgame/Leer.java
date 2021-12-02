package com.example.colorstapgame;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
//import de google firebase
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import models.User;


public class Leer extends AppCompatActivity {
    List<User> usuarios;
    ListView lw;
    Button irAlMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leer);

        usuarios = new ArrayList<>();

        lw = findViewById(R.id.lista_usuarios);
        irAlMenu = findViewById(R.id.irMenu);

        irAlMenu.setOnClickListener(view -> cambiarMenu());

        FirebaseDatabase fdb = FirebaseDatabase.getInstance();

        DatabaseReference myRef = fdb.getReference("Usuario");

        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot){
                usuarios = new ArrayList<>();
                for(DataSnapshot child:dataSnapshot.getChildren()){
                    User u = child.getValue(User.class);
                    usuarios.add(u);
                }
                rellenarLista();
            }
            @Override
            public void onCancelled(DatabaseError error){
                Log.e("ERROR FIREBASE",error.getMessage());
            }

        });


    }//onCreate:end

    public void cambiarMenu() {
        android.content.Intent starter = new android.content.Intent(this, Menu.class);
        startActivity(starter);
    }

    public void rellenarLista(){
        List<String> lista = new ArrayList<String>();
        for (User u:usuarios) {
            if(u.getColor().equals("rojo")) {
                String data = " NOMBRE: " + u.getNombre() + "\n COLOR: " + u.getColor() + "\n SCORE: " + u.getPuntuacion();
                lista.add(data);
            }else if(u.getColor().equals("azul")){
                String data = " NOMBRE: " + u.getNombre() + "\n COLOR: " + u.getColor() + "\n SCORE: " + u.getPuntuacion();
                lista.add(data);
            }else if(u.getColor().equals("verde")){
                String data = " NOMBRE: " + u.getNombre() + "\n COLOR: " + u.getColor() + "\n SCORE: " + u.getPuntuacion();
                lista.add(data);
            }else if(u.getColor().equals("amarillo")){
                String data = " NOMBRE: " + u.getNombre() + "\n COLOR: " + u.getColor() + "\n SCORE: " + u.getPuntuacion();
                lista.add(data);
            }
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,lista);
        lw.setAdapter(adapter);
    }

}