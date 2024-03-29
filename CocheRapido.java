
/**
 * Esta clase representa la posibilidad de que un coche sea CocheResistente. 
 * 
 * Estos coches se caracterizan por tener un depósito de 80 litros de nitro, 
 * un compuesto químico que es capaz de aportar un extra de velocidad a los 
 * coches de este tipo. 
 * 
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (27/11/2020)
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
        setNitro(80.0);
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
        double velocidadNitro; //la velocidad que alcanza con el nitro
        double aumento;        //el aumento de nitro que usa
        velocidadNitro = super.calcularVelocidadReal(piloto, circuito);

        if(nitro > 0){
            aumento = velocidadNitro*1.2 - velocidadNitro;

            if(aumento > nitro){ //no hay suficiente nitro para aumentar 20%
                aumento = nitro; //solo se aumenta la nitro restante
            }

            velocidadNitro += aumento; //aumentamos la velocidad lo que el aumento indique
            nitro -= aumento;          //restamos a la nitro lo que se haya aumentado

            velocidadNitro = Math.round(velocidadNitro*100d) / 100d;
            aumento = Math.round(aumento*100d) / 100d;

            System.out.println("+++ El "+getNombre()+" usa "+ aumento +" de nitro para alcanzar "+
                velocidadNitro+" km/hora y el nitro restante es "+this.getNitro()+" +++");
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
        return Math.round(nitro*100d)/100d;
    }

    //METODOS AUXILIARES
    /**
     * Método sobreescrito  toString
     * @return Representacion de CocheRapido
     */
    @Override
    public String toString(){
        StringBuilder builder= new StringBuilder();
        //<coche: nombreCoche> <tipo: tipoCoche> <vel_teó: velocidadCoche> 
        //<comb: combustibleCoche(valorOriginal)(actual:valorActual)> 
        //[opcionalmente si tiene reserva->] > <reserva: reservaCoche> 
        //[opcionalmente si tiene nitro->] > <nitroPendiente: nitroPendiente> 
        builder.append(super.toString());
        builder.append("<nitroPendiente: ");
        builder.append(getNitro());
        builder.append(">");
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
}
