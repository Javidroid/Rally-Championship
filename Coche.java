
/**
 * Esta clase representa los distintos Coches que los Pilotos pueden conducir en los Circuitos.
 * 
 * Cada instancia de Coche se diferencia por características como la
 * velocidad (teórica) y el combustible del Coche que influirán directamente en el rendimiento
 * de cada Piloto y su coche en cada Circuito.
 * 
 * velocidad puede ser:     TORTUGA (200.0), LENTA (210.0), NORMAL (220.0), RAPIDA (230.0) ó GUEPARDO (240.0)     
 * combustible puede ser:   ESCASO (350.0), NORMAL (440.0), GENEROSO (460.0) ó ELEFANTE (480.0)
 * 
 * Además, un coche puede ser una subclase: 
 * CocheRapido (con un campo nitro, que modifica velocidad)
 * CocheResistente (con un campo reserva, que modifica la forma de consumir combustible)
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (27/11/2020)
 */
public class Coche
{
    private String nombre;
    private Velocidad velocidad;
    private Combustible combustible;

    /**
     * Constructor de Coche
     */
    public Coche(String nombre, Velocidad velocidad, Combustible combustible)
    {
        this.nombre = nombre;
        this.velocidad = velocidad;
        this.combustible = combustible;
    }

    /**
     * Calcula la velocidad real del coche en función del piloto y la complejidad del circuito
     * 
     * @param  piloto       El piloto que conduce el coche
     * @param  circuito     El circuito en el que el coche compite (para usar la complejidad)
     * @return              Velocidad real del coche
     */
    public double calcularVelocidadReal(Piloto piloto, Circuito circuito)
    {
        // put your code here
        double velocidadReal = 0; //QUITAR INICIALIZACION
        //velocidadReal = (velocidad * piloto.destreza) / circuito.getComplejidad();
        return velocidadReal;
    }
    
    /**
     * Calcula el tiempo necesario para terminar la carrera según el piloto y el circuito
     * 
     * @param  piloto       El piloto que conduce el coche (para calcular la velocidad real)
     * @param  circuito     El circuito en el que el coche compite (para usar la distancia)
     * @return              Tiempo que tarda el coche en recorrer el circuito
     */
    public double calcularTiempoNecesario(Piloto piloto, Circuito circuito)
    {
        // put your code here
        double tiempo;
        double velocidadReal; 
        velocidadReal = calcularVelocidadReal(piloto, circuito);
        
        tiempo = circuito.getDistancia() / velocidadReal * 60;
        return tiempo;
    }
    
    /**
     * Reduce la cantidad de combustible que le queda en coche en función a lo que tarde
     * el piloto en el circuito indicado
     * 
     * @param  piloto       El piloto que conduce el coche (para calcular el tiempo)
     * @param  circuito     El circuito en el que el coche compite (para calcular el tiempo)
     */
    public void reducirCombustible(Piloto piloto, Circuito circuito)
    {
        double minutos;
        minutos = calcularTiempoNecesario(piloto, circuito);
        //this.combustible.getValor() = this.combustiblegetValor() - minutos;
    }
    
    
    
    /**
     * Descripción de lo que hace el método
     * 
     * @param  x   descripción de cada parámetro
     * @return     lo que devuelve, si devuelve xd
     */
    public void metodoPlantilla()
    {
        // put your code here
        
    }
}
