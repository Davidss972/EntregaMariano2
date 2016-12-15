/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Provedor.Interfaces;

import Productos.Cliente;

/**
 *
 * @author gokud
 */
public interface IClienteProveedor 
{
    void AñadirCliente(Cliente newCliente);
    void BorrarCliente(Cliente deleteCliente);
    void ModificarCliente(Cliente modifyCliente);
    Cliente ConseguirCliente(String dni);
    void mostrarClientes();
}
