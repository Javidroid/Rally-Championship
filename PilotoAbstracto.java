import java.util.*;
/**
 * Esta clase representa los distintos Pilotos que compiten con sus Coches en el Circuito
 * 
 * Cada instancia de Piloto se diferencia por la distinta concentracion. Esta característica
 * influye de diversas formas en el rendimiento del Piloto y su Coche en cada Circuito.
 * 
 * concentracion puede ser: DESPISTADO (90.0), NORMAL (100.0), CONCENTRADO (110.0) ó ZEN (120.0)
 * 
 * Piloto es una clase abstracta. 
 * Cada piloto puede ser PilotoNovato, PilotoExperimentado ó PilotoEstrella.
 * La diferencia entre estas subclases son la forma de calcular la destreza
 * 
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (27/11/2020)
 */
public abstract class PilotoAbstracto implements Piloto//esta clase es abstracta
{
    private String nombre;
    private Coche cocheAsignado; //asignado por Escudería. Puede ser null y hay que mostrar mensaje
    private Concentracion concentracion;
    private List <Resultado> resultados; //Registro de tiempo y puntos en cada circuito que haya disputado una carrera
    //resultados es una lista de la clase resultado, que almacena lo necesario
    private boolean descalificado; //true si ha superado los abandonos permitidos por Organizacion
    
    /**
     * Constructor de Piloto
     */
    public PilotoAbstracto(String nombre, Coche cocheAsignado, Concentracion concentracion)
    {
        setNombre(nombre);
        setCocheAsignado(cocheAsignado);
        setConcentracion(concentracion);
        List <Resultado> resultados = new ArrayList <Resultado>();
        setDescalificado(false);
    }

    
    //SETTERS
    /**
     * Setter de nombre
     * @param  nombre   Nuevo valor del campo nombre
     */
    private void setNombre(String nombre){this.nombre = nombre;}
    
    /**
     * Setter de cocheAsignado
     * @param  cocheAsignado   Nuevo valor del campo cocheAsignado
     */
    private void setCocheAsignado(Coche cocheAsignado){this.cocheAsignado = cocheAsignado;}
    
    /**
     * Setter de concentracion
     * @param  concentracion   Nuevo valor del campo concentracion
     */
    private void setConcentracion(Concentracion concentracion){this.concentracion = concentracion;}
    
    /**
     * Setter de resultados
     * @param  resultados   Nuevo valor del campo resultados (es un ARRAYLIST)
     */
    private void setListaResultados(List <Resultado> resultados){this.resultados = resultados;}
    
    /**
     * Setter de descalificado
     * @param  descalificado   Nuevo valor del campo descalificado
     */
    private void setDescalificado(boolean descalificado){this.descalificado = descalificado;}
    
    
    //GETTERS
    /**
     * Getter de nombre
     * @return  nombre
     */
    public String getNombre(){return nombre;}
    
    /**
     * Getter de cocheAsignado
     * @return  cocheAsignado
     */
    public Coche getCocheAsignado(){return cocheAsignado;}
    
    /**
     * Getter de concentracion
     * @return  concentracion
     */
    public Concentracion getConcentracion(){return concentracion;}
    /**
     * Método que devuelve el valor de concentracion
     * @return  double  valor de concentracion
     */
    public double getValorConcentracion(){return concentracion.getValor();}
    
    /**
     * Getter de resultados
     * @return  resultados  (es un ARRAYLIST)
     */
    public List <Resultado> getListaResultados(){return resultados;}
    
    /**
     * Getter de descalificado
     * @return  descalificado
     */
    public boolean getDescalificado(){return descalificado;}
    
    
    //FUNCIONALIDAD DE PILOTO
    /**
     * Método abstracto que calcula la destreza según la concentracion y el tipo de piloto
     * Cada clase lo implementa de una forma distinta.
     */
    public abstract double calcularDestreza();   
    
    /**
     * Descalifica al piloto instado. Pone el parámetro descalificado a true
     */
    public void descalificar()
    {
        setDescalificado(true);        
    }
        
