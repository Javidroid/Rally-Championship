
/**
 * Esta clase representa las distintas Escuderías que compiten.
 * 
 * Compiten tanto porque alguno de sus Pilotos gane en el "apartado de Pilotos" (Piloto con más puntos)
 * como por ganar el "apartado de Escuderías" (Escudería con más puntos entre todos sus Pilotos)
 * 
 * Cada Escudería tiene una serie de Pilotos y Coches en exclusiva. Su labor es mantener un equipo
 * de Pilotos y Coches, enviando a cada carrera los que la clase Organización pida.
 * 
 * Cada instancia de Escudería se diferencia de otras por tener distintos criterios de ordenación
 * de las estructuras de sus Pilotos/Coches
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (27/11/2020)
 */
public class Escuderia
{
    private String nombre;
    //private ? <Piloto> pilotos;
    //private ? <Coche> coches;
  
    //hay que ver qué estructura (collection) seleccionar para almacenar pilotos y coches
    
    //nos están pidiendo que haya un orden así que habría que ver una lista, pero
    //tal vez usar un mapa para que la escudería asigne un piloto a un coche
    

    /**
     * Constructor de Escuderia
     */
    public Escuderia(String nombre)
    {
        // initialise instance variables
        this.nombre = nombre;
        
        //inicializar estructuras
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
