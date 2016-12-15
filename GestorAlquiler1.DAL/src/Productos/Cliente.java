
package Productos;

public class Cliente 
{
    String dni;
    String nombre;
    String apellidos;

    public Cliente()
    {
        nombre = "sin nombre";
        apellidos = "sin apellidos";
        dni = "sin dni"; 
    }
    
    public void SetNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String GetNombre()
    {
        return nombre;
    }
    public void SetDni(String dni)
    {
        this.dni = dni;
    }
    public String GetDni()
    {
        return dni;
    }
    public void SetApellidos(String apellidos)
    {
        this.apellidos = apellidos;
    }
    public String GetApellidos()
    {
        return apellidos;
    }
    @Override
    public String toString()
    {
        return dni+";"+nombre+";"+apellidos;
    }
}