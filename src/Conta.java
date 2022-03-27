public abstract class Conta implements InterfaceConta {

//    private: Acesso somente dentro da classe
//    protected: As classes filhas também tem acesso

    private static final String AGENCIA_PADRAO = "0001";
    private static int NUM_CONTA_SEQUENCIAL = 1;

    protected String agencia;
    protected int conta;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.conta = NUM_CONTA_SEQUENCIAL++;  //Autoincremento
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        sacar(valor);
        contaDestino.depositar(valor);
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("Agência: %s", agencia));
        System.out.println(String.format("Conta: %d", conta));
        System.out.println(String.format("Saldo: %.2f", saldo));
    }
}
