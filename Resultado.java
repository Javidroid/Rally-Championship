
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
    public Resultado(Circuito circuito, double tiempo)
    {
        setCircuito(circuito);
        setTiempo(tiempo);
        setPuntos(-1); //Los puntos reales los tiene que asignar la clase Organizacion
                       //Inicializamos a -1 para indicar que aún no se ha asignado
                       //puntuación
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
    public void setPuntos(int puntos){this.puntos = puntos;}
    
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
    
    //METODOS AUXILIARES
    /**
     * Método sobreescrito  toString
     * @return Representacion de Resultado
     */
    @Override
    public String toString(){
        StringBuilder builder= new StringBuilder();
        builder.append("Carrera(");
        builder.append(getCircuito().getNombre());
        builder.append(") - Puntos:");
        builder.append(getPuntos());
        builder.append(" - Tiempo: ");
        builder.append(Math.round((getTiempo())*100d)/100d);
        builder.append(" minutos");
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
        if(!(obj instanceof Resultado)) {
            return false; 
        }
        
        Resultado other = (Resultado) obj;
        Double tiempoDouble = getTiempo();
        Integer puntosInteger = getPuntos();
        
        return getCircuito().equals(other.getCircuito()) &&
                tiempoDouble.equals(other.getTiempo()) &&
                puntosInteger.equals(other.getPuntos());
    }
    
    /**
    * Metodo sobreescrito hashCode
    * 
    * @return hashCode que representa la clase
    */
    @Override
    public int hashCode(){
       Double tiempoDouble = getTiempo();
       Integer puntosInteger = getPuntos();
       
       int result=17;
       
       result = 7 * result + getCircuito().hashCode();
       result = 13 * result + tiempoDouble.hashCode();
       result = 19 * result + puntosInteger.hashCode();
       return result;
    }
}
