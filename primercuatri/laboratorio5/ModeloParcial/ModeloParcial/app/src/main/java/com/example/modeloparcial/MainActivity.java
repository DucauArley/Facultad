package com.example.modeloparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Handler.Callback {

    public static final int TEXTO = 1;
    public static final int IMAGEN = 2;
    public static List<Contacto> contactos;
    public static ContactoAdapter adapter;
    public static Handler handler;
    private static MainActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.instance = this;

        ActionBar toolBar = getSupportActionBar();
        toolBar.setDisplayHomeAsUpEnabled(true);

        this.contactos = new ArrayList<>();

        this.handler = new Handler(this);

        HiloHttp miHilo = new HiloHttp(handler, " http://192.168.0.11:3000/personas", 1, -1, null);

        miHilo.start();

        Log.d("Entra1", "Entra1");

    }

    public static MainActivity getInstance()
    {
        return instance;
    }


    @Override
    public boolean handleMessage(@NonNull Message msg)
    {
        Log.d("Entra6",  msg.arg1 + "");
        if(msg.arg1==TEXTO)
        {
            this.contactos = (List) msg.obj;
            this.adapter =  new ContactoAdapter(this.contactos);
            this.adapter.notifyDataSetChanged();

            for(int i=0;i<this.contactos.size();i++)
            {
                HiloHttp miHiloImagen = new HiloHttp(this.handler, this.contactos.get(i).getImg(), 2 ,i, null);
                miHiloImagen.start();
            }
            final RecyclerView rvPersona = super.findViewById(R.id.rvPersonas);

            rvPersona.setAdapter(adapter);
            rvPersona.setLayoutManager(new LinearLayoutManager(this));

        }
        else if(msg.arg1 == IMAGEN)
        {
            Log.d("Entra28", msg.arg2 + "");

            this.contactos.get(msg.arg2).setImagen((byte[]) msg.obj);

            this.adapter.notifyItemChanged(msg.arg2);

            Log.d("Entra2", "Entra2");
        }
        else if(msg.arg1 == 3)
        {
            Log.d("funca", "funca");

            this.contactos.add((Contacto)  msg.obj);

            this.adapter.notifyDataSetChanged();

            HiloHttp miHiloImagen = new HiloHttp(this.handler, this.contactos.get(this.contactos.size() - 1).getImg(), 2 ,this.contactos.size() - 1, null);
            miHiloImagen.start();
        }

        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menuItem)
    {
        super.getMenuInflater().inflate(R.menu.menu, menuItem);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.opcion1)
        {
            Intent intent = new Intent(this,AltaActivity.class);
            super.startActivity(intent);
        }
        else if(android.R.id.home == item.getItemId())//Esto es para que funcione el boton back
        {
            super.finish();//Mata al activity
        }

        return false;
    }
}
