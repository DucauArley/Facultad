package com.example.ejadapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonaViewHolder extends RecyclerView.ViewHolder
{
    public View view;

    public PersonaViewHolder(@NonNull View itemView)
    {
        super(itemView);
        this.view = itemView;
    }
}
