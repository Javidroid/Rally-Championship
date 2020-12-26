
import java.util.Comparator;
/**
 * Write a description of class ComparadorResultadosTerminadosPiloto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class ComparadorResultadosCarrerasTerminadasPiloto implements Comparator<Piloto>
{
    
    public int compare (Piloto piloto1, Piloto piloto2){
        if (piloto1.getCarrerasTerminadas() == piloto2.getCarrerasTerminadas())
            return (piloto1.getNombre().compareTo(piloto2.getNombre()));
        else if (piloto1.getCarrerasTerminadas() > piloto2.getCarrerasTerminadas())
            return 1;
        else 
            return -1;
    }
}