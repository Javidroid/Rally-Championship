import java.util.*;
/**
 * Clase comparadora de Piloto por Total de Carreras Participadas.
 * Sirve para ordenar la lista de Pilotos
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (30/12/2020)
 */

public class CMPCarrerasParticipadas implements Comparator <Piloto>
{
    public int compare (Piloto piloto1, Piloto piloto2){
        if (piloto1.getCarrerasParticipadas() == piloto2.getCarrerasParticipadas())
            return 0;
        else if (piloto1.getCarrerasParticipadas() > piloto2.getCarrerasParticipadas())
            return 1;
        else 
            return -1;
    }
}
