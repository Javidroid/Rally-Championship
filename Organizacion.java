
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
    //private ? <Circuito> circuitos; //una estructura que almacene los circuitos
    //private ? <Escuderia> escuderias; //probablemente set porque no puede haber duplicados
    //private ? <Piloto> pilotosCarrera; //Probablemente una lista porque van ordenados
   
    /**
     * Constructor de Organizacion (privado por uso de Singleton
     */
    private Organizacion()
    {
        // initialise instance variables
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
}
