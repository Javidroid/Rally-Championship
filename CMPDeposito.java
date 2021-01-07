import java.util.*;
/**
 * Clase comparadora de Coche por Depósito.
 * Sirve para ordenar la lista de Coches
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (30/12/2020)
 */

public class CMPDeposito implements Comparator <Coche>
{
    public int compare (Coche c1, Coche c2){
        if (c1.getDeposito() == c2.getDeposito())
            return new CMPNombreCoche().compare(c1, c2);
        else if (c1.getDeposito() > c2.getDeposito())
            return 1;
        else 
            return -1;
    }
}
