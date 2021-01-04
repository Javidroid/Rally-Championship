
import java.util.*;
/**
 * Clase comparadora de Circuito por Nombre.
 * Sirve para ordenar los circuitos al inicio del campeonato
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (04/01/2021)
 */

public class CMPNombreCircuito implements Comparator <Circuito>
{
    public int compare (Circuito c1, Circuito c2){
        return c1.getNombre().compareTo(c2.getNombre());
    }
}
