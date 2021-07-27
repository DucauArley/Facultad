package com.example.menus;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class FormularioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla);

        ActionBar toolBar = getSupportActionBar();
        toolBar.setDisplayHomeAsUpEnabled(true);

        String nombre = (String)super.getIntent().getExtras().get("Nombre");
        int edad = (int)super.getIntent().getExtras().get("Age");

        TextView tv = super.findViewById(R.id.tv);
        tv.setText(nombre + " " + edad);
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
