
/**
 * ENUM de la Concentracion
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (30/11/2020)
 */
public enum Concentracion
{
    DESPISTADO  ("DESPISTADO", 90.0), 
    NORMAL      ("NORMAL", 100.0), 
    CONCENTRADO ("CONCENTRADO", 110.0),
    ZEN         ("ZEN", 120.0);
    
    private final String nombre;
    private final double valor;
    
    Concentracion(String nombre, double valor){
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
