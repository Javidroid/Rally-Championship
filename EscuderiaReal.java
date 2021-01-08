import java.util.*;
/**
 * Esta clase representa las distintas Escuderías que compiten.
 * 
 * Compiten tanto porque alguno de sus Pilotos gane en el "apartado de Pilotos" (Piloto con más puntos)
 * como por ganar el "apartado de Escuderías" (Escudería con más puntos entre todos sus Pilotos)
 * 
 * Cada Escudería tiene una serie de Pilotos y Coches en exclusiva. Su labor es mantener un equipo
 * de Pilotos y Coches, enviando a cada carrera los que la clase Organización pida.
 * 
 * Cada instancia de Escudería se diferencia de otras por tener distintos criterios de ordenación
 * de las estructuras de sus Pilotos/Coches
 * 
 * Además, es la clase "Contexto" para el Patrón "Strategy" usado para establecer un criterio
 * de ordenación de pilotos y coches.
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (27/11/2020)
 */
public class EscuderiaReal implements Escuderia 
{
    private String nombre;
    private List <Piloto> pilotos;
    private List <Coche>  coches;

    private List <Piloto> pilotosDescalificados; //almacenamos los pilotos descalificados para que no estorben
    private List <Coche>  cochesSinCombustible;  //lo mismo con los coches

    private CMPStrategyPiloto criterioPiloto;//campo que referencia la Strategy usada para ordenar pilotos
    private boolean ASCpiloto; //booleano que controla si se quiere ordenar ascendente o descendentemente

    private CMPStrategyCoche  criterioCoche; //campo que referencia la Strategy usada para ordenar coches
    private boolean ASCcoche;
    /**
     * Constructor de Escuderia
     */
    public EscuderiaReal(String nombre, CMPStrategyPiloto criterioPiloto, boolean ASCpiloto, 
    CMPStrategyCoche criterioCoche, boolean ASCcoche)
    {
        setNombre(nombre);
        pilotos = new ArrayList <Piloto>();
        coches  = new ArrayList <Coche>();

        pilotosDescalificados = new ArrayList <Piloto>();
        cochesSinCombustible  = new ArrayList <Coche>();

        setCriterioPiloto(criterioPiloto);
        setCriterioCoche(criterioCoche);

        setASCpiloto(ASCpiloto);
        setASCcoche(ASCcoche);
    }

    //FUNCIONALIDAD DE ESCUDERÍA
    /**
     * Se inscribe en el campeonato gestionado por la Organizacion
     */
    public void inscribirse()
    {
        //llamamos al método de clase, es decir, sin necesidad de crear una
        //instancia. Directamente usando el nombre de la clase y sin necesidad
        //de tener que crear una instancia
        Organizacion.getInstancia().inscribirEscuderia(this);
    }

    /**
     * Añade un Piloto a la plantilla de pilotos de la Escudería
     * 
     * @param piloto     Piloto que se quiere añadir a la lista
     */
    public void insertarPiloto(Piloto piloto){
        pilotos.add(piloto);        
    }

    /**
     * Añade un Coche a la plantilla de coches de la Escudería
     * 
     * @param Coche      Coche que se quiere añadir a la lista
     */
    public void insertarCoche(Coche coche){
        coches.add(coche);
    }

    /**
     * Ordena la lista de pilotos según el criterio establecido y de forma Ascendente (true) o Descendente
     * según ASCpiloto
     * 
     */
    public void ordenarPilotos()
    {
        if(this.pilotos.size() > 1){ //si el tamaño es 1 o menor, no hace falta ordenar nada
            criterioPiloto.ordenarPilotos(pilotos, ASCpiloto); //mandamos la lista de pilotos para que se ordene
        }
        if(this.pilotosDescalificados.size() > 1){
            criterioPiloto.ordenarPilotos(pilotosDescalificados, ASCpiloto);
        }
    }

    /**
     * Ordena la lista de coches según el criterio establecido y de forma Ascendente (true) o Descendente
     * según ASCcoche
     */
    public void ordenarCoches()
    {
        if(this.coches.size() > 1){
            criterioCoche.ordenarCoches(coches, ASCcoche);    //mandamos la lista de coches para que se ordene
        }
        if(this.cochesSinCombustible.size() > 1){
            criterioCoche.ordenarCoches(cochesSinCombustible, ASCcoche);
        }
    }

