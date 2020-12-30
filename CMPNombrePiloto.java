import java.util.*;
/**
 * Clase comparadora de Piloto por Concentracion.
 * Sirve para ordenar la lista de Pilotos
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (30/12/2020)
 */

public class CMPNombrePiloto implements Comparator <Piloto>
{
    public int compare (Piloto piloto1, Piloto piloto2){
        return piloto1.getNombre().compareTo(piloto2.getNombre());
    }
}
