
/**
 * Esta clase representa la posibilidad de que un coche sea CocheResistente. 
 * 
 * Estos coches se caracterizan por tener un depósito extra de 100 litros de reserva 
 * de combustible que pueden utilizar en una sola carrera en la que no vayan a poder 
 * terminar por no tener suficiente combustible. 
 * 
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (27/11/2020)
 */
public class CocheResistente extends CocheNormal
{
    private double reserva;

    /**
     * Constructor for objects of class CocheResistente
     */
    public CocheResistente(String nombre, Velocidad velocidad, Combustible combustible)
    {
        super(nombre, velocidad, combustible);    
        setReserva(100.0);
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
            setReserva(0.0);
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
}
