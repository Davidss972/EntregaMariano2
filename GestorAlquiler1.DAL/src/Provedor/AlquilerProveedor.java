
package Provedor;

import Productos.Alquiler;
import Productos.Cliente;
import Provedor.Interfaces.IAlquilerProveedor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AlquilerProveedor implements IAlquilerProveedor
{
    String nombreArchivo = "libretaAlquileres.csv";
    
    ArrayList<Alquiler> listaalquiler = new ArrayList<>();
    public AlquilerProveedor()
    {
        listaalquiler = CargarAlquileresDesdeArchivo();
    }
    
    public ArrayList<Alquiler> CargarAlquileresDesdeArchivo()
    {
        ArrayList<Alquiler> listaalquiler1 = new ArrayList<>();
        try
        {
            Scanner sc = new Scanner(new File(this.nombreArchivo)).useDelimiter(";");
            while(sc.hasNext())
            {
                Alquiler alquiler = new Alquiler();
                alquiler.SetDni(sc.next());
                alquiler.SetMatricula(sc.next());
                alquiler.SetFecha(sc.next());
                alquiler.SetPrecio(sc.next());
                listaalquiler1.add(alquiler);
            }
        }
        catch(FileNotFoundException ex)
        {
            Logger.getLogger(AlquilerProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaalquiler1;
    }
    private void volcarAlquileres() //antes de volcar manera de borrar todo lo que haya dentro/*porque lo que cargamos es la lista.*/
    {
        try {
                FileWriter fw = new FileWriter(new File(this.nombreArchivo));
                BufferedWriter bw = new BufferedWriter(fw); 
                for (Alquiler alquiler : listaalquiler) 
                {
                    fw.write(alquiler.toString() + ";");
                   
                }
                fw.close();
            } 
        catch (IOException ex) 
            {
                Logger.getLogger(AlquilerProveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void mostrarAlquiler()
    {
        for (Alquiler alquiler : listaalquiler)
        {
            System.out.println(alquiler);
        }
    }
    public Alquiler ConseguirAlquiler(String fecha)
    {
        String alquilermatricula = "";
            
        for (Alquiler alquiler : listaalquiler) 
        {
            alquilermatricula = alquiler.GetFecha();
            if(alquilermatricula != null)
            {
                if(alquilermatricula == null ? fecha == null : alquilermatricula.equals(fecha))
                {
                    return alquiler;
                }  
            }
        }
        return null;    
    }
    public void AñadirAlquiler (Alquiler newAlquiler)
        {
           listaalquiler.add(newAlquiler);
           volcarAlquileres();
        }
    public void BorrarAlquiler(Alquiler deleteAlquiler)
        {
           listaalquiler.remove(deleteAlquiler);
           volcarAlquileres();
        }
    public void ModificarAlquiler(Alquiler modifyAlquiler)//llamar a getclient y modificar diretamente
        {
            
           Alquiler alquiler = ConseguirAlquiler(modifyAlquiler.GetFecha());
           BorrarAlquiler(alquiler);
           AñadirAlquiler(modifyAlquiler);
        }

}
