public class ContaCorrente extends Conta {
    public ContaCorrente(String numeroConta) {
        super(numeroConta);
    }

    @Override
    public void tipoDeConta() {
        System.out.println("Conta Corrente");
    }
}
