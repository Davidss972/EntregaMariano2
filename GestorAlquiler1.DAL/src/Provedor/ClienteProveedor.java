/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Provedor;

import Productos.Cliente;
import Provedor.Interfaces.IClienteProveedor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteProveedor implements IClienteProveedor
{
    String nombreArchivo ="libretaContactos.csv";
    ArrayList<Cliente> listaclientes = new ArrayList<>();
    public ClienteProveedor()
    {
        listaclientes = CargarClientesDesdeArchivo();
    }
    
    public ArrayList<Cliente> CargarClientesDesdeArchivo()
    {
        ArrayList<Cliente> listaclientes1 = new ArrayList<>();
        try
        {
            Scanner sc = new Scanner(new File(this.nombreArchivo)).useDelimiter(";");
            while(sc.hasNext())
            {
                Cliente cliente = new Cliente();
                cliente.SetDni(sc.next());
                cliente.SetNombre(sc.next());
                cliente.SetApellidos(sc.next());
                listaclientes1.add(cliente);
            }
        }
        catch(FileNotFoundException ex)
        {
            Logger.getLogger(ClienteProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaclientes1;
    }
    private void volcarClientes() //antes de volcar manera de borrar todo lo que haya dentro/*porque lo que cargamos es la lista.*/
    {
        try {
                FileWriter fw = new FileWriter(new File(this.nombreArchivo));
                for (Cliente cliente : listaclientes) 
                {
                    fw.write(cliente.toString() + ";");
                }
                fw.close();
            } 
        catch (IOException ex) 
            {
                Logger.getLogger(ClienteProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void mostrarClientes()
    {
        for (Cliente cliente : listaclientes)
        {
            System.out.println(cliente);
        }
    }

    public Cliente ConseguirCliente(String dni)
    {
        String clientdni = "";
            
        for (Cliente cliente : listaclientes) 
        {
            clientdni = cliente.GetDni();
            if(clientdni != null)
            {
                if(clientdni == null ? dni == null : clientdni.equals(dni))
                {
                    return cliente;
                }  
            }
        }
        return null;    
    }
    
    public void AñadirCliente (Cliente newCliente)
        {
           listaclientes.add(newCliente);
           volcarClientes();
        }
    public void BorrarCliente(Cliente deleteCliente)
        {
           listaclientes.remove(deleteCliente);
           volcarClientes();
        }
    public void ModificarCliente(Cliente modifyCliente)//llamar a getclient y modificar diretamente
        {
            
           Cliente cliente = ConseguirCliente(modifyCliente.GetDni());
           BorrarCliente(cliente);
           AñadirCliente(modifyCliente);
        }
    
}
