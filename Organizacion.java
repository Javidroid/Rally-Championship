
import java.util.*;
/**
 * Esta clase es la "principal" ya que es la que gestiona y controla todas las competiciones.
 * De esta clase sólo puede existir una instancia
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (27/11/2020)
 */
public class Organizacion
{
    private static Organizacion instancia; //singleton
    
    private int limiteAbandonos;
    private int limitePilotos;
    
    //TreeSet porque los Circuitos son únicos y tienen orden.
    //Este orden es estático: se asigna al inicio y no se modifica en RunTime
    private Set <Circuito> circuitos;    
    
    //HashSet porque no se repiten ni tienen orden.
    private Set <Escuderia> escuderias;  
    
    //HashMap para que cada Piloto nunca pierda su Escudería y la tenga siempre asignada
    //Habría que hacer un método getKey y getValue
    private Map <Piloto, Escuderia> pilotosCarrera;
    /**
     * Constructor de Organizacion (privado por uso de Singleton)
     */
    private Organizacion()
    {
        circuitos       = new TreeSet <Circuito>();
        escuderias      = new HashSet <Escuderia>();
        pilotosCarrera  = new HashMap <Piloto, Escuderia>();
    }
    
    /**
     * Método de creación estático público para obtener la instancia
     * Singleton
     * @return  única instancia de Organization
     */
    public synchronized static Organizacion getInstancia(){
        if (instancia == null){
            instancia = new Organizacion();
        }
        return instancia;
    }
    
    //SETTERS
    /**
     * Setter de limiteAbandonos
     * @param    limiteAbandonos    Nuevo valor del campo limiteAbandonos
     */
    public void setLimiteAbandonos(int limAband){limiteAbandonos = limAband;}
    /**
     * Setter de limitePilotos
     * @param    limitePilotos      Nuevo valor del campo limitePilotos
     */
    public void setLimitePilotos(int limPilot){limitePilotos = limPilot;}
    
    
    //GETTERS
    /**
     * Getter de limiteAbandonos
     * @return   limiteAbandonos
     */
    public int getLimiteAbandonos(){return limiteAbandonos;}
    /**
     * Getter de limitePilotos
     * @return   limitePilotos
     */
    public int getLimitePilotos()  {return limitePilotos;}
}
