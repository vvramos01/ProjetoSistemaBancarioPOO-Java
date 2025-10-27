package ContaBancaria;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

       System.out.print("Informe o nome do cliente: ");
       String nome = sc.nextLine();

       System.out.print("Informe o CPF do cliente: ");
       String cpf = sc.nextLine();

       Cliente cliente = new Cliente(nome, cpf);

       System.out.print("Escolha o tipo de conta (1-Corrente, 2-Poupança): ");
       int tipoConta = sc.nextInt();

       System.out.print("Informe o número da conta: ");
       int numero = sc.nextInt();
       sc.nextLine();

       System.out.print("Possui depósito inicial (s/n)? ");
       char resposta = sc.next().charAt(0);

       ContaBancaria conta;

       if (tipoConta == 1) {
           if (resposta == 's' || resposta == 'S') {
               System.out.print("Informe o valor de depósito inicial: ");
               double depositoInicial = sc.nextDouble();
               conta = new ContaCorrente(numero, cliente, depositoInicial);
           } else {
               conta = new ContaCorrente(numero, cliente);
           }
       } else {
           if (resposta == 's' || resposta == 'S') {
               System.out.print("Informe o valor de depósito inicial: ");
               double depositoInicial = sc.nextDouble();
               conta = new ContaPoupanca(numero, cliente, depositoInicial);
           } else {
               conta = new ContaPoupanca(numero, cliente);
           }
       }

       System.out.println("\nDados da conta:");
       System.out.println(conta.toString());

       System.out.print("\nInforme o valor para depósito: ");
       double deposito = sc.nextDouble();
       conta.depositar(deposito);
       System.out.println("Dados da conta atualizados:");
       System.out.println(conta.toString());

       System.out.print("\nInforme o valor para saque: ");
       double saque = sc.nextDouble();
       conta.sacar(saque);
       System.out.println("Dados da conta atualizados:");
       System.out.println(conta.toString());

       if (conta instanceof ContaPoupanca) {
           ContaPoupanca poupanca = (ContaPoupanca) conta;
           poupanca.renderJuros();
           System.out.println("Após rendimento:");
           System.out.println(conta.toString());
       }

       System.out.println("\nComprovante final:");
       conta.imprimirComprovante();

       sc.close();
   }
}

