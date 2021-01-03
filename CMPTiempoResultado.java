
import java.util.*;
/**
 * Clase comparadora de Resultado por Tiempo.
 * Sirve para asignar puntos
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (03/01/2021)
 */

public class CMPTiempoResultado implements Comparator <Piloto>
{
    public int compare (Piloto piloto1, Piloto piloto2){
        if (piloto1.getTiempoUltimoResultado() == piloto2.getTiempoUltimoResultado())
            return 0;
        else if (piloto1.getTiempoUltimoResultado() > piloto2.getTiempoUltimoResultado())
            return 1;
        else 
            return -1;
    }
}
