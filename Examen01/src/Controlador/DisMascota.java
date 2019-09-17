/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.Serializable;

public class DisMascota implements Serializable {

    private static int auto_increment = 1;
    private int id; //Entero positivo
    private Time horaDes;
    private double cantDes;
    private Time horaCom;
    private double cantCom;
    private Time horaCena;
    private double cantCena;
     public boolean igual(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            DisMascota dm = (DisMascota) o;
            boolean a=this.id==dm.id;
            boolean b=this.horaDes.igual(dm.horaDes);
            boolean c=this.cantDes==dm.cantDes;
            boolean d=this.horaCom.igual(dm.horaCom);
            boolean e=this.cantCom==dm.cantCom;
            boolean f=this.horaCena.igual(dm.horaCena);
            boolean g=this.cantCena==dm.cantCena;
            if(a&&b&&c&&d&&e&&f&&g )
                return true;
            return false;
        }

    public DisMascota() {
        this.id = auto_increment;
        auto_increment++;
    }

    public DisMascota(Time horaDes, double cantDes, Time horaCom, double cantCom, Time horaCena, double cantCena) {
        this.id = auto_increment;
        auto_increment++;
        this.horaDes = horaDes;
        this.cantDes = cantDes;
        this.horaCom = horaCom;
        this.cantCom = cantCom;
        this.horaCena = horaCena;
        this.cantCena = cantCena;
    }
     public void set_ID(int id){
        this.id=id;
    }

    public int get_ID() {
        return this.id;
    }

    public Time get_HoraDes() {
        return this.horaDes.get_Time();
    }

    public void set_HoraDes(int horas, int minutos) {
        this.horaDes= new Time(horas,minutos);
       // this.horaDes.horas = horas;
       // this.horaDes.minutos = minutos;
    }

    public Time get_HoraCom() {
        return this.horaCom.get_Time();
    }

    public void set_HoraCom(int horas, int minutos) {
        this.horaCom = new Time(horas,minutos);
    //    this.horaCom.horas = horas;
    //    this.horaCom.minutos = minutos;
    }

    public Time get_HoraCena() {
        return this.horaCena.get_Time();
    }

    public void set_HoraCena(int horas, int minutos) {
        this.horaCena = new Time(horas,minutos);
    //    this.horaCena.horas = horas;
    //    this.horaCena.minutos = minutos;
    }

    public double get_CantDes() {
        return this.cantDes;
    }

    public void set_CantDes(double cantDes) {
        this.cantDes = cantDes;
    }

    public double get_CantCom() {
        return this.cantCom;
    }

    public void set_CantCom(double cantCom) {
        this.cantCom = cantCom;
    }

    public double get_CantCena() {
        return this.cantCena;
    }

    public void set_CantCena(double cantCena) {
        this.cantDes = cantCena;
    }

    public void display() {
        System.out.println("ID: "+id);
        this.horaDes.display_Time();
        this.horaCom.display_Time();
        this.horaCena.display_Time();
        System.out.println(cantDes);
        System.out.println(cantCom);
        System.out.println(cantCena);
    }

}
