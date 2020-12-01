
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
            reserva = 0;
        }
        else {
            super.reducirCombustible(piloto, circuito);
        }
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
