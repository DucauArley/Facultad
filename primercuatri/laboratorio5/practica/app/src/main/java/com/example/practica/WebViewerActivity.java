package com.example.practica;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_viewer);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);

        WebView wv = super.findViewById(R.id.Wv);
        wv.loadUrl(MainActivity.url);
    }
}
