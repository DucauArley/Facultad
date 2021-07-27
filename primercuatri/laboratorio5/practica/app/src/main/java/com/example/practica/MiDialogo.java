package com.example.practica;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.fragment.app.DialogFragment;

public class MiDialogo extends DialogFragment
{
    //Obiamente esto se puede hacer mas generico reciviendo parametros por el constructor y demas cosas para cambiar los botones
    //y el titulo/mensaje que tiene dentro el dialog
    public MainActivity mainActivity;

    public MiDialogo(MainActivity ma)
    {
        this.mainActivity = ma;
    }

    @Override
    public Dialog onCreateDialog(Bundle bundle)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(super.getActivity());
        builder.setTitle("Nuevo titulo");
        //builder.setMessage("Mensaje nuevo para el usuario");
        LayoutInflater li = LayoutInflater.from(getActivity());
        View view = li.inflate(R.layout.dialog, null);
        builder.setView(view);

        ClickDialog clickdg = new ClickDialog(view, this.mainActivity);

        builder.setPositiveButton("Ok", clickdg);
        builder.setNeutralButton("Neutral", clickdg);
        builder.setNegativeButton("Cancelar", clickdg);

        return builder.create();
    }

}
