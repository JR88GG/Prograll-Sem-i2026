package com.example.miprimerapp2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tempVal;//variable con valor temporal
    Button btn;//
    Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnCalcular);
        btn.setOnClickListener(v -> calcular());
    }

    private void calcular() {
        tempVal = findViewById(R.id.txtNum1);
        double num1 = Double.parseDouble(tempVal.getText().toString());

        tempVal = findViewById(R.id.txtNum2);
        double num2 = Double.parseDouble(tempVal.getText().toString());

        double respuesta = 0;

        spn = findViewById(R.id.cboOpciones);
        switch (spn.getSelectedItemPosition()){
            case 0: //suma
                respuesta = num1 + num2;
                break;
            case 1: //Resta
                respuesta = num1 - num2;
                break;
            case 2: //Multiplicacion
                respuesta = num1 * num2;
                break;
            case 3: //division
                respuesta = num1 / num2;
                break;
        }
            //agregar factorial, exponenciacion, porcentaje, raiz
            tempVal = findViewById(R.id.lblRespuesta);
            tempVal.setText("Respuesta: " + respuesta);
        }
    }
