
package Productos;

public class Coche 
{
    String matricula;
    String marca;
    String modelo;
    public void Coche()
    {
        matricula = "sin matricula";
        marca = "sin marca";
        modelo = "sin modelo";
    }
    public void SetMatricula(String matricula)
    {
        this.matricula = matricula;
    }
    public String GetMatricula()
    {
        return matricula;
    }
    public void SetMarca(String marca)
    {
        this.marca = marca;
    }
    public String GetMarca()
    {
        return marca;
    }
    public void SetModelo(String modelo)
    {
        this.modelo = modelo;
    }
    public String GetModelo()
    {
        return modelo;
    }
    @Override
    public String toString()
    {
        return matricula + ";" + marca + ";" + modelo;
    }
    
}
