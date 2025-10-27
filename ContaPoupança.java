package ContaBancaria;

public class ContaPoupanca extends ContaBancaria {
   private static final double TAXA_RENDIMENTO = 0.005; // 0,5%

   public ContaPoupanca(int numero, Cliente titular) {
       super(numero, titular);
   }

   public ContaPoupanca(int numero, Cliente titular, double depositoInicial) {
       super(numero, titular, depositoInicial);
   }

   @Override
   public void sacar(double quantia) {
       double saldoAtual = getSaldo();

       if (saldoAtual >= quantia) {
           setSaldo(saldoAtual - quantia);
           System.out.println("Saque de R$ " + quantia + " realizado.");
       } else {
           System.out.println("Saldo insuficiente! Não é permitido saldo negativo.");
       }
   }

   public void renderJuros() {
       double saldoAtual = getSaldo();
       double rendimento = saldoAtual * TAXA_RENDIMENTO;
       setSaldo(saldoAtual + rendimento);
       System.out.println("Rendimento aplicado: R$ " + String.format("%.2f", rendimento));
   }

   @Override
   public String toString() {
       return "Conta Poupança - " + super.toString();
   }
}
