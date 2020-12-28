
import java.util.*;
/**
 * Write a description of class ComparadorResultadosCombustibleCoche here.
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (28/12/2020)
 */
public class ComparadorResultadosCombustibleCoche implements Comparator <Coche>
{
    public int compare (Coche coche1, Coche coche2){
        if (coche1.getValorCombustibleTotal() == coche2.getValorCombustibleTotal())
            return new ComparadorResultadosVelocidadCoche().compare(coche1, coche2);
        else if (coche1.getValorCombustibleTotal() > coche2.getValorCombustibleTotal())
            return 1;
        else 
            return -1;
        }
}
