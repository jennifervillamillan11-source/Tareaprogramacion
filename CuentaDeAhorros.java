/**
 * Clase CuentaDeAhorros que extiende de Cuenta
 * Posee un atributo de sobregirio inicializado en cero
 */
public class CuentaDeAhorros extends Cuenta {
    private float sobregirio;

    /**
     * Constructor de CuentaDeAhorros
     * @param saldoInicial el saldo inicial
     * @param tasaAnual la tasa anual
     */
    public CuentaDeAhorros(float saldoInicial, float tasaAnual) {
        super(saldoInicial, tasaAnual);
        this.sobregirio = 0;
    }

    /**
     * Retira dinero de la cuenta actualizando el saldo
     * No se puede retirar más del saldo (no permite sobregirio)
     * @param cantidad la cantidad a retirar
     */
    @Override
    public void retirar(float cantidad) {
        if (cantidad > 0 && cantidad <= this.getSaldo()) {
            this.setSaldo(this.getSaldo() - cantidad);
            System.out.println("✓ Retiro exitoso de $" + cantidad);
        } else if (cantidad > this.getSaldo()) {
            System.out.println("✗ Error: saldo insuficiente. Saldo disponible: $" + this.getSaldo());
        } else {
            System.out.println("✗ Error: la cantidad debe ser mayor a 0");
        }
    }

    /**
     * Consigna dinero en la cuenta
     * Si hay sobregirio, la cantidad reduce el sobregirio
     * @param cantidad la cantidad a consignar
     */
    @Override
    public void consignar(float cantidad) {
        if (cantidad > 0) {
            if (this.sobregirio > 0) {
                if (cantidad >= this.sobregirio) {
                    cantidad -= this.sobregirio;
                    this.sobregirio = 0;
                    this.setSaldo(this.getSaldo() + cantidad);
                } else {
                    this.sobregirio -= cantidad;
                    cantidad = 0;
                }
            } else {
                this.setSaldo(this.getSaldo() + cantidad);
            }
            System.out.println("✓ Consignación exitosa de $" + cantidad);
        } else {
            System.out.println("✗ Error: la cantidad debe ser mayor a 0");
        }
    }

    /**
     * Genera el extracto mensual
     */
    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    /**
     * Imprime en pantalla el estado de la cuenta de ahorros
     */
    @Override
    public void imprimir() {
        System.out.println("\n========== CUENTA DE AHORROS ==========");
        System.out.println("Saldo: $" + String.format("%.2f", this.getSaldo()));
        System.out.println("Comisión mensual: $" + String.format("%.2f", this.getComisionMensual()));
        System.out.println("Número de transacciones: " + (this.getNumConsignaciones() + this.getNumRetiros()));
        System.out.println("Sobregirio: $" + String.format("%.2f", this.sobregirio));
        System.out.println("=====================================\n");
    }

    // Getters y Setters
    public float getSobregirio() {
        return sobregirio;
    }

    public void setSobregirio(float sobregirio) {
        this.sobregirio = sobregirio;
    }
}
