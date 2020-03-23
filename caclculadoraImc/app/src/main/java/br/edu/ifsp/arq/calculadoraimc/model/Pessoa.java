package br.edu.ifsp.arq.calculadoraimc.model;

import br.edu.ifsp.arq.calculadoraimc.R;

public class Pessoa {

    public static final int ABAIXO = R.string.abaixo_do_peso;

    public static final int NORMAL = R.string.peso_normal;

    public static final int SOBREPESO = R.string.sobrepeso;

    public static final int GRAU_1 = R.string.obeso_grau_1;

    public static final int GRAU_2 = R.string.obeso_grau_1;

    public static final int GRAU_3 = R.string.obeso_grau_1;

    private double altura;

    private double peso;

    public Pessoa() {}

    public Pessoa(double altura, double peso) {
        setAltura(altura);
        setPeso(peso);
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura < 0 ? altura * -1 : altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso < 0 ? peso * -1 : peso;
    }

    public double imc() {
        return this.peso / Math.pow(this.altura, 2);
    }

    public int resultado() {
        double imc = imc();

        if(imc < 18.5) {
            return ABAIXO;
        } else {
            if(imc <24.9) {
                return NORMAL;
            } else {
                if(imc < 29.9) {
                    return SOBREPESO;
                } else {
                    if(imc < 34.9) {
                        return GRAU_1;
                    } else {
                        if(imc < 39.9) {
                            return GRAU_2;
                        } else {
                            return GRAU_3;
                        }
                    }
                }
            }
        }
    }

    public int explicativo() {
        double imc = imc();

        if(imc < 18.5) {
            return R.string.resultado_abaixo_do_peso;
        } else {
            if(imc <24.9) {
                return R.string.resultado_peso_normal;
            } else {
                if(imc < 29.9) {
                    return R.string.resultado_sobrepeso;
                } else {
                    if(imc < 34.9) {
                        return R.string.resultado_grau_1;
                    } else {
                        if(imc < 39.9) {
                            return R.string.resultado_grau_2;
                        } else {
                            return R.string.resultado_grau_3;
                        }
                    }
                }
            }
        }
    }



}
