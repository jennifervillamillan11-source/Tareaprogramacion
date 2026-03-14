package com.cuenta;

public class Main {
    public static void main(String[] args) {
        CuentaAhorros ahorro = new CuentaAhorros(12000f, 10f);

        ahorro.consignar(1000f);
        ahorro.retirar(500f);
        ahorro.retirar(200f);
        ahorro.retirar(300f);
        ahorro.retirar(400f);
        ahorro.setComisionMensual(0f);
        ahorro.extractoMensual();

        System.out.println("Cuenta de Ahorros:");
        ahorro.imprimir();
    }
}