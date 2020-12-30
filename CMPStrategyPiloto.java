
import java.util.*;
/**
 * Interfaz para implementar cada estrategia de ordenación de Pilotos en cada Escudería.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public interface CMPStrategyPiloto
{
    /**
     * Método común de todas las estrategias para ordenar la lista de pilotos
     * 
     * @param  List <Piloto> pilotos
     */
    int ordenarPilotos(List <Piloto> pilotos);
}
