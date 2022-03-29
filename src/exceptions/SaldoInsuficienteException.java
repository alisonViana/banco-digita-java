package exceptions;

public class SaldoInsuficienteException extends Exception {

    public SaldoInsuficienteException(double saldo) {
        super(String.format("Saldo Insuficiente! Saldo atual: %.2f", saldo));
    }

}