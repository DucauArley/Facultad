package com.example.modeloparcial;

import android.net.Uri;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HttpManager
{
    public String consultarPersonas(String urlString)
    {

        try
        {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();// Aca se conecta
            int response = urlConnection.getResponseCode();

            if(response == 200)
            {
                InputStream is = urlConnection.getInputStream();
                byte[] buffer = new byte[1024];
                ByteArrayOutputStream bais = new ByteArrayOutputStream();
                int cantidadByte = 0;

                while ((cantidadByte = is.read(buffer))!= -1)
                {
                    bais.write(buffer,0, cantidadByte);
                }

                is.close();

                Log.d("Respuesta servidor", bais.toString());

                return bais.toString();
            }
            else
            {
                throw new IOException("Error en el servidor");
            }


        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
           }

        return null;

    }

    public byte[] consultarImg(String urlString)
    {
        try
        {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();// Aca se conecta
            int response = urlConnection.getResponseCode();

            if(response == 200)
            {
                InputStream is = urlConnection.getInputStream();
                byte[] buffer = new byte[1024];
                ByteArrayOutputStream bais = new ByteArrayOutputStream();
                int cantidadByte = 0;

                while ((cantidadByte = is.read(buffer))!= -1)
                {
                    bais.write(buffer,0, cantidadByte);
                }

                is.close();

                Log.d("Respuesta servidor", bais.toString());

                return bais.toByteArray();
            }
            else
            {
                throw new IOException("Error en el servidor");
            }

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        return null;

    }


    public boolean guardarContactos(Uri.Builder postParams, String urlString) throws IOException
    {
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        String query = postParams.build().getEncodedQuery();
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));

        writer.write(query);
        writer.flush();
        writer.close();
        os.close();
        int response = conn.getResponseCode();
        if(response==200)
        {
            return true;
        }
        else
        {
            throw new IOException();
        }

    }

}
