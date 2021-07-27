package com.example.modeloparcial;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class HiloHttp extends Thread
{
    public Handler handler;
    public String url;
    public int texto = 1;
    public int posicion = -1;
    public Contacto contacto;

    public HiloHttp(Handler handler, String url, int texto, int posicion, Contacto contacto)
    {
        this.handler = handler;
        this.url = url;
        this.texto = texto;
        this.posicion = posicion;
        this.contacto = contacto;
    }


    @Override
    public void run()//Aca va lo que se ejecuta en paralelo
    {
        HttpManager manager = new HttpManager();

        /*try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }*/

        switch (texto)
        {
            case 1:
                String respuesta = manager.consultarPersonas(this.url);
                ArrayList<Contacto> retorno = new ArrayList<Contacto>();

                try
                {
                    JSONArray array = new JSONArray(respuesta);

                    for(int i=0; i<array.length(); i++)
                    {
                        JSONObject o = array.getJSONObject(i);
                        Contacto c = new Contacto(o.getString("nombre"), o.getString("apellido"), o.getString("telefono"), o.getString("img"));
                        retorno.add(c);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Message message = new Message();
                message.arg1 = MainActivity.TEXTO;
                message.obj = retorno;
                this.handler.sendMessage(message);
                break;
            case 2:
                byte[] imagen = manager.consultarImg(this.url);
                message = new Message();
                message.arg1 = MainActivity.IMAGEN;
                message.arg2 = this.posicion;
                message.obj = imagen;
                this.handler.sendMessage(message);

                Log.d("Entra5", "Entra5");
                break;
            case 3:

                Uri.Builder params = new Uri.Builder();
                params.appendQueryParameter("nombre",this.contacto.getNombre());
                params.appendQueryParameter("apellido", this.contacto.getApellido());
                params.appendQueryParameter("telefono", this.contacto.getTelefono());
                params.appendQueryParameter("img", this.contacto.getImg());

                try
                {
                    manager.guardarContactos(params, this.url);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                message = new Message();
                message.arg1 = 3;
                message.obj = this.contacto;
                this.handler.sendMessage(message);
                break;
        }

    }


}
