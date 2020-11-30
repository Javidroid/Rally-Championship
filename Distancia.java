
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
        return getNombre() + "(Original" + getValor() + ")";
    }
}
