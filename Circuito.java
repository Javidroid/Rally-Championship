
/**
 * Interfaz que declara todos los métodos de Circuito
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (01/12/2020)
 */

public interface Circuito
{
    //GETTERS
    /**
     * Método que devuelve nombre
     * @return  nombre
     */
    public String getNombre();
    
    /**
     * Método que devuelve complejidad
     * @return  complejidad
     */
    public Complejidad getComplejidad();
    
    /**
     * Método que devuelve distancia
     * @return  distancia
     */
    public Distancia getDistancia();
    
    
    //FUNCIONALIDAD DE CIRCUITO
    /**
     * Muestra las características del circuito, incluyendo cada complicación
     * 
     * @return      Muestra por pantalla las características del circuito
     */
    public void mostrarCaracteristicas();
}
