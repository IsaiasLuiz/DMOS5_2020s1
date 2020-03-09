package br.edu.ifsp.arq.dmos5_2020s1.utils;

import br.edu.ifsp.arq.dmos5_2020s1.exception.InvalidData;

public class ConvertTemperature {


    public static double convertToCelsius(final double fahrenheit) throws InvalidData {

        if(fahrenheit == Double.parseDouble(null)) {
            throw new InvalidData("Valor não pode ser null");
        }

        return (fahrenheit - 32) / 1.8;
    }

}
