import java.util.*;

/**
 * Este programa simula las condiciones y operaciones de un péndulo, para poder encontrar su período de oscilación 
 * 
 * @author Bafen Ricardo Barragán Sánchez 
 * @version 1
 */
public class Péndulo
{
    static Scanner teclado = new Scanner(System.in); 
    private double l; 
    private double g; 
    
    /**
     * Constructor de objetos de la clase péndulo, sin parámetros. 
     */
    public Péndulo()
    {
        this.l = 15; 
        this.g = 9.8;
    }

    /**
     * Constructor de objetos de la clase péndulo, sin parámetros. 
     */
    public Péndulo(double longi, double grave)
    {
        this.l = longi; 
        this.g = grave;
    }

    /**
     * Métodos analizadores. 
     */
    public double obtenerLongitud()
    {
        return this.l; 
    }
    
    public double obtenerGravedad()
    {
        return this.g; 
    }
    
    public double periodOscilación()
    {
        return (2*Math.PI) * (Math.sqrt(this.l/ this.g));
    }
    
    /**
     * Métodos modificadores. 
     */
    public void cambiarLongitud(int nLongitud)
    {
        this.l = nLongitud;
    }
       
    public void cambiarGravedad(int nGravedad) throws Exception
    {
        if (nGravedad > 0 || nGravedad < 0)
        {
            this.g = nGravedad;
        }
        else 
        {
            throw new Exception ("Error!!! El valor de la gravedad es inválido");
        }
    }
}
