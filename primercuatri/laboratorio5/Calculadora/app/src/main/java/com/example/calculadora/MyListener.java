package com.example.calculadora;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MyListener implements View.OnClickListener
{
    Activity activity;

    public MyListener(Activity activity)
    {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        TextView tvOp = activity.findViewById(R.id.operando);
        TextView tvRes = activity.findViewById(R.id.result);
        EditText etNumUno = activity.findViewById(R.id.numUno);
        EditText etNumDos = activity.findViewById(R.id.numDos);
        Integer numeroUno = Integer.parseInt( etNumUno.getText().toString());
        Integer numeroDos = Integer.parseInt( etNumDos.getText().toString());
        float resultado = 0;

        switch(v.getId()){
            case R.id.btnMas:
                resultado = (float) numeroUno + numeroDos;
                tvOp.setText("+");
                break;
            case R.id.btnMenos:
                resultado = (float) numeroUno - numeroDos;
                tvOp.setText("-");
                break;
            case R.id.btnPor:
                resultado = (float) numeroUno * numeroDos;
                tvOp.setText("*");
                break;
            case R.id.btnDividir:
                resultado = (float) numeroUno / numeroDos;
                tvOp.setText("/");
                break;
        }

        tvRes.setText("El resultado es: " + resultado);
    }

}
