
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
     * Reduce la cantidad de combustible que se indica por parámetro 
     * 
     * @param  double cantidad Los minutos que el piloto ha estado conduciendo
     */
    @Override
    public void reducirCombustible(double cantidad)
    {
        if(reserva > 0 && getDeposito() < cantidad){
            repostar(reserva);
            setReserva(0.0);
            System.out.println("+++ El " + getNombre() + " tiene que recurrir al depósito de reserva "
            + "para poder correr +++");
        }
        
        super.reducirCombustible(cantidad);
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
        //<coche: nombreCoche> <tipo: tipoCoche> <vel_teó: velocidadCoche> 
        //<comb: combustibleCoche(valorOriginal)(actual:valorActual)> 
        //[opcionalmente si tiene reserva->] > <reserva: reservaCoche> 
        //[opcionalmente si tiene nitro->] > <nitroPendiente: nitroPendiente> 
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
