
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
     * Método que devuelve complejidad
     * @return  Valor de Complejidad
     */
    public double getValorComplejidad();
    
    
    /**
     * Método que devuelve distancia
     * @return  distancia
     */
    public Distancia getDistancia();
    
    /**
     * Método que devuelve distancia
     * @return  Valor de la Distancia
     */
    public double getValorDistancia();
    
    //METODOS AUXILIARES
    /**
     * Método sobreescrito  toString
     * @return Representacion de CircuitoReal
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

    
    //FUNCIONALIDAD DE CIRCUITO
    /**
     * Muestra las características del circuito, incluyendo cada complicación
     * 
     * @return      Muestra por pantalla las características del circuito
     */
    public void mostrarCaracteristicas();
}
