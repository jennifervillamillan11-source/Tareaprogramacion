package com.cuenta;

public class CuentaCorriente extends Cuenta {
    private float sobregiro = 0;

    public CuentaCorriente(float saldo, float tasaAnualPorcentaje) {
        super(saldo, tasaAnualPorcentaje);
    }

    public float getSobregiro() {
        return sobregiro;
    }

    public void retirar(float cantidad) {
        if (cantidad <= 0) {
            return;
        }
        if (cantidad <= getSaldo()) {
            super.retirar(cantidad);
            return;
        }
        float excedente = cantidad - getSaldo();
        setSaldo(0);
        sobregiro += excedente;
        aumentarRetiros();
    }

    public void consignar(float cantidad) {
        if (cantidad <= 0) {
            return;
        }
        super.consignar(cantidad);
        if (sobregiro > 0) {
            if (getSaldo() >= sobregiro) {
                setSaldo(getSaldo() - sobregiro);
                sobregiro = 0;
            } else {
                sobregiro -= getSaldo();
                setSaldo(0);
            }
        }
    }

    public void extractoMensual() {
        super.extractoMensual();
    }

    public void imprimir() {
        System.out.println("Saldo: " + getSaldo());
        System.out.println("Comision mensual: " + getComisionMensual());
        System.out.println("Numero transacciones: " + (getNumeroConsignacion() + getNumeroRetiros()));
        System.out.println("Sobregiro: " + sobregiro);
    }
}