package com.example.practica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements Handler.Callback, SearchView.OnQueryTextListener {

    public static String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txw = this.findViewById(R.id.google);
        url = txw.getText().toString();
        txw.setOnClickListener(new MyListener(this));

        SharedPreferences prefs = getSharedPreferences("miConfig", Context.MODE_PRIVATE);// Para que todos la vean
        //SharedPreferences prefs = this.getPreferences(Context.MODE_PRIVATE); Para que solo una activity la vea

        TextView txp = this.findViewById(R.id.texto);
        txp.setText(prefs.getString("Nombre", "Nombre"));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId() == R.id.dg)
        {
            MiDialogo miDialogo = new MiDialogo(this);
            miDialogo.show(super.getSupportFragmentManager(), "Confirm");
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        MenuItem mi = menu.findItem(R.id.buscar);
        SearchView searchView = (SearchView) mi.getActionView();
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        Log.d("Activity", "Hago una busqueda con:" + s);//Esto es para cuando se toca enter
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        Log.d("Acivity", "cambio texto " + s);//Este se ejecuta cada vez que escribis algo Deberia de usar uno solo

        //adapter.getFilter().filter(s) para filtrar los elementos del recycler view es medio raro, porque como que tenes que
        //Hacer una copia de la lista para no perder las cosas y despues pasarle una por una o algo asi
        //Pareciera que hay que implementar Filterable

        return false;
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        return false;
    }
}
