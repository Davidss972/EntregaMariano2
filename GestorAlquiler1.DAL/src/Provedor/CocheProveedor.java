/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Provedor;

import Productos.Coche;
import Provedor.Interfaces.ICocheProveedor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CocheProveedor implements ICocheProveedor
{
    String nombreFichero = "libretaCoches.csv";
    ArrayList<Coche> listacoches = new ArrayList<>();
    
    public CocheProveedor()
    {
        listacoches = CargarCochesDesdeArchivo();
    }
    
    public ArrayList<Coche> CargarCochesDesdeArchivo()
    {
        ArrayList<Coche> listacoches1 = new ArrayList<>();
        try  
        {
           
            Scanner sc = new Scanner(new File(this.nombreFichero)).useDelimiter(";");
            while (sc.hasNext()) 
            {
                Coche coche = new Coche();
                coche.SetMatricula(sc.next());
                coche.SetMarca(sc.next());
                coche.SetModelo(sc.next());
                listacoches1.add(coche);
            }
        }     
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(CocheProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }

            return listacoches1;
    }
    private void volcarCoches() //antes de volcar manera de borrar todo lo que haya dentro/*porque lo que cargamos es la lista.*/
    {
        try {
                FileWriter fw = new FileWriter(new File(this.nombreFichero));
                for (Coche coche : listacoches) 
                {
                    fw.write(coche.toString() + ";");
                }
                fw.close();
            } 
        catch (IOException ex) 
            {
                Logger.getLogger(CocheProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void mostrarCoches()
    {
        for (Coche coche : listacoches)
        {
            System.out.println(coche);
        }
    }

    public Coche ConseguirCoche(String matricula)
    {
        String cochematricula = "";
            
        for (Coche coche : listacoches) 
        {
            cochematricula = coche.GetMatricula();
            if(cochematricula != null)
            {
                if(cochematricula == null ? matricula == null : cochematricula.equals(matricula))
                {
                    return coche;
                }  
            }
        }
        return null;    
    }
    
    public void AñadirCoche (Coche newCoche)
        {
           listacoches.add(newCoche);
           volcarCoches();
        }
    public void BorrarCoche(Coche deleteCoche)
        {
           listacoches.remove(deleteCoche);
           volcarCoches();
        }
    public void ModificarCoche(Coche modifyCoche)//llamar a getclient y modificar diretamente
        {
           Coche coche = ConseguirCoche(modifyCoche.GetMatricula());
           BorrarCoche(coche);
           AñadirCoche(modifyCoche);
        }
    
}
