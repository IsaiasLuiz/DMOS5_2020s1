package br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.R;
import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.constants.Constantes;
import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.utils.Operacoes;

public class CalculadoraActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonLimpar, buttonDividir;

    private Button buttonSete, buttonOito, buttonNove, buttonMultiplicacao;

    private Button buttonQuatro, buttonCinco, buttonSeis, buttonMenos;

    private Button buttonUm, buttonDois, buttonTres, buttonMais;

    private Button buttonZero, buttonPonto, buttonIgual;

    private TextView textViewResultado;

    private Operacoes operacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

         operacoes = new Operacoes();

        buttonLimpar = findViewById(R.id.button_c);
        buttonLimpar.setOnClickListener(this);

        buttonDividir = findViewById(R.id.button_divisao);
        buttonDividir.setOnClickListener(this);

        buttonSete = findViewById(R.id.button_sete);
        buttonSete.setOnClickListener(this);

        buttonOito = findViewById(R.id.button_oito);
        buttonOito.setOnClickListener(this);

        buttonNove = findViewById(R.id.button_nove);
        buttonNove.setOnClickListener(this);

        buttonMultiplicacao = findViewById(R.id.button_multiplicacao);
        buttonMultiplicacao.setOnClickListener(this);

        buttonQuatro = findViewById(R.id.button_quatro);
        buttonQuatro.setOnClickListener(this);

        buttonCinco = findViewById(R.id.button_cinco);
        buttonCinco.setOnClickListener(this);

        buttonSeis = findViewById(R.id.button_seis);
        buttonSeis.setOnClickListener(this);

        buttonMenos = findViewById(R.id.button_subtracao);
        buttonMenos.setOnClickListener(this);

        buttonUm = findViewById(R.id.button_um);
        buttonUm.setOnClickListener(this);

        buttonDois = findViewById(R.id.button_dois);
        buttonDois.setOnClickListener(this);

        buttonTres = findViewById(R.id.button_tres);
        buttonTres.setOnClickListener(this);

        buttonMais = findViewById(R.id.button_adicao);
        buttonMais.setOnClickListener(this);

        buttonZero = findViewById(R.id.button_zero);
        buttonZero.setOnClickListener(this);

        buttonPonto = findViewById(R.id.button_ponto);
        buttonPonto.setOnClickListener(this);

        buttonIgual = findViewById(R.id.button_igual);
        buttonIgual.setOnClickListener(this);

        textViewResultado = findViewById(R.id.textview_lcd);

    }

    @Override
    public void onClick(View view) {
        if(view == buttonLimpar) {
            operacoes.limpar();
            textViewResultado.setText("0.0");
        } else if(view == buttonDividir) {
            operacoes.insereOperacao(Constantes.DIVISAO);
        } else if(view == buttonSete) {
            textViewResultado.setText(String.valueOf(operacoes.insereNumero("7")));
        } else if(view == buttonOito) {
            textViewResultado.setText(String.valueOf(operacoes.insereNumero("8")));
        } else if(view == buttonNove) {
            textViewResultado.setText(String.valueOf(operacoes.insereNumero("9")));
        } else if(view == buttonMultiplicacao) {
            operacoes.insereOperacao(Constantes.MULTIPLICACAO);
        } else if(view == buttonQuatro) {
            textViewResultado.setText(String.valueOf(operacoes.insereNumero("4")));
        } else if(view == buttonCinco) {
            textViewResultado.setText(String.valueOf(operacoes.insereNumero("5")));
        } else if(view == buttonSeis) {
            textViewResultado.setText(String.valueOf(operacoes.insereNumero("6")));
        } else if(view == buttonMenos) {
            operacoes.insereOperacao(Constantes.SUBTRACAO);
        } else if(view == buttonUm) {
            textViewResultado.setText(String.valueOf(operacoes.insereNumero("1")));
        } else if(view == buttonDois) {
            textViewResultado.setText(String.valueOf(operacoes.insereNumero("2")));
        } else if(view == buttonTres) {
            textViewResultado.setText(String.valueOf(operacoes.insereNumero("3")));
        } else if(view == buttonMais) {
            operacoes.insereOperacao(Constantes.ADICAO);
        } else if(view == buttonZero) {
            textViewResultado.setText(String.valueOf(operacoes.insereNumero("0")));
        } else if(view == buttonPonto) {
            operacoes.inserePonto();
        } else if (view == buttonIgual){
            textViewResultado.setText(operacoes.calcular());
        }
    }
}
