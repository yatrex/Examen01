/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.Serializable;

public class Termostato implements Serializable {

    private static int auto_increment = 1;
    private int id; //Entero positivo
    private double temperatura;//Rango valido 18 y 30 grados
    
     public boolean igual(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Termostato t = (Termostato) o;
            boolean a=this.id==t.id;
            boolean b=this.temperatura==t.temperatura;
          
            if(a&&b )
                return true;
            return false;
        }

    public Termostato(double temperatura) {
        this.id = auto_increment;
        auto_increment++;
        if (18 <= temperatura && temperatura <= 30) {
            this.temperatura = temperatura;
        } else {
            System.out.println("Rango valido 18 a 30 grados");
        }

    }

    public Termostato() {
        this.id = auto_increment;
        auto_increment++;
    }
     public void set_ID(int id){
        this.id=id;
    }

    public int get_ID() {
        return this.id;
    }

    public double get_Temperatura() {
        return this.temperatura;
    }

    public void set_Temperatura(double temperatura) {
        if (18 <= temperatura && temperatura <= 30) {
            this.temperatura = temperatura;
        } else {
            System.out.println("Rango valido 18 a 30 grados");
        }
    }

    public void display() {
        System.out.println("ID: "+id);
        System.out.println(temperatura);
    }

}
