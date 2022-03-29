package models;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

//     O método "imprimirExtrato" foi declarado na interface "models.InterfaceConta",
//     como a classe "models.Conta" implementa essa interface, ela seria obrigada a
//     implementar o método, porém, por ser uma classe abstrata, a obrigação
//     de implementação é passada para as classes filhas que herdam de "models.Conta".

    @Override
    public void imprimirExtrato() {
        System.out.println(String.format("***** Extrato models.Conta Corrente *****"));
        super.imprimirInfosComuns();
    }
}
