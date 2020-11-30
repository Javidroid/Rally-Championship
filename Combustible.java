
/**
 * ENUM de la Combustible
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (30/11/2020)
 */
public enum Combustible
{
    ESCASO ("ESCASO", 350.0), 
    NORMAL ("NORMAL", 440.0), 
    GENEROSO ("GENEROSO", 460.0),
    ELEFANTE ("ELEFANTE", 480);
    
    private final String nombre;
    private final double valor;
    
    Combustible(String nombre, double valor){
        this.nombre = nombre;
        this.valor = valor;
    }
    
    //HAY QUE HACER LOS SIGUIENTES MÉTODOS
    //getNombre()
    //getValor()
    //toString()
}
