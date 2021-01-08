
import java.util.*;
/**
 * Clase comparadora de Circuito por Distancia.
 * Sirve para ordenar los circuitos al inicio del campeonato
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (04/01/2021)
 */

public class CMPDistanciaCircuito implements Comparator <Circuito>
{
    public int compare (Circuito c1, Circuito c2){
        if (c1.getValorDistancia() == c2.getValorDistancia())
            return new CMPComplejidadCircuito().compare(c1, c2);
        else if (c1.getValorDistancia() > c2.getValorDistancia())
            return 1;
        else 
            return -1;
    }
}
