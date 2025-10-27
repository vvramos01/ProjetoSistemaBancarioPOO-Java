package ContaBancaria;

public class ContaCorrente extends ContaBancaria {
   private static final double TAXA_SAQUE = 5.00;
   private static final double LIMITE_NEGATIVO = -50.00;

   public ContaCorrente(int numero, Cliente titular) {
       super(numero, titular);
   }

   public ContaCorrente(int numero, Cliente titular, double depositoInicial) {
       super(numero, titular, depositoInicial);
   }

   @Override
   public void sacar(double quantia) {
       double valorTotal = quantia + TAXA_SAQUE;
       double saldoAtual = getSaldo();

       if (saldoAtual - valorTotal >= LIMITE_NEGATIVO) {
           setSaldo(saldoAtual - valorTotal);
           System.out.println("Saque de R$ " + quantia + " realizado. Taxa: R$ " + TAXA_SAQUE);
       } else {
           System.out.println("Saldo insuficiente! Limite negativo máximo: R$ " + (-LIMITE_NEGATIVO));
       }
   }

   @Override
   public String toString() {
       return "Conta Corrente - " + super.toString();
   }
}