    /**
     * Devuelve todos los puntos acumulados que tienen los pilotos de la Escuderia 
     *
     * @return     puntos totales de todos los Pilotos (no descalificados) de la Escudería
     */
    public int getPuntosPilotosTotal()
    {
        int puntos = 0;
        for (Piloto pilot : pilotos){
            puntos += pilot.getTotalPuntos();
        }
        return puntos;
    }

    /**
     * Devuelve el número total de carreras terminadas de sus pilotos
     *
     * @return     Numero de carreras total entre todos los pilotos de la escuderia
     */
    public int getCarrerasTerminadasPilotos()
    {
        int carreras = 0;
        for (Piloto pilot : pilotos){
            carreras += pilot.getCarrerasTerminadas();
        }
        return carreras;
    }

    /**
     * Envía el primer piloto con el primer coche disponible asignado a la carrera
     * Controla también si un piloto no tiene coche disponible, en cuyo caso
     * el piloto no puede ser enviado, pero no cuenta como abandono
     * 
     * Si devuelve null, significa que la escudería no tiene pilotos disponibles
     * 
     * @return Piloto    Piloto que participa en la siguiente carrera
     */
    public Piloto enviarPiloto()
    {
        //iterator que escoge el primer piloto no descalificado de la lista y le asigna
        //el primer coche con combustible de la lista

        Coche cocheAsignable = null; //variable que almacena el primer coche disponible para ser asignado
        Piloto pilotoEnviable = null; //almacena el primer piloto enviable en la lista

        //quitamos los pilotos y coches que no sirvan de la lista
        separarPilotos(); //quitamos los pilotos descalificados de pilotos y los ponemos en pilotosDescalificados
        separarCoches();  //quitamos los coches sin combustibles de coches y los ponemos en cochesSinCombustible

        //ordenamos los pilotos y los coches antes de asignarlos
        ordenarPilotos();
        ordenarCoches();

        //Buscamos el primer coche con combustible en la lista
        if(!coches.isEmpty()){ //si la lista NO está vacia, asignamos el primer coche
            cocheAsignable = coches.get(0);
            coches.remove(0); //sacamos al coche de la lista para evitar que otro piloto lo use
        }

        //Ya tenemos el primer coche con combustible de la lista (o no), y tenemos que asignarselo al primer
        //piloto no descalificado de la lista. 
        //Se podría hacer para que, si no hay cocheAsignable, ni siquiera buscar piloto, pero hay que mostrar
        //el mensaje del piloto concreto que no puede participar en la carrera
        if(!pilotos.isEmpty()){
            pilotoEnviable = pilotos.get(0);
            pilotoEnviable.recibirCoche(cocheAsignable);
            if (cocheAsignable != null){ //si el piloto SI tiene coche, también lo borramos de la lista
                pilotos.remove(0);
            }
        }
        else{//si no hay piloto disponible, devolvemos el coche
            coches.add(cocheAsignable);
        }

        //si hay piloto disponible (pilotoEnviable!=null) pero NO hay coche (null) entonces no se puede mandar el piloto
        if(pilotoEnviable != null && cocheAsignable == null){
            pilotos.add(pilotoEnviable); //devolvemos al piloto porque no puede participar

            System.out.println("¡¡¡ " + pilotoEnviable.getNombre() + " NO ES ENVIADO A LA CARRERA porque " +
                "su escudería (" + nombre + ") no tiene más coches con combustible disponibles !!!");

            pilotoEnviable = null; //no hay piloto enviable porque no tiene coche    
        }

        return pilotoEnviable;
    }

    /**
     * Método que manda a pilotosDescalificados a todos aquellos pilotos en pilotos que estén descalificados
     */
    public void separarPilotos(){
        Iterator <Piloto> it = this.pilotos.iterator();
        Piloto pil;
        while (it.hasNext()){
            pil = it.next();
            if(pil.getDescalificado() == true){
                it.remove(); //borramos el elemento de la lista que el iterador indique
                pilotosDescalificados.add(pil);   
            }
        }
    }

    /**
     * Método que manda a cochesSinCombustible todos aquellos coches en coches que no tengan combustible
     */
    public void separarCoches(){
        Iterator <Coche> it = this.coches.iterator();
        Coche coch;
        while (it.hasNext()){
            coch = it.next();
            if(coch.getDeposito() <= 0){ //si el depósito está vacío
                it.remove(); //borramos el elemento de la lista que el iterador indique
                cochesSinCombustible.add(coch);   
            }
        }
    }

