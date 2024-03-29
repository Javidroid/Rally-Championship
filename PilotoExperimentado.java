
/**
 * Subclase de Piloto: PilotoExperimentado.
 *
 * La diferencia con las demás subclases es la forma de calcular la destreza.
 * 
 * PilotoExperimentado calcula la destreza tal que: 
 *  destreza = ((concentración del piloto + 3) / 130) * 1.03; 
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (27/11/2020)
 */
public class PilotoExperimentado extends PilotoAbstracto
{
    /**
     * Constructor de PilotoExperimentado
     */
    public PilotoExperimentado(String nombre, Concentracion concentracion)
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
        double concentracion = Math.round(getValorConcentracion() *100d)/100d;
        destreza = ((concentracion + 3.0) / 130) * 1.03;
        
        destreza = Math.round(destreza*100d) / 100d;
        
        return destreza;
    }
    
    
    //METODOS AUXILIARES
    /**
     * Método sobreescrito  toString
     * @return Representacion de PilotoNovato
     */
    @Override
    public String toString(){
        return super.toString();
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
        if(!(obj instanceof PilotoExperimentado)) {
            return false; 
        }
        
        PilotoExperimentado other = (PilotoExperimentado) obj;
        
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
