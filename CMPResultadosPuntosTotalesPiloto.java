
import java.util.*;
/**
 * Clase comparadora de Piloto por Puntos Totales.
 * Sirve para ordenar los resultados finales
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (28/12/2020)
 */

public class CMPResultadosPuntosTotalesPiloto implements Comparator <Piloto>
{
    public int compare (Piloto piloto1, Piloto piloto2){
        if (piloto1.getTotalPuntos() == piloto2.getTotalPuntos())
            return new CMPResultadosCarrerasTerminadasPiloto().compare(piloto1, piloto2);
        else if (piloto1.getTotalPuntos() > piloto2.getTotalPuntos())
            return 1;
        else 
            return -1;
    }
}
