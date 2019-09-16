/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.Serializable;
import java.util.LinkedList;

public class ListaUsuarios implements Serializable{

    private int tipoClase;
    private int cantidad;
    private LinkedList<Usuario> usuarios;
    public ListaUsuarios(){
        this.tipoClase=0;
        usuarios=new LinkedList<Usuario>();
        usuarios.add(new Usuario("Adan", "12345", "Adan Rodriguez", true));
        usuarios.add(new Usuario("Ivan", "12345", "Ivan Gallaga", true));
        usuarios.add(new Usuario("Hector", "12345", "Hector Guzman", true));
        this.cantidad=this.usuarios.size();
    }
    public int get_TipoClase(){return this.tipoClase;}

    public int get_Cantidad(){return this.cantidad;}

    public LinkedList<Usuario> get_ListaUsuarios(){return this.usuarios;}

}