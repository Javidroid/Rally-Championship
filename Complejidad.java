
/**
 * ENUM de la Complejidad
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (30/11/2020)
 */
public enum Complejidad
{
    BAJA ("BAJA", 1.0), 
    MEDIA ("MEDIA", 1.25), 
    ALTA ("ALTA", 1.5);
    
    private final String nombre;
    private final double valor;
    
    Complejidad(String nombre, double valor){
        this.nombre = nombre;
        this.valor = valor;
    }
    
    //HAY QUE HACER LOS SIGUIENTES MÉTODOS
    //getNombre()
    //getValor()
    //toString()
}
