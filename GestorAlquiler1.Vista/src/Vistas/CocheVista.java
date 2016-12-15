/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Presentadores.Interfaces.ICochePresentador;
import Productos.Coche;
import Provedor.CocheProveedor;
import Provedor.Interfaces.ICocheProveedor;
import Vistas.Interfaces.ICocheVista;
import colores.ColorTexto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author gokud
 */
public class CocheVista implements ICocheVista
{
    BufferedReader console;
    ICochePresentador cochePresenter;
    ICocheProveedor cocheProvider;
    CocheProveedor mostrar = new CocheProveedor();
    public CocheVista(ICochePresentador diseño)
    {
        cochePresenter = diseño;
        console = new BufferedReader(new InputStreamReader(System.in));
    }
    public Coche GetCocheDetails() throws IOException//detalles para cuando te hayas metido en coche.
    {
        Coche newcoche = new Coche();
        String continuamos;
        do{
            newcoche.SetMatricula(GetCocheMatricula());
            ColorTexto.println(ColorTexto.ANSI_CYAN,"introduce Marca");
            newcoche.SetMarca(console.readLine());
            ColorTexto.println(ColorTexto.ANSI_CYAN,"introduce Modelo");
            newcoche.SetModelo(console.readLine()); 
            ColorTexto.println(ColorTexto.ANSI_GREEN,"¿Deseea introducir un nuevo coche(S/N)?");
            continuamos = console.readLine();        
            return newcoche;
        }while (continuamos.startsWith("s") || continuamos.startsWith("S"));
    }
    public String GetCocheMatricula() throws IOException//pedir matricula
    {
        ColorTexto.println(ColorTexto.ANSI_CYAN,"Introduzca la matricula: ");
        
        return console.readLine();
    }
    public int GetCocheAction() throws IOException//switch 
    {
        console.readLine();
        int op;
        String menu="";
        Coche coche;
            menu="";
            menu+="****** Menú ******\n";
            menu+="1.- Añadir Coche \n";
            menu+="2.- Borrar Coche \n";
            menu+="3.- Modificar Coche \n";
            menu+="4.- Buscar Coche \n";
            menu+="5.- Mostrar Coches \n";
            menu+="6.- Salir \n";
            ColorTexto.println(ColorTexto.ANSI_PURPLE,menu);
            op=Integer.parseInt(console.readLine());
            
            switch(op)
            {
                case 1:
                coche = GetCocheDetails();
                cochePresenter.AñadirCoche(coche);
                if(cochePresenter.AñadirCoche(coche) == false)
                {

                }
                    break;
                case 2:
                
                if(cochePresenter.BorrarCoche(GetCocheMatricula()) == false)
                {
                    ColorTexto.println(ColorTexto.ANSI_RED,"El coche no existe");
                }
                    break;
                case 3:
                coche = GetCocheDetails();
                cochePresenter.ModificarCoche(coche);
                if(cochePresenter.ModificarCoche(coche) == false)
                {
                    ColorTexto.println(ColorTexto.ANSI_RED,"El coche ha sido modificado");
                }
                    break;
                case 4:
                    break;
                case 5:
                    mostrar.mostrarCoches();
                    break;
                case 6:
                    break;
            }
        
        return op;
        
    }
    public void Run() throws IOException//while bucle
    {
        while(GetCocheAction() != 6)
        {
        
        }    
           
    }
}
