package com.example.aluno.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IMCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        Button clickBtncal = (Button) findViewById(R.id.clickBtncal);
        clickBtncal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editTextpeso = (EditText) findViewById(R.id.peso);

                EditText editTextaltura = (EditText) findViewById(R.id.altura);
                double peso = 0;
                double altura = 0;

                try {
                    peso = Double.parseDouble(editTextpeso.getText().toString());
                }catch (Exception e){
                    Toast.makeText(getBaseContext(), "Peso inválida",Toast.LENGTH_LONG).show();
                    return;
                }
                try {
                    altura = Double.parseDouble(editTextaltura.getText().toString());
                }catch (Exception e){
                    Toast.makeText(getBaseContext(), "Altura inválida",Toast.LENGTH_LONG).show();
                    return;
                }

                double resultado = peso / (altura * altura);
                String resultadoPeso = "";

                if (resultado < 18.6){
                    resultadoPeso = "abaixo do peso";
                }

                if (resultado >= 18.6 && resultado <= 24.9){
                    resultadoPeso = "peso ideal";
                }
                if (resultado >= 25.0 && resultado <= 29.9){
                    resultadoPeso = "levemente acima do peso";
                }
                if (resultado >= 30.0 && resultado <= 34.9){
                    resultadoPeso = "Obesidade grau 1";
                }
                if (resultado >= 35.0 && resultado <= 39.9){
                    resultadoPeso = "obesidade grau 2";
                }
                if (resultado >= 40){
                    resultadoPeso = "Obesidade grau 3";
                }
                Toast.makeText(getBaseContext(), resultadoPeso,Toast.LENGTH_LONG).show();
            }
        });
    }

}
