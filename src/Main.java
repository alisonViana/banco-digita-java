public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("João", "12345678912");

        Conta cc = new ContaCorrente(cliente);
        Conta poupanca = new ContaPoupanca(cliente);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        cc.depositar(100);
        cc.imprimirExtrato();

        poupanca.depositar(200);
        poupanca.imprimirExtrato();

        cc.transferir(100, poupanca);
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

    }
}
