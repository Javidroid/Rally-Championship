
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
    public Resultado(Circuito circuito, double tiempo, int puntos)
    {
        setCircuito(circuito);
        setTiempo(tiempo);
        setPuntos(puntos);
    }

    //SETTERS
    /**
     * Setter de circuito
     * @param  circuito   Nuevo valor del campo circuito
     */
    private void setCircuito(Circuito circuito){this.circuito = circuito;}
    
    /**
     * Setter de tiempo
     * @param  tiempo   Nuevo valor del campo tiempo
     */
    private void setTiempo(double tiempo){this.tiempo = tiempo;}

    /**
     * Setter de puntos
     * @param  puntos   Nuevo valor del campo puntos
     */
    private void setPuntos(int puntos){this.puntos = puntos;}
    
    //GETTERS
    /**
     * Getter de circuito
     * @return  circuito
     */
    public Circuito getCircuito(){return circuito;}
    
    /**
     * Getter de tiempo
     * @return  tiempo
     */
    public double getTiempo(){return tiempo;}
    
    /**
     * Getter de puntos
     * @return  puntos
     */
    public int getPuntos(){return puntos;}
}
