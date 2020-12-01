import java.util.*;
/**
 * Interfaz que declara todos los métodos de Escuderia
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (01/12/2020)
 */

public interface Escuderia
{
    //GETTERS
    /**
     * Getter de nombre
     * @return   nombre
     */
    public String getNombre();
    
    /**
     * Getter de pilotos
     * @return   pilotos
     */
    public List <Piloto> getPilotos();
    
    /**
     * Getter de coches
     * @return   coches
     */
    public List <Coche> getCoches();
    
    
    //FUNCIONALIDAD DE ESCUDERÍA
    /**
     * Se inscribe en el campeonato gestionado por la Organizacion
     */
    public void inscribirse();
    
    /**
     * Ordena la lista de pilotos y coches según el criterio establecido
     */
    public void ordenarPilotosyCoches();
    
    /**
     * Devuelve todos los puntos acumulados que tienen los pilotos de la Escuderia 
     *
     * @return     puntos totales
     */
    public int getPuntosPilotosTotal();
    
    /**
     * Envía el primer piloto y el primer coche disponibles a la carrera
     * Controla también si un piloto no tiene coche disponible, en cuyo caso
     * el piloto no puede ser enviado, pero no cuenta como abandono
     */
    public void enviarPilotoyCoche();
}
