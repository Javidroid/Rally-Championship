
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
public abstract class Piloto //esta clase es abstract
{
    protected String nombre;
    protected Coche cocheAsignado; //asignado por Escudería. Puede ser null y hay que mostrar mensaje
    protected Concentracion concentracion;
    protected double destreza; //este campo lo tiene que generar cada subclase 
    //private ? resultados; //Registro de tiempo y puntos en cada circuito que haya disputado una carrera
    protected boolean descalificado; //true si ha superado los abandonos permitidos por Organizacion
    /**
     * Constructor de Piloto
     */
    public Piloto(String nombre, Coche cocheAsignado, Concentracion concentracion)
    {
        this.nombre = nombre;
        this.cocheAsignado = cocheAsignado;
        this.concentracion = concentracion;
        //inicializar resultados
        descalificado = false;
        //destreza se inicializa en cada subclase
    }

    /**
     * Método abstracto que calcula la destreza según la concentracion y el tipo de piloto
     * Cada clase lo implementa de una forma distinta.
     * 
     * @return     Devuelve la destreza calculada y también la guarda en el campo destreza
     */
    public abstract double calcularDestreza();   
    
    
    
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
