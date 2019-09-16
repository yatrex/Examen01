/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.net.*;
import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

public class Servidor {

    boolean administrador;
    ListaUsuarios lu;
    LinkedList<Usuario> usuarios;
    ListaObjetos[] lo;
    Usuario u;
    ObjectOutputStream oos;
    ObjectInputStream ois;
    DataInputStream dis;
    DataOutputStream dos;
    ServerSocket s;
    Socket cl;
    int idObjeto;
    int tipoClase;

    public Servidor() {
        try {
         //   this.lu = (ListaUsuarios) Servidor.ReadObjectFromFile("//ExamenListaUsuarios"); ***********************************************************************
         //   this.lo = (ListaObjetos[]) Servidor.ReadObjectFromFile("//ExamenListaObjetos");
            this.lu = (ListaUsuarios) Servidor.ReadObjectFromFile("ListaUsuarios");
            this.lo = (ListaObjetos[]) Servidor.ReadObjectFromFile("ListaObjetos");
            this.usuarios = lu.get_ListaUsuarios();
            for(int i=0;i<usuarios.size();i++){
                usuarios.get(i).display();
            }
           //  LinkedList<ListaObjetos> objetos;
            for(int j=0;j<lo.length;j++){
                for(int k=0;k<lo[j].get_Cantidad();k++){
                    lo[j].get_Objetos().get(k);
                }
                
                
            }
            
            
            this.s = new ServerSocket(9000);
            System.out.println("Servidor iniciado, esperando cliente");
            cl = s.accept();//Esperando cliente a conectarse 
            System.out.println("Cliente conectado desde " + cl.getInetAddress() + ":" + cl.getPort());//Cliente conectado
            oos = new ObjectOutputStream(cl.getOutputStream());
            ois = new ObjectInputStream(cl.getInputStream());
            dis = new DataInputStream((cl.getInputStream()));
            dos = new DataOutputStream((cl.getOutputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /////*****///
    public void baja(Object objeto){
       boolean encontrado=false;
        switch(tipoClase){
            case 1:
                for(Iterator i=lo[tipoClase-1].get_Objetos().iterator();i.hasNext();){
                    Refrigerador refri=(Refrigerador) i.next();
                    if(refri.igual(objeto)){
                        encontrado=true;
                        i.remove();
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("Objeto no encontrado");
                }
                break;
                 case 2:
                for(Iterator i=lo[tipoClase-1].get_Objetos().iterator();i.hasNext();){
                    Cortinas cortina=(Cortinas) i.next();
                    if(cortina.igual(objeto)){
                        encontrado=true;
                        i.remove();
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("Objeto no encontrado");
                }
                break;
                 case 3:
                for(Iterator i=lo[tipoClase-1].get_Objetos().iterator();i.hasNext();){
                    Termostato termostato=(Termostato) i.next();
                    if(termostato.igual(objeto)){
                        encontrado=true;
                        i.remove();
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("Objeto no encontrado");
                }
                break;
                 case 4:
                for(Iterator i=lo[tipoClase-1].get_Objetos().iterator();i.hasNext();){
                    DisMascota dm=(DisMascota) i.next();
                    if(dm.igual(objeto)){
                        encontrado=true;
                        i.remove();
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("Objeto no encontrado");
                }
                break;
                 case 5:
                for(Iterator i=lo[tipoClase-1].get_Objetos().iterator();i.hasNext();){
                    Irrigador irrigador=(Irrigador) i.next();
                    if(irrigador.igual(objeto)){
                        encontrado=true;
                        i.remove();
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("Objeto no encontrado");
                }
                break;
                 case 6:
                for(Iterator i=lo[tipoClase-1].get_Objetos().iterator();i.hasNext();){
                    Alarma alarma=(Alarma) i.next();
                    if(alarma.igual(objeto)){
                        encontrado=true;
                        i.remove();
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("Objeto no encontrado");
                }
                break;
                 case 7:
                for(Iterator i=lo[tipoClase-1].get_Objetos().iterator();i.hasNext();){
                    Lampara lampara=(Lampara) i.next();
                    if(lampara.igual(objeto)){
                        encontrado=true;
                        i.remove();
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("Objeto no encontrado");
                }
                break;
                  case 8:
                for(Iterator i=lo[tipoClase-1].get_Objetos().iterator();i.hasNext();){
                    Luminaria luminaria=(Luminaria) i.next();
                    if(luminaria.igual(objeto)){
                        encontrado=true;
                        i.remove();
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("Objeto no encontrado");
                }
                break;
                     
            default:
                System.out.println("TipoClase no encontrada");
        }
        
    }
    
       public void cambio(Object objeto) throws IOException, ClassNotFoundException{
       boolean encontrado=false;
        switch(tipoClase){
            case 1:
                for(Object o:lo[tipoClase-1].get_Objetos()){
                    Refrigerador refri=(Refrigerador) o;
                    if(refri.igual(objeto)){
                        encontrado=true;
                        o=ois.readObject();
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("Objeto no encontrado");
                }
                break;
                 case 2:
                for(Iterator i=lo[tipoClase-1].get_Objetos().iterator();i.hasNext();){
                    Cortinas cortina=(Cortinas) i.next();
                    if(cortina.igual(objeto)){
                        encontrado=true;
                        i.remove();
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("Objeto no encontrado");
                }
                break;
                 case 3:
                for(Iterator i=lo[tipoClase-1].get_Objetos().iterator();i.hasNext();){
                    Termostato termostato=(Termostato) i.next();
                    if(termostato.igual(objeto)){
                        encontrado=true;
                        i.remove();
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("Objeto no encontrado");
                }
                break;
                 case 4:
                for(Iterator i=lo[tipoClase-1].get_Objetos().iterator();i.hasNext();){
                    DisMascota dm=(DisMascota) i.next();
                    if(dm.igual(objeto)){
                        encontrado=true;
                        i.remove();
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("Objeto no encontrado");
                }
                break;
                 case 5:
                for(Iterator i=lo[tipoClase-1].get_Objetos().iterator();i.hasNext();){
                    Irrigador irrigador=(Irrigador) i.next();
                    if(irrigador.igual(objeto)){
                        encontrado=true;
                        i.remove();
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("Objeto no encontrado");
                }
                break;
                 case 6:
                for(Iterator i=lo[tipoClase-1].get_Objetos().iterator();i.hasNext();){
                    Alarma alarma=(Alarma) i.next();
                    if(alarma.igual(objeto)){
                        encontrado=true;
                        i.remove();
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("Objeto no encontrado");
                }
                break;
                 case 7:
                for(Iterator i=lo[tipoClase-1].get_Objetos().iterator();i.hasNext();){
                    Lampara lampara=(Lampara) i.next();
                    if(lampara.igual(objeto)){
                        encontrado=true;
                        i.remove();
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("Objeto no encontrado");
                }
                break;
                  case 8:
                for(Iterator i=lo[tipoClase-1].get_Objetos().iterator();i.hasNext();){
                    Luminaria luminaria=(Luminaria) i.next();
                    if(luminaria.igual(objeto)){
                        encontrado=true;
                        i.remove();
                        break;
                    }
                }
                if(!encontrado){
                    System.out.println("Objeto no encontrado");
                }
                break;
                     
            default:
                System.out.println("TipoClase no encontrada");
        }
        
    }

    public static void WriteObjectToFile(Object serObj, String filepath) {

        try {
            System.out.println("JaJe -> user.dir: "+System.getProperty("user.dir") +" filepath: "+ filepath);
           // FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir") + filepath);
           FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean usuario_registrado(Usuario usuario_ingresado, LinkedList<Usuario> lista_usuarios) {

        for (Usuario u : lista_usuarios) {
            if (usuario_ingresado.get_usr() == null ? u.get_usr() == null : usuario_ingresado.get_usr().equals(u.get_usr())) {
                if (usuario_ingresado.get_Passsword() == null ? u.get_Passsword() == null : usuario_ingresado.get_Passsword().equals(u.get_Passsword())) {
                    this.u = u;
                    return true;
                }
            }
        }
        return false;

    }

    public static Object ReadObjectFromFile(String filepath) {

        try {

           // FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir") + filepath);
             FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static Object get_objeto(int tipoClase, ObjectInputStream ois) {

        try {
            switch (tipoClase) {
                case 0:
                    Usuario u = (Usuario) ois.readObject();
                    return u;
                case 1:
                    Refrigerador refri = (Refrigerador) ois.readObject();
                    return refri;

                case 2:
                    Cortinas cortina = (Cortinas) ois.readObject();
                    return cortina;
                case 3:
                    Termostato termostato = (Termostato) ois.readObject();
                    return termostato;
                case 4:
                    DisMascota dismascota = (DisMascota) ois.readObject();
                    return dismascota;
                case 5:
                    Irrigador irrigador = (Irrigador) ois.readObject();
                    return irrigador;
                case 6:
                    Alarma alarma = (Alarma) ois.readObject();
                    return alarma;
                case 7:
                    Lampara lampara = (Lampara) ois.readObject();
                    return lampara;
                case 8:
                    Luminaria luminaria = (Luminaria) ois.readObject();
                    return luminaria;
                default:
                    System.out.println("TipoClase no identificado");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public Object get_consulta(LinkedList<Object> aux, int idObj) {
        Object objeto = null;
        boolean si_encontrado = false;
        try {
            switch (this.tipoClase) {

                case 1:
                    for (Object o : aux) {
                        Refrigerador refri = (Refrigerador) o;
                        if (refri.get_ID() == idObj) {
                            si_encontrado = true;
                            dos.writeBoolean(si_encontrado);
                            oos.writeObject(refri);

                            break;
                        }

                    }
                    if (!si_encontrado) {
                        dos.writeBoolean(false);
                        System.out.println("Objeto no encontrado");
                    }

                    break;

                case 2:
                    for (Object o : aux) {
                        Cortinas cortina = (Cortinas) o;
                        if (cortina.get_ID() == idObj) {
                            si_encontrado = true;
                            dos.writeBoolean(si_encontrado);
                            oos.writeObject(cortina);

                            break;
                        }

                    }
                    if (!si_encontrado) {
                        dos.writeBoolean(false);
                        System.out.println("Objeto no encontrado");
                    }
                    break;
                case 3:
                    for (Object o : aux) {
                        Termostato termostato = (Termostato) o;
                        if (termostato.get_ID() == idObj) {
                            si_encontrado = true;
                            dos.writeBoolean(si_encontrado);
                            oos.writeObject(termostato);

                            break;
                        }

                    }
                    if (!si_encontrado) {
                        dos.writeBoolean(false);
                        System.out.println("Objeto no encontrado");
                    }
                    break;
                case 4:
                    for (Object o : aux) {
                        DisMascota disMascota = (DisMascota) o;
                        if (disMascota.get_ID() == idObj) {
                            si_encontrado = true;
                            dos.writeBoolean(si_encontrado);
                            oos.writeObject(disMascota);

                            break;
                        }

                    }
                    if (!si_encontrado) {
                        dos.writeBoolean(false);
                        System.out.println("Objeto no encontrado");
                    }
                    break;
                case 5:
                    for (Object o : aux) {
                        Irrigador irrigador = (Irrigador) o;
                        if (irrigador.get_ID() == idObj) {
                            oos.writeObject(irrigador);
                            si_encontrado = true;
                            break;
                        }

                    }
                    if (!si_encontrado) {
                        dos.writeBoolean(false);
                        System.out.println("Objeto no encontrado");
                    }
                    break;
                case 6:
                    for (Object o : aux) {
                        Alarma alarma = (Alarma) o;
                        if (alarma.get_ID() == idObj) {
                            si_encontrado = true;
                            dos.writeBoolean(si_encontrado);
                            oos.writeObject(alarma);

                            break;
                        }

                    }
                    if (!si_encontrado) {
                        dos.writeBoolean(false);
                        System.out.println("Objeto no encontrado");
                    }
                    break;
                case 7:
                    for (Object o : aux) {
                        Lampara lampara = (Lampara) o;
                        if (lampara.get_ID() == idObj) {
                            si_encontrado = true;
                            dos.writeBoolean(si_encontrado);
                            oos.writeObject(lampara);

                            break;
                        }

                    }
                    if (!si_encontrado) {
                        dos.writeBoolean(false);
                        System.out.println("Objeto no encontrado");
                    }
                    break;
                case 8:
                    for (Object o : aux) {
                        Luminaria luminaria = (Luminaria) o;
                        if (luminaria.get_ID() == idObj) {
                            si_encontrado = true;
                            dos.writeBoolean(si_encontrado);
                            oos.writeObject(luminaria);

                            break;
                        }

                    }
                    if (!si_encontrado) {
                        dos.writeBoolean(false);
                        System.out.println("Objeto no encontrado");
                    }
                    break;
                default:
                    si_encontrado = false;
                    dos.writeBoolean(si_encontrado);
                    System.out.println("TipoClase no identificado en consulta");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return objeto;

    }

    public void menu() {
        try {
            int opcion = 0;
            while (opcion != 5) {
                System.out.println("Esperando opcion a realizar");
                int opcion2 = this.dis.readInt();
                System.out.println("Opcion recibida");
                System.out.println(opcion2);

                Object objeto;
                opcion = opcion2;

                switch (opcion) {
                    case 1://alta
                        System.out.println("*Alta*");
                        tipoClase = dis.readInt();
                        System.out.println(tipoClase);

                        if (this.administrador && tipoClase == 0) {
                            objeto = Servidor.get_objeto(tipoClase, ois);
                            this.lu.get_ListaUsuarios().add((Usuario) objeto);
                            dos.writeBoolean(true); //bandera de usuario agregado
                            dos.flush();
                            System.out.println("Usuario Agregado");
                            /************************************************************************************************************************/
                            this.oos.writeObject(this.lu);
                            this.oos.flush();
                            System.out.println("numero de usuarios: "+this.lu.get_Cantidad());
                            break;
                        } else {
                            if (tipoClase == 0) {
                                System.out.println("No tienes permisos para hacer eso");
                                break;
                            }
                        }
                       
                        objeto = Servidor.get_objeto(tipoClase, ois);

                        lo[tipoClase - 1].get_Objetos().add(objeto);
                        System.out.println(objeto);

                        break;
                    case 2://baja
                        System.out.println("*Baja*");
                        tipoClase = dis.readInt();
                        System.out.println(tipoClase);
                        
                        if (this.administrador && tipoClase == 0) {
                            objeto = Servidor.get_objeto(tipoClase, ois);
                            Usuario user = (Usuario) objeto;
                            for (Object o : this.lu.get_ListaUsuarios()) {
                                Usuario usuario = (Usuario) o;
                                if (usuario.get_ID() == user.get_ID()) {
                                    this.lu.get_ListaUsuarios().remove(usuario);
                                    break;
                                }

                            }
                        } else {
                            if (tipoClase == 0) {
                                System.out.println("No tienes permisos para hacer eso");
                                break;
                            } else {
                                 this.consulta();
                                 objeto = Servidor.get_objeto(tipoClase, ois);
                                
                                if (objeto == null) {
                                    System.out.println("Objeto no encontrado");
                                } else {
                                    this.baja(objeto);
                                }
                            }
                        }

                        break;
                    case 3://cambio
                        System.out.println("*Cambio*");
                        tipoClase = dis.readInt();
                        System.out.println(tipoClase);
                        
                        if (this.administrador && tipoClase == 0) {
                            objeto = Servidor.get_objeto(tipoClase, ois);
                            Usuario user = (Usuario) objeto;
                            int contador=0;
                            for (Object o : this.lu.get_ListaUsuarios()) {
                                Usuario usuario = (Usuario) o;
                                if (usuario.get_ID() == user.get_ID()) {
                                    this.lu.get_ListaUsuarios().set(contador,usuario);
                                    break;
                                }
                                contador++;
                            }
                        } else {
                            if (tipoClase == 0) {
                                System.out.println("No tienes permisos para hacer eso");
                                break;
                            } else {
                                 this.consulta();
                                 objeto = Servidor.get_objeto(tipoClase, ois);
                                
                                if (objeto == null) {
                                    System.out.println("Objeto no encontrado");
                                } else {
                                    
                                    this.cambio(objeto);
                                }
                            }
                        }
                        break;
                    case 4://consulta
                       System.out.println("*Consulta*");
                       this.consulta();
                        break;
                    case 5://salir
                        Servidor.WriteObjectToFile(lu, "ListaUsuarios");
                        Servidor.WriteObjectToFile(lo, "ListaObjetos");
                        this.cerrar();
                        break;
                    default:
                        System.out.println("Opcion no listada");

                }
            }
            System.out.println("*Salir*");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void consulta() throws IOException{
         LinkedList<Object> array;
                        tipoClase = dis.readInt();
                        System.out.println(tipoClase);
                        idObjeto = dis.readInt();
                        System.out.println(idObjeto);
                        boolean si_encontrado = false;
                        //this.idObjeto++;
                        if (tipoClase == 0) {
                            if (this.administrador) {
                                for (Object o : this.lu.get_ListaUsuarios()) {
                                    Usuario usuario = (Usuario) o;
                                    if (usuario.get_ID() == idObjeto) {
                                        si_encontrado = true;
                                        dos.writeBoolean(true);
                                        oos.writeObject(usuario);
                                        break;

                                    }

                                }

                            } else {
                                System.out.println("No tienes permisos para buscar usuarios");
                            }

                        } else {
                            array = lo[tipoClase - 1].get_Objetos();

                            this.get_consulta(array, idObjeto);
                            return;
                        }
                        if (!si_encontrado) {
                            dos.writeBoolean(false);
                            System.out.println("usuario no encontrado");
                            return;
                        }
    }

    public static void inicializar_Archivos() {
        Servidor.WriteObjectToFile(new ListaUsuarios(), "ListaUsuarios");
        Servidor.WriteObjectToFile(ListaObjetos.llenarListaObjetos(), "ListaObjetos");
    }

    public void cerrar() throws IOException {
        this.oos.close();
        this.ois.close();
        this.dis.close();
        this.dos.close();
        this.cl.close();
        this.s.close();
    }

    public static void main(String[] args) {
        try {

            for (;;) {

                Servidor servidor = new Servidor();
                servidor.u = (Usuario) servidor.ois.readObject();//Recibiendo informamcion de Login
                if (!servidor.usuario_registrado(servidor.u, servidor.lu.get_ListaUsuarios())) {
                    System.out.println("Usuario o contraseña incorrectos");
                    servidor.cerrar();
                } else {
                    System.out.println("Bienvenido");
                    servidor.administrador = servidor.u.is_Admin();
                    servidor.dos.writeBoolean(servidor.administrador);
                    servidor.oos.writeObject(servidor.lo);
                    if (servidor.administrador) {
                        servidor.oos.writeObject(servidor.lu);
                    }

                    servidor.menu();

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
