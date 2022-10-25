package com.pabiya.appmydinerov2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ConfigurationInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.annotation.ElementType;

public class myDineroV2 extends AppCompatActivity {
    /**
     * 1eu =0.98do
     * 1pe =0.0060ue
     * 1eu=0.87li
     */


    TextView textEuro,textDolar,textLibra;
    EditText moneda,chdolarText,chlibraText;
    Button bEuro,bDolar,bLibra,port,chdolar,chlibra;
    ImageView image;
    Double dolar,libra;
//    String[] archivos = fileList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dinero);

        textEuro=findViewById(R.id.textEuros);
        textDolar=findViewById(R.id.textDollar);
        textLibra=findViewById(R.id.textLibra);
        moneda =findViewById(R.id.editDinero);
        bEuro=findViewById(R.id.buttonEuro);
        bDolar=findViewById(R.id.buttonDolar);
        bLibra=findViewById(R.id.buttonLibra);
        image=findViewById(R.id.imageView);
        port=findViewById(R.id.port);
        chdolar=findViewById(R.id.chdolar);
        chlibra=findViewById(R.id.chlibra);
        chdolarText=findViewById(R.id.chdolarText);
        chlibraText=findViewById(R.id.chlibraText);
        dolar=0.98;
        libra=1.14;
//        if (existeArchivo(archivos, "dolar.dat")) {
//            try {
//                InputStreamReader archivo = new InputStreamReader(openFileInput("dolar.dat"));
//                BufferedReader br = new BufferedReader(archivo);
//                String ínea = br.readLine();
//                String todas = "";
//                while (ínea != null) {
//                    todas = todas + ínea + "\n";
//                    ínea = br.readLine();
//                }
//                br.close();
//                archivo.close();
//                chdolarText.setText(todas);
//                dolar=Double.parseDouble(todas);
//            } catch (IOException e) {
//                Toast.makeText(this, "Error leyendo dólar", Toast.LENGTH_SHORT).show();
//            }
//        }
        chdolarText.setText(dolar.toString());
        chlibraText.setText(libra.toString());


        bEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (moneda.getText().length()==0){
                    mostrarMensaje("ERROR Euro: Introducca un numero ",view);
                }else {
                    textEuro.setText(String.format("%1$,.2f",Double.parseDouble(moneda.getText().toString())/166.386)+" euros");
                    ocultarTeclado();

                }
            }
        });
        bDolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (moneda.getText().length()==0){
                    mostrarMensaje("ERROR DOLAR: Introducca un numero ",view);
                }else {
                    textDolar.setText(String.format("%1$,.2f",Double.parseDouble(moneda.getText().toString())/166.386*dolar)+" dolares");
                    ocultarTeclado();

                }
            }
        });
        bLibra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (moneda.getText().length()==0){
                    mostrarMensaje("ERROR LIBRA: Introducca un numero ",view);
                }else {
                    textLibra.setText(String.format("%1$,.2f",Double.parseDouble(moneda.getText().toString())/166.386*libra)+" libras");
                    ocultarTeclado();

                }
            }
        });

        port.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Configuration conf=myDineroV2.this.getResources().getConfiguration();
//                if(conf.orientation==ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE)
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

            }
        });
        chdolar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dolar=Double.parseDouble(chdolarText.getText().toString());
//                guardarDolar();
                Toast.makeText(myDineroV2.this, "Valor Dolar actualizado", Toast.LENGTH_SHORT).show();

            }
        });
        chlibra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                libra=Double.parseDouble(chlibraText.getText().toString());
                Toast.makeText(myDineroV2.this, "Valor Libra actualizado", Toast.LENGTH_SHORT).show();
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

                ocultarTeclado();

            }
        });



    }

    /**
     * Muestra un mensaje recibido
     * @param msg mensaje recibido
     * @param view vista
     */
    private void mostrarMensaje(String msg,View view){
        ocultarTeclado();
        Snackbar.make(view,msg,Snackbar.LENGTH_SHORT).show();

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mimenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.accion_salir:
//                Toast.makeText(this, "Salir", Toast.LENGTH_SHORT).show();
//                System.exit(0);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
//    private boolean existeArchivo(String[] archivos, String archbusca) {
//        for (int f = 0; f < archivos.length; f++)
//            if (archbusca.equals(archivos[f]))
//                return true;
//        return false;
//    }
//    public void guardarDolar() {
//        try {
//            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("dolar.dat", Activity.MODE_PRIVATE));
//            archivo.write(chdolarText.getText().toString());
//            archivo.flush();
//            archivo.close();
//        } catch (IOException e) {
//            Toast.makeText(this, "Error guardando dólar", Toast.LENGTH_SHORT).show();
//        }
//        Toast.makeText(this, "Dólar guardado", Toast.LENGTH_SHORT).show();
//
//    }

}