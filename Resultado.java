
/**
 * Clase encargada de almacenar el resultado de un Piloto en un Circuito
 * Su verdadera funcionalidad viene en la List que tendrá el piloto
 * con todos sus resultados almacenados
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (01/12/2020)
 */
public class Resultado
{
    private Circuito circuito;
    private double tiempo;
    private int puntos;

    /**
     * Constructor for objects of class Resultado
     */
    public Resultado()
    {
        
    }

    //SETTERS
    /**
     * Setter de tiempo
     * @param  tiempo   Nuevo valor del campo tiempo
     */
    private void setTiempo(double tiempo){this.tiempo = tiempo;}
    
    //GETTERS
    /**
     * Getter de tiempo
     * @return  tiempo
     */
    public double getTiempo(){return tiempo;}
}
