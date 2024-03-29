
import java.util.*;
/**
 * Esta clase representa los distintos Pilotos que compiten con sus Coches en el Circuito
 * 
 * Cada instancia de Piloto se diferencia por la distinta concentracion. Esta característica
 * influye de diversas formas en el rendimiento del Piloto y su Coche en cada Circuito.
 * 
 * concentracion puede ser: DESPISTADO (90.0), NORMAL (100.0), CONCENTRADO (110.0) ó ZEN (120.0)
 * 
 * Piloto es una clase abstracta. 
 * Cada piloto puede ser PilotoNovato, PilotoExperimentado ó PilotoEstrella.
 * La diferencia entre estas subclases son la forma de calcular la destreza
 * 
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (27/11/2020)
 */
public abstract class PilotoAbstracto implements Piloto //esta clase es abstracta
{
    private String nombre;
    private Coche cocheAsignado; //asignado por Escudería. Puede ser null y hay que mostrar mensaje
    private Concentracion concentracion;
    private List <Resultado> resultados; //Registro de tiempo y puntos en cada circuito que haya disputado una carrera
    //resultados es una lista de la clase resultado, que almacena lo necesario

    private boolean descalificado; //true si ha superado los abandonos permitidos por Organizacion

    /**
     * Constructor de Piloto
     * 
     * Siempre se va a inicializar SIN coche asignado y el piloto SIN descalificar
     * Además, se crea el espacio para la lista de resultados
     * 
     * @param nombre            El nombre asignado al piloto
     * @param concentracion     La concentracion que tenga el piloto
     */
    public PilotoAbstracto(String nombre, Concentracion concentracion)
    {
        setNombre(nombre);
        setCocheAsignado(null);
        setConcentracion(concentracion);
        resultados = new ArrayList <Resultado>();
        setDescalificado(false);
    }

    //FUNCIONALIDAD DE PILOTO
    /**
     * Método abstracto que calcula la destreza según la concentracion y el tipo de piloto
     * Cada clase lo implementa de una forma distinta.
     */
    public abstract double calcularDestreza();   

    /**
     * Descalifica al piloto instado. Pone el parámetro descalificado a true
     */
    public void descalificar()
    {
        setDescalificado(true);
    }

    /**
     * Inserta el Coche que la Escuderia le de al Piloto para poder cambiarlo entre carrera y carrera
     * 
     * @param  coche   el coche que la escudería le proporcione
     */
    public void recibirCoche(Coche coche)
    {
        setCocheAsignado(coche);   
    }

    /**
     * Pone a NULL el cocheAsignado al piloto para tenerlo listo para la siguiente carrera
     * 
     * @return  coche   el coche que el piloto tenga que devolver a la escuderia
     */
    public Coche devolverCoche(){
        Coche coche = this.cocheAsignado; //objeto auxiliar para devolver el coche
        setCocheAsignado(null); //quitamos el coche del piloto

        return coche;
    }

    /**
     * Devuelve el tiempo que el piloto ha conseguido en el 
     * circuito dado por parámetro
     * 
     * @param circuito del que se quiere saber el tiempo
     * @return tiempo que ha tardado en acabar el circuito
     */
    public double getTiempoEnCircuito(Circuito circuito){
        boolean encontrado = false;
        double tiempo = -1; //-1 en caso de que el piloto no haya competido en ese circuito
        Iterator<Resultado> it = resultados.iterator();
        while (!encontrado && it.hasNext()){
            Resultado res = it.next();
            if(res.getCircuito().equals(circuito)){
                encontrado = true;
                tiempo = res.getTiempo();
            }
        }
        tiempo = Math.round(tiempo*100d)/100d;
        return tiempo;
    }

    /**
     * Devuelve los puntos que el piloto ha conseguido en el 
     * circuito dado por parámetro
     * 
     * @param circuito del que se quiere saber la puntuacion
     * @return puntos que ha conseguido el piloto en la carrera
     */
    public int getPuntosEnCircuito(Circuito circuito){
        boolean encontrado = false;
        int puntos = -1; //en caso de que no haya participado en ese circuito
        Iterator<Resultado> it = resultados.iterator();
        while (!encontrado && it.hasNext()){
            Resultado res = it.next();
            if(res.getCircuito().equals(circuito)){
                encontrado = true;
                puntos = res.getPuntos();
            }
        }
        return puntos;
    }

    /**
     * Pone los puntos que la clase Organizacion le asigne
     * según el tiempo conseguido entre todos los pilotos
     * 
     * @param circuito del que se asignan los puntos
     * @param puntos asignados por la clase Organizacion
     */
    public void setPuntosEnCircuito(Circuito circuito, int puntos){
        boolean encontrado = false;
        Iterator<Resultado> it = resultados.iterator();
        while (!encontrado && it.hasNext()){
            Resultado res = it.next();
            if(res.getCircuito().equals(circuito)){
                encontrado = true;
                res.setPuntos(puntos);
            }
        }
    }

