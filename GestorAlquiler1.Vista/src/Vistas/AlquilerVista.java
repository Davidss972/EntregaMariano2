/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Productos.Alquiler;
import Vistas.Interfaces.IAlquilerVista;
import java.io.BufferedReader;
import Presentadores.Interfaces.IAlquilerPresentador;
import Productos.Cliente;
import Provedor.Interfaces.IAlquilerProveedor;
import Provedor.AlquilerProveedor;
import Provedor.CocheProveedor;
import colores.ColorTexto;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
/**
 *
 * @author gokud
 */
public class AlquilerVista implements IAlquilerVista
{
    BufferedReader console;
    IAlquilerPresentador alquilerPresenter;
    IAlquilerProveedor alquilerProveedor;
    AlquilerProveedor mostrar = new AlquilerProveedor();
    
    public AlquilerVista(IAlquilerPresentador diseño)
    {
        alquilerPresenter = diseño;
        console = new BufferedReader(new InputStreamReader(System.in));
    }
    public Alquiler GetAlquilerDetails()throws IOException
    {
        Alquiler newalquiler = new Alquiler();
        String continuamos;
        do
        {
            String dni = GetClDni();
            if(!"".equals(dni))
            {
               Cliente clienteEncontrado = buscarcliente(dni);
               if (clienteEncontrado == null)
               {
                   System.out.println("El cliente no existe");
               }
               else
               {
               
                    mostrarCliente(clienteEncontrado);
                    newalquiler.SetDni(dni);
                    newalquiler.SetMatricula(GetChMatri());
                    newalquiler.SetFecha(GetAlquilerFecha());
                    ColorTexto.println(ColorTexto.ANSI_CYAN,"Introduce el precio");
                    newalquiler.SetPrecio(console.readLine());
                    ColorTexto.println(ColorTexto.ANSI_GREEN,"¿Deseea introducir un nuevo alquiler(S/N)?");
                    continuamos = console.readLine();
               }   
            }
        
            return newalquiler;
        
        }while (continuamos.startsWith("s") || continuamos.startsWith("S"));
    }
    public String GetAlquilerFecha()throws IOException
    {
        Alquiler mostrarfechaactual = new Alquiler();
        ColorTexto.println(ColorTexto.ANSI_CYAN,"Usted alquilara los servicios desde "+mostrarfechaactual.mostrarFecha()+" hasta ");
        return console.readLine();
    }
    public String GetClDni()throws IOException
    {
        ColorTexto.println(ColorTexto.ANSI_CYAN,"Introduzca el dni");
        return console.readLine();
    }
    public String GetChMatri()throws IOException
    {
        ColorTexto.println(ColorTexto.ANSI_CYAN,"Introduzca la matricula correspondiente al coche que desea alquilar: ");
        CocheProveedor mostrarCoche = new CocheProveedor();
        mostrarCoche.mostrarCoches();
        return console.readLine();
    }
    public int GetAlquilerAction()throws IOException
    {
        console.readLine();
        
        int op;
        String menu="";
        Alquiler alquiler;
            menu="";
            menu+="****** Menú ******\n";
            menu+="1.- Añadir Alquiler \n";
            menu+="2.- Borrar Alquiler \n";
            menu+="3.- Modificar Alquiler \n";
            menu+="4.- Buscar Alquiler \n";
            menu+="5.- Mostrar Alquiler \n";
            menu+="6.- Salir \n";
            
            ColorTexto.println(ColorTexto.ANSI_PURPLE,menu);
            op=Integer.parseInt(console.readLine());
        
        switch(op)
        {
            case 1:
                alquiler = GetAlquilerDetails();
                alquilerPresenter.AñadirAlquiler(alquiler);
                if(alquilerPresenter.AñadirAlquiler(alquiler) == false)
                {
                
                }
                break;
            case 2:
                if(alquilerPresenter.BorrarAlquiler(GetAlquilerFecha()) == false)
                {
                    ColorTexto.println(ColorTexto.ANSI_RED,"El alquiler no existe");
                }
                break;
            case 3:
                alquiler = GetAlquilerDetails();
                alquilerPresenter.ModificarAlquiler(alquiler);
                if(alquilerPresenter.ModificarAlquiler(alquiler) == false)
                {
                    System.out.println("El cliente ha sido modificado");
                }
                break;
            case 4:
                break;
            case 5:
                mostrar.mostrarAlquiler();
                break;
                
        }
        return op;
    }
    public void Run()throws IOException
    {
        while(GetAlquilerAction() != 6)
        {
            
        }
    
    }

    private Cliente buscarcliente(String Dni) 
        {
            return alquilerPresenter.buscarCliente(Dni);
        }

    private void mostrarCliente(Cliente cliente) 
        {
            System.out.println(cliente.toString());
        }


   }
