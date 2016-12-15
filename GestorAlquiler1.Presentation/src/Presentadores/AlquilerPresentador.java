/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentadores;
import Presentadores.Interfaces.IAlquilerPresentador;
import Productos.Alquiler;
import Productos.Cliente;
import Provedor.Interfaces.IAlquilerProveedor;
import Provedor.Interfaces.IClienteProveedor;
import Provedor.Interfaces.ICocheProveedor;
import colores.ColorTexto;

/**
 *
 * @author gokud
 */
public class AlquilerPresentador implements IAlquilerPresentador
{
    private IAlquilerProveedor alquilerProveedor;
    private IClienteProveedor clienteProveedor;
    private ICocheProveedor cocheProveedor;
    public AlquilerPresentador(IAlquilerProveedor alquilerp,IClienteProveedor clientep,ICocheProveedor cochep)
    {
        alquilerProveedor = alquilerp;
        clienteProveedor = clientep;
        cocheProveedor = cochep;
    }
    
    
    public boolean AñadirAlquiler(Alquiler newAlquiler)
    {
        Alquiler AlquilerAAñadir = alquilerProveedor.ConseguirAlquiler(newAlquiler.GetFecha());
        if(AlquilerAAñadir == null)
        {
            alquilerProveedor.AñadirAlquiler(newAlquiler);
            ColorTexto.println(ColorTexto.ANSI_RED,"El alquiler ha sido creado");
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean BorrarAlquiler(String fecha)
    {
        Alquiler AlquilerABorrar = alquilerProveedor.ConseguirAlquiler(fecha);
        if(AlquilerABorrar == null)
        {
            alquilerProveedor.BorrarAlquiler(AlquilerABorrar);
            ColorTexto.println(ColorTexto.ANSI_RED,"El alquiler ha sido borrado");
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean ModificarAlquiler(Alquiler modifyAlquiler) 
    {
        Alquiler AlquilerAModificar = alquilerProveedor.ConseguirAlquiler(modifyAlquiler.GetFecha());
            
        if (AlquilerAModificar != null )
        {
            alquilerProveedor.ModificarAlquiler(modifyAlquiler);
            return true;
        }
        else
        {
            return false;  
        }
    }  
    public Cliente buscarCliente(String Dni)
    {
        return clienteProveedor.ConseguirCliente(Dni);
    }
}
