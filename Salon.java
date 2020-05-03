public class Salon
{
    public String nombre;
    private Puerta p;
   
    public Salon(String Nom,Puerta pu)
    {setPuerta(pu);
        setNombre(Nom);
        
    }
     public void setNombre(String nombre){
    this.nombre=nombre;}
      
    public String getNombre(){
        return "nombre: "+nombre;}
     
    public void setPuerta(Puerta c){
    p=c;}
     
     public Puerta getPuerta(){
         return p;}
    
}
