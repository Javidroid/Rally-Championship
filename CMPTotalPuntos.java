import java.util.*;
/**
 * Clase comparadora de Piloto por Total de Puntos.
 * Sirve para ordenar la lista de Pilotos
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (30/12/2020)
 */

public class CMPTotalPuntos implements Comparator <Piloto>
{
    public int compare (Piloto piloto1, Piloto piloto2){
        if (piloto1.getTotalPuntos() == piloto2.getTotalPuntos())
            return 0;
        else if (piloto1.getTotalPuntos() > piloto2.getTotalPuntos())
            return 1;
        else 
            return -1;
    }
}
