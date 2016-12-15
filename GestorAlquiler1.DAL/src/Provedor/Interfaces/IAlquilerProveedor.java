/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Provedor.Interfaces;

import Productos.Alquiler;

/**
 *
 * @author gokud
 */
public interface IAlquilerProveedor 
{
    void AñadirAlquiler(Alquiler newAlquiler);
    void BorrarAlquiler(Alquiler deleteAlquiler);
    void ModificarAlquiler(Alquiler modifyAlquiler);
    Alquiler ConseguirAlquiler(String fecha);
    void mostrarAlquiler();   
}
