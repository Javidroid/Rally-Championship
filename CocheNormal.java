
/**
 * Esta clase representa los distintos Coches que los Pilotos pueden conducir en los Circuitos.
 * 
 * Cada instancia de Coche se diferencia por características como la
 * velocidad (teórica) y el combustible del Coche que influirán directamente en el rendimiento
 * de cada Piloto y su coche en cada Circuito.
 * 
 * velocidad puede ser:     TORTUGA (200.0), LENTA (210.0), NORMAL (220.0), RAPIDA (230.0) ó GUEPARDO (240.0)     
 * combustible puede ser:   ESCASO (350.0), NORMAL (440.0), GENEROSO (460.0) ó ELEFANTE (480.0)
 * 
 * Además, un coche puede ser una subclase: 
 * CocheRapido (con un campo nitro, que modifica velocidad)
 * CocheResistente (con un campo reserva, que modifica la forma de consumir combustible)
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (27/11/2020)
 */
public class CocheNormal implements Coche
{
    private String nombre;
    private Velocidad velocidad; //esto es velocidad teórica
    private Combustible combustibleTotal;   //deposito lleno, combustible original, no es modificable
    private double deposito; //es variable con cada carrera, hasta que llega a 0
    
    /**
     * Constructor de Coche
     */
    public CocheNormal(String nombre, Velocidad velocidad, Combustible combustibleTotal)
    {
        setNombre(nombre);
        setVelocidad(velocidad);
        setCombustibleTotal(combustibleTotal); 
        setDeposito(combustibleTotal.getValor());
    }

    
    //SETTERS
    /**
     * Setter de nombre
     * @param  nombre   Nuevo valor del campo nombre
     */
    private void setNombre(String nombre){this.nombre = nombre;}
    
    /**
     * Setter de velocidad
     * @param  velocidad   Nuevo valor del campo velocidad
     */
    private void setVelocidad(Velocidad velocidad){this.velocidad = velocidad;}
    
    /**
     * Setter de combustibleTotal
     * @param  combustibleTotal   Nuevo valor del campo combustibleTotal (que NO es variable)
     */
    private void setCombustibleTotal(Combustible combustibleTotal){this.combustibleTotal = combustibleTotal;}
    
    /**
     * Setter de deposito
     * @param  nuevoDeposito   Nuevo valor del campo deposito (que es variable)
     */
    private void setDeposito(double nuevoDeposito){deposito = nuevoDeposito;}

    
    //GETTERS
    /**
     * Getter de nombre
     * @return  String nombre
     */
    public String getNombre(){return nombre;}
    
    /**
     * Getter de velocidad (teórica)
     * @return  Velocidad velocidad
     */
    public Velocidad getVelocidad(){return velocidad;}
    /**
     * Método que devuelve el valor de velocidad (teórica)
     * @return  Double Valor de velocidad
     */
    public double getValorVelocidad(){return velocidad.getValor();}
    
    /**
     * Getter de combustibleTotal
     * @return  Combustible combustibleTotal
     */
    public Combustible getCombustibleTotal(){return combustibleTotal;}
    /**
     * Método que devuelve el valor de combustibleTotal
     * @return  double Valor de combustibleTotal
     */
    public double getValorCombustibleTotal(){return combustibleTotal.getValor();}
    
    /**
     * Getter de deposito
     * @return  double deposito
     */
    public double getDeposito(){return deposito;}

        
    //FUNCIONALIDADES DE COCHE    
    /**
     * Calcula la velocidad real del coche en función del piloto y la complejidad del circuito
     * 
     * @param  piloto       El piloto que conduce el coche
     * @param  circuito     El circuito en el que el coche compite (para usar la complejidad)
     * @return              Velocidad real del coche
     */
    public double calcularVelocidadReal(Piloto piloto, Circuito circuito)
    {
        double velocidadReal;
        velocidadReal = (getValorVelocidad() * piloto.calcularDestreza()) / circuito.getValorComplejidad();
        velocidadReal = Math.round(velocidadReal*100d) / 100d;
        return velocidadReal;
    }
    
    /**
     * Calcula el tiempo necesario para terminar la carrera según el piloto y el circuito
     * 
     * @param  piloto       El piloto que conduce el coche (para calcular la velocidad real)
     * @param  circuito     El circuito en el que el coche compite (para usar la distancia)
     * @return              Tiempo que tarda el coche en recorrer el circuito
     */
    public double calcularTiempoNecesario(Piloto piloto, Circuito circuito)
    {
        double tiempo;
        double velocidadReal; 
        velocidadReal = calcularVelocidadReal(piloto, circuito);
        
        tiempo = circuito.getValorDistancia() / velocidadReal * 60;
        tiempo = Math.round(tiempo*100d) / 100d;
        return tiempo;
    }
    
    /**
     * Reduce la cantidad de combustible indicada por parámetro.
     * Controlado por piloto en el método conducir. Puede reducir el combustible necesario
     * para un circuito, o el combustible usado antes de abandonar por concentracion o combustible.
     * 
     * @param  double cantidad: la cantidad de combustible que hay que reducir
     */
    public void reducirCombustible(double cantidad)
    {
        setDeposito(deposito-cantidad);
    }
    
    /**
     * Aumenta el depósito la cantidad indicada.
     * Actualmente sólo sirve para CocheResistente y su funcionalidad de
     * depósito de reserva. Pero podría servir para
     * futuros cambios donde cualquier coche pueda repostar.
     * 
     * @param  cantidad   La cantidad que se AÑADE al depósito
     */
    //La funcionalidad de este método podría sustituirse cambiando a 
    //protected el método setDeposito para que se pueda modificar desde
    //CocheResistente directamente, pero podría romper un poco la 
    //encapsulación
    public void repostar(double cantidad)
    {
        setDeposito(deposito+cantidad);
    }
    

    //METODOS AUXILIARES
    /**
     * Método sobreescrito  toString
     * @return Representacion de CocheNormal
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        //<coche: nombreCoche> <tipo: tipoCoche> <vel_teó: velocidadCoche> 
        //<comb: combustibleCoche(valorOriginal)(actual:valorActual)> 
        //[opcionalmente si tiene reserva->] > <reserva: reservaCoche> 
        //[opcionalmente si tiene nitro->] > <nitroPendiente: nitroPendiente> 
        builder.append("<coche: ");
        builder.append(getNombre());
        builder.append(" > ");
        builder.append("<tipo: normal > ");
        builder.append("<vel_teó:");
        builder.append(getValorVelocidad());
        builder.append("> ");
        builder.append("<comb: (");
        builder.append(getValorCombustibleTotal());
        builder.append(") (actual: ");
        builder.append(getDeposito());
        builder.append(") > ");
        builder.append("\n");
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
        if(!(obj instanceof CocheNormal)) {
            return false; 
        }
        
        CocheNormal other = (CocheNormal) obj;
        Double depositoDouble = getDeposito();
       
        return getNombre().equals(other.getNombre()) &&
               getVelocidad().equals(other.getVelocidad()) &&
               depositoDouble.equals(other.getDeposito()) &&
               getCombustibleTotal().equals(other.getCombustibleTotal());
    }
   
   
    /**
    * Metodo sobreescrito hashCode
    * 
    * @return hashCode que representa la clase
    */
    @Override
    public int hashCode(){
       Double depositoDouble = getDeposito();
       
       int result=17;
       
       result = 7 * result + getVelocidad().hashCode();
       result = 13 * result + getVelocidad().hashCode();
       result = 19 * result + depositoDouble.hashCode();
       return result;
    }
}
