package com.example.miprimerapp2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    double valor;
    TabHost tbh;
    TextView tempVal;
    EditText txt;
    Spinner spn;
    Button btn;

    Double Area[] = new Double[] {
            1.0,
            0.13295,
            0.11111,
            0.09290,
            0.0002127,
            0.00001329,
            0.00000929
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhConversores);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("Monedas").setContent(R.id.tabArea).setIndicator("", getDrawable(R.drawable.medida_de_volumen)));
        tbh.addTab(tbh.newTabSpec("Longitud").setContent(R.id.tabAgua).setIndicator("", getResources().getDrawable(R.drawable.medida_de_volumen)));


        btn = findViewById(R.id.btnMonedasConvertir);
        btn.setOnClickListener(v->convertirMonedas());

        btn = findViewById(R.id.btnLongitudConvertir);
        btn.setOnClickListener(v->convertirAgua());


    }

    private void convertirAgua(){

        txt = findViewById(R.id.txtAguaConsumo);
        String texto = txt.getText().toString();

        if(texto.isEmpty()){
            return;
        }

        valor = Double.parseDouble(texto);

        if (valor >= 1 && valor <= 18){
            tempVal = findViewById(R.id.lblaguaRespuesta);
            tempVal.setText("Respuesta: $6");
        }else
        if (valor >= 19 && valor <= 28){
            tempVal = findViewById(R.id.lblaguaRespuesta);
            valor = ((valor -18)*0.45)+6;
            tempVal.setText("Respuesta:$"+ valor);
        }else
        if (valor >= 29){
            tempVal = findViewById(R.id.lblaguaRespuesta);
            valor = ((valor -28)*0.65)+6+4.5;
            tempVal.setText("Respuesta:$"+valor);
        }else  if (valor <=0){
            tempVal = findViewById(R.id.lblaguaRespuesta);
            tempVal.setText("Respuesta:Valor invalido");}


    }
    private void convertirMonedas(){
        spn = findViewById(R.id.spnMonedasDe);
        int de = spn.getSelectedItemPosition();

        spn = findViewById(R.id.spnMonedasA);
        int a = spn.getSelectedItemPosition();

        tempVal = findViewById(R.id.txtMonedasCantidad);
        double cantidad = Double.parseDouble(tempVal.getText().toString());
        double respuesta = conversor(de, a, cantidad);

        tempVal = findViewById(R.id.lblMonedasRespuesta);
        tempVal.setText("Respuesta: "+ respuesta);
    }
    double conversor(int de, int a, double cantidad){
        return Area[a]/Area[de] * cantidad;
    }
}


