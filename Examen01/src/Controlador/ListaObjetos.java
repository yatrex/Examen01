/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class ListaObjetos implements Serializable{
    private int tipoClase;
    private int cantidad;
    private LinkedList<Object> objetos;
    
    public ListaObjetos(int tipoClase,int cantidad,LinkedList<Object> objetos){
        this.tipoClase=tipoClase;
        this.cantidad=cantidad;
        this.objetos=objetos;
    }
    public int get_tipoClase(){
        return this.tipoClase;
    }
    public int get_Cantidad(){
        return this.cantidad;
    }
    
    public void set_Cantidad(int cantidad){
        this.cantidad=cantidad;
    }
    public LinkedList<Object>get_Objetos(){
        return this.objetos;
    }
    public static ListaObjetos[] llenarListaObjetos(){
       ListaObjetos[] nueva=new ListaObjetos[8];
       int horas,minutos;
       Time horaAper,horaCierre,horaDes,horaCom,horaCena,horaRiego,horaInicio,horaTermino;
        for(int i=1;i<9;i++){
            Random r = new Random();
          
            int cant=r.nextInt((10 - 1) + 1) + 1;
              Object[] array=new Object[cant];
               switch(i){
                   case 1:
                       Refrigerador[] refri=new Refrigerador[cant];
                       int temFrigo = r.nextInt((3 - (-5)+1))-5;
                       int temCentro = r.nextInt((10 - 0)+1);
                       int temCharola = r.nextInt((10-5)+1)+5;
                       for(int j=0;j<cant;j++){
                           refri[j]=new Refrigerador(temFrigo, temCentro,temCharola );
                       }
                       array=refri;
                       break;
                   case 2:
                       Cortinas[] cortina=new Cortinas[cant];
                       int posicion = r.nextInt((4 - (1)+1))+1;
                        horas = r.nextInt((24 - 0)+1);
                        minutos = r.nextInt((60-0)+1);
                        horaAper=new Time(horas, minutos);
                        horaCierre=new Time(horas,minutos);
                       for(int j=0;j<cant;j++){
                          cortina[j]=new Cortinas("aaaa", posicion, horaAper, horaCierre);
                       }
                       array=cortina;
                       break;
                   case 3:
                       Termostato[] termostato=new Termostato[cant];
                       temCentro = r.nextInt((30 - 18)+1)+18;
                       for(int j=0;j<cant;j++){
                          termostato[j]=new Termostato(temCentro);
                       }
                       array=termostato;
                       break;
                   case 4:
                       DisMascota[]dismascota=new DisMascota[cant];
                       horas = r.nextInt((24 - 0)+1);
                       minutos = r.nextInt((60-0)+1);
                       horaDes=new Time(horas, minutos);
                       horaCom=new Time(horas,minutos);
                       horaCena=new Time(horas,minutos);
                       
                       for(int j=0;j<cant;j++){
                           int gramos=r.nextInt((3500-100)+1)+100;
                          dismascota[j]=new DisMascota(horaDes, gramos, horaCom, gramos, horaCena, gramos);
                       }
                       array=dismascota;
                       break;
                   case 5:
                       Irrigador[]irrigador=new Irrigador[cant];
                        horas = r.nextInt((24 - 0)+1);
                       minutos = r.nextInt((60-0)+1);
                       horaRiego=new Time(horas,minutos);
                       temFrigo=r.nextInt((90-0)+1);
                        for(int j=0;j<cant;j++){
                         irrigador[j]=new Irrigador(horaRiego, temFrigo);
                       }
                        array=irrigador;
                       break;
                   case 6:
                       Alarma[]alarma=new Alarma[cant];
                       horas = r.nextInt((24 - 0)+1);
                       minutos = r.nextInt((60-0)+1);
                       horaInicio=new Time(horas, minutos);
                       horaTermino=new Time(horas,minutos);
                       for(int j=0;j<cant;j++){
                           alarma[j]=new Alarma(horaInicio, horaTermino, true);
                       }
                       array=alarma;
                       break;
                   case 7:
                       Lampara[]lampara=new Lampara[cant];
                       for(int j=0;j<cant;j++){
                          lampara[j]=new Lampara("lamparaaa", true);
                       }
                       array=lampara;
                       break;
                   case 8:
                       Luminaria[]luminaria=new Luminaria[cant];
                       for(int j=0;j<cant;j++){
                          luminaria[j]=new Luminaria("Luminariaaa", 50, true);
                       }
                       array=luminaria;
                       break;
                       default:
                           System.out.println("Algo salio mal");
                           
                       
                       
               }           
             nueva[i-1]=new ListaObjetos(i, cant , new LinkedList<>(Arrays.asList(array)));
        }
        return nueva;
    }
    
    
}   
