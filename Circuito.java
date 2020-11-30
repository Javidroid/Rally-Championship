
/**
 * Representa los Circuitos donde los Pilotos compiten con sus Coches.
 * 
 * Cada instancia de Circuito se diferencia por características como la
 * complejidad y la distancia, que influirán directamente en el rendimiento
 * de cada Piloto y su Coche.
 * 
 * complejidad puede ser: BAJA  (1.0), INTERMEDIA (1.25) ó ALTA  (1.5).
 * distancia puede ser:   CORTA (250), INTERMEDIA (275)  ó LARGA (300).
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (27/11/2020)
 */
public class Circuito
{
    // Campos de cada circuito
    private String nombre;      //Nombre del circuito
    private Complejidad complejidad;  //ENUM: BAJA (1.0), MEDIA (1.25), ALTA (1.5)
    private Distancia distancia;      //ENUM: CORTA (250), INTERMEDIA (275), LARGA (300)

    /**
     * Constructor de Circuito
     */
    public Circuito(String nombre, Complejidad complejidad, Distancia distancia)
    {
        this.nombre = nombre;
        this.complejidad = complejidad;
        this.distancia = distancia;
    }

    /**
     * Muestra las características del circuito, incluyendo cada complicación
     * 
     * @return      Muestra por pantalla las características del circuito
     */
    public void mostrarCaracteristicas()
    {
        // put your code here
        
    }
    
    /**
     * Devuelve la complejidad del circuito
     * 
     * @return     Complejidad del circuito instanciado
     */
    public double getComplejidad(){
        return 1.25; //this.complejidad.getValor();
    }
    
    /**
     * Devuelve la distancia del circuito
     * 
     * @return     Distancia del circuito instanciado
     */
    public double getDistancia(){
        return 1.25; //this.distancia.getValor();
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
