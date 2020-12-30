
import java.util.*;
/**
 * Interfaz para implementar cada estrategia de ordenación de Coches en cada Escudería.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface CMPStrategyCoche
{
    /**
     * Método común de todas las estrategias para ordenar la lista de coches
     * 
     * @param  List <Coche> coches
     */
    int ordenarCoches(List <Coche> coches);
}
