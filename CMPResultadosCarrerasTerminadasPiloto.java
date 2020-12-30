
import java.util.*;
/**
 * Clase comparadora de Piloto por Puntos Totales.
 * Sirve para ordenar los resultados finales
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (28/12/2020)
 */

public class CMPResultadosCarrerasTerminadasPiloto implements Comparator<Piloto>
{
    public int compare (Piloto piloto1, Piloto piloto2){
        if (piloto1.getCarrerasTerminadas() == piloto2.getCarrerasTerminadas())
            return (piloto1.getNombre().compareTo(piloto2.getNombre()));
        else if (piloto1.getCarrerasTerminadas() > piloto2.getCarrerasTerminadas())
            return 1;
        else 
            return -1;
    }
}