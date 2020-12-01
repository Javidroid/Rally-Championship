
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
    public PilotoEstrella(String nombre, Coche cocheAsignado, Concentracion concentracion)
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
        double destreza;
        double concentracion = getConcentracion().getValor();
        destreza = (((concentracion + 6) / 140) * 1.06) + 0.05;
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
