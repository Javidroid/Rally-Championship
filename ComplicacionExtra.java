/**
 * Clase base para realizar el Patrón Decorator y hacer que Circuito pueda
 * tener ComplicacionesExtra (que serán: Nocturno, Mojado, Frio y Gravilla, de momento)
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (13/12/2020) 
 */
public abstract class ComplicacionExtra extends CircuitoReal
{
    protected Circuito circuitoComplicacion;
    
    public ComplicacionExtra(Circuito circuito){
        super(circuito.getNombre(), circuito.getComplejidad(), circuito.getDistancia());
        circuitoComplicacion = circuito;
    }
    
    /**
     * Getter del valor de Complejidad
     * @return  Valor de Complejidad
     */
    public double getValorComplejidad(){return circuitoComplicacion.getValorComplejidad();}
    
    /**
     * Getter del valor de Distancia
     * @return  Valor de Distancia
     */
    public double getValorDistancia(){return circuitoComplicacion.getValorDistancia();}
    
    /**
     * Método sobreescrito  toString
     * @return Representacion de CircuitoReal con ComplicacionesExtra
     */
    @Override
    public String toString(){
        return circuitoComplicacion.toString() +
        "\n + extra: " + getClass().getSimpleName() +
        "\n >> Nueva complejidad: "   + getValorComplejidad() +
        "\n >> Nueva distancia: "     + getValorDistancia()   +
        "\n";
    }
}
