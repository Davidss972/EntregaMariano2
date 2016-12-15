
package Productos;

import java.time.LocalDate;

public class Alquiler 
{
    private String dni;
    private String matricula;
    private String fecha;
    private String precio;
    public Alquiler()
    {
        dni = "sin dni";
        matricula = "sin matricula";
        fecha = "sin fecha";
        precio ="sin precio";
    }
    public void SetDni(String dni)
    {
        this.dni = dni;
    }
    public String GetDni()
    {
        return dni;
    }
    public void SetMatricula(String matricula)
    {
        this.matricula = matricula;
    }
    public String GetMatricula()
    {
        return matricula;
    }

    public void SetFecha(String fecha)
    {
        this.fecha = fecha;
    }
    
    public String GetFecha() 
    {
        return fecha;
    }

    public void SetPrecio(String precio) 
    {
        this.precio = precio;
    }
    public String GetPrecio() 
    {
        return precio;
    }
    @Override
    public String toString()
    {
        //return fecha+";"+matricula+";"+dni+";"+precio;
        return dni+";"+matricula+";"+fecha+";"+precio;
    }
    public LocalDate mostrarFecha()
    {
        LocalDate fechaactual = LocalDate.now();
        return fechaactual;
    }
}   
