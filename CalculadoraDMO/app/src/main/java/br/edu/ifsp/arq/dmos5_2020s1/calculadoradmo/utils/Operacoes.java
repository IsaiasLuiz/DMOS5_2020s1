package br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.utils;

import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.constants.Constantes;
import br.edu.ifsp.arq.dmos5_2020s1.calculadoradmo.model.Calculadora;

public class Operacoes {

    private Calculadora calculadora;

    private int operacao;

    public Operacoes() {
        this.calculadora = Calculadora.getInstance();
        reset();
    }

    private void reset() {
        this.operacao = Constantes.NULO;
        this.primeroNumero = "";
        this.segundoNumero = "";
        this.resultadoCalculo = "";
    }

    public void limpar() {
        calculadora.c();
        reset();
    }

    private String primeroNumero;

    private String segundoNumero;

    private String resultadoCalculo;

    public String insereNumero(final String numero) {

        if(primeroNumero.isEmpty()) {
            primeroNumero = primeroNumero + numero;
            resultadoCalculo = primeroNumero;
            operacao = Constantes.NULO;
            return primeroNumero;
        }

        segundoNumero = segundoNumero + numero;
        return segundoNumero;

    }

    public void insereOperacao(final int operacao) {
        this.operacao = operacao;
        primeroNumero = resultadoCalculo;
    }

    public String calcular() {
        if(!primeroNumero.isEmpty() && !segundoNumero.isEmpty()) {
            calculadora.calcular(operacao, Float.valueOf(primeroNumero));
            resultadoCalculo = String.valueOf(calculadora.calcular(operacao, Float.valueOf(segundoNumero)));
            calculadora.c();
            primeroNumero = "";
            segundoNumero = "";

            return resultadoCalculo;
        }

        return "0.0";
    }


    public String inserePonto() {
        if(operacao == Constantes.NULO) {
            primeroNumero = primeroNumero + ".";
            return primeroNumero;
        }

        segundoNumero = segundoNumero  + ".";
        return segundoNumero;
    }

    public String limparParcial() {
        if(segundoNumero.isEmpty()) {
            primeroNumero = "";
            resultadoCalculo = "";
            return "0.0";
        }

        segundoNumero = "";
        return primeroNumero;
    }

}

