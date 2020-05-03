
import java.util.*;
public class Persona
{
    private String nombre;
    public Persona(String nom)
    {
         nombre=nom;
    }

    public void setNombre(String nombre){
    this.nombre=nombre;} 
    
    public String getNombre(){ return "nombre: "+nombre;}
    
    public boolean abrirpuerta(Puerta p, Llave ll){
     if (!p.getestado() && ll.getcodigo().equals((p.getcerrojo()).getcodigo())) 
       {p.setestado(true);
           return true;
        }
      return false;  
    }
    public Vector crearLlavero(){
        Vector<Llave>Llavero=new Vector<Llave>();
        return Llavero;
    }
    
    public boolean abrirPuertallavero(Puerta p,Vector llavero){
        if(!p.getestado()){
        for(int pos=0;pos< llavero.size();pos++)
        {
            if( ((Llave)llavero.get(pos)).getcodigo().equals((p.getcerrojo()).getcodigo()))
            {   
          p.setestado(true);
          return true;
            
        }
    }
     
} return false;
}
  public boolean abrirPuertallave(Puerta p,Llave ll){
        if(!p.getestado()){
       
            if( (ll.getcodigo().equals((p.getcerrojo()).getcodigo())))
            {   
          p.setestado(true);
          return true;
            
        }
    
     
} return false;
}
public boolean abrirSalon(Salon s ,Vector llavero){
  if(!s.getPuerta().getestado()){
   abrirPuertallavero(s.getPuerta(),llavero);
   return true;
 
}

return false;
}
public boolean abrirSalon1(Salon s ,Llave ll){
  
   if(!s.getPuerta().getestado()){
     abrirPuertallave(s.getPuerta(),ll);
    return true;
}
return false;
}

 public Vector<Llave> agregarllavellavero(Vector llaver, Llave ll){  
    //En esta linea de codigo se agrega un llave a un vector llavero
    //llaver.add() es con el cual agregamos una llave al llavero
    //retornamos un el vector que contiene las llaves, que funge como llavero
    llaver.add(ll);
    return llaver;
}

