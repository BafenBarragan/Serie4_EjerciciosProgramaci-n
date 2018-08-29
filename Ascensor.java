import java.util.*;

/**
 * Programa que simula el funcionamiento de un ascensor
 * 
 * @author Bafen Ricardo Barragán Sánchez
 * @version 1.0
 */
public class Ascensor
{
    static Scanner teclado = new Scanner(System.in);
    
    private int nPisos; 
    private int nSótanos; 
    private int pisoActual; 

    /**
     * Constructor sin parámetros 
     */
    public Ascensor()
    {
        this.nPisos = 25; 
        this.nSótanos = 4;         
    }
    
    /**
     * Constructor con parámetros 
     */
    public Ascensor(int pisos, int sótanos)
    {
        this.nPisos = pisos; 
        this.nSótanos = sótanos;         
    }
    
    public int obtenerPisos ()
    {
        return this.nPisos; 
    }
    
    public int obtenerSótanos ()
    {
        return this.nSótanos; 
    }
    
     /**
     * Métodos modificadores 
     */
    public void cambiarPisos(int nuevosPisos) throws Exception 
    {
        if (nuevosPisos > 0)
        {
            this.nPisos = nuevosPisos;
        }   
        else 
        {
            throw new Exception ("ERROR!!! El número de pisos debe ser una cantidad mayor que 0");
        }
    }
    
    public void cambiarSótanos(int nuevosSótanos) 
    {
        this.nSótanos= nuevosSótanos;
    }  
    
      /**
     * Método para crear un nuevo ascensor. 
     */
  
    public void nuevoAscensor() throws Exception
    {
        System.out.print("Cuántos pisos habitables tendrá su edificio? "); 
        int p = teclado.nextInt(); 
        
        System.out.print("Cuántos sótanos tendrá su edificio? "); 
        int s = teclado.nextInt(); 
        
        System.out.println(); 
        
        cambiarPisos(p);
        cambiarSótanos(s);  
    }
    
    /**
     * Método para calcular el piso actual. 
     */
  
    public int pisoActual (int piso) throws Exception
    {
        if (piso < -(nSótanos) || piso > nPisos)
        {
            throw new Exception ("PISO INVÁLIDO!!! El edificio tiene únicamente " + nSótanos + " sótanos y " + nPisos + " pisos.");
        }
        else if (piso == 0)
        {
            this.pisoActual = 1; 
        }
        else
        {
            this.pisoActual = piso;
        }
        
        return pisoActual; 
    }
    
    /**
     * Método para subir un piso. 
     */
    public int subirUno() throws Exception
    {
        if (pisoActual != -1)
        {
            if (this.pisoActual < nPisos)
            {
            this.pisoActual = pisoActual + 1; 
            }
            else 
            {
                throw new Exception ("ERROR!!! No hay más pisos arriba de este.");
            }
        }
        else 
        {
            this.pisoActual = pisoActual + 2;
        }
        
        return pisoActual; 
    }
    
    /**
     * Método para bajar un piso. 
     */
    public int bajarUno() throws Exception
    {
        if (pisoActual != 1)
        {
            if (this.pisoActual > - (nSótanos))
            {
            this.pisoActual = pisoActual - 1; 
            }
            else 
            {
                throw new Exception ("ERROR!!! No hay más pisos debajo de este.");
            }
        }
        else 
        {
            this.pisoActual = pisoActual - 2;
        }
        
        return pisoActual; 
    }
    
    /**
     * Método para calcular el total de pisos. 
     */
    public int pisosPorAtender()
    {
        return this.nPisos + this.nSótanos; 
    }
    
         
    public static void main (String[] args) throws Exception
    {
        Ascensor unAscensor = new Ascensor(); 
        char opción = 0; 
        int piso = 0; 
        
        System.out.println("<<BIENVENIDO A SU ASCENSOR>>"); 
        System.out.println();
        System.out.println();
        
        do {
          System.out.println("Presione T para ver el total de pisos del ascensor");
          System.out.println("Presione C para crear un nuevo ascensor.");
          System.out.println("Presione S para subir un piso.");
          System.out.println("Presione B para bajar un piso.");
          System.out.println("Presione A para ver en qué piso está.");
          System.out.println("Presione I para ir a un piso específico."); 
          System.out.println("Presione X para salir del ascensor.");
          opción = teclado.next().charAt(0); 
          System.out.println();
          
                         
          switch (opción)
          {
             case 'T': case 't': 
                 int total = unAscensor.pisosPorAtender(); 
                 int pisos = unAscensor.obtenerPisos();
                 int sótanos = unAscensor.obtenerSótanos();
                 System.out.println("El ascensor se mueve por " + total + " niveles; " + pisos + " pisos habitables y " 
                 + sótanos + " sótanos. \n");
                 break;
             
             case 'C': case 'c':             
                unAscensor.nuevoAscensor();
                System.out.println("<< SU ASCENSOR HA SIDO CREADO!!! >>\n\n"); 
                piso = 0; 
                break; 
             
             case 'S': case 's':                                 
                unAscensor.pisoActual(piso);
                int suba = unAscensor.subirUno(); 
                              
                System.out.println ("Usted ha subido un piso. Ahora se encuentra en el piso #" + suba + "\n"); 
                piso = suba;
                break; 
             
             case 'B': case 'b': 
                unAscensor.pisoActual(piso);
                int baje = unAscensor.bajarUno(); 
             
                System.out.println ("Usted ha bajado un piso. Ahora se encuentra en el piso #" + baje + "\n"); 
                piso = baje;
                break;    
             
             case 'A': case 'a': 
                int ahora = unAscensor.pisoActual(piso);
                System.out.println ("Usted se encuentra en el piso #" + ahora + "\n"); 
                break; 
             
             case 'I': case 'i': 
                System.out.print("¿A qué piso desea ir?"); 
                int ir = teclado.nextInt(); 
                
                piso = ir; 
                int go = unAscensor.pisoActual(piso);
                System.out.println ("\n\n ...Vamos al piso #" + go + "\n"); 
                break; 
             
             case 'X': case 'x': 
                System.out.println("--- Ahora puede salir del ascensor. ---");
                break; 
                
          }
          
          
        } while (opción != 'X' && opción != 'x');
        
    
    }
}
