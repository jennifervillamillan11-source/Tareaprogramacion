/**
 * Clase que representa una Cuenta Bancaria
 * Atributos: saldo, número de consignaciones, número de retiros,
 * tasa anual y comisión mensual
 */
public class Cuenta {
    private float saldo;
    private int numConsignaciones;
    private int numRetiros;
    private float tasaAnual;
    private float comisionMensual;

    /**
     * Constructor que inicializa la cuenta con saldo y tasa anual
     * @param saldoInicial el saldo inicial de la cuenta
     * @param tasaAnual la tasa anual (porcentaje)
     */
    public Cuenta(float saldoInicial, float tasaAnual) {
        this.saldo = saldoInicial;
        this.tasaAnual = tasaAnual;
        this.numConsignaciones = 0;
        this.numRetiros = 0;
        this.comisionMensual = 0;
    }

    /**
     * Consigna una cantidad de dinero en la cuenta
     * @param cantidad la cantidad a consignar
     */
    public void consignar(float cantidad) {
        if (cantidad > 0) {
            this.saldo += cantidad;
            this.numConsignaciones++;
            System.out.println("✓ Consignación exitosa de $" + cantidad);
        } else {
            System.out.println("✗ Error: la cantidad debe ser mayor a 0");
        }
    }

    /**
     * Retira una cantidad de dinero de la cuenta
     * El valor a retirar no debe superar el saldo
     * @param cantidad la cantidad a retirar
     */
    public void retirar(float cantidad) {
        if (cantidad > 0 && cantidad <= this.saldo) {
            this.saldo -= cantidad;
            this.numRetiros++;
            System.out.println("✓ Retiro exitoso de $" + cantidad);
        } else if (cantidad > this.saldo) {
            System.out.println("✗ Error: saldo insuficiente. Saldo disponible: $" + this.saldo);
        } else {
            System.out.println("✗ Error: la cantidad debe ser mayor a 0");
        }
    }

    /**
     * Calcula el interés mensual de la cuenta
     * Actualiza el saldo restando la comisión mensual y calculando el interés
     */
    public void calcularInteresMensual() {
        float tasaMensual = (this.tasaAnual / 12) / 100;
        float interesMensual = this.saldo * tasaMensual;
        this.saldo += interesMensual;
    }

    /**
     * Genera el extracto mensual
     * Actualiza el saldo restando la comisión y calculando el interés
     */
    public void extractoMensual() {
        this.saldo -= this.comisionMensual;
        this.calcularInteresMensual();
    }

    /**
     * Imprime en pantalla los valores de los atributos de la cuenta
     */
    public void imprimir() {
        System.out.println("\n========== ESTADO DE LA CUENTA ==========");
        System.out.println("Saldo: $" + String.format("%.2f", this.saldo));
        System.out.println("Número de consignaciones: " + this.numConsignaciones);
        System.out.println("Número de retiros: " + this.numRetiros);
        System.out.println("Tasa anual: " + this.tasaAnual + "%");
        System.out.println("Comisión mensual: $" + String.format("%.2f", this.comisionMensual));
        System.out.println("========================================\n");
    }

    // Getters y Setters
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getNumConsignaciones() {
        return numConsignaciones;
    }

    public int getNumRetiros() {
        return numRetiros;
    }

    public float getTasaAnual() {
        return tasaAnual;
    }

    public void setTasaAnual(float tasaAnual) {
        this.tasaAnual = tasaAnual;
    }

    public float getComisionMensual() {
        return comisionMensual;
    }

    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }
}
