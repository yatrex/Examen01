/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.Serializable;

public class Luminaria implements Serializable{
       private static int auto_increment=1;
    private int id; //Entero positivo
    private String ubicacion;
    private int intensidad;
    private boolean estado;
     public boolean igual(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Luminaria l = (Luminaria) o;
            boolean a=this.id==l.id;
            boolean b=(this.ubicacion == null ? l.ubicacion == null : this.ubicacion.equals(l.ubicacion));
            boolean c=this.intensidad==l.intensidad;
            boolean d=this.estado==l.estado;
            if(a&&b&&c&&d )
                return true;
            return false;
        }
    
    public Luminaria(){
        this.id=auto_increment;
        auto_increment++;
    }
     public void set_ID(int id){
        this.id=id;
    }
    public Luminaria(String ubicacion,int intensidad,boolean estado){
        this.id=auto_increment;
        auto_increment++;
        if(0<=intensidad&&intensidad<=100&&intensidad%10==0){
            this.intensidad=intensidad;
        }else{
            System.out.println("No cumple con las especificaciones de intensidad");
        }
        this.ubicacion=ubicacion;
        this.estado=estado;
    }
    public int get_ID(){
        return this.id;
    }
    public void set_Intensidad(int intensidad){
        if(0<=intensidad&&intensidad<=100&&intensidad%10==0){
            this.intensidad=intensidad;
        }else{
            System.out.println("No cumple con las especificaciones de intensidad");
        }
    }
    public int get_Intensidad(){
        return this.intensidad;
    }
    public String get_Ubicacion(){
        return this.ubicacion;
    }
    public void set_Ubicacion(String ubicacion){
        this.ubicacion=ubicacion;
    }
    
    
     public boolean esta_prendido(){
        return this.estado;
    }
    public void set_estado(boolean estado){
        this.estado=estado;
    }
    
    public void display(){
        System.out.println("ID: "+id);
        System.out.println(ubicacion);
        System.out.println(intensidad);
        System.out.println(estado);
    }
    
}
