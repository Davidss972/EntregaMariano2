/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentadores.Interfaces;

import Productos.Cliente;

/**
 *
 * @author gokud
 */
public interface IClientePresentador 
{
    boolean AñadirCliente(Cliente newCliente);
    boolean BorrarCliente(String dni);
    boolean ModificarCliente(Cliente modifyCliente);
    Cliente buscarCliente(String Dni);
}
