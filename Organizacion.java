
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
    
    
    //FUNCIONALIDAD DE ORGANIZACIÓN
    
    /**
     * Método que permite que las Escuderías se inscriban
     * 
     * 
     * 
     */
    public void inscribirEscuderia(Escuderia escuderia){
        //básicamente hay que llamar a este método desde escudería
        //para pasar todos los datos de la propia escudería y la clase organizadora ya
        //las va metiendo en la colección
    }
    
    /**
     * Método que gestiona las carreras del campeonato por cada circuito
     * Por cada Circuito, solicita a cada escudería que mande a sus pilotos (escuderia.enviarPiloto())
     * Los pilotos se incluyen por orden de pilotosCarrera hasta alcanzar el limitePilotos
     * 
     * Tiene que haber mínimo un piloto para que se pueda competir.
     * En este caso, se ordenarán los pilotos disponibles por puntos totales, carreras terminadas y nombre
     * Siguiendo el orden anterior, se pedirá a los pilotos que conduzcan (piloto.conducir())
     * 
     * Se mostrarán las características del piloto y coche que esté conduciendo en este momento
     * 
     * Al finalizar la iteración de pilotos, se procederá a asignarles los puntos correspondientes
     * 
     * Finalmente, se muestran los resultados obtenidos en la carrera y se devuelven
     * los pilotos a su escudería
     */
    public void celebrarCarrera(){
        //posibilidad de que sea aquí donde hay que mandar el map con piloto y su escudería
        
        //controlar con if que haya más de un piloto ¿variable de que el campeonato ha terminado?
        //ordenar con CMPResultadosPuntosTotalesPilotos
        
        //revisar el toString de piloto y coche para que muestre sus características (revisar plantilla)
        //revisar bien todo lo que hay que mostrar de cada piloto en el enunciado
        /*
         * ■   sus características
         * ■   las características de su coche
         * ■   la velocidad que es capaz de alcanzar en ese circuito con ese coche
         * ■   en caso de terminar la carrera:
         *      ●   el tiempo obtenido
         * ■   en caso de no terminar la carrera:
         *      ●   el motivo del abandono (pérdida de concentración o falta de combustible)
         *      ●   la cantidad de tiempo que le faltaba para finalizar la carrera
         *      ●   el tiempo que llevaba en carrera en el momento del abandono
         *      ●   si el piloto es descalificado por haber superado el límiteAbandonos de la Organización.
         * ■   el combustible que le queda al coche tras la carrera
         */

        //aquí se controla si al piloto se le descalifica o no mirando en el método propio de piloto
        
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
