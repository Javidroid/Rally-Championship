
/**
 * ENUM de la Distancia
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (30/11/2020)
 */
public enum Distancia
{
    CORTA ("CORTA", 250.0), 
    INTERMEDIA ("INTERMEDIA", 275.0), 
    LARGA ("LARGA", 300.0);
    
    private final String nombre;
    private final double valor;
    
    Distancia(String nombre, double valor){
        this.nombre = nombre;
        this.valor = valor;
    }
}
