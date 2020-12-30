import java.util.*;
/**
 * Clase comparadora de Coche por Nombre.
 * Sirve para ordenar la lista de Coches
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (30/12/2020)
 */

public class CMPNombreCoche implements Comparator <Coche>
{
    public int compare (Coche c1, Coche c2){
        return c1.getNombre().compareTo(c2.getNombre());
    }
}
