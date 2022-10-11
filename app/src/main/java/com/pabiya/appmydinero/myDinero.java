package com.pabiya.appmydinero;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class myDinero extends AppCompatActivity {
    /**
     * 1eu =0.98do
     * 1pe =0.0060ue
     * 1eu=0.87li
     */

    ProgressBar progressBar;
    TextView textEuro,textDolar,textLibra;
    EditText moneda;
    Button bEuro,bDolar,bLibra;
    ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dinero);

        progressBar=findViewById(R.id.progressBar);
        textEuro=findViewById(R.id.textEuros);
        textDolar=findViewById(R.id.textDollar);
        textLibra=findViewById(R.id.textLibra);
        moneda =findViewById(R.id.editDinero);
        bEuro=findViewById(R.id.buttonEuro);
        bDolar=findViewById(R.id.buttonDolar);
        bLibra=findViewById(R.id.buttonLibra);
        progressBar.setVisibility(View.INVISIBLE);
        image=findViewById(R.id.imageView);

        bEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (moneda.getText().length()==0){
                    mostrarMensaje("ERROR Euro: Introducca un numero ");
                }else {
                    textEuro.setText(String.format("%1$,.2f",Double.parseDouble(moneda.getText().toString())/166.386)+" euros");
                    ocultarTeclado();
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });
        bDolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (moneda.getText().length()==0){
                    mostrarMensaje("ERROR DOLAR: Introducca un numero ");
                }else {
                    textDolar.setText(String.format("%1$,.2f",Double.parseDouble(moneda.getText().toString())/166.386*0.98)+" dolares");
                    ocultarTeclado();
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });
        bLibra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (moneda.getText().length()==0){
                    mostrarMensaje("ERROR LIBRA: Introducca un numero ");
                }else {
                    textLibra.setText(String.format("%1$,.2f",Double.parseDouble(moneda.getText().toString())/166.386*0.87)+" libras");
                    ocultarTeclado();
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textEuro.length()!=0){
                    textEuro.setText("");
                }
                if (textDolar.length()!=0){
                    textDolar.setText("");
                }
                if (textLibra.length()!=0){
                    textLibra.setText("");
                }
                if (textEuro.length()!=0){
                    textEuro.setText("");
                }
                if (moneda.length()!=0){
                    moneda.setText("");
                }
                if (progressBar.getVisibility()==View.VISIBLE){
                    progressBar.setVisibility(View.INVISIBLE);
                }
                ocultarTeclado();

            }
        });



    }

    /**
     * Muestra un mensaje recibido
     * @param msg mensaje recibido
     */
    private void mostrarMensaje(String msg){
        ocultarTeclado();
        Toast toast=Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.show();
    }
    /**
     * Visivilidad teclado
     */
    private void ocultarTeclado(){
        InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(moneda.getWindowToken(),0);
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("eu",textEuro.getText().toString());
        savedInstanceState.putString("do",textDolar.getText().toString());
        savedInstanceState.putString("li",textLibra.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textEuro.setText(""+savedInstanceState.getString("eu"));
        textDolar.setText(""+savedInstanceState.getString("do"));
        textLibra.setText(""+savedInstanceState.getString("li"));
    }
}