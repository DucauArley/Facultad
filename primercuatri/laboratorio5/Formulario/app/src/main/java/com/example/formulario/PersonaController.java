package com.example.formulario;

import android.view.View;
import android.app.Activity;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;

public class PersonaController implements View.OnClickListener
{
    Activity activity;
    PersonaView personaView;
    PersonaModel model;

    public PersonaController(PersonaModel model)
    {
        this.model = model;
    }

    public void setView(PersonaView personaView)
    {
        this.personaView = personaView;
    }

    @Override
    public void onClick(View v)
    {
        personaView.cargarViews();

        personaView.cargarModelo();

        Log.d( "Click",model.getNombre() + model.getApellido() + model.getSexo() + model.getDni());

    }
}