    /**
     * Inserta el Coche que la Escuderia le de al Piloto para poder cambiarlo entre carrera y carrera
     * 
     * @param  coche   el coche que la escudería le proporcione
     */
    public void recibirCoche(Coche coche)
    {
        setCocheAsignado(coche);   
    }
    
    /**
     * Devuelve el tiempo que el piloto ha conseguido en el 
     * circuito dado por parámetro
     * 
     * return double tiempo que ha tardado en acabar el circuito
     */
    public double getTiempoEnCircuito(Circuito circuito){
        boolean encontrado = false;
        double tiempo = -1; //-1 en caso de que el piloto no haya competido en ese circuito
        Iterator<Resultado> it = resultados.iterator();
        while (!encontrado && it.hasNext()){
            Resultado res = it.next();
            if(res.getCircuito().equals(circuito)){
                encontrado = true;
                tiempo = res.getTiempo();
            }
        }
        return tiempo;
    }
    
    /**
     * Pone los puntos que la clase Organizacion le asigne
     * según el tiempo conseguido entre todos los pilotos
     * 
     */
    public void setPuntosEnCircuito(Circuito circuito, int puntos){
        boolean encontrado = false;
        Iterator<Resultado> it = resultados.iterator();
        while (!encontrado && it.hasNext()){
            Resultado res = it.next();
            if(res.getCircuito().equals(circuito)){
                encontrado = true;
                res.setPuntos(puntos);
            }
        }
    }
       
    
    /**
     * Devuelve los puntos que ha conseguido el piloto
     * en todas las carreras
     * 
     * @return Total de puntos
     */
    public int getTotalPuntos(){
        int puntos = 0;
        for (Resultado result: resultados){
            if(result.getPuntos() != -1){ //Si puntos -1 es porque no se han asignado
                puntos += result.getPuntos();
            }
        }
        return puntos;
    }
    
    /**
     * Devuelve el nº de carreras (terminadas o no) en las que
     * ha participado el Piloto
     * 
     * @return Nº de carreras participadas
     */
    public int getCarrerasParticipadas(){
        int carreras;
        carreras = resultados.size();
        return carreras;
    }
    
    /**
     * Devuelve el nº de carreras que el Piloto ha terminado
     * 
     * @return Nº de carreras terminadas
     */
    public int getCarrerasTerminadas(){
        int terminadas = 0;
        for (Resultado result: resultados){
            if(result.getTiempo() >= 0){
                terminadas++;
            }
        }
        return terminadas;
    }
    
    /**
     * Devuelve el nº de carreras que el Piloto ha abandonado
     * 
     * @return Nº de carreras abandonadas
     */
    public int getCarrerasAbandonadas(){
        int abandonadas = 0;
        for (Resultado result: resultados){
            if(result.getTiempo() < 0){
                abandonadas++;
            }
        }
        return abandonadas;
    }
    
    /**
     * Gestiona todos los métodos necesarios para que el piloto
     * dispute una carrera 
     * 
     */
    public void conducir(){
        
    }
    
    
    //METODOS AUXILIARES
    /**
     * Método sobreescrito  toString
     * @return Representacion de PilotoAbstracto
     */
    @Override
    public String toString(){
        StringBuilder builder= new StringBuilder();
        builder.append(getNombre());
        builder.append('\n');
        builder.append(getTotalPuntos());
        builder.append('\n');
        builder.append(getCocheAsignado());
        builder.append('\n');
        builder.append(getConcentracion());
        builder.append('\n');
        builder.append(getListaResultados());
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
        if(!(obj instanceof PilotoAbstracto)) {
            return false; 
        }
        
        PilotoAbstracto other = (PilotoAbstracto) obj;
        
        return getNombre().equals(other.getNombre()) &&
                getCocheAsignado().equals(other.getCocheAsignado()) &&
                getConcentracion().equals(other.getConcentracion()) &&
                getListaResultados().equals(other.getListaResultados());
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
       result = 13 * result + getCocheAsignado().hashCode();
       result = 17 * result + getConcentracion().hashCode();
       result = 23 * result + getListaResultados().hashCode();
       return result;
    }
}
