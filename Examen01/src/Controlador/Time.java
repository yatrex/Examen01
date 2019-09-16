/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.Serializable;

public class Time implements Serializable{
    public int minutos;
    public int horas;
    
    public Time(int horas,int minutos){
        this.minutos=minutos;
        this.horas=horas;
        
    }
    public void display_Time(){
        System.out.println(this.horas+" Horas con "+this.minutos);
    }
    public Time get_Time(){
        System.out.println(this.horas+" Horas con "+this.minutos);
        return this;
    }
    public int get_minutos(){
        return this.minutos;
    }
    public int get_horas(){
        return this.horas;
    }
     public boolean igual(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Time time = (Time) o;
            boolean a=this.horas==time.horas;
            boolean b=this.minutos==time.minutos;
           
            if(a&&b )
                return true;
            return false;
        }
    
    
}
