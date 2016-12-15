/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Provedor.Interfaces;

import Productos.Coche;

/**
 *
 * @author gokud
 */
public interface ICocheProveedor 
{
    void AñadirCoche(Coche newCliente);
    void BorrarCoche(Coche deleteCliente);
    void ModificarCoche(Coche modifyCliente);
    Coche ConseguirCoche(String matricula);
    void mostrarCoches();
}
