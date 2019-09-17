/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.Serializable;

public class Cortinas implements Serializable{
    public final static int ABIERTA=1;
    public final static int SEMICERRADA=2;
    public final static int SEMIABIERTA=3;
    public final static int CERRADA=4;
    private static int auto_increment=1;
    private int id; //Entero positivo
    private String ubicacion;//Cadena que indica el lugar de la cortina
    private int posicion;//Permite abierta,semicerrada,semiabierta,cerrada.
    private Time horaAper;
    private Time horaCierre; 

    //private int horaA;
    //private int minA;
    //private int horaC;
    //private int minC;
    public boolean igual(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Cortinas c = (Cortinas) o;
            boolean a=this.id==c.id;
            boolean b=(this.ubicacion == null ? c.ubicacion == null : this.ubicacion.equals(c.ubicacion));
            boolean d=this.posicion==c.posicion;
            boolean e=this.horaAper.igual(c.horaAper);
            boolean f=this.horaCierre.igual(c.horaCierre);
            if(a&&b&&d&&e&&f )
                return true;
            return false;
        }
    public Cortinas(){
        this.id=auto_increment;
        auto_increment++;
    }
    public Cortinas(String ubicacion,int posicion,Time horaAper,Time horaCierre){
        this.id=auto_increment;
        auto_increment++;
        this.posicion=posicion;
        this.horaAper=horaAper;
        this.horaCierre=horaCierre;
        
    }
     public void set_ID(int id){
        this.id=id;
    }
    
    public int get_ID(){
        return this.id;
    }
    
    public String get_Ubicacion(){
        return this.ubicacion;
    }
    public void set_Ubicacion(String ubicacion){
        this.ubicacion=ubicacion;
        
    }
    public void get_Posicion(){
        switch(this.posicion){
            case ABIERTA:
                System.out.println("Cortina abierta");
                break;
            case SEMIABIERTA:
                System.out.println("Cortina semiabierta");
                break;
            case SEMICERRADA:
                System.out.println("Cortina semicerrada");
                break;
            case CERRADA:
                System.out.println("Cortina cerrada");
                break;
            default:
                System.out.println("Posicion no encontrada");
                break;
        }
    }
    public void set_PosicionAbierta(){
        this.posicion=ABIERTA;
    }
    public void set_PosicionSemicerrada(){
        this.posicion=SEMICERRADA;
    }
    public void set_PosicionSemiabierta(){
        this.posicion=SEMIABIERTA;
    }
    public void set_PosicionCerrada(){
        this.posicion=CERRADA;
    }
    
    public Time get_HoraAper(){
      return  this.horaAper.get_Time();
    }
     public void set_HoraAper(int horas,int minutos){
         System.out.println("Hora enviada:"+horas+":"+minutos);
         //this.horaA=horas;
         //this.minA=minutos;
       //  this.horaAper=horas;
     //   this.minAper=minutos;
        this.horaAper = new Time(horas,minutos);
     
      //  this.horaAper.horas =horas;
      //  this.horaAper.minutos=minutos;
    }
      public Time get_HoraCierre(){
        return this.horaCierre.get_Time();
    }
     public void set_HoraCierre(int horas,int minutos){
       // this.horaCierre.horas=horas;
       // this.horaCierre.minutos=minutos;
        
        
        
        this.horaCierre = new Time(horas, minutos);
       // this.horaC=horas;
        //this.minC=minutos;
    }
     
     public void display(){
         System.out.println("ID: "+id);
         System.out.println("Ubicación: "+ubicacion);
         System.out.println("Posición: "+posicion);
         this.horaAper.display_Time();
         this.horaCierre.display_Time();
     }
     
    
    
}
