
import java.util.Comparator;
/**
 * Write a description of class ComparadorPuntosPiloto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class ComparadorResultadosPuntosTotalesPiloto implements Comparator <Piloto>
{
    public int compare (Piloto piloto1, Piloto piloto2){
        if (piloto1.getTotalPuntos() == piloto2.getTotalPuntos())
            return new ComparadorResultadosCarrerasTerminadasPiloto().compare(piloto1, piloto2);
        else if (piloto1.getTotalPuntos() > piloto2.getTotalPuntos())
            return 1;
        else 
            return -1;
        }
    
}
