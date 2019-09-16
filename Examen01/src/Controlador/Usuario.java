/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class Usuario implements Externalizable{
    private static int auto_increment=1;
    private int id; //entero positivo
    private String usr; //Maximo 20 caracteres y minimo 5
    private String pwd;//password
    private String nombre;
    private boolean tipo;//true=administrador & false=usuario
    
    public Usuario(String usr,String pwd,String nombre,boolean tipo){
        
        this.id=auto_increment;
        auto_increment++;
        if(5<=usr.length()&&usr.length()<=20){
              this.usr=usr;
        }else{
            System.out.println("Usuario debe tener entre 5 y 20 caracteres");
        }
      
        this.pwd=pwd;
        this.nombre=nombre;
        this.tipo=tipo;
                
        
    }
    public Usuario(){
        this.id=auto_increment;
        auto_increment++;
    }
     public void set_ID(int id){
        this.id=id;
    }
    public int get_ID(){
        return this.id;
    }
    public String get_usr(){
        return this.usr;
    }
    public void set_usr(String usr){
       if(5<=usr.length()&&usr.length()<=20){
              this.usr=usr;
        }else{
            System.out.println("Usuario debe tener entre 5 y 20 caracteres");
        }
    }
  
     public String get_Passsword(){
        return this.pwd;
    }
    public void set_Password(String pwd){
        this.pwd=pwd;
    }
    public String get_Nombre(){
        return this.nombre;
    }
    public void set_Nombre(String nombre){
        this.nombre=nombre;
    }
    public void set_Admin(boolean admin){
        this.tipo=admin;
    }
   
    public boolean is_Admin(){
        return tipo;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        
        out.writeObject(id);
        out.writeObject(usr);
        out.writeObject(nombre);
        out.writeObject(tipo);
        
        out.writeObject(pwd);//AQui se debe encriptar la contraseña
    
    
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.id=(int)in.readObject();
        this.usr=(String)in.readObject();
        this.nombre=(String)in.readObject();
        this.tipo=(boolean)in.readObject();
        //Aqui se debe desencriptar la contraseña
        this.pwd=(String)in.readObject();
    }
    
    
    
    public void display(){
        System.out.println(usr);
        System.out.println(nombre);
        System.out.println(pwd);
        System.out.println(tipo);
    }
    
}
