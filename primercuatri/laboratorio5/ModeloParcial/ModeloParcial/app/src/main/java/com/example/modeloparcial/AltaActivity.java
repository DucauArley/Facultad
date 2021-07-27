package com.example.modeloparcial;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class AltaActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);

        ActionBar toolBar = getSupportActionBar();
        toolBar.setDisplayHomeAsUpEnabled(true);

        Contacto contacto = new Contacto("","","", "");
        ContactoController controller = new ContactoController(contacto);
        ContactoView view = new ContactoView(this, controller);
        controller.setView(view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu m)
    {
        super.getMenuInflater().inflate(R.menu.menu, m);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == android.R.id.home)
        {
            super.finish();
        }

        return false;
    }



}
