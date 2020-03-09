package br.edu.ifsp.arq.dmos5_2020s1.utils;

import br.edu.ifsp.arq.dmos5_2020s1.exception.InvalidData;

public class ConvertTemperature {


    public static double convertToCelsius(final String fahrenheit) throws InvalidData {

        try {
            return (Double.parseDouble(fahrenheit) - 32) / 1.8;
        } catch (Exception e) {
            throw new InvalidData("Valor Invalido");
        }

    }


    public static double convertToFahrenheit(final String celsius) throws InvalidData {

        try {
            return 1.8 * Double.parseDouble(celsius) + 32;
        } catch (Exception e) {
            throw new InvalidData("Valor Invalido");
        }

    }

}
