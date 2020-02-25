package br.edu.ifsp.arq.dmos5.conversormoeda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IntDef;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final double VALOR_DOLAR = 4.50;

    private EditText valorRealEditText;

    private Button converterButton;

    private TextView valorDolarTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorRealEditText = findViewById(R.id.edittext_valor_reais);
        converterButton = findViewById(R.id.button_converter);
        valorDolarTextView = findViewById(R.id.textview_valor_dolar);

        converterButton.setOnClickListener(this);

    }

    private void converterDolar() {
        double entrada;
        try {

            entrada = Double.valueOf(valorRealEditText.getText().toString());
        } catch (NumberFormatException e) {
            entrada = 0;
            Toast.makeText(this, "Valor digitado é inválido", Toast.LENGTH_SHORT).show();
        }

        entrada = entrada / VALOR_DOLAR;

        valorDolarTextView.setText(String.valueOf(entrada));

    }

    @Override
    public void onClick(View v) {
        if(v == converterButton) {
        }

    }
}
