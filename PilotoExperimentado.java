
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
public class PilotoExperimentado extends Piloto
{
    //rellenar atributos necesarios
    /**
     * Constructor de PilotoExperimentado
     */
    public PilotoExperimentado(String nombre, Coche cocheAsignado, Concentracion concentracion)
    {
        //revisar
        super(nombre, cocheAsignado, concentracion);
        calcularDestreza();
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
        //double destreza;
        double concentracion = getConcentracion().getValor();
        this.destreza = ((concentracion + 3.0) / 130) * 1.03;
        return this.destreza;
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
