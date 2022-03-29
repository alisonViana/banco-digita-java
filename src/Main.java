import models.Cliente;
import models.Conta;
import models.ContaCorrente;
import models.ContaPoupanca;

public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente("João", "12345678912");

        ContaCorrente cc = new ContaCorrente(cliente);
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

        cc.sacar(250);
        cc.transferir(50, poupanca);
        poupanca.imprimirExtrato();
        poupanca.transferir(50, cc);
        cc.sacar(250);
        poupanca.transferir(200, cc);
        cc.sacar(250);

    }
}
