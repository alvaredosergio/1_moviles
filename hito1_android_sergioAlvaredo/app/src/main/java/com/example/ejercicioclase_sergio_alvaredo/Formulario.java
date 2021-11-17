package com.example.ejercicioclase_sergio_alvaredo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Formulario extends AppCompatActivity {
    TextView nom, apel, tlf, captcha, code;
    Button btnVal, btnCap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        // TextViews IDs
        nom = findViewById(R.id.nombre);
        apel = findViewById(R.id.apellidos);
        tlf = findViewById(R.id.telefono);
        captcha = findViewById(R.id.captcha);
        code = findViewById(R.id.code);
        btnVal = findViewById(R.id.btnvalidar);
        btnCap = findViewById(R.id.btnCap);

        //ButtonViews IDs
        btnVal.setOnClickListener(view -> pintarValidar());
        btnCap.setOnClickListener(view -> generarRandom());
    }

    public void pintarValidar(){
        System.out.println("Nombre: " + nom.getText());
        System.out.println("Apellido: " + apel.getText());
        System.out.println("Teléfono: " + tlf.getText());

        String nombre = nom.getText().toString();
        String apellido = apel.getText().toString();
        String telefono = tlf.getText().toString();
        String capt = captcha.getText().toString();

        if(nombre.equals("sergio") && apellido.equals("alvaredo") && telefono.equals("664790707") && capt.equals(code.getText().toString())){
            System.out.println("Login correcto.");
        }else{
            System.out.println("Login incorrecto.");
        }
    }

    public void generarRandom(){
        int num = (int)(Math.random()*10000);
        if (num <1000){
            num = num + 1000;
        }
        code.setText(Integer.toString(num));
    }
}