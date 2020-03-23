package br.edu.ifsp.arq.calculadoraimc.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import br.edu.ifsp.arq.calculadoraimc.R;
import br.edu.ifsp.arq.calculadoraimc.model.Pessoa;

public class DetalhesImcActivity extends AppCompatActivity {

    private TextView  textViewImc;

    private TextView textViewResultado;

    private TextView textViewDetalhes;

    private Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_imc);

        textViewImc = findViewById(R.id.textview_saida_imc);
        textViewResultado = findViewById(R.id.textview_saida_resultado);
        textViewDetalhes = findViewById(R.id.textview_saida_detalhes);

        desembrulhar();

        mostrar();

    }

    private void desembrulhar() {
        Intent intecao = getIntent();
        Bundle embrulho = intecao.getExtras();

        if(embrulho != null) {
            double peso = embrulho.getDouble(MainActivity.KEY_PESO);
            double altura = embrulho.getDouble(MainActivity.KEY_ALTURA);

            pessoa = new Pessoa(altura, peso);
        }
    }

    private void mostrar() {
        textViewImc.setText(String.format("%.2f", pessoa.imc()));
        textViewResultado.setText(getString(pessoa.resultado()));
        textViewDetalhes.setText(getString(pessoa.explicativo()));
    }

}
