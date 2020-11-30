
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
    private String nombre;      //Nombre del circuito
    private Complejidad complejidad;  //ENUM: BAJA (1.0), MEDIA (1.25), ALTA (1.5)
    private Distancia distancia;      //ENUM: CORTA (250), INTERMEDIA (275), LARGA (300)

    //********************************************
    //REVISAR QUÉ SETTERS/GETTERS SE NECESITAN Y SI SON PUBLIC, PRIVATE, PROTECTED
    /**
     * Constructor de Circuito
     */
    public Circuito(String nombre, Complejidad complejidad, Distancia distancia)
    {
        setNombre(nombre);
        setComplejidad(complejidad);
        setDistancia(distancia);
    }
    
    //SETTERS
    /**
     * Setter de nombre
     * @param  nombre   Nuevo valor del campo nombre
     */
    private void setNombre(String nombre){this.nombre = nombre;}
    
    /**
     * Setter de complejidad
     * @param  complejidad   Nuevo valor del campo complejidad
     */
    private void setComplejidad(Complejidad complejidad){this.complejidad = complejidad;}
    
    /**
     * Setter de distancia
     * @param  distancia   Nuevo valor del campo distancia
     */
    private void setDistancia(Distancia distancia){this.distancia = distancia;}
    
    
    //GETTERS
    /**
     * Getter de nombre
     * @return  nombre
     */
    public String getNombre(){return nombre;}
    
    /**
     * Getter de complejidad
     * @return  complejidad
     */
    public Complejidad getComplejidad(){return complejidad;}
    
    /**
     * Getter de distancia
     * @return  distancia
     */
    public Distancia getDistancia(){return distancia;}
    
    
    //FUNCIONALIDAD DE CIRCUITO
    /**
     * Muestra las características del circuito, incluyendo cada complicación
     * 
     * @return      Muestra por pantalla las características del circuito
     */
    public void mostrarCaracteristicas()
    {
        //todo
        
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
