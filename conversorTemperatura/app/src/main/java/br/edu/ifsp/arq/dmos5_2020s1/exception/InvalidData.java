package br.edu.ifsp.arq.dmos5_2020s1.exception;

public class InvalidData extends Exception {

    public InvalidData() {
    }

    public  InvalidData(final String s) {
        super(s);
    }

    public InvalidData(final String s, final Throwable throwable) {
        super(s, throwable);
    }

    public InvalidData(final Throwable throwable) {
        super(throwable);
    }

    public InvalidData(final String s, final Throwable throwable, final boolean b, final boolean b1) {
        super(s, throwable, b, b1);
    }

}
