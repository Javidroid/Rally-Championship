
/**
 * Decorador Mojado. Modifica la complejidad original en un factor
 * constante de 1.15 y la distancia original en un factor constante de 0.85
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (13/12/2020) 
 */
public class Mojado extends ComplicacionExtra
{
    /**
     * Constructor del decorador Mojado
     */
    public Mojado(Circuito circuito)
    {
        super(circuito);
    }

    /**
     * Getter del valor de complejidad con la complicación Mojado
     * @return  Valor de Complejidad con ComplicacionExtra Mojado
     */
    public double getValorComplejidad(){
        return Math.round((circuitoComplicacion.getValorComplejidad() * 1.15) *100d)/100d;
    }
    
    /**
     * Getter del valor de distancia con la complicación Mojado
     * @return  Valor de Distancia con la ComplicacionExtra Mojado
     */
    public double getValorDistancia(){
        return Math.round((circuitoComplicacion.getValorDistancia() * 0.85) *100d)/100d;
    }
    
    /**
     * Método sobreescrito  toString
     * @return Representacion de CircuitoReal con Mojado
     */
    @Override
    public String toString(){
        return circuitoComplicacion.toString() + " " + getClass().getSimpleName();
    }
}
