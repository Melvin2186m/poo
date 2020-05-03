

public class Puerta
{
    private boolean estado;
    private Cerrojo cer;

    
    public Puerta(Cerrojo c)
    {
       estado=false;
       cer=c;
    }

    public void setestado(boolean estado){
     this.estado=estado;}
     
     public boolean getestado(){
         return estado;}
     
    public void setcerrojo(Cerrojo c){
    cer=c;}
     
     public Cerrojo getcerrojo(){
         return cer;}
}
