/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.Serializable;

public class Refrigerador implements Serializable {

    private static int auto_increment = 1;
    private int id; //Entero positivo
    private double temFrigo; //Rango valido -5 y 3 grados
    private double temCentro; //RAngo valido 0 y 10 grados
    private double temCharola; //Valorm minimo 5 y maximo de TemCentro

    public Refrigerador() {
        this.id = auto_increment;
        auto_increment++;
    }
     public void set_ID(int id){
        this.id=id;
    }

    public Refrigerador(double temFrigo, double TemCentro, double TemCharola) {
        this.id = auto_increment;
        auto_increment++;
        if (-5 <= temFrigo && temFrigo <= 3) {
            this.temFrigo = temFrigo;
        } else {
            System.out.println("Rango valido -5 a 3 grados");
        }
        if (0 <= TemCentro && TemCentro <= 10) {
            this.temCentro = TemCentro;
        } else {
            System.out.println("Rango valido de 0 a 10 grados");
        }
        if (5 <= TemCharola && TemCharola <= 10) {
            this.temCharola = TemCharola;
        } else {
            System.out.println("Rango valido de 5 a TemCentro");
        }

    }

    public int get_ID() {
        return this.id;
    }

    public void set_TemFrigo(double temFrigo) {
        if (-5 <= temFrigo && temFrigo <= 3) {
            this.temFrigo = temFrigo;
        } else {
            System.out.println("Rango valido -5 a 3 grados");
        }
    }

    public double get_TemFrigo() {
        return this.temFrigo;
    }

    public void set_TemCentro(double temCentro) {
        if (0 <= temCentro && temCentro <= 10) {
            this.temCentro = temCentro;
        } else {
            System.out.println("Rango valido de 0 a 10 grados");
        }
    }

    public double get_TemCentro() {
        return this.temCentro;
    }

    public void set_TemCharola(double temCharola) {
        if (5 <= temCharola && temCharola <= 10) {
            this.temCharola = temCharola;
        } else {
            System.out.println("Rango valido de 5 a TemCentro");
        }
    }

    public double get_TemCharola() {
        return this.temCharola;
    }

    public void display() {
        System.out.println("ID: "+id);
        System.out.println("Frigorifico: "+temFrigo+"°");
        System.out.println("Centro: "+temCentro+"°");
        System.out.println("Charola: "+temCharola+"°");
    }
    
        public boolean igual(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Refrigerador refri = (Refrigerador) o;
            boolean a=this.id==refri.id;
            boolean b=this.temCentro==refri.temCentro;
            boolean c=this.temCharola==refri.temCharola;
            boolean d=this.temFrigo==refri.temFrigo;
            if(a&&b&&c&&d )
                return true;
            return false;
        }

}
