
/**
 * Subclase de Piloto: PilotoNovato.
 *
 * La diferencia con las demás subclases es la forma de calcular la destreza.
 * 
 * PilotoNovato calcula la destreza tal que: 
 *  destreza = ((concentración del piloto * 0.97) / 120 ) -  0.03; 
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (27/11/2020)
 */
public class PilotoNovato extends Piloto
{
    //rellenar atributos necesarios
    /**
     * Constructor de PilotoNovato
     */
    public PilotoNovato()
    {
        //revisar cómo se hace el constructor de una subclase
        
    }

    /**
     * Método abstracto que calcula la destreza según la concentracion y el tipo de piloto
     * Cada clase lo implementa de una forma distinta.
     * 
     * @return     Devuelve la destreza calculada y también la guarda en el campo destreza
     */
    @Override
    public float calcularDestreza(){
        //implementar
        float destreza = 0;//CUANDO SE CALCULE DESTREZA, QUITAR INICIALIZACIÓN
        //destreza = ((concentracion * 0.97) / 120) - 0.03;
        return destreza;
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
