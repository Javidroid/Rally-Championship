import java.util.*;
/**
 * Clase comparadora de Escuderia por Puntos Totales de sus pilotos
 * Sirve para ordenar la lista de Escuderias
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (07/01/2021)
 */

public class CMPPuntosEscuderia implements Comparator <Escuderia>
{
    public int compare (Escuderia e1, Escuderia e2){
        if (e1.getPuntosPilotosTotal() == e2.getPuntosPilotosTotal())
            return new CMPCarrerasTermEscuderia().compare(e1, e2);
        else if (e1.getPuntosPilotosTotal() > e2.getPuntosPilotosTotal())
            return 1;
        else 
            return -1;
    }
}
