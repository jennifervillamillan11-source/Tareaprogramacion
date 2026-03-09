/**
 * Clase Principal que demuestra el funcionamiento del sistema bancario
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║          SISTEMA DE CUENTA BANCARIA - DEMOSTRACIÓN       ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝\n");

        // ============ CUENTA DE AHORROS ============
        System.out.println("┌──────────────────────────────────────────────────────────┐");
        System.out.println("│              1. CUENTA DE AHORROS                        │");
        System.out.println("└──────────────────────────────────────────────────────────┘");
        
        CuentaDeAhorros ahorros = new CuentaDeAhorros(2000, 8);
        System.out.println("Cuenta de Ahorros creada con saldo inicial de $2000 y tasa del 8%\n");
        ahorros.imprimir();

        System.out.println("--- Realizando consignaciones en Cuenta de Ahorros ---");
        ahorros.consignar(500);
        ahorros.consignar(300);
        ahorros.imprimir();

        System.out.println("--- Realizando retiros en Cuenta de Ahorros ---");
        ahorros.retirar(300);
        ahorros.retirar(200);
        ahorros.imprimir();

        System.out.println("--- Intento de retiro con saldo insuficiente ---");
        ahorros.retirar(5000);
        ahorros.imprimir();

        System.out.println("--- Procesando extracto mensual ---");
        ahorros.setComisionMensual(10);
        ahorros.extractoMensual();
        ahorros.imprimir();

        // ============ CUENTA CORRIENTE ============
        System.out.println("\n┌──────────────────────────────────────────────────────────┐");
        System.out.println("│              2. CUENTA CORRIENTE                         │");
        System.out.println("└──────────────────────────────────────────────────────────┘");
        
        CuentaCorriente corriente = new CuentaCorriente(1500, 6);
        System.out.println("Cuenta Corriente creada con saldo inicial de $1500 y tasa del 6%\n");
        corriente.imprimir();

        System.out.println("--- Realizando consignaciones en Cuenta Corriente ---");
        corriente.consignar(800);
        corriente.consignar(400);
        corriente.imprimir();

        System.out.println("--- Realizando retiros en Cuenta Corriente ---");
        corriente.retirar(500);
        corriente.retirar(300);
        corriente.imprimir();

        System.out.println("--- Retiro con sobregirio permitido (característica de CC) ---");
        corriente.retirar(3000);
        System.out.println("(Nota: En Cuenta Corriente se permite sobregirio)");
        corriente.imprimir();

        System.out.println("--- Consignación que reduce el sobregirio ---");
        corriente.consignar(1500);
        corriente.imprimir();

        System.out.println("--- Procesando extracto mensual ---");
        corriente.setComisionMensual(20);
        corriente.extractoMensual();
        corriente.imprimir();

        // ============ RESUMEN COMPARATIVO ============
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║              RESUMEN COMPARATIVO                         ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        
        System.out.println("\n--- CUENTA DE AHORROS ---");
        System.out.println("Saldo: $" + String.format("%.2f", ahorros.getSaldo()));
        System.out.println("Transacciones: " + (ahorros.getNumConsignaciones() + ahorros.getNumRetiros()));
        System.out.println("Sobregirio: $" + String.format("%.2f", ahorros.getSobregirio()));
        System.out.println("Característica: NO permite sobregirio");
        
        System.out.println("\n--- CUENTA CORRIENTE ---");
        System.out.println("Saldo: $" + String.format("%.2f", corriente.getSaldo()));
        System.out.println("Transacciones: " + (corriente.getNumConsignaciones() + corriente.getNumRetiros()));
        System.out.println("Sobregirio: $" + String.format("%.2f", corriente.getSobregirio()));
        System.out.println("Característica: SÍ permite sobregirio");
    }
}
