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
        resultadoCalculo = "";
    }

    public void limpar() {
        calculadora.c();
        reset();
    }

    private String primeroNumero;

    private String segundoNumero;

    private String resultadoCalculo;

    public String insereNumero(final String numero) {

        if(operacao == Constantes.NULO) {
            primeroNumero = primeroNumero + numero;
            resultadoCalculo = primeroNumero;
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
        calculadora.calcular(operacao, Float.valueOf(primeroNumero));
        resultadoCalculo = String.valueOf(calculadora.calcular(operacao, Float.valueOf(segundoNumero)));
        calculadora.c();
        operacao = Constantes.NULO;
        segundoNumero = "";
        return resultadoCalculo;
    }


    public String inserePonto() {
        if(operacao == Constantes.NULO) {
            primeroNumero = primeroNumero + ".";
            return primeroNumero;
        }

        segundoNumero = segundoNumero  + ".";
        return segundoNumero;
    }

}

