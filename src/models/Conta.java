package models;

import exceptions.SaldoInsuficienteException;

public abstract class Conta implements InterfaceConta {

//    private: Acesso somente dentro da classe
//    protected: As classes filhas também tem acesso

    private static final String AGENCIA_PADRAO = "0001";
    private static int NUM_CONTA_SEQUENCIAL = 1;
    private static final String MENSAGEM_SUCESSO = "Operação realizada com sucesso!";

    private final String agencia;
    private final int conta;
    private double saldo;
    private final Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.conta = NUM_CONTA_SEQUENCIAL++;  //Autoincremento
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        try{
            if (operacaoSaque(valor)) System.out.println(MENSAGEM_SUCESSO);
        } catch (SaldoInsuficienteException erro){
            System.out.println("Operação cancelada: " + erro.getMessage());
        }
    }

    private boolean operacaoSaque(double valor) throws SaldoInsuficienteException {
        if (temSaldoSuficiente(valor)) {
            saldo -= valor;
            return true;
        }
        else throw new SaldoInsuficienteException(saldo);
    }

    @Override
    public void depositar(double valor) {
        if (operacaoDeposito(valor)) System.out.println(MENSAGEM_SUCESSO);
    }

    private boolean operacaoDeposito(double valor) {
        saldo += valor;
        return true;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        boolean statusSaque = false;
        boolean statusDeposito = false;

        try {
            statusSaque = operacaoSaque(valor);
            statusDeposito = contaDestino.operacaoDeposito(valor);
        } catch (SaldoInsuficienteException erro) {
            System.out.println("Operação cancelada: " + erro.getMessage());
        }

        if (statusSaque && statusDeposito) System.out.println(MENSAGEM_SUCESSO);
    }

    private boolean temSaldoSuficiente(double valor) {
        return valor <= saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("Agência: %s", agencia));
        System.out.println(String.format("models.Conta: %d", conta));
        System.out.println(String.format("Saldo: %.2f", saldo));
    }
}
