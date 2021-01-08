import java.util.*;
/**
 * Clase comparadora de Escuderia por Carerras Terminadas de sus pilotos
 * Sirve para ordenar la lista de Escuderias
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (07/01/2021)
 */

public class CMPCarrerasTermEscuderia implements Comparator <Escuderia>
{
    public int compare (Escuderia e1, Escuderia e2){
        if (e1.getCarrerasTerminadasPilotos() == e2.getCarrerasTerminadasPilotos())
            return e1.getNombre().compareTo(e2.getNombre());
        else if (e1.getCarrerasTerminadasPilotos() > e2.getCarrerasTerminadasPilotos())
            return 1;
        else 
            return -1;
    }
}
