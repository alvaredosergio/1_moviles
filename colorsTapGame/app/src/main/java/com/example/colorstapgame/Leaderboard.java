package com.example.colorstapgame;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;
import models.User;

// Leaderboard Activity
public class Leaderboard extends AppCompatActivity {
    List<User> usuarios;
    ListView lv;
    Button irAlMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        usuarios = new ArrayList<>();

        // findViewById's
        lv = findViewById(R.id.lista_usuarios);
        irAlMenu = findViewById(R.id.irMenu);

        // onClickListener's
        irAlMenu.setOnClickListener(view -> toMain());

        // Database object
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
                fillList();
            }
            @Override
            public void onCancelled(DatabaseError error){
                Log.e("ERROR FIREBASE",error.getMessage());
            }
        });
    }

    // Change Activity to Main
    public void toMain() {
        android.content.Intent starter = new android.content.Intent(this, Main.class);
        startActivity(starter);
    }

    // fill the list with Users
    public void fillList(){
        List<String> lista = new ArrayList<String>();
        for (User u:usuarios) {
            String data = u.getNombre() + "\t\t\t\t\t\t\t\t" + u.getEmail() + "\t\t\t\t\t\t\t\t" + u.getPuntuacion() + " pts";
            lista.add(data);
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,lista);
        lv.setAdapter(adapter);
    }

}