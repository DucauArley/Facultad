package com.example.formulario;

import android.app.Activity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class PersonaView
{
    Button btn;
    Activity activity;
    EditText etN;
    EditText etA;
    EditText etD;
    RadioButton rbH;
    RadioButton rbM;
    PersonaModel model;
    String sexo = "nulo";

    public PersonaView(Activity activity, PersonaController mylistener)
    {
        this.activity = activity;
        this.btn = activity.findViewById(R.id.btnG);
        btn.setOnClickListener(mylistener);
        this.model = mylistener.model;
    }

    public void cargarViews()
    {
        this.etN = activity.findViewById(R.id.etNombre);
        this.etA = activity.findViewById(R.id.etApellido);
        this.etD = activity.findViewById(R.id.etDni);
        this.rbH = activity.findViewById(R.id.rHom);
        this.rbM = activity.findViewById(R.id.rMuj);

        if(rbH.isChecked())
        {
            this.sexo = "Hombre";
        }
        else
        {
            if(rbM.isChecked())
            {
                this.sexo = "Mujer";
            }
        }
    }

    public void cargarModelo()
    {
        model.setNombre(etN.getText().toString());
        model.setApellido(etA.getText().toString());
        model.setDni(Integer.parseInt( etD.getText().toString()));
        model.setSexo(sexo);
    }

}
