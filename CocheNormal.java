
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
public class CocheNormal implements Coche
{
    private String nombre;
    private Velocidad velocidad; //esto es velocidad teórica
    private Combustible combustibleTotal;   //deposito lleno, combustible original, no es modificable
    private double deposito; //es variable con cada carrera, hasta que llega a 0
    
    //********************************************
    //REVISAR QUÉ SETTERS/GETTERS SE NECESITAN Y SI SON PUBLIC, PRIVATE, PROTECTED
    /**
     * Constructor de Coche
     */
    public CocheNormal(String nombre, Velocidad velocidad, Combustible combustibleTotal)
    {
        setNombre(nombre);
        setVelocidad(velocidad);
        setCombustibleTotal(combustibleTotal); 
        setDeposito(combustibleTotal.getValor());
    }

    
    //SETTERS
    /**
     * Setter de nombre
     * @param  nombre   Nuevo valor del campo nombre
     */
    private void setNombre(String nombre){this.nombre = nombre;}
    
    /**
     * Setter de velocidad
     * @param  velocidad   Nuevo valor del campo velocidad
     */
    private void setVelocidad(Velocidad velocidad){this.velocidad = velocidad;}
    
    /**
     * Setter de combustibleTotal
     * @param  combustibleTotal   Nuevo valor del campo combustibleTotal (que NO es variable)
     */
    private void setCombustibleTotal(Combustible combustibleTotal){this.combustibleTotal = combustibleTotal;}
    
    /**
     * Setter de deposito
     * @param  nuevoDeposito   Nuevo valor del campo deposito (que es variable)
     */
    private void setDeposito(double nuevoDeposito){deposito = nuevoDeposito;}
    
    
    //GETTERS
    /**
     * Getter de nombre
     * @return  nombre
     */
    public String getNombre(){return nombre;}
    
    /**
     * Getter de velocidad (teórica)
     * @return  velocidad
     */
    public Velocidad getVelocidad(){return velocidad;}
    
    /**
     * Getter de combustibleTotal
     * @return  combustibleTotal
     */
    public Combustible getCombustibleTotal(){return combustibleTotal;}
    
    /**
     * Getter de deposito
     * @return  deposito
     */
    public double getDeposito(){return deposito;}
    
    
    //FUNCIONALIDADES DE COCHE    
    /**
     * Calcula la velocidad real del coche en función del piloto y la complejidad del circuito
     * 
     * @param  piloto       El piloto que conduce el coche
     * @param  circuito     El circuito en el que el coche compite (para usar la complejidad)
     * @return              Velocidad real del coche
     */
    public double calcularVelocidadReal(Piloto piloto, Circuito circuito)
    {
        double velocidadReal;
        velocidadReal = (velocidad.getValor() * piloto.calcularDestreza()) / circuito.getComplejidad().getValor();
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
        double tiempo;
        double velocidadReal; 
        velocidadReal = calcularVelocidadReal(piloto, circuito);
        
        tiempo = circuito.getDistancia().getValor() / velocidadReal * 60;
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
        setDeposito(deposito-minutos);
    }
    
    /**
     * Aumenta el depósito la cantidad indicada.
     * Actualmente sólo sirve para CocheResistente y su funcionalidad de
     * depósito de reserva. Pero podría servir para
     * futuras implementaciones
     * 
     * @param  cantidad   La cantidad que se AÑADE al depósito
     */
    //La funcionalidad de este método podría sustituirse cambiando a 
    //protected el método setDeposito para que se pueda modificar desde
    //CocheResistente directamente, pero podría romper un poco la 
    //encapsulación
    public void repostar(double cantidad)
    {
        setDeposito(deposito+cantidad);
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
