package com.example.internet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Handler.Callback {
    public static final int TEXTO = 1;
    public static final int IMAGEN = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Handler handler = new Handler(this);

        HiloHttp miHilo = new HiloHttp(handler, "http://www.lslutnfra.com/alumnos/practicas/listaPersonas.xml", true);
        HiloHttp miHiloImagen = new HiloHttp(handler, "http://www.lslutnfra.com/alumnos/practicas/ubuntu-logo.png", false);

        miHilo.start();
        miHiloImagen.start();

    }

    //Es el metodo que recorre infinitamente viendo si hay un mensaje nuevo para procesar
    @Override
    public boolean handleMessage(@NonNull Message msg)
    {
        Log.d("Mensaje", "Llego un mensaje" + msg.obj);

        if(msg.arg1==TEXTO)
        {
            TextView tv = this.findViewById(R.id.server);
            tv.setText(msg.obj.toString());
        }
        else if(msg.arg1 == IMAGEN)
        {
            ImageView img = super.findViewById(R.id.img);
            byte[] imagen = (byte[]) msg.obj;
            img.setImageBitmap(BitmapFactory.decodeByteArray(imagen,0,imagen.length));
        }

        return false;
    }
}
