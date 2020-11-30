import java.util.*;
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
    private List <Piloto> pilotos;
    private List <Coche> coches;
    //Revisar si la Collection es una lista (probablemente sí porque se requiere orden)
    //Hay que usar el Comparator para ordenar por distintos criterios

    /**
     * Constructor de Escuderia
     */
    public Escuderia(String nombre)
    {
        this.nombre = nombre;
        List <Piloto> pilotos   = new ArrayList <Piloto>();
        List <Coche> coches     = new ArrayList <Coche>();
    }

    
    //SETTERS
    /**
     * Setter de nombre
     * @param  nombre   Nuevo valor del campo nombre
     */
    private void setNombre(String nombre){this.nombre = nombre;}
    
    /**
     * Setter de pilotos
     * @param  pilotos   Nuevo valor del campo pilotos
     */
    private void setPilotos(List <Piloto> pilotos){this.pilotos = pilotos;}
    
    /**
     * Setter de coches
     * @param  coches   Nuevo valor del campo coches
     */
    private void setCoches(List <Coche> coches){this.coches = coches;}
    
    
    //GETTERS
    /**
     * Getter de nombre
     * @return   nombre
     */
    public String getNombre(){return nombre;}
    
    /**
     * Getter de pilotos
     * @return   pilotos
     */
    public List <Piloto> getPilotos(){return pilotos;}
    
    /**
     * Getter de coches
     * @return   coches
     */
    public List <Coche> getCoches(){return coches;}
    
    
    //FUNCIONALIDAD DE ESCUDERÍA
    /**
     * Se inscribe en el campeonato gestionado por la Organizacion
     */
    public void inscribirse()
    {
        //todo       
    }
    
    /**
     * Ordena la lista de pilotos y coches según el criterio establecido
     */
    public void ordenarPilotosyCoches()
    {
        //todo       
    }
    
    /**
     * Devuelve todos los puntos acumulados que tienen los pilotos de la Escuderia 
     *
     * @return     puntos totales
     */
    public int getPuntosPilotosTotal()
    {
        //todo
        return -1;        
    }
    
    /**
     * Envía el primer piloto y el primer coche disponibles a la carrera
     * Controla también si un piloto no tiene coche disponible, en cuyo caso
     * el piloto no puede ser enviado, pero no cuenta como abandono
     */
    public void enviarPilotoyCoche()
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
