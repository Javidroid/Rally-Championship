
/**
 * Decorador Frio. Modifica la complejidad original en un factor
 * constante de 1.1 y la distancia original en un factor constante de 0.9
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (13/12/2020) 
 */
public class Frio extends ComplicacionExtra
{
    /**
     * Constructor del decorador Frio
     */
    public Frio(Circuito circuito)
    {
        super(circuito);
    }

    /**
     * Getter del valor de complejidad con la complicación Frio
     * @return  Valor de Complejidad con ComplicacionExtra Frio
     */
    public double getValorComplejidad(){
        return Math.round((circuitoComplicacion.getValorComplejidad() * 1.1) *100d)/100d;
    }
    
    /**
     * Getter del valor de distancia con la complicación Frio
     * @return  Valor de Distancia con la ComplicacionExtra Frio
     */
    public double getValorDistancia(){
        return Math.round((circuitoComplicacion.getValorDistancia() * 0.9) *100d)/100d;
    }
    
    /**
     * Método sobreescrito  toString
     * @return Representacion de CircuitoReal con Frio
     */
    @Override
    public String toString(){
        return circuitoComplicacion.toString() + " " + getClass().getSimpleName();
    }
}
