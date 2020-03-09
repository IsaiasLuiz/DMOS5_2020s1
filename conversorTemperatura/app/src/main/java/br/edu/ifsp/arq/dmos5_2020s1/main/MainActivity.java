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

    private EditText temperatureEditText;

    private Button convertCelsius;

    private Button convertFahrenheit;

    private TextView convertedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temperatureEditText = findViewById(R.id.temperature_edit_text);

        convertCelsius = findViewById(R.id.convert_celsius);

        convertFahrenheit = findViewById(R.id.convert_fahrenheit);

        convertedTextView = findViewById(R.id.converted_text_view);

        convertCelsius.setOnClickListener(this);

        convertFahrenheit.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if(v == convertCelsius) {
            convertCelsius();
        } else if(v == convertFahrenheit) {
            convertFahrenheit();
        }

    }

    private void convertCelsius() {
        try {
            double converted = ConvertTemperature.convertToCelsius(temperatureEditText.getText().toString());
            convertedTextView.setText(String.format("%.2f ºC", converted));
        } catch (InvalidData e) {
            showToast("Não foi possível converter");
        } catch (Exception e) {
            showToast("Algo inesperado aconteceu");
        }
    }

    private void convertFahrenheit() {
        try {
            double converted = ConvertTemperature.convertToFahrenheit(temperatureEditText.getText().toString());
            convertedTextView.setText(String.format("%.2f ºF", converted));
        } catch (InvalidData e) {
            showToast("Não foi possível converter");
        } catch (Exception e) {
            showToast("Algo inesperado aconteceu");
        }
    }

    private void showToast(final String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
