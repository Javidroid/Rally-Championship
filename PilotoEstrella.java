
import java.util.*;
/**
 * Subclase de Piloto: PilotoEstrella.
 *
 * La diferencia con las demás subclases es la forma de calcular la destreza.
 * 
 * PilotoEstrella calcula la destreza tal que: 
 *  destreza = (((concentración del piloto + 6) / 140) * 1.06) + 0.05; 
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (27/11/2020)
 */
public class PilotoEstrella extends PilotoAbstracto
{
    /**
     * Constructor de PilotoEstrella
     */
    public PilotoEstrella(String nombre, Concentracion concentracion)
    {
        //revisar
        super(nombre, concentracion);
    }
    
    
    /**
     * Método abstracto que calcula la destreza según la concentracion y el tipo de piloto
     * Cada clase lo implementa de una forma distinta.
     * 
     * @return     Devuelve la destreza calculada y también la guarda en el campo destreza
     */
    @Override
    public double calcularDestreza(){
        //implementar
        double destreza;
        double concentracion = getValorConcentracion();
        destreza = (((concentracion + 6) / 140) * 1.06) + 0.05;
        
        destreza = Math.round(destreza*100d) / 100d;
        
        return destreza;
    }
    
    //METODOS AUXILIARES
    /**
     * Método sobreescrito  toString
     * @return Representacion de PilotoEstrella
     */
    @Override
    public String toString(){
        StringBuilder builder= new StringBuilder();
        //<piloto:nombrePiloto> <tipo: tipoPiloto> <dest: destrezaPiloto> 
        //<conc: concentracionPiloto> <descalificado: booleano>
        builder.append("<piloto: ");
        builder.append(getNombre());
        builder.append("> ");
        builder.append("<tipo: estrella> ");
        builder.append("<dest: ");
        builder.append(calcularDestreza());
        builder.append("> ");
        builder.append("<conc: ");
        builder.append(getConcentracion());
        builder.append("> ");
        builder.append("<descalificado: ");
        builder.append(getDescalificado());
        builder.append(">");
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
        if(!(obj instanceof PilotoEstrella)) {
            return false; 
        }
        
        PilotoEstrella other = (PilotoEstrella) obj;
        
        return super.equals(other);
    }
    
    /**
    * Metodo sobreescrito hashCode
    * 
    * @return hashCode que representa la clase
    */
    @Override
    public int hashCode(){
       int result=17;
       
       result = 7 * result + super.hashCode();
       return result;
    }
}
