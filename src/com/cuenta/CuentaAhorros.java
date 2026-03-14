package com.cuenta;

public class CuentaAhorros extends Cuenta {
    public boolean activa;

    public CuentaAhorros(float saldo, float tasaAnualPorcentaje) {
        super(saldo, tasaAnualPorcentaje);
        actualizarEstado();
    }

    private void actualizarEstado() {
        activa = getSaldo() >= 10000f;
    }

    public void consignar(float cantidad) {
        if (!activa) {
            return;
        }
        super.consignar(cantidad);
    }

    public void retirar(float cantidad) {
        if (!activa) {
            return;
        }
        super.retirar(cantidad);
    }

    public void extractoMensual() {
        if (getNumeroRetiros() > 4) {
            int retirosAdicionales = getNumeroRetiros() - 4;
            setComisionMensual(getComisionMensual() + (retirosAdicionales * 1000f));
        }
        super.extractoMensual();
        actualizarEstado();
    }

    public void imprimir() {
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Comision mensual: " + getComisionMensual());
        System.out.println("Numero transacciones: " + (getNumeroConsignacion() + getNumeroRetiros()));
    }
}