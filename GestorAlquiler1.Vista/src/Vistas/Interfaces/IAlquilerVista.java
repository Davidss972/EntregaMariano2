/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Interfaces;

import Productos.Alquiler;
import java.io.IOException;

/**
 *
 * @author gokud
 */
public interface IAlquilerVista 
{
    Alquiler GetAlquilerDetails() throws IOException; 
    String GetAlquilerFecha()throws IOException;
    int GetAlquilerAction()throws IOException;
    void Run()throws IOException;
}
