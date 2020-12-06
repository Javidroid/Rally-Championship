
/**
 * Interfaz que declara todos los métodos de Coche
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (01/12/2020)
 */

public interface Coche
{
    //GETTERS
    /**
     * Método que devuelve nombre
     * @return  nombre
     */
    public String getNombre();
    
    /**
       * Método que devuelve velocidad (teórica)
     * @return  velocidad
     */
    public Velocidad getVelocidad();
    
    /**
       * Método que devuelve combustibleTotal
     * @return  combustibleTotal
     */
    public Combustible getCombustibleTotal();
    
    /**
     * Método que devuelve deposito
       * @return  deposito
     */
    public double getDeposito();
    
    //METODOS AUXILIARES
    /**
     * Método sobreescrito  toString
     * @return Representacion de CocheNormal
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
    
    //FUNCIONALIDADES DE COCHE    
    /**
     * Calcula la velocidad real del coche en función del piloto y la complejidad del circuito
       * 
     * @param  piloto       El piloto que conduce el coche
     * @param  circuito     El circuito en el que el coche compite (para usar la complejidad)
     * @return              Velocidad real del coche
     */
    public double calcularVelocidadReal(Piloto piloto, Circuito circuito);
    
    /**
     * Calcula el tiempo necesario para terminar la carrera según el piloto y el circuito
     * 
     * @param  piloto       El piloto que conduce el coche (para calcular la velocidad real)
       * @param  circuito     El circuito en el que el coche compite (para usar la distancia)
     * @return              Tiempo que tarda el coche en recorrer el circuito
     */
    public double calcularTiempoNecesario(Piloto piloto, Circuito circuito);
    
    /**
     * Reduce la cantidad de combustible que le queda en coche en función a lo que tarde
     * el piloto en el circuito indicado
     * 
     * @param  piloto       El piloto que conduce el coche (para calcular el tiempo)
     * @param  circuito     El circuito en el que el coche compite (para calcular el tiempo)
     */
    public void reducirCombustible(Piloto piloto, Circuito circuito);
    
    /**
     * Aumenta el depósito la cantidad indicada.
     * Actualmente sólo sirve para CocheResistente y su funcionalidad de
     * depósito de reserva. Pero podría servir para
     * futuras implementaciones
     * 
     * @param  cantidad   La cantidad que se AÑADE al depósito
     */
    public void repostar(double cantidad);
}