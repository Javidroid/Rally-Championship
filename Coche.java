
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
    private float velocidad;
    private float combustible;

    /**
     * Constructor de Coche
     */
    public Coche()
    {
        // initialise instance variables
        
        //usar el enum para velocidad y combustible
        
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
