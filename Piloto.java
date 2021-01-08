
import java.util.*;
/**
 * Interfaz que declara todos los métodos de Piloto
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (01/12/2020)
 */

public interface Piloto
{
    //GETTERS (de los campos de Piloto)
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
     * Método que devuelve el valor de concentracion
     * @return  double  valor de concentracion
     */
    public double getValorConcentracion();
    
    /**
     * Método que devuelve resultados
     * @return  resultados  (es un ARRAYLIST)
     */
    public List <Resultado> getListaResultados();
    
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
     * Pone a NULL el cocheAsignado al piloto para tenerlo listo para la siguiente carrera
     * 
     * @return  Coche   el coche que el piloto le tenga que devolver a la escuderia
     * 
     */
    public Coche devolverCoche();
    
    /**
     * Devuelve el tiempo que el piloto ha conseguido en el 
     * circuito dado por parámetro
     * 
     * return double tiempo que ha tardado en acabar el circuito
     */
    public double getTiempoEnCircuito(Circuito circuito);
    
    /**
     * Devuelve los puntos que el piloto ha conseguido en el 
     * circuito dado por parámetro
     * 
     * return int  Puntos que ha conseguido el piloto en la carrera
     */
    public int getPuntosEnCircuito(Circuito circuito);
    
    /**
     * Pone los puntos que la clase Organizacion le asigne
     * según el tiempo conseguido entre todos los pilotos
     * 
     */
    public void setPuntosEnCircuito(Circuito circuito, int puntos);
    
    /**
     * Devuelve los puntos que ha conseguido el piloto
     * en todas las carreras
     * 
     * @return Total de puntos
     */
    public int getTotalPuntos();
    
    /**
     * Devuelve el nº de carreras (terminadas o no) en las que
     * ha participado el Piloto
     * 
     * @return Nº de carreras participadas
     */
    public int getCarrerasParticipadas();
    
    /**
     * Devuelve el nº de carreras que el Piloto ha terminado
     * 
     * @return Nº de carreras terminadas
     */
    public int getCarrerasTerminadas();
    
    /**
     * Devuelve el nº de carreras que el Piloto ha abandonado
     * 
     * @return Nº de carreras abandonadas
     */
    public int getCarrerasAbandonadas();
    
    /**
     * Devuelve el tiempo obtenido en el último resultado del Piloto
     * Esto sirve para que la clase Organización pueda ordenarlos por puntos
     * 
     * @return Tiempo del ultimo resultado
     */
    public double getTiempoUltimoResultado();
    
    /**
     * Gestiona todos los métodos necesarios para que el piloto
     * dispute una carrera 
     * 
     */
    public void conducir(Circuito circuito);    
    
    //METODOS AUXILIARES
    /**
     * Método sobreescrito  toString
     * @return Representacion de PilotoAbstracto
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
