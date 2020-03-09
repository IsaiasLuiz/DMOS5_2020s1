package br.edu.ifsp.arq.calculadoraimc.activities;

import androidx.appcompat.app.AppCompatActivity;

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
            pessoa = new Pessoa(altura, peso);
            Toast.makeText(this, String.format("IMC: %.1f", pessoa.imc()), Toast.LENGTH_LONG).show();
        }
    }
}
