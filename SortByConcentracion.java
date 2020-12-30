
import java.util.*;
/**
 * Sirve para ordenar la lista de Pilotos por Concentracion
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (30/12/2020)
 */
public class SortByConcentracion implements CMPStrategyPiloto
{
    /**
     * Método común de todas las estrategias para ordenar la lista de pilotos
     * 
     * @param pilotos   La lista de pilotos que se quiere ordenar
     * @param ASC       True si se quiere ordenar ascendentemente. False para descendentemente
     */
    public void ordenarPilotos(List <Piloto> pilotos, boolean ASC){
        if(ASC){
            Collections.sort(pilotos, new CMPConcentracion());
        }
        else{
            Collections.sort(pilotos, Collections.reverseOrder(new CMPConcentracion()));
        }
    }
}
