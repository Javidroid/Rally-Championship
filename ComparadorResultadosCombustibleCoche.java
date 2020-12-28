
/**
 * Write a description of class ComparadorResultadosCombustibleCoche here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorResultadosCombustibleCoche
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
