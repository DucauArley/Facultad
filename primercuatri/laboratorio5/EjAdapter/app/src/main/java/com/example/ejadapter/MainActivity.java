package com.example.ejadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<Persona> personas = new ArrayList<Persona>();

        personas.add(new Persona("Nombre1", "Apellido1"));
        personas.add(new Persona("Nombre2", "Apellido2"));
        personas.add(new Persona("Nombre3", "Apellido3"));
        personas.add(new Persona("Nombre4", "Apellido4"));
        personas.add(new Persona("Nombre5", "Apellido5"));
        personas.add(new Persona("Nombre6", "Apellido6"));
        personas.add(new Persona("Nombre7", "Apellido7"));
        personas.add(new Persona("Nombre8", "Apellido8"));
        personas.add(new Persona("Nombre9", "Apellido9"));
        personas.add(new Persona("Nombre10", "Apellido10"));
        personas.add(new Persona("Nombre11", "Apellido11"));
        personas.add(new Persona("Nombre12", "Apellido12"));
        personas.add(new Persona("Nombre13", "Apellido13"));
        personas.add(new Persona("Nombre14", "Apellido14"));
        personas.add(new Persona("Nombre15", "Apellido15"));
        personas.add(new Persona("Nombre16", "Apellido16"));
        personas.add(new Persona("Nombre17", "Apellido17"));
        personas.add(new Persona("Nombre18", "Apellido18"));
        personas.add(new Persona("Nombre19", "Apellido19"));
        personas.add(new Persona("Nombre20", "Apellido20"));
        personas.add(new Persona("Nombre21", "Apellido21"));


        PersonaAdapter adapter = new PersonaAdapter(personas);

        final RecyclerView rvPersona = super.findViewById(R.id.rvPersonas);

        adapter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),
                        "Seleccion:" + personas.get(rvPersona.getChildAdapterPosition(view)).getNombre(),
                                Toast.LENGTH_SHORT).show();
            }


        });

        rvPersona.setAdapter(adapter);

        rvPersona.setLayoutManager(new LinearLayoutManager(this));

    }
}
