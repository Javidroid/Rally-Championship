
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
     * @return  String nombre
     */
    public String getNombre();
    
    /**
     * Método que devuelve velocidad (teórica)
     * @return  Velocidad velocidad
     */
    public Velocidad getVelocidad();
    /**
     * Método que devuelve el valor de velocidad (teórica)
     * @return  double Valor de velocidad
     */
    public double getValorVelocidad();
    
    /**
     * Método que devuelve el valor de combustibleTotal
     * @return  Combustible combustibleTotal
     */
    public Combustible getCombustibleTotal();
    /**
     * Método que devuelve el valor de combustibleTotal
     * @return  double valor de combustibleTotal
     */
    public double getValorCombustibleTotal();
    
    /**
     * Método que devuelve deposito
     * @return  double deposito
     */
    public double getDeposito();
    
    
    //FUNCIONALIDADES DE COCHE    
    /**
     * Calcula la velocidad real del coche en función del piloto y la complejidad del circuito
       * 
     * @param  piloto       El piloto que conduce el coche
     * @param  circuito     El circuito en el que el coche compite (para usar la complejidad)
     * @return              double Velocidad real del coche
     */
    public double calcularVelocidadReal(Piloto piloto, Circuito circuito);
    
    /**
     * Muestra por pantalla la velocidad real base del coche (sin tener en cuenta si es rapido)
     * 
     * @param  piloto       El piloto que conduce el coche
     * @param  circuito     El circuito en el que el coche compite (para usar la complejidad)
     * @return              double Velocidad real del coche
     */
    public void imprimirVelocidadReal(Piloto piloto, Circuito circuito);
    
    /**
     * Calcula el tiempo necesario para terminar la carrera según el piloto y el circuito
     * 
     * @param  piloto       El piloto que conduce el coche (para calcular la velocidad real)
     * @param  circuito     El circuito en el que el coche compite (para usar la distancia)
     * @return              double Tiempo que tarda el coche en recorrer el circuito
     */
    public double calcularTiempoNecesario(Piloto piloto, Circuito circuito);
    
    /**
     * Reduce la cantidad de combustible indicada por parámetro.
     * Controlado por piloto en el método conducir. Puede reducir el combustible necesario
     * para un circuito, o el combustible usado antes de abandonar por concentracion o combustible.
     * 
     * @param  double cantidad: la cantidad de combustible que hay que reducir
     */
    public void reducirCombustible(double cantidad);
    
    /**
     * Método que devuelve cómo quedaría el depósito si se aplicase la reducción de combustible
     * Pero no lo modifica
     * Sirve principalmente para, en el método Piloto.conducir(), controlar el caso en el que se use la reserva
     * y además se quede sin concentración el piloto (para reducir la concentración y no el total)
     * 
     * @param  double cantidad: la cantidad de combustible que hay que reducir
     */
    public double calcularReduccionCombustible(double cantidad);
    
    /**
     * Aumenta el depósito la cantidad indicada.
     * Actualmente sólo sirve para CocheResistente y su funcionalidad de
     * depósito de reserva. Pero podría servir para
     * futuras implementaciones
     * 
     * @param  cantidad   La cantidad que se AÑADE al depósito
     */
    public void repostar(double cantidad);
    
    
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
}