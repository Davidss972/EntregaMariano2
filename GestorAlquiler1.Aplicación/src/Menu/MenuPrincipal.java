/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Presentadores.AlquilerPresentador;
import Presentadores.ClientePresentador;
import Presentadores.CochePresentador;
import Presentadores.Interfaces.IAlquilerPresentador;
import Presentadores.Interfaces.IClientePresentador;
import Presentadores.Interfaces.ICochePresentador;
import Provedor.AlquilerProveedor;
import Provedor.ClienteProveedor;
import Provedor.CocheProveedor;
import Provedor.Interfaces.IAlquilerProveedor;
import Provedor.Interfaces.IClienteProveedor;
import Provedor.Interfaces.ICocheProveedor;
import Vistas.AlquilerVista;
import Vistas.ClienteVista;
import Vistas.CocheVista;
import Vistas.Interfaces.IAlquilerVista;
import Vistas.Interfaces.IClienteVista;
import Vistas.Interfaces.ICocheVista;
import colores.ColorTexto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author gokud
 */
public class MenuPrincipal 
{
    public void ejecutar() throws IOException
    {
        BufferedReader console;
        console = new BufferedReader(new InputStreamReader(System.in));
        console.readLine();
        int op;
        String menu=";";
        do{
            menu="";
            menu+="****** Menú ******\n";
            menu+="1.- Añadir Clientes \n";
            menu+="2.- Añadir Coches \n";
            menu+="3.- Añadir Alquileres \n";
            menu+="4.- Consultar Alquileres\n";
            menu+="5.- Salir \n";
            
            ColorTexto.println(ColorTexto.ANSI_YELLOW,menu);
            op = 0;
            try{
            op=Integer.parseInt(console.readLine());//hacer un try catch para capturar la excepcion de poner enter
            }
            
            catch(Exception ex)
            {
                ColorTexto.println(ColorTexto.ANSI_RED,"introduzca una opcion");
                continue;
            }
            IAlquilerProveedor alquilerproveedor = new AlquilerProveedor();
            ICocheProveedor cocheproveedor = new CocheProveedor();
            IClienteProveedor clienteproveedor = new ClienteProveedor();
            switch(op)
            {
                case 1:
                    
                    IClientePresentador clientepresentador = new ClientePresentador(clienteproveedor);
                    IClienteVista clientsview =  new ClienteVista(clientepresentador);
                    clientsview.Run();
                   
                    break;
                case 2:
                    
                    ICochePresentador cochepresentador = new CochePresentador(cocheproveedor);
                    ICocheVista cochevista = new CocheVista(cochepresentador);
                    cochevista.Run();
                    break;  
                case 3 :

                    IAlquilerPresentador alquilerpresentador = new AlquilerPresentador(alquilerproveedor,clienteproveedor,cocheproveedor);
                    IAlquilerVista alquilervista = new AlquilerVista(alquilerpresentador);
                    alquilervista.Run();
                    break;
                case 4 :
                    
                case 5:
                    System.exit(0);
                    break;
                default :
                    System.out.println("introduzca una opcion");
                    break;
                        
            }
        }while(op!=4);
    }
}
