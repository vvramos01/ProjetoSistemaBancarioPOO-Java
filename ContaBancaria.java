package ContaBancaria;

public abstract class ContaBancaria {
   private final int numero;
   private Cliente titular;
   private double saldo;

   public ContaBancaria(int numero, Cliente titular) {
       this.numero = numero;
       this.titular = titular;
       this.saldo = 0.0;
   }

   public ContaBancaria(int numero, Cliente titular, double depositoInicial) {
       this.numero = numero;
       this.titular = titular;
       depositar(depositoInicial);
   }

   public final int getNumero() {
       return numero;
   }

   public final Cliente getTitular() {
       return titular;
   }

   public final double getSaldo() {
       return saldo;
   }

   public final void setTitular(Cliente titular) {
       this.titular = titular;
   }

   public final void depositar(double quantia) {
       if (quantia > 0) {
           saldo += quantia;
       }
   }

   public abstract void sacar(double quantia);

   public final void imprimirComprovante() {
       System.out.println("=== COMPROVANTE BANCÁRIO ===");
       System.out.println(this.toString());
       System.out.println("============================");
   }

   @Override
   public String toString() {
       return "Conta " + numero +
               ", Titular: " + titular.getNome() +
               ", Saldo: R$ " + String.format("%.2f", saldo);
   }

   protected final void setSaldo(double saldo) {
       this.saldo = saldo;
   }
}

