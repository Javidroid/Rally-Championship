
/**
 * Decorador Gravilla. Modifica la complejidad original en un factor
 * constante de 1.05 y la distancia original en un factor constante de 0.95
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (13/12/2020) 
 */
public class Gravilla extends ComplicacionExtra
{
    /**
     * Constructor del decorador Gravilla
     */
    public Gravilla(Circuito circuito)
    {
        super(circuito);
    }

    /**
     * Getter del valor de complejidad con la complicación Gravilla
     * @return  Valor de Complejidad con ComplicacionExtra Gravilla
     */
    public double getValorComplejidad(){
        return circuitoComplicacion.getValorComplejidad() * 1.05;
    }
    
    /**
     * Getter del valor de distancia con la complicación Gravilla
     * @return  Valor de Distancia con la ComplicacionExtra Gravilla
     */
    public double getValorDistancia(){
        return circuitoComplicacion.getValorDistancia() * 0.95;
    }
}