    /**
     * Devuelve los puntos que ha conseguido el piloto
     * en todas las carreras
     * 
     * @return Total de puntos
     */
    public int getTotalPuntos(){
        int puntos = 0;
        for (Resultado result: resultados){
            if(result.getPuntos() != -1){ //Si puntos -1 es porque no se han asignado
                puntos += result.getPuntos();
            }
        }
        return puntos;
    }

    /**
     * Devuelve el nº de carreras (terminadas o no) en las que
     * ha participado el Piloto
     * 
     * @return carreras Nº de carreras participadas
     */
    public int getCarrerasParticipadas(){
        int carreras;
        carreras = resultados.size();
        return carreras;
    }

    /**
     * Devuelve el nº de carreras que el Piloto ha terminado
     * 
     * @return terminadas Nº de carreras terminadas
     */
    public int getCarrerasTerminadas(){
        int terminadas = 0;
        for (Resultado result: resultados){
            if(result.getTiempo() >= 0){
                terminadas++;
            }
        }
        return terminadas;
    }

    /**
     * Devuelve el nº de carreras que el Piloto ha abandonado
     * 
     * @return abandonadas Nº de carreras abandonadas
     */
    public int getCarrerasAbandonadas(){
        int abandonadas = 0;
        for (Resultado result: resultados){
            if(result.getTiempo() < 0){
                abandonadas++;
            }
        }
        return abandonadas;
    }

    /**
     * Devuelve el tiempo obtenido en el último resultado del Piloto
     * Esto sirve para que la clase Organización pueda ordenarlos por puntos
     * 
     * @return Tiempo del ultimo resultado
     */
    public double getTiempoUltimoResultado(){
        return Math.round(resultados.get(resultados.size()-1).getTiempo() * 100d)/100d;
    }

    /**
     * Gestiona todos los métodos necesarios para que el piloto dispute una carrera 
     * 
     * @param Circuito circuito
     * 
     */
    public void conducir(Circuito circuito){
        Resultado resNuevaCarrera;

        double tiempoParaAcabar; //tiempo necesario para finalizar el circuito
        tiempoParaAcabar = cocheAsignado.calcularTiempoNecesario(this, circuito);

        double tiempoConducido; //el tiempo que el piloto ha llegado a conducir en el circuito
        //Además, es el valor que hay que restarle al depósito

        if (this.getValorConcentracion() < tiempoParaAcabar){
            //el piloto va a abandonar la carrera, en principio por falta de concentración
            //a no ser que tenga menos combustible que concentración

            tiempoConducido = cocheAsignado.getDeposito(); //almacenamos el depósito que le queda por si aband. por comb.

            //reducimos el combustible ahora para abordar el caso de que no tenga ni concentración ni deposito suficiente
            //para terminar la carrera y que se quede sin concentración un piloto con un coche que recurra a la reserva
            cocheAsignado.reducirCombustible(getValorConcentracion());

            if(cocheAsignado.getDeposito() < 0){
                //ha terminado porque se ha quedado sin combustible porque tenía menos depósito que concentración
                //incluso habiendo recurrido a la reserva (porque sería positivo en ese caso)
                //hay que restar, además, el tiempo que le faltaba para terminar para que se refleje en el deposito

                resNuevaCarrera = new Resultado(circuito, tiempoConducido - tiempoParaAcabar);

                System.out.println("¡¡¡ El " + cocheAsignado.getNombre() + " se quedó sin combustible a falta de "
                    + Math.round((tiempoParaAcabar-tiempoConducido)*100d)/100d + " minutos para terminar !!!");

                System.out.println("¡¡¡ En el momento de quedarse sin combustible llevaba en carrera "
                    + tiempoConducido + " minutos !!!");

                //reducimos el tiempo total que necesitaba para acabar (explicado arriba el porqué)
                cocheAsignado.reducirCombustible(tiempoParaAcabar - getValorConcentracion());
            }
            else{
                //abandono porque se ha quedado sin concentración. porque aún le quedaba depósito
                tiempoConducido = getValorConcentracion();

                resNuevaCarrera = new Resultado(circuito, tiempoConducido - tiempoParaAcabar);

                System.out.println("¡¡¡ " + nombre + " perdió la concentración a falta de "
                    + Math.round((tiempoParaAcabar-tiempoConducido)*100d)/100d + " minutos para terminar !!!");

                System.out.println("¡¡¡ En el momento del despiste llevaba en carrera "
                    + tiempoConducido + " minutos !!!");

                //ya hemos reducido el combustible el tiempo que ha conducido, es decir: la concentración
            }
        }
        else{
            //reducimos todo el tiempo de la carrera independientemente de que acabe o abandone por falta de combustible
            //(porque si se llega aquí es porque le da la concentración)

            tiempoConducido = cocheAsignado.getDeposito(); //almacenamos el depósito que le queda por si aband. por comb.

            //el combustible que se quite va a ser siempre lo necesario para acabar la carrera independientemente
            //de que termine o de que abandone por falta de combustible (para reflejar en depósito lo que le faltaría)
            this.cocheAsignado.reducirCombustible(tiempoParaAcabar);

            if(cocheAsignado.getDeposito() < 0){
                //abandono por falta de combustible porque el deposito es negativo

                resNuevaCarrera = new Resultado(circuito, tiempoConducido - tiempoParaAcabar);

                System.out.println("¡¡¡ El " + cocheAsignado.getNombre() + " se quedó sin combustible a falta de "
                    + Math.round((tiempoParaAcabar-tiempoConducido)*100d)/100d + " minutos para terminar !!!");

                System.out.println("¡¡¡ En el momento de quedarse sin combustible llevaba en carrera "
                    + tiempoConducido + " minutos !!!");

                //ya se ha reducido el combustible
            }
            else{
                //ha terminado porque tiene concentración y el combustible ha acabado positivo

                tiempoConducido = tiempoParaAcabar;
                resNuevaCarrera = new Resultado(circuito, tiempoConducido);

                System.out.println("+++ " + nombre + " termina la carrera en " + tiempoConducido +" minutos +++");

                //ya se ha reducido el combustible
            }
        }
        System.out.println("+++ El combustible del "+ cocheAsignado.getNombre() + " tras la carrera es " 
            +cocheAsignado.getDeposito() +" +++");

        resultados.add(resNuevaCarrera); //Añadimos a la lista el resultado de esta carrera
        //Siempre que se llame a este método, se ha de añadir un resultado a la lista.
        //Es por esto por lo que hemos optado por inicializar el objeto resultado en cada
        //condición y, al final, ya añadirla a la lista.
        //Otra opción sería añadirla justo después de inicializar cada objeto pero se ahorra código
    }

