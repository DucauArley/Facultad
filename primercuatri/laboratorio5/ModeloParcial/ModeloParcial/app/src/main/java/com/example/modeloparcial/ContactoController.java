package com.example.modeloparcial;

import android.app.Activity;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

public class ContactoController implements View.OnClickListener
{
    Activity activity;
    ContactoView contactoView;
    Contacto contacto;

    public ContactoController(Contacto contacto)
    {
        this.contacto = contacto;
    }

    public void setView(ContactoView contactoView)
    {
        this.contactoView = contactoView;
    }

    @Override
    public void onClick(View v)
    {
        this.contactoView.cargarViews();

        boolean ok = this.contactoView.cargarModelo();

        Log.d( "Click",contacto.getNombre() + contacto.getApellido() + contacto.getTelefono() + contacto.getImg());

        if(ok)
        {
            HttpManager manager = new HttpManager();
            Handler handler = new Handler(MainActivity.getInstance());

            HiloHttp hiloAlta = new HiloHttp(handler, " http://192.168.0.11:3000/nuevaPersona", 3, -1, this.contacto);

            hiloAlta.start();

            this.contactoView.vaciarEts();

            Toast toast1 =
                    Toast.makeText(MainActivity.getInstance(),
                            "El contacto fue cargado correctamente", Toast.LENGTH_SHORT);

            toast1.show();

        }
        else
        {
            Toast toast1 =
                    Toast.makeText(MainActivity.getInstance(),
                            "Uno de los campos esta vacio", Toast.LENGTH_SHORT);

            toast1.show();
        }

    }

}
