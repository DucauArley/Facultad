package com.example.internet;

import android.os.Handler;
import android.os.Message;

public class HiloHttp extends Thread
{

    public Handler handler;
    public String url;
    public boolean texto = true;

    public HiloHttp(Handler handler, String url, boolean texto)
    {
        this.handler = handler;
        this.url = url;
        this.texto = texto;
    }


    @Override
    public void run()//Aca va lo que se ejecuta en paralelo
    {
        HttpManager manager = new HttpManager();

        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }


        if (texto)
        {
            String respuesta = manager.consultarPersonas(this.url);

            Message message = new Message();
            message.arg1 = MainActivity.TEXTO;
            message.obj = respuesta;
            this.handler.sendMessage(message);
        }
        else
        {
            byte[] imagen = manager.consultarImg(this.url);
            Message message = new Message();
            message.arg1 = MainActivity.IMAGEN;
            message.obj = imagen;
            this.handler.sendMessage(message);

        }
    }







}
