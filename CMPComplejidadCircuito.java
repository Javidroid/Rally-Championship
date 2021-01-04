
import java.util.*;
/**
 * Clase comparadora de Circuito por Complejidad.
 * Sirve para ordenar los circuitos al inicio del campeonato
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (04/01/2021)
 */

public class CMPComplejidadCircuito implements Comparator <Circuito>
{
    public int compare (Circuito c1, Circuito c2){
        if (c1.getValorComplejidad() == c2.getValorComplejidad())
            return 0;
        else if (c1.getValorComplejidad() > c2.getValorComplejidad())
            return 1;
        else 
            return -1;
    }
}
