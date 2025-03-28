public class ContaPoupança extends Conta {
    public ContaPoupança(String numeroConta) {
        super(numeroConta);
    }

    @Override
    public void tipoDeConta() {
        System.out.println("Conta Poupança");
    }
}
