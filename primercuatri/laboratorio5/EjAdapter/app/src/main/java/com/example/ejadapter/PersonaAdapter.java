package com.example.ejadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaViewHolder> implements View.OnClickListener{

    private List<Persona> personas;
    private View.OnClickListener listener;

    public PersonaAdapter(List<Persona> personas)
    {
        this.personas = personas;
    }

    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_persona, parent, false);
        PersonaViewHolder vh = new PersonaViewHolder(view);

        view.setOnClickListener(this);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position)
    {
        Persona p = this.personas.get(position);
        TextView tvApellido = holder.view.findViewById(R.id.tvApellido);
        TextView tvNombre = holder.view.findViewById(R.id.tvNombre);
        tvApellido.setText(p.getApellido());
        tvNombre.setText(p.getNombre());
    }

    @Override
    public int getItemCount()
    {
        return this.personas.size();
    }

    public void setOnClickListener(View.OnClickListener listener)
    {
        this.listener = listener;
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
