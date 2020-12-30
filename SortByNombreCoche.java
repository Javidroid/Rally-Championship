
import java.util.*;
/**
 * Sirve para ordenar la lista de Coches por nombre
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (30/12/2020)
 */
public class SortByNombreCoche implements CMPStrategyCoche
{
    /**
     * Método común de todas las estrategias para ordenar la lista de coches
     * 
     * @param coches    La lista de coches que se quiere ordenar
     * @param ASC       True si se quiere ordenar ascendentemente. False para descendentemente
     */
    public void ordenarCoches(List <Coche> coches, boolean ASC){
        if(ASC){
            Collections.sort(coches, new CMPNombreCoche());
        }
        else{
            Collections.sort(coches, Collections.reverseOrder(new CMPNombreCoche()));
        }
    }
}
