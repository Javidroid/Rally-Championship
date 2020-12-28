
/**
 * Write a description of class ComparadorResultadosVelocidadCoche here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorResultadosVelocidadCoche
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
