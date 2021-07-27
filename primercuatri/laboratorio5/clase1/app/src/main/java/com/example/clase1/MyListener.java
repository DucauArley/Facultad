package com.example.clase1;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MyListener implements View.OnClickListener {

    Activity activity;
    //TextView tv;

    /*public MyListener(TextView tv)
    {
        this.tv = tv;
    }*/

    public MyListener(Activity activity)
    {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        TextView tv = activity.findViewById(R.id.tvSaludo);
        EditText et = activity.findViewById(R.id.edNombre);
        //Log.d( "Click","Se hizo click en el boton saludar!!");
        tv.setText("Mi nombre es: " + et.getText().toString());
    }
}
