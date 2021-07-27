package com.example.modeloparcial;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoViewHolder> implements View.OnClickListener
{
    private List<Contacto> contactos;
    private View.OnClickListener listener;

    public ContactoAdapter(List<Contacto> contactos)
    {
        this.contactos = contactos;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto, parent, false);
        ContactoViewHolder vh = new ContactoViewHolder(view);

        view.setOnClickListener(this);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position)
    {
        HttpManager manager = new HttpManager();
        Contacto c = this.contactos.get(position);
        TextView tvApellido = holder.view.findViewById(R.id.tvApellido);
        TextView tvNombre = holder.view.findViewById(R.id.tvNombre);
        TextView tvTelefono = holder.view.findViewById(R.id.tvTelefono);
        ImageView img = holder.view.findViewById(R.id.Imagen);
        tvApellido.setText(c.getApellido());
        tvNombre.setText(c.getNombre());
        tvTelefono.setText(c.getTelefono());

        if(c.getImagen() != null)
        {
            img.setImageBitmap(BitmapFactory.decodeByteArray(c.getImagen(), 0, c.getImagen().length));
        }

    }

    @Override
    public int getItemCount()
    {
        return this.contactos.size();
    }

    @Override
    public void onClick(View v)
    {
        if(this.listener != null)
        {
            listener.onClick(v);
        }
    }
}