    //SETTERS
    /**
     * Setter de nombre
     * @param  nombre   Nuevo valor del campo nombre
     */
    private void setNombre(String nombre){this.nombre = nombre;}

    /**
     * Setter de cocheAsignado
     * @param  cocheAsignado   Nuevo valor del campo cocheAsignado
     */
    private void setCocheAsignado(Coche cocheAsignado){this.cocheAsignado = cocheAsignado;}

    /**
     * Setter de concentracion
     * @param  concentracion   Nuevo valor del campo concentracion
     */
    private void setConcentracion(Concentracion concentracion){this.concentracion = concentracion;}

    /**
     * Setter de resultados
     * @param  resultados   Nuevo valor del campo resultados (es un ARRAYLIST)
     */
    private void setListaResultados(List <Resultado> resultados){this.resultados = resultados;}

    /**
     * Setter de descalificado
     * @param  descalificado   Nuevo valor del campo descalificado
     */
    private void setDescalificado(boolean descalificado){this.descalificado = descalificado;}

    //GETTERS
    /**
     * Getter de nombre
     * @return  nombre
     */
    public String getNombre(){return nombre;}

    /**
     * Getter de cocheAsignado
     * @return  cocheAsignado
     */
    public Coche getCocheAsignado(){return cocheAsignado;}

    /**
     * Getter de concentracion
     * @return  concentracion
     */
    public Concentracion getConcentracion(){return concentracion;}

    /**
     * Método que devuelve el valor de concentracion
     * @return  double  valor de concentracion
     */
    public double getValorConcentracion(){return Math.round(concentracion.getValor() *100d)/100d;}

    /**
     * Getter de resultados
     * @return  resultados  (es un ARRAYLIST)
     */
    public List <Resultado> getListaResultados(){return resultados;}

    /**
     * Getter de descalificado
     * @return  descalificado
     */
    public boolean getDescalificado(){return descalificado;}

    //METODOS AUXILIARES
    /**
     * Método sobreescrito  toString
     * @return Representacion de PilotoAbstracto
     */
    @Override
    public String toString(){
        StringBuilder builder= new StringBuilder();
        builder.append("<piloto:");
        builder.append(getNombre());
        builder.append("> ");
        builder.append("<tipo: ");
        builder.append(getClass().getSimpleName());
        builder.append("> ");
        builder.append("<dest: ");
        builder.append(calcularDestreza());
        builder.append("> ");
        builder.append("<conc: ");
        builder.append(getConcentracion());
        builder.append("> ");
        builder.append("<descalificado:");
        builder.append(getDescalificado());
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
        if(!(obj instanceof PilotoAbstracto)) {
            return false; 
        }

        PilotoAbstracto other = (PilotoAbstracto) obj;

        return getNombre().equals(other.getNombre()) &&
        getCocheAsignado().equals(other.getCocheAsignado()) &&
        getConcentracion().equals(other.getConcentracion()) &&
        getListaResultados().equals(other.getListaResultados());
    }

    /**
     * Metodo sobreescrito hashCode
     * 
     * @return hashCode que representa la clase
     */
    @Override
    public int hashCode(){
        int result=17;

        result = 7 * result + getNombre().hashCode();
        return result;
    }
}
