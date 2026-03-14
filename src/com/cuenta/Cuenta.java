package com.cuenta;
public class Cuenta {
    private int numeroConsignacion = 0;
    private float saldo;
    private int numeroRetiros = 0;
    private float tasaAnualPorcentaje;
    private float comisionMensual = 0;

    //inicialización con constructor vacío 
    public Cuenta() {
    }

    // Constructor con parámetros
    public Cuenta(float saldo, float tasaAnualPorcentaje) {
        this.saldo = saldo;
        this.tasaAnualPorcentaje = tasaAnualPorcentaje;
    }

    public int getNumeroConsignacion() {
        return numeroConsignacion;
    }

    public float getSaldo() {
        return saldo;
    }

    public int getNumeroRetiros() {
        return numeroRetiros;
    }

    public float getTasaAnualPorcentaje() {
        return tasaAnualPorcentaje;
    }

    public float getComisionMensual() {
        return comisionMensual;
    }

    public void setComisionMensual(float comisionMensual) {
        this.comisionMensual = comisionMensual;
    }

    protected void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    protected void aumentarConsignacion() {
        numeroConsignacion++;
    }

    protected void aumentarRetiros() {
        numeroRetiros++;
    }

    // Consignar una cantidad de dinero en la cuenta actualizando su saldo
    public void consignar(float cantidad) {
        if (cantidad <= 0) {
            return;
        }
        saldo += cantidad;
        aumentarConsignacion();
    }

    // Retirar una cantidad de dinero en la cuenta actualizando su saldo
    public void retirar(float cantidad) {
        if (cantidad <= 0) {
            return;
        }
        if (cantidad > saldo) {
            return;
        }
        saldo -= cantidad;
        aumentarRetiros();
    }

    // Calcular el interes mensual de la cuenta y actualiza el saldo correspondiente
    public void calcularInteresMensual() {
        float interesMensual = saldo * (tasaAnualPorcentaje / 100f) / 12f;
        saldo += interesMensual;
    }

    // Extracto mensual: actualiza el saldo y calcula el interes mensual
    public void extractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

    // Imprimir: muestra en pantalla los valores de los atributos
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Tasa anual (%): " + tasaAnualPorcentaje);
        System.out.println("Numero consignaciones: " + numeroConsignacion);
        System.out.println("Numero retiros: " + numeroRetiros);
        System.out.println("Comision mensual: " + comisionMensual);
    }
}