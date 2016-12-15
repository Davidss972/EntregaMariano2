
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentadores;

import Presentadores.Interfaces.ICochePresentador;
import Productos.Coche;
import Provedor.Interfaces.ICocheProveedor;
import colores.ColorTexto;

/**
 *
 * @author gokud
 */
public class CochePresentador implements ICochePresentador
{
    private ICocheProveedor cocheProvider;
    
    
    public CochePresentador(ICocheProveedor Cochep)
        {
            cocheProvider = Cochep;
        } 
    
    
    public boolean AñadirCoche(Coche newCoche)
        {
            Coche CocheAAñadir = cocheProvider.ConseguirCoche(newCoche.GetMatricula());
            
            if (CocheAAñadir == null )
                {
                    cocheProvider.AñadirCoche(newCoche);
                    ColorTexto.println(ColorTexto.ANSI_RED,"El coche ha sido creado");
                    return true;
                }
            else
                {
                    return false;
                }
            
        }
    public boolean BorrarCoche(String matricula)
    {
            Coche CocheABorrar = cocheProvider.ConseguirCoche(matricula);
            
        if (CocheABorrar != null )
            {
                cocheProvider.BorrarCoche(CocheABorrar);
                ColorTexto.println(ColorTexto.ANSI_RED,"El coche ha sido borrado");
                return true;
            }
        else
            {
                return false;
            }
            
    }
    public boolean ModificarCoche(Coche modifyCoche)
        {
            Coche CocheAModificar = cocheProvider.ConseguirCoche(modifyCoche.GetMatricula());
            
            if (CocheAModificar == null )
                {
                    cocheProvider.ModificarCoche(modifyCoche);
                    return true;
                }
            else
                {
                    return false;
                }
            
        }
}
