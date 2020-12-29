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
public class EscuderiaReal implements Escuderia
{
    private String nombre;
    private List <Piloto> pilotos;
    private List <Coche> coches;

    /**
     * Constructor de Escuderia
     */
    public EscuderiaReal(String nombre)
    {
        this.nombre = nombre;
        List <Piloto> pilotos    = new ArrayList <Piloto>();
        List <Coche>  coches     = new ArrayList <Coche>();
        
        //Asignar el orden de la lista
        //ver si hay que crear un campo comparator para establecer con qué criterio se ordena
        //en ese caso, habría que establecerlo en este constructor
        //Para saber si es ascendente o descendente, se puede usar un boolean
        
        //coches.sort([la mierda con la que haya que ordenar])
    }

    
    //FUNCIONALIDAD DE ESCUDERÍA
    /**
     * Se inscribe en el campeonato gestionado por la Organizacion
     */
    public void inscribirse()
    {
        //todo     
        //puede ser que sea añadiendo la escudería en el SET de Organizacion
    }
    
    /**
     * Ordena la lista de pilotos y coches según el criterio establecido
     */
    public void ordenarPilotosyCoches(/* criterio de ordenación*/)
    {
        //todo       
    }
    
    /**
     * Devuelve todos los puntos acumulados que tienen los pilotos de la Escuderia 
     *
     * @return     puntos totales de todos los Pilotos de la Escudería
     */
    public int getPuntosPilotosTotal()
    {
        int puntos = 0;
        for (Piloto pilot : pilotos){
            puntos += pilot.getTotalPuntos();
        }
        return puntos;
    }
    
    /**
     * Envía el primer piloto y el primer coche disponibles a la carrera
     * Controla también si un piloto no tiene coche disponible, en cuyo caso
     * el piloto no puede ser enviado, pero no cuenta como abandono
     * 
     * Se utiliza el patrón Strategy
     */
    public void enviarPilotoyCoche()
    {
        //todo      
        //condicional según si el piloto tiene coche o no
        //asignar el primer coche de la lista al primer piloto con:
        //      instanciaPiloto.asignarCoche(instanciaCoche);
        //  ver cómo hacer para no enviar el piloto sin que cuente como abandono
        
        //HAY QUE USAR EL PATRÓN STRATEGY AQUÍ (¿doblemente?)
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
    
    //METODOS AUXILIARES
    /**
     * Método sobreescrito  toString
     * @return Representacion de EscuderiaReal
     */
    @Override
    public String toString(){
        StringBuilder builder= new StringBuilder();
        builder.append(getNombre());
        builder.append('\n');
        builder.append(getCoches());
        builder.append('\n');
        builder.append(getPilotos());
        builder.append('\n');
        return builder.toString();
    }
    
    /**
     * Método sobreescrito equals
     * 
     * @param  obj Objeto con el que se quiere comparar la igualdad   
     * @return True si se cumple la igualdad, False en el caso contrario    
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj){ 
            return true;
        }
        if(!(obj instanceof EscuderiaReal)) {
            return false; 
        }
        
        EscuderiaReal other = (EscuderiaReal) obj;
        
        return getNombre().equals(other.getNombre()) &&
                getCoches().equals(other.getCoches()) &&
                getPilotos().equals(other.getPilotos());
    }
    
    /**
    * Metodo sobreescrito hashCode
    * 
    * @return hashCode que representa la clase
    */
    @Override
    public int hashCode(){
       int result=17;
       
       result = 7 * result + getNombre().hashCode();
       result = 13 * result + getCoches().hashCode();
       result = 17 * result + getPilotos().hashCode();
       return result;
    }
}
