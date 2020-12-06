
/**
 * Write a description of class CocheResistente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CocheResistente extends CocheNormal
{
    // instance variables - replace the example below with your own
    private double reserva;

    /**
     * Constructor for objects of class CocheResistente
     */
    public CocheResistente(String nombre, Velocidad velocidad, Combustible combustible)
    {
        super(nombre, velocidad, combustible);    
        reserva = 100.0;
    }
    
    /**
     * Reduce la cantidad de combustible que le queda en Coche Resistente en función a lo que tarde
     * el piloto en el circuito indicado
     * 
     * @param  piloto       El piloto que conduce el coche (para calcular el tiempo)
     * @param  circuito     El circuito en el que el coche compite (para calcular el tiempo)
     */
    @Override
    public void reducirCombustible(Piloto piloto, Circuito circuito)
    {
        double tiempoNecesario;
        tiempoNecesario = calcularTiempoNecesario(piloto, circuito);
        if(reserva > 0 && getDeposito() < tiempoNecesario){
            repostar(reserva);
            reserva = 0.0;
        }
        else {
            super.reducirCombustible(piloto, circuito);
        }
    }

    //SETTERS
    /**
     * Setter de reserva
     * 
     * @param reserva Nuevo valor del campo reserva
     */
    public void setReserva(double reserva){
        this.reserva=reserva;
    }
    
    //GETTERS
    /**
     * Getter de reserva 
     * 
     * @return reserva
     */
    public double getReserva(){
        return reserva;
    }
    
    //METODOS AUXILIARES
    
    /**
     * Método sobreescrito  toString
     * @return Representacion de CocheResistente
     */
    @Override
    public String toString(){
        StringBuilder builder= new StringBuilder();
        builder.append(getReserva());
        builder.append('\n');
        builder.append(super.toString());
        return builder.toString();
    }
    
    
    /**
     * Método sobreescrito equals
     * 
     * @param  obj Objeto con el que se quiere comparar la igualdad   
     * @return True si se cumple la igualdad, False en el caso contrario    
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj){ 
            return true;
        }
        if(!(obj instanceof CocheResistente)) {
            return false; 
        }
        
        CocheResistente other = (CocheResistente) obj;
        Double reservaDouble = getReserva();
        
        return super.equals(other) &&
               reservaDouble.equals(other.getReserva());
    }
    
     /**
    * Metodo sobreescrito hashCode
    * 
    * @return hashCode que representa la clase
    */
   @Override
   public int hashCode(){
       Double reservaDouble = getReserva();
       
       int result=17;
       
       result = 7 * result + super.hashCode();
       result = 13 * result + reservaDouble.hashCode();
       return result;
    }
    
    /**
     * Descripción de lo que hace el método
     * 
     * @param  x   descripción de cada parámetro
     * @return     lo que devuelve, si devuelve xd
     */
    public void metodoPlantilla()
    {
        // put your code here
        
    }
}
