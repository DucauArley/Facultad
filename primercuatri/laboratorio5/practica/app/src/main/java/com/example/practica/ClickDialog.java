package com.example.practica;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ClickDialog implements DialogInterface.OnClickListener {

    public View v;
    public MainActivity mainActivity;

    public ClickDialog(View v, MainActivity ma)
    {
        this.v = v;
        this.mainActivity = ma;
    }

    @Override
    public void onClick(DialogInterface dialog, int which)
    {
        switch(which)
        {
            case -1:
                //Este es el positivo
                EditText et = v.findViewById(R.id.editText);
                SharedPreferences preferences = this.mainActivity.getSharedPreferences("miConfig", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("Nombre", et.getText().toString());
                editor.commit();
                TextView txt = this.mainActivity.findViewById(R.id.texto);
                txt.setText(et.getText());
                Log.d("Click", "clickeo el boton positivo " + et.getText());
                break;
            case -2:
                //Este es el negativo
                Log.d("Click", "clickeo el boton negativo");
                break;
            case -3:
                Log.d("Click", "clickeo el boton neutral");
                break;
        }

    }
}
