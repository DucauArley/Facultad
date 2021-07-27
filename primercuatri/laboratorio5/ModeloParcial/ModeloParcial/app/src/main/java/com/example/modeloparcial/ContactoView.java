package com.example.modeloparcial;

import android.app.Activity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class ContactoView
{
    Button btn;
    Activity activity;
    EditText etN;
    EditText etA;
    EditText etT;
    EditText etU;
    Contacto contacto;

    public ContactoView(Activity activity, ContactoController mylistener)
    {
        this.activity = activity;
        this.btn = activity.findViewById(R.id.btnG);
        btn.setOnClickListener(mylistener);
        this.contacto = mylistener.contacto;
    }

    public void cargarViews()
    {
        this.etN = activity.findViewById(R.id.etNombre);
        this.etA = activity.findViewById(R.id.etApellido);
        this.etT = activity.findViewById(R.id.etTelefono);
        this.etU = activity.findViewById(R.id.etUrl);
    }

    public boolean cargarModelo()
    {
        boolean retorno = false;

        if(!isEmpty(etN) && !isEmpty(etA) && !isEmpty(etT) && !isEmpty(etU))
        {
            this.contacto.setNombre(etN.getText().toString());
            this.contacto.setApellido(etA.getText().toString());
            this.contacto.setTelefono(etT.getText().toString());
            this.contacto.setImg(etU.getText().toString());

            retorno =  true;
        }

        return  retorno;
    }

    public void vaciarEts()
    {
        etN.setText("");
        etA.setText("");
        etT.setText("");
        etU.setText("");
    }

    private boolean isEmpty(EditText etText)
    {
        boolean retorno = true;

        if (etText.getText().toString().trim().length() > 0)
        {
            retorno = false;
        }

        return retorno;
    }


}
