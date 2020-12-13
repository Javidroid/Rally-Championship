
/**
 * Decorador Nocturno. Modifica la complejidad original en un factor
 * constante de 1.2 y la distancia original en un factor constante de 0.8
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (13/12/2020) 
 */
public class Nocturno extends ComplicacionExtra
{
    /**
     * Constructor del decorador Nocturno
     */
    public Nocturno(Circuito circuito)
    {
        super(circuito);
    }

    /**
     * Getter del valor de complejidad con la complicación Nocturno
     * @return  Valor de Complejidad con ComplicacionExtra Nocturno
     */
    public double getValorComplejidad(){
        return circuitoComplicacion.getValorComplejidad() * 1.2;
    }
    
    /**
     * Getter del valor de distancia con la complicación Nocturno
     * @return  Valor de Distancia con la ComplicacionExtra Nocturno
     */
    public double getValorDistancia(){
        return circuitoComplicacion.getValorDistancia() * 0.8;
    }
}
