package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMas = super.findViewById(R.id.btnMas);
        Button btnMenos = super.findViewById(R.id.btnMenos);
        Button btnPor = super.findViewById(R.id.btnPor);
        Button btnDividir = super.findViewById(R.id.btnDividir);

        MyListener mylistener = new MyListener(this);

        btnMas.setOnClickListener(mylistener);
        btnMenos.setOnClickListener(mylistener);
        btnPor.setOnClickListener(mylistener);
        btnDividir.setOnClickListener(mylistener);

    }
}
