
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

    //ArrayList porque requiere orden
    private List <Piloto>   pilotosCarrera;
    
    //HashMap para almacenar el valor de la escudería
    //Esta es una estructura auxiliar para almacenar la escudería a la que pertenece cada piloto
    private Map <Piloto, Escuderia> mapaPilotosEscuderia;
    /**
     * Constructor de Organizacion (privado por uso de Singleton)
     */
    private Organizacion()
    {
        circuitos            = new TreeSet <Circuito>();
        escuderias           = new HashSet <Escuderia>();
        pilotosCarrera       = new ArrayList <Piloto>();
        mapaPilotosEscuderia = new HashMap <Piloto, Escuderia>();
    }
    
    /**
     * Método de creación estático público para obtener la instancia
     * Singleton.
     * Es un método de clase, es decir, para invocarlo hay que usar el nombre
     * de la clase, y no el de la instancia.
     * 
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
     * Añade la escudería indicada por parámetro al set de escuderias
     * 
     * @param escuderia     La escudería que se desea añadir a la estructura
     * 
     */
    public void inscribirEscuderia(Escuderia escuderia){
        escuderias.add(escuderia);
        //aqui hay que hacer que cada escudería inscriba a sus pilotos en mapaPilotoEscuderia
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
     * 
     * param circuito   El circuito en el que se va a disputar la carrera
     */
    public void celebrarCarrera(Circuito circuito){
        //posibilidad de que sea aquí donde hay que mandar el map con piloto y su escudería
        
        //ordenar con CMPPuntosTotalesPilotos
        
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
        
        for (Escuderia escuderia : escuderias) {
            pilotosCarrera.add(escuderia.enviarPiloto());
        }
        Collections.sort(pilotosCarrera, new CMPPuntosTotalesPiloto());
        
    }
    
    /**
     * Método que maneja todo el transcurso de la competición una vez se insertan
     * todos los circuitos y escuderias.
     * 
     * Ordena y muestra los circuitos que componen el campeonato
     * Se muestran las escuderías que compiten, realiza las carreras con cada circuito
     * disponible de la estructura si no se produce una condición de finalización (no hay pilotos o solo queda uno)
     * 
     * Cuando finalicen los circuitos, se realiza la "Ceremonia de Entrega de Premios del Campeonato" donde
     * o se declarará desierto el torneo, o se proclama Piloto y Escudería campeón a aquellos que más puntos tengan
     * 
     * Siempre se muestran al final los pilotos sin descalificar, descalificados y escuderías junto sus resultados
     * 
     */
    public void celebrarCompeticion(){
        //todo
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
