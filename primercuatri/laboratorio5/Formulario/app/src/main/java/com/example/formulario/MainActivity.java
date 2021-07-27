package com.example.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonaModel model = new PersonaModel();
        PersonaController controller = new PersonaController(model);
        PersonaView view = new PersonaView(this, controller);
        controller.setView(view);
    }
}
