/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentadores.Interfaces;

import Productos.Coche;

/**
 *
 * @author gokud
 */
public interface ICochePresentador 
{
    boolean AñadirCoche(Coche newCliente);
    boolean BorrarCoche(String matricula);
    boolean ModificarCoche(Coche modifyCliente);
}
