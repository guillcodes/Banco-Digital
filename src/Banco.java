import java.util.Scanner;

public class Banco {
    private Conta conta1;
    private Conta conta2;

    public Banco() {
        // Inicializando as contas
        conta1 = new ContaCorrente("001");
        conta2 = new ContaPoupança("002");
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            System.out.println("\n===== Menu Banco Digital =====");
            System.out.println("1. Exibir saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Transferir");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    exibirSaldo();
                    break;
                case 2:
                    realizarDeposito(scanner);
                    break;
                case 3:
                    realizarSaque(scanner);
                    break;
                case 4:
                    realizarTransferencia(scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 5);
        
        scanner.close();
    }

    private void exibirSaldo() {
        System.out.println("Saldo da Conta 1 (Corrente): R$ " + conta1.getSaldo());
        System.out.println("Saldo da Conta 2 (Poupança): R$ " + conta2.getSaldo());
    }

    private void realizarDeposito(Scanner scanner) {
        System.out.print("Escolha a conta para depósito (1 para Conta Corrente, 2 para Conta Poupança): ");
        int escolhaConta = scanner.nextInt();
        System.out.print("Informe o valor do depósito: ");
        double valor = scanner.nextDouble();

        if (escolhaConta == 1) {
            conta1.depositar(valor);
        } else if (escolhaConta == 2) {
            conta2.depositar(valor);
        } else {
            System.out.println("Opção de conta inválida!");
        }
    }

    private void realizarSaque(Scanner scanner) {
        System.out.print("Escolha a conta para saque (1 para Conta Corrente, 2 para Conta Poupança): ");
        int escolhaConta = scanner.nextInt();
        System.out.print("Informe o valor do saque: ");
        double valor = scanner.nextDouble();

        if (escolhaConta == 1) {
            conta1.sacar(valor);
        } else if (escolhaConta == 2) {
            conta2.sacar(valor);
        } else {
            System.out.println("Opção de conta inválida!");
        }
    }

    private void realizarTransferencia(Scanner scanner) {
        System.out.print("Escolha a conta de origem para a transferência (1 para Conta Corrente, 2 para Conta Poupança): ");
        int contaOrigem = scanner.nextInt();
        System.out.print("Escolha a conta de destino para a transferência (1 para Conta Corrente, 2 para Conta Poupança): ");
        int contaDestino = scanner.nextInt();
        System.out.print("Informe o valor da transferência: ");
        double valor = scanner.nextDouble();

        if (contaOrigem == 1 && contaDestino == 2) {
            conta1.transferir(valor, conta2);
        } else if (contaOrigem == 2 && contaDestino == 1) {
            conta2.transferir(valor, conta1);
        } else {
            System.out.println("Opções de conta inválidas para transferência.");
        }
    }
}
