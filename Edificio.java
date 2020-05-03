import java.util.*;
public class Edificio
{
    // instance variables - replace the example below with your own
    private String nombre;
    private Vector<Salon>aulas;
   

    /**
     * Constructor for objects of class Edificio
     */
    public Edificio(String nombre)
    {
        this.nombre=nombre;
        aulas=new Vector<Salon>();
        
    }

  
    public void agregarSalon(Salon s)
    {
      aulas.add(s);
    }
    public Vector<Salon> getVector(){
    return aulas;
    }
     public Salon regresarsalonpos(int n)
    { 
      //modificamos la condicion para que empiezela posicion cero 
      //que es cero para el programado y uuno para el usuario
      if(n>=1 &&n<=aulas.size())
       return aulas.get(n-1);
    
       return null;
        }
    
    public int regresardimensionaulas(){
      int b=aulas.size();
      return b;
    }
    
    }
    
    

