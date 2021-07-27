package com.example.modeloparcial;

public class Contacto
{
    private String nombre;
    private String apellido;
    private String telefono;
    private String img;
    private byte[] imagen;

    public Contacto(String nombre, String apellido, String telefono, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.img = img;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getImg() {
        return img;
    }

    public byte[] getImagen() {
        return imagen;
    }
}


