package com.example.menus;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar toolBar = getSupportActionBar();
        toolBar.setDisplayHomeAsUpEnabled(true);//Y ya tenemos el boton de back disponible

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
            Log.d("Click en menu", "Se hizo click en configuracion");
        }
        else if(item.getItemId() == R.id.opcion2)
        {
            Log.d("Click en menu", "Se hizo click en Alta");
            Intent intent = new Intent(this,FormularioActivity.class);
            intent.putExtra("Nombre","Matias");
            intent.putExtra("Age",26);//Para pasarle info extra de tipo de dato primitivo a la activity
            super.startActivity(intent);
        }
        else if(android.R.id.home == item.getItemId())//Esto es para que funcione el boton back
        {
            super.finish();//Mata al activity
        }

        return false;
    }

}
