package br.edu.ifsp.arq.calculadoraimc.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

import br.edu.ifsp.arq.calculadoraimc.R;
import br.edu.ifsp.arq.calculadoraimc.model.Pessoa;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText pesoEditText;

    private EditText alturaEditText;

    private Button calcularButton;

    public static final String KEY_PESO = "peso";

    public static final String KEY_ALTURA = "altura";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesoEditText = findViewById(R.id.edittext_peso);
        alturaEditText = findViewById(R.id.edittext_altura);

        calcularButton = findViewById(R.id.button_calcular_imc);
        calcularButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == calcularButton) {
            calcularImc();
        }
    }

    private void calcularImc() {
        Pessoa pessoa;
        double altura, peso;

        try {
            peso = Double.parseDouble(pesoEditText.getText().toString());
            altura = Double.parseDouble(alturaEditText.getText().toString());
        } catch (NumberFormatException nfe) {
            peso = 0;
            altura = 0;
        }

        if(peso == 0 || altura == 0) {
            Toast.makeText(this, "Entrada de dados inválida", Toast.LENGTH_SHORT).show();
        } else {
            Bundle argumentos = new Bundle();
            argumentos.putDouble(MainActivity.KEY_PESO, peso);
            argumentos.putDouble(MainActivity.KEY_ALTURA, altura);

            Intent novaTela = new Intent(this, DetalhesImcActivity.class);
            novaTela.putExtras(argumentos);
            startActivity(novaTela);
        }
    }
}
