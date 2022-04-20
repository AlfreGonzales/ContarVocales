package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Atribute
    private EditText ETPalabra;
    private Button BtnProcesar, BtnContar;
    private CheckBox CBMinuscula;

    private String palabra;
    private Boolean esMinuscula;

    private char letra;

    private int contadorVocales;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarVistas();
        //Version tradicional
        /*BtnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerInformacion();
            }
        });*/

        //Version reducida, óptima
        //Lambda functions o funciones Lambda o funciones de flecha
        BtnProcesar.setOnClickListener(view -> obtenerInformacion());

        BtnContar.setOnClickListener(view -> {
            obtenerInformacion();
            obtenerMensaje();
        });
    }
    private void inicializarVistas(){
        ETPalabra = findViewById(R.id.ETPalabra);
        BtnProcesar = findViewById(R.id.BtnProcesar);
        BtnContar = findViewById(R.id.BtnContar);
        CBMinuscula = findViewById(R.id.CBMinuscula);
    }

    private void obtenerInformacion(){
        palabra = ETPalabra.getText().toString();
        //getChecked --- isChecked sigue siendo un getter
        esMinuscula = CBMinuscula.isChecked();
    }
    //cuantas volcales tiene una palabra

    private String contarVocales(){
        contadorVocales = 0;
        String mensaje;
        for(int i = 0; i < palabra.length(); i++){
            letra = palabra.charAt(i);
            if(letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u'){
                contadorVocales++;
            }
        }
        return "la pablabre ingresada tiene " + contadorVocales + " vocales";
    }

    private void obtenerMensaje(){
        Toast.makeText(this,contarVocales(),Toast.LENGTH_LONG).show();
    }
}