import java.util.*;
/**
 * Clase comparadora de Coche por Combustible.
 * Sirve para ordenar la lista de Coches
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (30/12/2020)
 */

public class CMPCombustible implements Comparator <Coche>
{
    public int compare (Coche c1, Coche c2){
        if (c1.getValorCombustibleTotal() == c2.getValorCombustibleTotal())
            return 0;
        else if (c1.getValorCombustibleTotal() > c2.getValorCombustibleTotal())
            return 1;
        else 
            return -1;
    }
}
