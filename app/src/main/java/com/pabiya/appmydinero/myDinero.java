package com.pabiya.appmydinero;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class myDinero extends AppCompatActivity {
    /**
     * 1eu =0.98do
     * 1eu =0.0060pe
     * 1eu=0.87li
     */

    ProgressBar progressBar;
    TextView textEuro,textDolar,textLibra;
    EditText pesetas;
    Button bEuro,bDolar,bLibra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dinero);

        progressBar=findViewById(R.id.progressBar);
        textEuro=findViewById(R.id.textEuros);
        textDolar=findViewById(R.id.textDollar);
        textLibra=findViewById(R.id.textLibra);
        pesetas=findViewById(R.id.editDinero);
        bEuro=findViewById(R.id.buttonEuro);
        bDolar=findViewById(R.id.buttonDolar);
        bLibra=findViewById(R.id.buttonLibra);


        progressBar.setVisibility(View.INVISIBLE);

        /**
         * Visivilidad teclado
         */
        InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(pesetas.getWindowToken(),0);
    }
}