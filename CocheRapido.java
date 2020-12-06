
/**
 * Write a description of class CocheRapido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CocheRapido extends CocheNormal
{
    private double nitro;

   /**
     * Constructor for objects of class CocheRapido
     */
    public CocheRapido(String nombre, Velocidad velocidad, Combustible combustible)
    {
        super(nombre, velocidad, combustible);
        nitro = 80.0;
    }

   /**
     * Calcula la velocidad real del CocheRapido en función del piloto y la complejidad del circuito
     * También varía según el nitro restante.
     * 
     * @param  piloto       El piloto que conduce el coche
     * @param  circuito     El circuito en el que el coche compite
     * @return              Velocidad real del coche
     */
    @Override
    public double calcularVelocidadReal(Piloto piloto, Circuito circuito)
    {
        double velocidadNitro;
        double diferencia;
        velocidadNitro = super.calcularVelocidadReal(piloto, circuito);
        
        if(nitro > 0){
            diferencia = velocidadNitro*1.2 - velocidadNitro;
            if(diferencia > nitro){ //no hay suficiente nitro para aumentar 20%
                velocidadNitro += nitro;
                nitro -= nitro; //nitro = 0;
            }
            else{
                velocidadNitro += diferencia;
                nitro -= diferencia;
            }
        }
        
        return velocidadNitro;
    }
    
    
    //SETTERS
    /**
     * Setter de nitro
     * 
     * @param nitro Nuevo valor del campo nitro
     */
    public void setNitro(double nitro){
        this.nitro=nitro;
    }
    
    //GETTERS
    /**
     * Getter de nitro 
     * 
     * @return nitro
     */
    public double getNitro(){
        return nitro;
    }
    
    //METODOS AUXILIARES
    /**
     * Método sobreescrito  toString
     * @return Representacion de CocheRapido
     */
    @Override
    public String toString(){
        StringBuilder builder= new StringBuilder();
        builder.append(getNitro());
        builder.append('\n');
        builder.append(super.toString());
        return builder.toString();
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
        if(!(obj instanceof CocheRapido)) {
            return false; 
        }
        
        CocheRapido other = (CocheRapido) obj;
        Double nitroDouble = getNitro();
        
        return super.equals(other) &&
               nitroDouble.equals(other.getNitro());
    }
    
    /**
    * Metodo sobreescrito hashCode
    * 
    * @return hashCode que representa la clase
    */
   @Override
   public int hashCode(){
       Double nitroDouble = getNitro();
       
       int result=17;
       
       result = 7 * result + super.hashCode();
       result = 13 * result + nitroDouble.hashCode();
       return result;
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
