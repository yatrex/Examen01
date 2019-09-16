/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.Serializable;

public class Alarma implements Serializable {
    private static int auto_increment=1;
    private int id; //Entero positivo
    private Time horaInicio;
    private Time horaTermino;
    private boolean estado;//true=encendido false=apagado
    
    public Alarma(){
        this.id=auto_increment;
        auto_increment++;
    }
    public Alarma(Time horaInicio,Time horaTermino,boolean estado){
        this.id=auto_increment;
        auto_increment++;
        this.horaInicio=horaInicio;
        this.horaTermino=horaTermino;
        this.estado=estado;
    }
    public int get_ID(){
        return this.id;
    }
    public void set_ID(int id){
        this.id=id;
    }
     public boolean igual(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Alarma alarma = (Alarma) o;
            boolean a=this.id==alarma.id;
            boolean b1=this.horaInicio.get_horas()==alarma.horaInicio.get_horas();
            boolean b2=this.horaTermino.get_horas()==alarma.horaInicio.get_horas();
            boolean c1=this.horaInicio.get_minutos()==alarma.horaInicio.get_minutos();
            boolean c2=this.horaTermino.get_minutos()==alarma.horaTermino.get_minutos();
            boolean d=this.estado==alarma.estado;
            if(a&&b1&&b2&&c1&&c2&&d )
                return true;
            return false;
        }
    
    public Time get_horaInicio(){
        return this.horaInicio.get_Time();
    }
    public void set_horaInicio(int horas,int minutos){
        this.horaInicio.horas=horas;
        this.horaInicio.minutos=minutos;
    }
    public Time get_horaTermino(){
        return this.horaTermino.get_Time();
    }
    public void set_horaTermino(int horas,int minutos){
        this.horaTermino.horas=horas;
        this.horaTermino.minutos=minutos;
    }
    public boolean esta_prendido(){
        return this.estado;
    }
    public void set_estado(boolean estado){
        this.estado=estado;
    }
    public void display(){
        this.horaInicio.display_Time();
        this.horaTermino.display_Time();
        
        System.out.println(this.estado);
    }
    
}