 public boolean abrirsalonedificio(Edificio e, int x, Llave ll){  
   // este metodo abre un salon en una posicion especifica dentro del vector aulas
   //boolean s nos permite guardar lo que nos retornara el metodo que llamamos que es 
   //regresarsalonpos(le mandamos el argumento que previamente pedimos al usuario)
   boolean s=false;
   Salon b=e.regresarsalonpos(x);
   //en esta linea declaramos una variable de tipo salon que almacenara el salon
   //que nos retornara el metodo regresarsalonpos perteneciente a la clase edificio.
   if(b!=null){
   //en esta linea comparamos la variable b siempre que sea diferente a null ejecutara la
   //la siguiente linea.
   s=abrirSalon1(b,ll);
   //en este linea mandamos los argumentos del metodo de la clase b=a un salon en una 
   //posicion especifica. ll pertenece ala llave que llamamos een el propio metodo.
   //utilice el metodo abrirSalon1 para poder diferenciarlo de otro metodo identico 
   //pero que recibe diferentes argumentos.
}
   return s;
   //retornamos s que es un salon para que se pueda verificar que el estado de la puerta
   //alla cambiado.
    }
public boolean abrirsalonedificiollavero(Edificio e, int x, Vector llav){  
   //en este metodo declaramos un booleano de tipo s que almacenara lo que nos
   //retornara el metodo abrirsalon() de la clase.
   boolean s= true;
   Salon b=e.regresarsalonpos(x);
   //declaramos b de tipo salon que almacenara el salon que retornara el metodo 
   //regresarsalonpos(mandamos el argumento propio del metodo que mandamos a llamar)
   if(b!=null)
     s=abrirSalon(b,llav);
   //en este metodo abrir salon(mandamos el salon almacenado en la variable b,
   //llav que correponde al vector llamado en el propio metodo)
   return s;//retornamos s que es el salon para verificar que se halla abierto
}

public  Vector<Salon> abrirtodoeledificio(Edificio e,Vector llavero){  
   //en esta linea de codigo creamos un nuevo vector que nos almacenara todos los salones
   //qe se logren abrir con el llavero
  Vector<Salon>abierto=new Vector<Salon>();
  boolean r;
  //declaramos una variaable de b de tipo salon y un booleano r
   Salon b; 
   Vector p=e.getVector();
   //para poder acceder al vector aulas de la clase edificio la llamamos mediante
   //el metodo getVector() de que nos retornara el vector aulas y la guardamos en la
   //variable p de tipo vector
   for(int i=1;i<=p.size();i++){
    //con este for recorremos el vector aulas almacenado en la variable p
    //empesamos de i=1 y condicionando i<=p.size() ya que para poder 
    //acceder ala posicion 0 debemos retornar i-1 ya que el usuario no sabe 
    //que se empiesa de cero
   b=(Salon)e.regresarsalonpos(i);
   //decimos que la variable b almacenara el salon en la posicio i
      r=abrirSalon(b,llavero);
      if(r!=false){
        abierto.add(b);
    //por lo consiguiente decimos que r almacenara el salon 
    //y reutilizamos el metodo abrirSalon(madamos b que es el salon,
    //y el llavero) , y decimos si r es diferente de falso la agregamos al
    //vector que hemos creado de abiertos.
        }
       
    }
    return abierto;
    //retornamoos el vector para poder ver  cuales salones si estan abiertos
}
public  Vector<Salon> cerraredificio(Edificio e){  
   // Creamos un vector aulas que almacenara el vector aulas de la clase
   //edificio retornado por el metodo getVector
   Vector aulas=e.getVector();
   for(int i=0;i<aulas.size();i++){
    //en este for empezamos de cero puesto que nosostros si sabemos que se empieza de 
    //de cero
       Salon o=(Salon)aulas.get(i);
    //declaramos una varible salon que almacenara el aula del vector en la posicion
    //i
       o.getPuerta().setestado(false);
    //ya que cerraremos todos los salones acedemos directamente al estado del salon 
    //y como sabemos la puerta contiene el estado lo modificamos en falso
    }
   return aulas;
   //retornaremos aulas que es el vector ya para verificar que las aulas han sido cerradas


}
 public  Vector<Salon>  regresaAbiertos(Edificio e){  
   //Crearemos  un nuevo vector que llamaremos aulasAbiertas que como su nombre lo 
   //dice utilizaremos para almacenar las aulas abiertas
   Vector<Salon>aulasAbiertas=new Vector<Salon>();;
   Vector aulas=e.getVector();
   //almacenaremos en el vector aulas en vector aulas de la clase edificio el cual contiene
   //los edificios en realidad solo la almacenamos en esta para poder acceder a ella,
   for(int i=0;i<aulas.size();i++){
   //este for lo ocupamos `para obtener un salon y recorrer el vector que almacena
   //las aulas
       Salon o=(Salon)aulas.get(i);
       if(o.getPuerta().getestado()==true){
        aulasAbiertas.add(o);
  //Creamos una variable o de tipo salon y almacenamos un salon en la posicion i
  //con la ayuda de el metodo get para obtener una posicion
  //comparamos si el salon que retorna una puerta que ha su vez retorna un estado
  //es igual a verdadero guardamos el salon i en el vector aulasABIERTAS
        }
    }
   return  aulasAbiertas;
 //retornamos el vector aulasabiertas para verificar que aulas estan abiertas.
}

public  Vector<Salon> regresaaCerrados(Edificio e ){  
   //Creamos un nuevo vector que almacenara la aulas cerradas
   //que tiene por nombre aulasCerradas
    Vector<Salon>aulasCerradas=new Vector<Salon>();;
   Vector aulas=e.getVector();//vector que almacena un vector que retorna
   //el el metodo getVector de la clase edificio
   for(int i=0;i<aulas.size();i++){
       Salon o=(Salon)aulas.get(i);
       //con un for recorremos el vector que almacena las aulas u obtenemos en 
       //variable o un salon en la posicion i
       if(o.getPuerta().getestado()==false){
        aulasCerradas.add(o);
        }
       //comparamos si el salon que tiene un get pueta que la puerta tiene un 
      //get estado es igual a false la guardamos en el vector que hemos creado 
      //aulasCerradas
    }
   return  aulasCerradas;
   //retornamos aulasCerradas para ver cuales aulas estaban cerradas
}


public boolean taabierto(Edificio e, int x){  
   //declaramos una variable l de tipo booleano el cual
 //el cual almacenara el valor retornado por si el salon esta abierto o no
   boolean l;
   Salon s=e.regresarsalonpos(x);//almacenamos el salon en la varible s
   //en el cual utilizamos el metodo regresarsalonpos de la clase edificio
   if(s.getPuerta().getestado()==true){
     l=true;
     //comparamos si s que es el salon y tiene un getpuerta, que asu vez tiene 
     //getestado, si es igual a verdaderole asignamos el valor verdadero ala 
     //variable l de tipo booleano
    }else{l=false;}
    //si no es asi le asignamos el valor de false
    return l;
    //retornamos l si es true es porque esta abierto y si false esta cerrado
}


 public Llave cualeslallave(Edificio e, int x){  
   // este metodo esta anexado por mi jajaja
   Llave o=null;
   Salon l=e.regresarsalonpos(x);
   //declaramos llave o igual a nulo ya que no tenemos nada aun
   String y=l.getPuerta().getcerrojo().getcodigo();
   //obtenemos el codigo del cerrojo para crear uan llave
     o=new Llave(y);
    //aqui creamos una llave que abre la puerta
    return o;
  //retornamos la llave que hemos creado

}
  public Llave cualeslallaveES(Edificio e,int x,Vector llavero){  
   //en este metodo creaqmos una variable p de tipo booleano y inicializamos la 
   //variable m de tpo llave en nulo por que no existe aun
   boolean p;
   Llave m=null;
   Salon l=e.regresarsalonpos(x);
   //almacenamos un salon en la varible l de tipo salon reutilizando el metodo de la
   //clase edificio que retorna un salon en una posicion
        for(int i=0;i<llavero.size();i++){
          //utilizamos un for para recorrer el vector llavero
          //cateamos para decirle que es de tipo llave y obtenemos una posicion i 
          m=(Llave)llavero.get(i);
            
        //reutilizamos el metodo abrirsalon y le mandamos la variable l salon 
        //y m la llave 
            p=abrirSalon1(l,m);
            if(p!=false)
            return m;
        //si es diferente a false retornara la llave si no es asi retornara nulo
      }
    
    return m;
}
}