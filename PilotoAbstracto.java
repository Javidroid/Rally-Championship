
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
public abstract class PilotoAbstracto implements Piloto//esta clase es abstract
{
    protected String nombre;
    protected Coche cocheAsignado; //asignado por Escudería. Puede ser null y hay que mostrar mensaje
    protected Concentracion concentracion;
    //private List <Resultados> resultados; //Registro de tiempo y puntos en cada circuito que haya disputado una carrera
    //resultados es una lista de la clase resultado, que almacena lo necesario
    protected boolean descalificado; //true si ha superado los abandonos permitidos por Organizacion
    
    /**
     * Constructor de Piloto
     */
    public PilotoAbstracto(String nombre, Coche cocheAsignado, Concentracion concentracion)
    {
        setNombre(nombre);
        setCocheAsignado(cocheAsignado);
        setConcentracion(concentracion);
        //inicializar 'resultados' y hacer su get
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
     * 
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
