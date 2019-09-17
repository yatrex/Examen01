/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.Serializable;

public class Irrigador implements Serializable {

    private static int auto_increment = 1;
    private int id; //Entero positivo
    private Time horaRiego;
    private int tempRiego;

     public boolean igual(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Irrigador i = (Irrigador) o;
            boolean a=this.id==i.id;
            boolean b=this.horaRiego.igual(i.horaRiego);
            boolean c=this.tempRiego==i.tempRiego;
           
            if(a&&b&&c )
                return true;
            return false;
        }
    public Irrigador() {
        this.id = auto_increment;
    }

    public Irrigador(Time horaRiego, int tempRiego) {
        this.id = auto_increment;
        auto_increment++;
        this.horaRiego = horaRiego;
        this.tempRiego = tempRiego;
    }

    public int get_ID() {
        return this.id;
    }
     public void set_ID(int id){
        this.id=id;
    }

    public Time get_HoraRiego() {
        return this.horaRiego.get_Time();
    }

    public void set_HoraRiego(int horas, int minutos) {
        this.horaRiego = new Time(horas, minutos);
       // this.horaRiego.horas = horas;
       // this.horaRiego.minutos = minutos;
    }

    public int get_TempRiego() {
        return this.tempRiego;
    }

    public void set_TempRiego(int tempRiego) {
        this.tempRiego = tempRiego;
    }

    public void display() {
        System.out.println("ID: "+id);
        this.horaRiego.display_Time();
        System.out.println(tempRiego);
    }

}
