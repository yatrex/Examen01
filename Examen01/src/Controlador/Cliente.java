/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*lineas:
*152
*466

 */
package Controlador;

import java.io.*;
import java.net.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    boolean administrador;
    String host = "localhost";
    int idObjeto;
    int pto = 9000;
    Scanner lapiz = new Scanner(System.in);
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;
    ListaObjetos[] lo;
    ListaUsuarios lu;
    Socket cl;
    int totalUsuarios=0;
    int totalObjetos=0;
    /////////////////////////////datos usuario
    public String usr;
    String pwd;
    int opcion_abc;
    int tipoClase;
    DataInputStream dis;
    DataOutputStream dos;

    public Cliente() {
        try {
            cl = new Socket(host, pto);
            System.out.println("Conexion establecida...");
            oos = new ObjectOutputStream(cl.getOutputStream());
            ois = new ObjectInputStream(cl.getInputStream());
            dis = new DataInputStream(cl.getInputStream());
            dos = new DataOutputStream((cl.getOutputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Object ReadObjectFromFile(String filepath) {

        try {

            FileInputStream fileIn = new FileInputStream(System.getProperty("user.dir") + filepath);
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

    public static void WriteObjectToFile(Object serObj, String filepath) {

        try {

            FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir") + filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void set_usr(String usr) {
        this.usr = usr;
    }

    public void set_tipoClase(int tipoClase) {
        this.tipoClase = tipoClase;
    }

    public void set_pwd(String pwd) {
        this.pwd = pwd;
    }

    public void set_opcion_abc(int opcion_abc) {
        this.opcion_abc = opcion_abc;
    }

    public boolean login(String Usr, String Pass) {
        try {
            Usuario u = new Usuario();
            System.out.println("-Usuario-");
            this.set_usr(Usr);
            System.out.println("-Contraseña-");
            this.set_pwd(Pass);
            u.set_usr(usr);
            u.set_Password(pwd);
            oos.writeObject(u);
            administrador = dis.readBoolean();
            //System.out.println("Administrador: "+administrador);
            lo = (ListaObjetos[]) ois.readObject(); //recivimos los objetos
            System.out.println("-Objetos recividos-");
            totalObjetos = lo.length;
            if(!administrador){
                System.out.println("Bienvenido usuario");
            }
            else{
                lu = (ListaUsuarios) ois.readObject(); //recivimos los usuarios
                totalUsuarios = lu.get_Cantidad();
                System.out.println("-Usuarios recividos-"); 
                System.out.println("Bienvenido administrador");

            }
            
           // if (administrador) {
           //     lu = (ListaUsuarios) ois.readObject(); //recivimos los usuarios
           //     System.out.println("Usuarios recividos");
           // }

        } catch (EOFException e) {
            System.out.println("Datos incorrectos");
            return false;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public void alta() {
        try {
            dos.writeInt(tipoClase);
            if (!this.administrador && tipoClase == 0) {
                System.out.println("Acceso Denegado");
                System.out.println("No tienes permisos para hacer eso");

            } else {
                System.out.println("Acceso Concedido");
                Object objeto = this.escribir_objeto(tipoClase);//   Object objeto = Cliente.escribir_objeto(tipoClase);
                oos.writeObject(objeto);
                
                boolean usuarioAgregado= false;
                usuarioAgregado = dis.readBoolean();
                if(usuarioAgregado){
                System.out.println("Usuario agregado correctamente");
                
                /******************************************************                               ***************************************************************************************************/
                this.lu = (ListaUsuarios) ois.readObject(); //actualizamos lista de usuarios
                System.out.println("Ahora hay: " + this.lu.get_Cantidad()+" usuarios");
                }
                
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void baja() {
        try {
            dos.writeInt(tipoClase);
            if (this.administrador && tipoClase == 0) {
                for (Object o : this.lu.get_ListaUsuarios()) {
                    Usuario usuario = (Usuario) o;
                    if (usuario.get_ID() == idObjeto) {
                        oos.writeObject(usuario);
                        break;
                    }

                }
                //Object objeto = lu.get_ListaUsuarios().get(idObjeto);
                //oos.writeObject((Usuario)objeto);

            } else {
                if (tipoClase == 0) {
                    System.out.println("No tienes permisos para hacer eso");
                    return;
                } else {
                    Object objeto = this.consulta();

                    oos.writeObject(objeto);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

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
                            return refri;
                        }

                    }
                    if (!si_encontrado) {

                        System.out.println("Objeto no encontrado");
                    }

                    break;

                case 2:
                    for (Object o : aux) {
                        Cortinas cortina = (Cortinas) o;
                        if (cortina.get_ID() == idObj) {
                            si_encontrado = true;
                            return cortina;
                        }

                    }
                    if (!si_encontrado) {

                        System.out.println("Objeto no encontrado");
                    }
                    break;
                case 3:
                    for (Object o : aux) {
                        Termostato termostato = (Termostato) o;
                        if (termostato.get_ID() == idObj) {
                            si_encontrado = true;

                            return termostato;
                        }

                    }
                    if (!si_encontrado) {

                        System.out.println("Objeto no encontrado");
                    }
                    break;
                case 4:
                    for (Object o : aux) {
                        DisMascota disMascota = (DisMascota) o;
                        if (disMascota.get_ID() == idObj) {
                            si_encontrado = true;
                            return disMascota;
                        }

                    }
                    if (!si_encontrado) {

                        System.out.println("Objeto no encontrado");
                    }
                    break;
                case 5:
                    for (Object o : aux) {
                        Irrigador irrigador = (Irrigador) o;
                        if (irrigador.get_ID() == idObj) {
                            si_encontrado = true;
                            return irrigador;
                        }

                    }
                    if (!si_encontrado) {

                        System.out.println("Objeto no encontrado");
                    }
                    break;
                case 6:
                    for (Object o : aux) {
                        Alarma alarma = (Alarma) o;
                        if (alarma.get_ID() == idObj) {
                            si_encontrado = true;
                            return alarma;
                        }

                    }
                    if (!si_encontrado) {

                        System.out.println("Objeto no encontrado");
                    }
                    break;
                case 7:
                    for (Object o : aux) {
                        Lampara lampara = (Lampara) o;
                        if (lampara.get_ID() == idObj) {
                            si_encontrado = true;
                            return lampara;
                        }

                    }
                    if (!si_encontrado) {

                        System.out.println("Objeto no encontrado");
                    }
                    break;
                case 8:
                    for (Object o : aux) {
                        Luminaria luminaria = (Luminaria) o;
                        if (luminaria.get_ID() == idObj) {
                            si_encontrado = true;
                            return luminaria;
                        }

                    }
                    if (!si_encontrado) {

                        System.out.println("Objeto no encontrado");
                    }
                    break;
                default:
                    si_encontrado = false;
                    System.out.println("TipoClase no identificado en consulta");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return objeto;

    }

    public Object consulta() {
        try {
            dos.writeInt(this.tipoClase);
            if (!this.administrador && tipoClase == 0) {
                System.out.println("No tienes permisos para hacer eso");

            } else {
                dos.writeInt(this.idObjeto);
                boolean si_encontrado = dis.readBoolean();
                System.out.println(si_encontrado);
                if (si_encontrado) {
                    Object nuevo = ois.readObject();
                    Cliente.get_objeto(tipoClase, nuevo);
                    return nuevo;
                } else {
                    System.out.println("Objeto no encontrado");
                    return null;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void get_objeto(int tipoClase, Object o) {
        Object objeto = null;
        try {
            switch (tipoClase) {
                case 0:
                    Usuario u = (Usuario) o;
                    u.display();
                    break;
                case 1:
                    Refrigerador refri = (Refrigerador) o;
                    refri.display();

                    break;
                case 2:
                    Cortinas cortina = (Cortinas) o;
                    cortina.display();
                    break;
                case 3:
                    Termostato termostato = (Termostato) o;
                    termostato.display();
                    break;
                case 4:
                    DisMascota dismascota = (DisMascota) o;
                    dismascota.display();
                    break;
                case 5:
                    Irrigador irrigador = (Irrigador) o;
                    irrigador.display();
                    break;
                case 6:
                    Alarma alarma = (Alarma) o;
                    alarma.display();
                    break;
                case 7:
                    Lampara lampara = (Lampara) o;
                    lampara.display();
                    break;
                case 8:
                    Luminaria luminaria = (Luminaria) o;
                    luminaria.display();
                    break;
                default:
                    System.out.println("TipoClase no identificado");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void cambio() {
        try {
            dos.writeInt(tipoClase);
            if (this.administrador && tipoClase == 0) {
                for (Object o : this.lu.get_ListaUsuarios()) {
                    Usuario usuario = (Usuario) o;
                    if (usuario.get_ID() == idObjeto) {
                        this.cambiar_objeto(tipoClase, o);
                        //oos.writeObject(usuario);
                        break;
                    }

                }
                //Object objeto = lu.get_ListaUsuarios().get(idObjeto);
                //oos.writeObject((Usuario)objeto);

            } else {
                if (tipoClase == 0) {
                    System.out.println("No tienes permisos para hacer eso");
                    return;
                } else {
                    Object objeto = this.consulta();
                    this.cambiar_objeto(tipoClase, objeto);
                    // oos.writeObject(objeto);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public Object agregarUsuario(Usuario u) throws IOException{
            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escriba el nombre de usuario:");
            
            u.set_usr(br1.readLine());          
            
           
            System.out.println("Escriba el nombre completo:");
            
            u.set_Nombre(br1.readLine());
                
            
            System.out.println("Escriba la contraseña:");
            u.set_Password(br1.readLine());//("predeterminado");//(br1.readLine());
            System.out.println("¿Establecer como administrador?: (S/N)");
            String sino=br1.readLine();
            if(sino.equals("S")||sino.equals("s")){
                u.set_Admin(true);
                System.out.println("Usuario establecido como administrador");
            }
            else{
                u.set_Admin(false);
            }          
            u.set_ID(this.totalUsuarios+1);            
        return u;
    }

  public Object escribir_objeto(int tipoClase) {//  public static Object escribir_objeto(int tipoClase) {
        Object objeto = null;
        try {
            switch (tipoClase) {
                case 0://Usuario
                    System.out.println("Añadir usuario");
                    Usuario u = new Usuario();
                    
                   // u.set_Nombre("Nuevo nombre");
                   // u.set_usr("wholecharlygold");
                   // u.set_Password("Predeterminado");
                   // u.set_Admin(false);
                   // u.set_ID(100);
                   
                      return agregarUsuario(u);
                    //return u;
                case 1:
                    Refrigerador refri = new Refrigerador();
                    refri.set_TemCentro(5);
                    refri.set_TemCharola(5);
                    refri.set_TemFrigo(0);
                    refri.set_ID(100);

                    return refri;

                case 2:
                    Cortinas cortina = new Cortinas();
                    cortina.set_HoraAper(10, 10);
                    cortina.set_HoraCierre(10, 10);
                    cortina.set_PosicionAbierta();//.set_PosicionCerrada,.set_Posicion_Semiabierta,.set_Posicion_Semicerrada
                    cortina.set_Ubicacion("Nueva Ubicacion");
                    cortina.set_ID(100);

                    return cortina;
                case 3:
                    Termostato termostato = new Termostato();
                    termostato.set_Temperatura(30);
                    termostato.set_ID(100);

                    return termostato;
                case 4:
                    DisMascota dismascota = new DisMascota();
                    dismascota.set_CantCena(200);
                    dismascota.set_CantCom(300);
                    dismascota.set_CantDes(400);
                    dismascota.set_HoraCena(10, 10);
                    dismascota.set_HoraCom(20, 20);
                    dismascota.set_HoraDes(30, 30);
                    dismascota.set_ID(100);

                    return dismascota;
                case 5:
                    Irrigador irrigador = new Irrigador();
                    irrigador.set_HoraRiego(10, 10);
                    irrigador.set_TempRiego(10);
                    irrigador.set_ID(100);
                    return irrigador;
                case 6:
                    Alarma alarma = new Alarma(null, null, true);
                    alarma.set_estado(true);
                    alarma.set_horaInicio(10, 10);
                    alarma.set_horaTermino(20, 20);
                    alarma.set_ID(100);
                    return alarma;
                case 7:
                    Lampara lampara = new Lampara(null, true);
                    lampara.set_Ubicacion(null);
                    lampara.set_estado(true);
                    lampara.set_ID(100);
                    return lampara;
                case 8:
                    Luminaria luminaria = new Luminaria(null, 0, true);
                    luminaria.set_Intensidad(20);
                    luminaria.set_Ubicacion("nueva luminaria");
                    luminaria.set_estado(true);
                    luminaria.set_ID(100);
                    return luminaria;
                default:
                    System.out.println("TipoClase no identificado");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return objeto;

    }

    public Object cambiar_objeto(int tipoClase, Object o) {
        Object objeto = null;
        try {
            switch (tipoClase) {
                case 0://Usuario
                    Usuario u = (Usuario) o;
                    u.set_Nombre("Cambio de nombre");
                    u.set_usr(u.get_usr());
                    u.set_Password(u.get_Passsword());
                    u.set_Admin(true);
                    oos.writeObject(u);

                    return u;
                case 1:
                    Refrigerador refri = (Refrigerador) o;
                    refri.set_TemCentro(5);
                    refri.set_TemCharola(5);
                    refri.set_TemFrigo(0);
                   
                    oos.writeObject(refri);
                    return refri;

                case 2:
                    Cortinas cortina = (Cortinas) o;
                    cortina.set_HoraAper(10, 10);
                    cortina.set_HoraCierre(10, 10);
                    cortina.set_PosicionAbierta();//.set_PosicionCerrada,.set_Posicion_Semiabierta,.set_Posicion_Semicerrada
                    cortina.set_Ubicacion("Nueva Ubicacion");
                    
                    oos.writeObject(cortina);
                    return cortina;
                case 3:

                    Termostato termostato = (Termostato) o;
                    termostato.set_Temperatura(30);
                    
                    oos.writeObject(termostato);
                    return termostato;
                case 4:
                    DisMascota dismascota = (DisMascota) o;
                    dismascota.set_CantCena(200);
                    dismascota.set_CantCom(300);
                    dismascota.set_CantDes(400);
                    dismascota.set_HoraCena(10, 10);
                    dismascota.set_HoraCom(20, 20);
                    dismascota.set_HoraDes(30, 30);
                   
                    oos.writeObject(dismascota);
                    return dismascota;
                case 5:
                    Irrigador irrigador = (Irrigador) o;
                    irrigador.set_HoraRiego(10, 10);
                    irrigador.set_TempRiego(10);
                    
                    oos.writeObject(irrigador);
                    return irrigador;
                case 6:
                    Alarma alarma = (Alarma) o;
                    alarma.set_estado(true);
                    alarma.set_horaInicio(10, 10);
                    alarma.set_horaTermino(20, 20);

                    oos.writeObject(alarma);
                    return alarma;
                case 7:
                    Lampara lampara = (Lampara) o;
                    lampara.set_Ubicacion(null);
                    lampara.set_estado(true);

                    oos.writeObject(lampara);
                    return lampara;
                case 8:
                    Luminaria luminaria = (Luminaria) o;
                    luminaria.set_Intensidad(luminaria.get_Intensidad());
                    luminaria.set_Ubicacion("en tu corazon");
                    luminaria.set_estado(true);

                    oos.writeObject(luminaria);
                    return luminaria;
                default:
                    System.out.println("TipoClase no identificado");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return objeto;

    }

    public void set_IDObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }

    public void menu() {
        try {
            Scanner lapiz = new Scanner(System.in);
            dos.writeInt(opcion_abc);

            Object objeto = null;

            switch (opcion_abc) {
                case 1://alta
                    System.out.println("Ingresa tipoClase");
                    this.set_tipoClase(lapiz.nextInt());
                    this.alta();
                   // cliente.login(nameuser,password);
                    break;
                case 2://baja
                    System.out.println("Ingresa tipoClase");
                    this.set_tipoClase(lapiz.nextInt());
                    System.out.println("Ingresa ID del objeto a eliminar");
                    this.set_IDObjeto(lapiz.nextInt());
                    this.baja();
                    break;
                case 3://cambio
                    System.out.println("Ingresa tipoClase");
                    this.set_tipoClase(lapiz.nextInt());
                    System.out.println("Ingresa ID del objeto a eliminar");
                    this.set_IDObjeto(lapiz.nextInt());
                    this.cambio();
                    break;
                case 4://consulta
                    System.out.println("Ingresa tipoClase");
                    this.set_tipoClase(lapiz.nextInt());
                    System.out.println("Ingresa ID del objeto");
                    this.set_IDObjeto(lapiz.nextInt());
                    this.consulta();
                    break;
                case 5://salir
                    System.out.println("Cerrar sesion exitoso");
                    cl.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no listada");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) throws IOException {

        Scanner lapiz = new Scanner(System.in);
        boolean succesful_login = false;
        while(true){//while (!succesful_login) {
            BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escriba el nombre del usuario:");
            String nameuser = br1.readLine();
            System.out.println("\n\nEscriba la contraseña:");
            String password = br1.readLine();
            Cliente cliente = new Cliente();
            succesful_login =cliente.login(nameuser,password);
            System.out.println("resultado:"+succesful_login);
            if (succesful_login) {
                for (;;) {
                    System.out.println("Ingresa opcion");
                    System.out.println("1:Alta\n2:Baja\n3:Cambio\n4:Consulta\n5:Salir");
                    cliente.set_opcion_abc(lapiz.nextInt());//leemos el siguiente entero ingresado y lo enviamos a set_opcion_abc 
                    cliente.menu();
                  //  cliente.login(nameuser,password);
                  //  System.out.println("ahora hay "+cliente.lu.get_Cantidad()+" usuarios"); //*************************************************************************
                 
                }
            }
            else{
                System.out.println("Usuario o contraseña incorrecto, intentelo nuevamente");
            }
        }

    }

}
