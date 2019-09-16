/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.Serializable;

public class Lampara implements Serializable {

    private static int auto_increment = 1;
    private int id; //Entero positivo
    private String ubicacion;
    private boolean estado;
    
     public boolean igual(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Lampara l = (Lampara) o;
            boolean a=this.id==l.id;
            boolean b=(this.ubicacion == null ? l.ubicacion == null : this.ubicacion.equals(l.ubicacion));
            boolean c=this.estado==l.estado;
         
            if(a&&b&&c )
                return true;
            return false;
        }

    public Lampara() {
        this.id = auto_increment;
        auto_increment++;
    }

    public Lampara(String ubicacion, boolean estado) {
        this.id = auto_increment;
        auto_increment++;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    public int get_ID() {
        return this.id;
    }
     public void set_ID(int id){
        this.id=id;
    }

    public String get_Ubicacion() {
        return this.ubicacion;
    }

    public void set_Ubicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean esta_prendido() {
        return this.estado;
    }

    public void set_estado(boolean estado) {
        this.estado = estado;
    }

    public void display() {
        System.out.println(ubicacion);
        System.out.println(estado);
    }

}
