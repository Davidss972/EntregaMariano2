/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas.Interfaces;

import Productos.Coche;
import java.io.IOException;

/**
 *
 * @author gokud
 */
public interface ICocheVista 
{
    Coche GetCocheDetails() throws IOException; 
    String GetCocheMatricula()throws IOException;
    int GetCocheAction()throws IOException;
    void Run()throws IOException;  
}
