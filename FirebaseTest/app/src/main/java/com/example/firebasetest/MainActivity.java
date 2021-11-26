package com.example.firebasetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewDataNombre,mTextViewDataApellido,mTextViewDataCorreo,mTextViewDataTelefono,mTextViewDataMano;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewDataNombre = (TextView) findViewById(R.id.nombredb);
        mTextViewDataApellido = (TextView) findViewById(R.id.apellidodb);
        mTextViewDataCorreo = (TextView) findViewById(R.id.correodb);
        mTextViewDataTelefono = (TextView) findViewById(R.id.telefonodb);
        mTextViewDataMano = (TextView) findViewById(R.id.manodb);

        mDatabase = FirebaseDatabase.getInstance("https://humanes-alvaredo-default-rtdb.europe-west1.firebasedatabase.app/").getReference();

        for(int i = 0; i<4; i++) {
            mDatabase.child("usuarios").child("usuario").child("0").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {

                        String nombre = dataSnapshot.child("nombre").getValue().toString();
                        String apellido = dataSnapshot.child("apellido").getValue().toString();
                        String correo = dataSnapshot.child("correo").getValue().toString();
                        String telefono = dataSnapshot.child("telefono").getValue().toString();
                        String mano = dataSnapshot.child("mano").getValue().toString();

                        User user = new User(nombre, apellido, correo, telefono, mano);

                        mTextViewDataNombre.setText("Nombre: " + nombre);
                        mTextViewDataApellido.setText("Apellido: " + apellido);
                        mTextViewDataCorreo.setText("Correo: " + correo);
                        mTextViewDataTelefono.setText("Telefono: " + telefono);
                        mTextViewDataTelefono.setText("Mano: " + mano);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }


    }
}