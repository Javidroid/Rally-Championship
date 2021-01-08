
/**
 * ENUM de la Velocidad
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (30/11/2020)
 */
public enum Velocidad
{
    TORTUGA ("TORTUGA", 200.0), 
    LENTA ("LENTA", 210.0), 
    NORMAL ("NORMAL", 220.0),
    RAPIDO ("RAPIDO", 230.0),
    GUEPARDO ("GUEPARDO", 240.0); 
    
    private final String nombre;
    private final double valor;
    
    Velocidad(String nombre, double valor){
        this.nombre = nombre;
        this.valor = valor;
    }
    
    /**
     * Devuelve el atributo nombre 
     *
     * @return     Nombre
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Devuelve el atributo valor
     * 
     * @return     Valor
     */
    public double getValor()
    {
        return valor;
    }
    
    /**
     * Sobreescribe el metodo de String toString
     * 
     * @return     Representacion del Objeto 
     */
    @Override
    public String toString()
    {
        return getNombre() + "(" + getValor() + ")";
    }
}
