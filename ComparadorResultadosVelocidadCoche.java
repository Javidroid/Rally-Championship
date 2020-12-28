
import java.util.*;
/**
 * Write a description of class ComparadorResultadosVelocidadCoche here.
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (28/12/2020)
 */
public class ComparadorResultadosVelocidadCoche implements Comparator <Coche>
{
    public int compare (Coche coche1, Coche coche2){
        if (coche1.getValorVelocidad() == coche2.getValorVelocidad())
            return (coche1.getNombre().compareTo(coche2.getNombre()));
        else if (coche1.getValorVelocidad() > coche2.getValorVelocidad())
            return 1;
        else 
            return -1;
    }
}
