package br.edu.ifsp.arq.dmos5_2020s1.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsp.arq.dmos5_2020s1.R;
import br.edu.ifsp.arq.dmos5_2020s1.exception.InvalidData;
import br.edu.ifsp.arq.dmos5_2020s1.utils.ConvertTemperature;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText fahrenheitEditText;

    private Button convertCelsius;

    private TextView convertedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fahrenheitEditText = findViewById(R.id.fahrenhei_eEdit_text);

        convertCelsius = findViewById(R.id.convert_celsius);

        convertedTextView = findViewById(R.id.converted_text_view);

        convertCelsius.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(v == convertCelsius) {
                convertCelsius();
        }

    }

    private void convertCelsius() {
        try {
            double converted = ConvertTemperature.convertToCelsius(Double.parseDouble(fahrenheitEditText.getText().toString()));
            convertedTextView.setText(String.format("%.2f ºC", converted));
        } catch (InvalidData e) {
            Toast.makeText(this, "Não foi possível converter", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Algo inesperado aconteceu", Toast.LENGTH_SHORT).show();
        }
    }

}
