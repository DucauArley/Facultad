package com.example.clase1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = super.findViewById(R.id.tvSaludo);
        Button btn = super.findViewById(R.id.btn);
        MyListener mylistener = new MyListener(this);

        btn.setOnClickListener(mylistener);
        /*btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TextView tv = (TextView) findViewById(R.id.tvSaludo);
                tv.setText("Hola que talco");
            }

        });*/

        tv.setText("Hola desde java!!!");
    }
}
