import java.util.*;
/**
 * Clase comparadora de Coche por Velocidad Teórica.
 * Sirve para ordenar la lista de Coches
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (30/12/2020)
 */

public class CMPVelocidad implements Comparator <Coche>
{
    public int compare (Coche c1, Coche c2){
        if (c1.getValorVelocidad() == c2.getValorVelocidad())
            return 0;
        else if (c1.getValorVelocidad() > c2.getValorVelocidad())
            return 1;
        else 
            return -1;
    }
}
