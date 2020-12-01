
/**
 * Interfaz que declara todos los métodos de Piloto
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (01/12/2020)
 */

public interface Piloto
{
    //GETTERS
    /**
     * Método que devuelve nombre
     * @return  nombre
     */
    public String getNombre();
    
    /**
     * Método que devuelve cocheAsignado
     * @return  cocheAsignado
     */
    public Coche getCocheAsignado();
    
    /**
     * Método que devuelve concentracion
     * @return  concentracion
     */
    public Concentracion getConcentracion();
    
    /**
     * Método que devuelve descalificado
     * @return  descalificado
     */
    public boolean getDescalificado();
    
    
    //FUNCIONALIDAD DE PILOTO
    /**
     * Método abstracto que calcula la destreza según la concentracion y el tipo de piloto
     * Cada clase lo implementa de una forma distinta.
     */
    public abstract double calcularDestreza(); 
    
    /**
     * Descalifica al piloto instado. Pone el parámetro descalificado a true
     * 
     */
    public void descalificar();
        
    /**
     * Inserta el Coche que la Escuderia le de al Piloto para poder cambiarlo entre carrera y carrera
     * 
     * @param  coche   el coche que la escudería le proporcione
     */
    public void recibirCoche(Coche coche);
    
    /**
     * Gestiona y proporciona info sobre los resultados del piloto 
     * en cualquier circuito donde haya competido
     * 
     */
    public void infoResultados();
    
    /**
     * Devuelve los puntos que ha conseguido el piloto
     * en todas las carreras
     * 
     * @return Total de puntos
     */
    public int getTotalPuntos();
    
    /**
     * Gestiona todos los métodos necesarios para que el piloto
     * dispute una carrera 
     * 
     */
    public void conducir();
}