    /**
     * Método que devuelve true si aún quedan pilotos enviables por la escudería
     * 
     * @return true si hay pilotos, false si no
     */
    public boolean quedanPilotos(){
        return pilotos.size() > 0;
    }

    /**
     * Método que devuelve true si aún quedan coches asignables a pilotos por la escudería
     * 
     * @return true si hay coches, false si no
     */
    public boolean quedanCoches(){
        return coches.size() > 0;
    }

    //SETTERS
    /**
     * Setter de nombre
     * @param  nombre   Nuevo valor del campo nombre
     */
    private void setNombre(String nombre){this.nombre = nombre;}

    /**
     * Setter de pilotos
     * @param  pilotos   Nuevo valor del campo pilotos
     */
    private void setPilotos(List <Piloto> pilotos){this.pilotos = pilotos;}

    /**
     * Setter de coches
     * @param  coches   Nuevo valor del campo coches
     */
    private void setCoches(List <Coche> coches){this.coches = coches;}

    /**
     * Setter de criterioPiloto.    Público para poder elegir la estrategia.
     * @param  CMPStrategyPiloto   Nuevo valor del campo criterioPiloto
     */
    public void setCriterioPiloto(CMPStrategyPiloto criterio){criterioPiloto = criterio;}

    /**
     * Setter de criterioCoche.     Público para poder elegir la estrategia.
     * @param  CMPStrategyCoche    Nuevo valor del campo criterioCoche
     */
    public void setCriterioCoche(CMPStrategyCoche criterio){criterioCoche = criterio;}

    /**
     * Setter de ASCpiloto.      Público para poder elegir la estrategia.
     * @param  ASCpiloto         Nuevo valor del campo ASCpiloto
     */
    public void setASCpiloto(boolean ASCpiloto){this.ASCpiloto=ASCpiloto;}

    /**
     * Setter de ASCcoche.      Público para poder elegir la estrategia.
     * @param  ASCcoche         Nuevo valor del campo ASCcoche
     */
    public void setASCcoche(boolean ASCcoche){this.ASCcoche=ASCcoche;}

    //GETTERS
    /**
     * Getter de nombre
     * @return   nombre
     */
    public String getNombre(){return nombre;}

    /**
     * Getter de pilotos
     * @return   pilotos
     */
    public List <Piloto> getPilotos(){return pilotos;}

    /**
     * Método que devuelve pilotos descalificados
     * @return   pilotos descalificados
     */
    public List <Piloto> getPilotosDescalificados(){return this.pilotosDescalificados;}

    /**
     * Getter de coches
     * @return   coches
     */
    public List <Coche> getCoches(){return coches;}

    /**
     * Método que devuelve coches sin combustible
     * @return   coches sin combustible
     */
    public List <Coche> getCochesSinCombustible(){return this.cochesSinCombustible;}

    /**
     * Getter de criterioPiloto
     * @return  CMPStrategyPiloto   criterioPiloto
     */
    public CMPStrategyPiloto getCriterioPiloto(){return criterioPiloto;}

    /**
     * Getter de criterioCoche
     * @return  CMPStrategyCoche   criterioCoche
     */
    public CMPStrategyCoche getCriterioCoche(){return criterioCoche;}   

    //METODOS AUXILIARES
    /**
     * Método sobreescrito  toString
     * @return Representacion de EscuderiaReal
     */
    @Override
    public String toString(){
        ordenarPilotos(); //ordenamos los pilotos y coches por si acaso estuvieran desordenados
        ordenarCoches();

        StringBuilder builder= new StringBuilder();
        builder.append("%%% ");
        builder.append(getNombre());
        builder.append(" %%% \n");
        for (Piloto p : pilotos){
            builder.append(p.toString());
            builder.append("\n");
        }
        for (Piloto p : pilotosDescalificados){
            builder.append(p.toString());
            builder.append("\n");
        }
        for (Coche c : coches){
            builder.append(c.toString());
            builder.append("\n");
        }
        for (Coche c : cochesSinCombustible){
            builder.append(c.toString());
            builder.append("\n");
        }
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
        if(!(obj instanceof EscuderiaReal)) {
            return false; 
        }

        EscuderiaReal other = (EscuderiaReal) obj;

        return getNombre().equals(other.getNombre()) &&
        getCoches().equals(other.getCoches()) &&
        getPilotos().equals(other.getPilotos());
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
