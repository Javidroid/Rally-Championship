
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
