package com.example.practica;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public class MyListener implements View.OnClickListener {

    public Activity a;

    public MyListener(Activity a)
    {
        this.a = a;
    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(a, WebViewerActivity.class);
        i.putExtra("url", MainActivity.url);
        a.startActivity(i);
    }
}
