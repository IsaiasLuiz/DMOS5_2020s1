package br.edu.ifsp.arq.calculadoraimc.model;

public class Pessoa {

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

}
