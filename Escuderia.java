import java.util.*;
/**
 * Interfaz que declara todos los métodos de Escuderia
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (01/12/2020)
 */

public interface Escuderia
{
    //FUNCIONALIDAD DE ESCUDERÍA
    /**
     * Se inscribe en el campeonato gestionado por la Organizacion
     */
    public void inscribirse();

    /**
     * Añade un Piloto a la plantilla de pilotos de la Escudería
     * 
     * @param piloto     Piloto que se quiere añadir a la lista
     */
    public void insertarPiloto(Piloto piloto);

    /**
     * Añade un Coche a la plantilla de coches de la Escudería
     * 
     * @param Coche      Coche que se quiere añadir a la lista
     */
    public void insertarCoche(Coche coche);

    /**
     * Ordena la lista de pilotos según el criterio establecido y de forma Ascendente (true) o Descendente
     * según ASCpiloto
     * 
     */
    public void ordenarPilotos();

    /**
     * Ordena la lista de coches según el criterio establecido y de forma Ascendente (true) o Descendente
     * según ASCcoche
     */
    public void ordenarCoches();

    /**
     * Devuelve todos los puntos acumulados que tienen los pilotos de la Escuderia 
     *
     * @return     puntos totales
     */
    public int getPuntosPilotosTotal();

    /**
     * Envía el primer piloto con el primer coche disponible asignado a la carrera
     * Controla también si un piloto no tiene coche disponible, en cuyo caso
     * el piloto no puede ser enviado, pero no cuenta como abandono
     * 
     * Si devuelve null, significa que la escudería no tiene pilotos disponibles
     * 
     * @return Piloto    Piloto que participa en la siguiente carrera
     */
    public Piloto enviarPiloto();

    /**
     * Método que devuelve true si aún quedan pilotos enviables por la escudería
     * 
     * @return true si hay pilotos, false si no
     */
    public boolean quedanPilotos();

    /**
     * Método que devuelve true si aún quedan coches asignables a pilotos por la escudería
     * 
     * @return true si hay coches, false si no
     */
    public boolean quedanCoches();

    //GETTERS
    /**
     * Método que devuelve nombre
     * @return   nombre
     */
    public String getNombre();

    /**
     * Método que devuelve pilotos
     * @return   pilotos
     */
    public List <Piloto> getPilotos();

    /**
     * Método que devuelve coches
     * @return   coches
     */
    public List <Coche> getCoches();

    /**
     * Getter de criterioPiloto
     * @return  CMPStrategyPiloto   criterioPiloto
     */
    public CMPStrategyPiloto getCriterioPiloto();

    /**
     * Getter de criterioCoche
     * @return  CMPStrategyCoche   criterioCoche
     */
    public CMPStrategyCoche getCriterioCoche();

    //GETTERS STRATEGY
    /**
     * Setter de criterioPiloto.    Público para poder elegir la estrategia.
     * @param  CMPStrategyPiloto   Nuevo valor del campo criterioPiloto
     */
    public void setCriterioPiloto(CMPStrategyPiloto criterio);

    /**
     * Setter de criterioCoche.     Público para poder elegir la estrategia.
     * @param  CMPStrategyCoche     Nuevo valor del campo criterioCoche
     */
    public void setCriterioCoche(CMPStrategyCoche criterio);

    /**
     * Setter de ASCpiloto.      Público para poder elegir la estrategia.
     * @param  ASCpiloto         Nuevo valor del campo ASCpiloto
     */
    public void setASCpiloto(boolean ASCpiloto);

    /**
     * Setter de ASCcoche.      Público para poder elegir la estrategia.
     * @param  ASCcoche         Nuevo valor del campo ASCcoche
     */
    public void setASCcoche(boolean ASCcoche);

    //METODOS AUXILIARES
    /**
     * Método sobreescrito  toString
     * @return Representacion de EscuderiaReal
     */
    @Override
    public String toString();

    /**
     * Método sobreescrito equals
     * 
     * @param  obj Objeto con el que se quiere comparar la igualdad   
     * @return True si se cumple la igualdad, False en el caso contrario    
     */
    @Override
    public boolean equals(Object obj);

    /**
     * Metodo sobreescrito hashCode
     * 
     * @return hashCode que representa la clase
     */
    @Override
    public int hashCode();
}