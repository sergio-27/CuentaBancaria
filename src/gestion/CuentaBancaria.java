package gestion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu2015018
 */
public class CuentaBancaria {

    private static final double CANTIDAD_MINIMA_INICIAL = 50;
    private double saldo;

    public CuentaBancaria(double cantidad) throws Exception {

        if (cantidad < 50) {
            throw new Exception("Cantidad minima de 50 €.");
        }

        this.saldo = cantidad;

    }

    public void ingreso(double cantidad) {
        saldo += cantidad;
    }

    public double getSaldo() {
        return saldo;
    }

    public void reintegro(double cantidad) throws Exception {
        if (cantidad <= saldo){
            saldo -= cantidad;
        }else{
            throw new Exception("No puede retirar mas dinero del que tiene!");
        }
        
        
    }

}
