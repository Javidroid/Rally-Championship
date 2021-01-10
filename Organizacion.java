
import java.util.*;
/**
 * Esta clase es la "principal" ya que es la que gestiona y controla todas las competiciones.
 * De esta clase sólo puede existir una instancia
 * 
 * @author Javier Florido Cartolano, Eugenia Andújar Sánchez y Carmen Martín Granado
 * @version v1 (27/11/2020)
 */
public class Organizacion
{
    private static Organizacion instancia; //singleton

    private int limiteAbandonos; //numero maximo de abandonos
    private int limitePilotos; //numero maximo de pilotos que cada escudería puede mandar
    private boolean finalizado; //booleano que indica si el torneo tiene que acabar por tener <= 1 pilotos

    private List <Piloto> pilotosDescalificados; //una lista que almacena todos los pilotos que han sido descalificados
    private List <Piloto> pilotosSinDescalificar;//una lista que almacena todos los pilotos que NO han sido descalificados 
    private List <Escuderia> escuderiasDescalificadas;

    //TreeSet porque los Circuitos son únicos y tienen orden.
    //Este orden es estático: se asigna al inicio y no se modifica en RunTime
    private Set <Circuito> circuitos;

    //HashSet porque no se repiten.
    private Set <Escuderia> escuderias;  

    //ArrayList porque requiere orden
    private List <Piloto>   pilotosCarrera;

    //HashMap para almacenar el valor de la escudería
    //Esta es una estructura auxiliar para almacenar la escudería a la que pertenece cada piloto
    protected Map <Piloto, Escuderia> mapaPilotosEscuderia;
    /**
     * Constructor de Organizacion sin parámetros (privado por uso de Singleton)
     */
    private Organizacion()
    {
        setFinalizado(false);
        pilotosDescalificados    = new ArrayList <Piloto>();
        pilotosSinDescalificar   = new ArrayList <Piloto>();
        escuderiasDescalificadas = new ArrayList <Escuderia>();
        circuitos                = new TreeSet <Circuito>(); //ordenamos por el comparador asignado
        escuderias               = new TreeSet <Escuderia>(Collections.reverseOrder(new CMPPuntosEscuderia()));
        pilotosCarrera           = new ArrayList <Piloto>();
        mapaPilotosEscuderia     = new HashMap <Piloto, Escuderia>();
    }

    /**
     * Constructor de Organizacion con parámetros (privado por uso de Singleton)
     */
    private Organizacion(Comparator CMPCircuito, int limiteAbandonos, int limitePilotos)
    {
        setLimiteAbandonos(limiteAbandonos);
        setLimitePilotos(limitePilotos);
        setFinalizado(false);
        pilotosDescalificados    = new ArrayList <Piloto>();
        pilotosSinDescalificar   = new ArrayList <Piloto>();
        escuderiasDescalificadas = new ArrayList <Escuderia>();
        circuitos                = new TreeSet <Circuito>(CMPCircuito); //ordenamos por el comparador asignado
        escuderias               = new TreeSet <Escuderia>(Collections.reverseOrder(new CMPPuntosEscuderia()));
        pilotosCarrera           = new ArrayList <Piloto>();
        mapaPilotosEscuderia     = new HashMap <Piloto, Escuderia>();
    }

    /**
     * Método de creación estático público para obtener la instancia
     * Singleton.
     * Realmente sirve para llamar al constructor parametrizado
     * Es un método de clase, es decir, para invocarlo hay que usar el nombre
     * de la clase, y no el de la instancia.
     * 
     * @return  única instancia de Organization
     */
    public synchronized static Organizacion getInstancia(Comparator CMPCircuito, int limiteAbandonos, int limitePilotos){
        if (instancia == null){
            instancia = new Organizacion(CMPCircuito, limiteAbandonos, limitePilotos);
        }
        return instancia;
    }

    /**
     * Método de creación estático público para obtener la instancia
     * Singleton.
     * Es un método de clase, es decir, para invocarlo hay que usar el nombre
     * de la clase, y no el de la instancia.
     * 
     * @return  única instancia de Organization
     */
    public synchronized static Organizacion getInstancia(){
        if (instancia == null){
            instancia = new Organizacion();
        }
        return instancia;
    }

    //FUNCIONALIDAD DE ORGANIZACIÓN
    /**
     * Método que permite que las Escuderías se inscriban
     * 
     * Añade la escudería indicada por parámetro al set de escuderias
     * Además, se almacenan los pilotos en mapaPilotosEscuderia para no perder a qué
     * escudería pertenece cada piloto
     * 
     * @param escuderia     La escudería que se desea añadir a la estructura
     * 
     */
    public void inscribirEscuderia(Escuderia escuderia){
        escuderias.add(escuderia); //añadimos la escudería al set de escuderías

        List <Piloto> pilotos = escuderia.getPilotos();
        //añadimos cada piloto de la lista de pilotos de la escudería en cuestión al
        //mapa con key cada piloto y value la escudería en cuestión
        for (Piloto piloto : pilotos){
            mapaPilotosEscuderia.put(piloto, escuderia); 
        }
    }

    /**
     * Método que gestiona las carreras del campeonato por cada circuito
     * Por cada Circuito, solicita a cada escudería que mande a sus pilotos (escuderia.enviarPiloto())
     * Los pilotos se incluyen por orden de pilotosCarrera hasta alcanzar el limitePilotos
     * 
     * Tiene que haber mínimo un piloto para que se pueda competir.
     * En este caso, se ordenarán los pilotos disponibles por puntos totales, carreras terminadas y nombre
     * Siguiendo el orden anterior, se pedirá a los pilotos que conduzcan (piloto.conducir())
     * 
     * Se mostrarán las características del piloto y coche que esté conduciendo en este momento
     * 
     * Al finalizar la iteración de pilotos, se procederá a asignarles los puntos correspondientes
     * 
     * Finalmente, se muestran los resultados obtenidos en la carrera y se devuelven
     * los pilotos a su escudería
     * 
     * param circuito   El circuito en el que se va a disputar la carrera
     */
    public void celebrarCarrera(Circuito circuito){
        //cargamos en pilotosCarrera todos los pilotos aspirantes a participar en esta carrera
        cargarPilotosCarrera();

        if (pilotosCarrera.size() > 1){
            //Ordenamos a los pilotos por puntos totales para la parrilla de salida
            Collections.sort(pilotosCarrera, new CMPPuntosTotalesPiloto());

            //Mostramos los pilotos que van a participar en el Circuito
            mostrarPilotosCarrera(circuito);

            //Comenzamos la carrera
            comenzarCarrera(circuito);

            //Creamos una lista para los pilotos que han abandonado y los que no
            List <Piloto> pilotosAbandono  = new ArrayList <Piloto>();
            List <Piloto> pilotosTerminado = new ArrayList <Piloto>();

            //Se asigna los puntos correspondientes a cada piloto que ha abandonado
            //y se separan los pilotos que han abandonado de los que han terminado
            for (Piloto piloto : pilotosCarrera){
                if (piloto.getTiempoUltimoResultado() < 0){
                    piloto.setPuntosEnCircuito(circuito, 0); //le ponemos 0 a sus puntos
                    pilotosAbandono.add(piloto); //añadimos a la lista de pilotos que han abandonado
                }
                else{
                    pilotosTerminado.add(piloto); //como ha terminado, lo añadimos a la lista de pilotos que han terminado
                }
            }

            //Asignamos los puntos correspondientes a los pilotos que han terminado
            asignarPuntos(pilotosTerminado, circuito);

            //mostramos la clasificación final de los pilotos tras la carrera (mostrar pilotos
            //por orden de tiempo y, luego, los que han abandonado)-
            mostrarClasificacion(pilotosAbandono, pilotosTerminado, circuito);

            //devolvemos los pilotos a su escudería
            devolverPilotos();
        }
        else {
            finalizarCampeonato(); //llamamos al método que pone el valor finalizado a true para parar de hacer carreras

            if (pilotosCarrera.size() > 0){
                devolverPilotos(); //devolvemos los pilotos por si quedara un único piloto
            }
            System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
            System.out.println("¡¡¡ No se celebra esta carrera ni la(s) siguiente(s) por no haber pilotos para competir !!!!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }

    /**
     * Método que maneja todo el transcurso de la competición una vez se insertan
     * todos los circuitos y escuderias.
     * 
     * Ordena y muestra los circuitos que componen el campeonato
     * Se muestran las escuderías que compiten, realiza las carreras con cada circuito
     * disponible de la estructura si no se produce una condición de finalización (no hay pilotos o solo queda uno)
     * 
     * Cuando finalicen los circuitos, se realiza la "Ceremonia de Entrega de Premios del Campeonato" donde
     * o se declarará desierto el torneo, o se proclama Piloto y Escudería campeón a aquellos que más puntos tengan
     * 
     * Siempre se muestran al final los pilotos sin descalificar, descalificados y escuderías junto sus resultados
     * 
     */
    public void celebrarCompeticion(){
        //Mostramos los circuitos
        mostrarCircuitos();

        //Mostramos cada escudería
        mostrarEscuderias();

        int turno = 1;

        Iterator <Circuito> itCir = circuitos.iterator();
        while (itCir.hasNext() && !finalizado){

            Circuito circuito = itCir.next();

            System.out.println("********************************************************************************************************");
            System.out.println("*** CARRERA<"+turno+"> EN " + circuito.mostrarCaracteristicas() + " ***");
            System.out.println("********************************************************************************************************");

            celebrarCarrera(circuito);

            turno++;
        }

        //Que comience la Ceremonia de Entrega de Premios del Campeonato
        entregarPremios();
    }

    /**
     *  Método que se encarga de asignar los premios a los pilotos segun su clasificacion final
     * 
     * @param 
     */
    public void entregarPremios(){
        System.out.println("****************************************************");
        System.out.println("**************** FIN DEL CAMPEONATO ****************");

        //separamos los pilotos y las escuderías que han ido siendo descalificados durante el torneo
        separarPilotosyEscuderiasDescalificados();

        mostrarClasificacionFinalPilotos(); //mostramos la clasificación de pilotos

        mostrarClasificacionFinalEscuderias(); //lo mismo con las escuderías

    }

    /**
     * Método que separa los pilotos y las escuderías descalificadas en sus respectivas estructuras definidas en
     * la clase organización para hacer correctamente el recuento de datos en la Clasificación Final
     */
    public void separarPilotosyEscuderiasDescalificados(){
        Escuderia escuderia; //objeto auxiliar
        Iterator <Escuderia> it = escuderias.iterator();
        while (it.hasNext()){
            escuderia = it.next();

            escuderia.separarPilotos(); //separamos los pilotos descalificados de los que no

            for(Piloto piloto : escuderia.getPilotos()){
                this.pilotosSinDescalificar.add(piloto);
            }

            for(Piloto piloto : escuderia.getPilotosDescalificados()){
                this.pilotosDescalificados.add(piloto);
            }

            if(escuderia.getPilotos().size() == 0){ //si la escudería no tiene pilotos sin descalificar
                escuderiasDescalificadas.add(escuderia); //almacenamos la escudería en la lista de descalificadas
                it.remove(); //borramos la escudería de la lista de sin descalificar
            }
        }
    }

    /**
     *  Método que muestra la clasificaicón final de los pilotos
     */
    public void mostrarClasificacionFinalPilotos(){
        System.out.println("****************************************************");
        System.out.println("********** CLASIFICACIÓN FINAL DE PILOTOS **********");
        System.out.println("****************************************************");

        //si todos los pilotos descalificados (tamañaoListaDescalificados == tamañoMapaDeTodosLosPilotos)
        if (pilotosDescalificados.size() == mapaPilotosEscuderia.size()){
            System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
            System.out.println("¡¡¡ Campeonato de pilotos queda desierto por haber sido descalificados todos los pilotos !!!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        else{
            //si hay pilotos sin descalificar en el campeonato

            int posicion = 1;
            Collections.sort(pilotosSinDescalificar, Collections.reverseOrder(new CMPPuntosTotalesPiloto())); 
            //ordenamos la lista por puntos (descendente porque el primero es el que más puntos tiene)
            for (Piloto piloto : pilotosSinDescalificar){
                System.out.println("@@@ Posición("+ posicion +"): " + piloto.getNombre()
                    +" - Puntos Totales: "+piloto.getTotalPuntos()+" @@@");

                for (Resultado result : piloto.getListaResultados()){
                    System.out.println("Carrera("+result.getCircuito().getNombre()+") - Puntos:"+result.getPuntos()+
                        " - Tiempo:"+result.getTiempo()+" minutos");
                }
                posicion++; //incrementamos la posicion para el siguiente piloto
            }
        }

        //mostramos los pilotos descalificados
        mostrarPilotosDescalificados();
    }

    /**
     * Método que muestra la info de los pilotos descalificados
     */
    public void mostrarPilotosDescalificados(){
        System.out.println("****************************************************");
        System.out.println("************** PILOTOS DESCALIFICADOS **************");
        System.out.println("****************************************************");

        Collections.sort(pilotosDescalificados, Collections.reverseOrder(new CMPPuntosTotalesPiloto()));
        for (Piloto piloto : pilotosDescalificados){
            System.out.println("--- Piloto Descalificado: "+ piloto.getNombre()+
                " - Puntos Totales Anulados: "+piloto.getTotalPuntos()+" ---");
            System.out.println();
            for (Resultado result : piloto.getListaResultados()){
                System.out.println(result.toString());
            }
        }
    }

    /**
     *  Método que muestra la clasificaicón final de las escuderias
     */
    public void mostrarClasificacionFinalEscuderias(){
        System.out.println("****************************************************");
        System.out.println("******** CLASIFICACIÓN FINAL DE ESCUDERÍAS *********");
        System.out.println("****************************************************");

        if (pilotosDescalificados.size() == mapaPilotosEscuderia.size()){
            System.out.println("¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡¡");
            System.out.println("¡¡¡ Campeonato de escuderías queda desierto por haber sido descalificados todos los pilotos !!!");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        else{
            int posicion = 1;

            for (Escuderia escuderia : this.escuderias){

                System.out.println("@@@ Posición("+ posicion +") "+
                    escuderia.getNombre()+" con "+ escuderia.getPuntosPilotosTotal() +" puntos @@@");
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

                System.out.println(escuderia.toString()); //Mostramos todos los pilotos y los coches de la escuderia

                posicion++;
            }
        }
        //mostramos las escuderías descalificadas
        mostrarEscuderiasDescalificados();
    }

    /**
     * Método que muestra la info de las escuderías- descalificadas
     */
    public void mostrarEscuderiasDescalificados(){
        System.out.println("****************************************************");
        System.out.println("************ ESCUDERIAS DESCALIFICADAS *************");
        System.out.println("****************************************************");

        for(Escuderia escuderia : escuderiasDescalificadas){
            System.out.println("¡¡¡ Escudería Descalificada: "+escuderia.getNombre()+" con 0.0 puntos !!!");
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println(escuderia.toString());
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
    }

    /**
     *  Método que inserta los pilotos mandados por las escuderías
     */
    public void cargarPilotosCarrera(){
        //por cada escudería inscrita, hacemos que manden sus pilotos tantas veces como el límite indique
        Piloto pilotoCandidato;

        for (Escuderia escuderia : this.escuderias){
            int pilotosInscritos = 0;
            boolean pilotoNulo = false; 
            while(pilotosInscritos < limitePilotos && escuderia.quedanPilotos() && !pilotoNulo){
                pilotoCandidato = escuderia.enviarPiloto();
                if(pilotoCandidato != null){ //no dejamos que las escuderías manden un piloto nulo
                    pilotosCarrera.add(pilotoCandidato); //añadimos un piloto no nulo
                    pilotosInscritos++;
                }
                else {
                    pilotoNulo = true; //como la escudería ha mandado un piloto nulo, no va a mandar más
                }
            }
        }
    }

    /**
     *  Método que comprueba si hay algún piloto candidato para participar en una carrera en todas las escuderías
     *  
     *  NOTA:
     *  Este método se podría optimizar llevando un control de condición de bucle para que pare una vez encuentre
     *  al menos una escudería con piloto. Pero, por legibilidad y que esta optimización no supondría una mejora
     *  notable (porque no se va a trabajar con muchos elementos) dejamos que recorra siempre toda la estructura
     *  en vez de parar cuando encuentre.
     *  
     *  @return true si existe un piloto, false si no
     */
    public boolean hayPilotosDisponibles(){
        boolean hay = false;
        for(Escuderia escuderia : escuderias){
            if(escuderia.quedanPilotos() && escuderia.quedanCoches()){
                hay = true;
            }
        }
        return hay;
    }

    /**
     *  Método que devuelve los Pilotos de pilotosCarrera a su respectiva escudería
     */
    public void devolverPilotos(){
        Escuderia escuderia;
        for(Piloto piloto : this.pilotosCarrera){
            escuderia = mapaPilotosEscuderia.get(piloto); //obtenemos la escudería a la que pertenece el piloto
            escuderia.insertarPiloto(piloto); //volvemos a insertar al piloto en la lista de su escuderia
            if(piloto.getCocheAsignado() != null){
                escuderia.insertarCoche(piloto.devolverCoche()); //lo mismo que arriba pero con el coche, además de que se
                //deasigna el coche del piloto
            }
        }
        pilotosCarrera.clear(); //borramos la lista entera
    }

    /**
     *  Método que muestra los circuitos de los que se dispone el campeonato
     */
    public void mostrarCircuitos(){
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| CIRCUITOS DEL CAMPEONATO |||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        for (Circuito circuito : this.circuitos){
            System.out.println(circuito.mostrarCaracteristicas());
        }
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
    }

    /**
     *  Método que muestra las escuderías inscritas en el campeonato
     */
    public void mostrarEscuderias(){
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%% ESCUDERÍAS DEL CAMPEONATO %%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        for (Escuderia escuderia : this.escuderias){
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println(escuderia.toString());
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }

        System.out.println("\n");
    }

    /**
     *  Método que muestra la información necesaria sobre los pilotos que van a participar en un Circuito
     */
    public void mostrarPilotosCarrera(Circuito circuito){
        System.out.println("********************************************************************************************************");
        System.out.println("******************************** Pilotos que van a competir en "+circuito.getNombre()+" *********************************");
        System.out.println("********************************************************************************************************");

        //ordenar pilotos
        for (Piloto piloto : this.pilotosCarrera){
            System.out.println(piloto.toString());
        }
    }

    /**
     * Método que muestra la información de inicio de carrera y hace las operaciones
     * necesarias para que todos los pilotos en pilotosCarrera conduzcan
     */
    public void comenzarCarrera(Circuito circuito){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++ Comienza la carrera en "+circuito.getNombre()+" ++++++++++++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        int contadorPiloto = 1;
        for(Piloto piloto : this.pilotosCarrera){
            System.out.println("@@@ Piloto " + contadorPiloto + " de " + pilotosCarrera.size());

            System.out.println(piloto.toString() + " con "); //mostrarmos las CARACTERÍSTICAS del PILOTO
            System.out.println(piloto.getCocheAsignado().toString()); //mostrarmos las CARACTERÍSTICAS del COCHE

            //Mostramos la velocidad real BASE del coche (sin tener en cuenta si es cocheRapido o no)
            piloto.getCocheAsignado().imprimirVelocidadReal(piloto, circuito);

            piloto.conducir(circuito); //circuito es el Circuito que se ha pasado por parámetro

            if(piloto.getCarrerasAbandonadas() >= limiteAbandonos){
                piloto.descalificar();

                //podríamos añadir aquí el piloto en this.pilotosDescalificados pero como al mostrar los
                //resultados los vamos a separar y añadir, pues consideramos que no es responsabilidad
                //de este método añadir o quitar pilotos de listas de descalificación

                System.out.println("@@@");
                System.out.println("¡¡¡ " +piloto.getNombre()+ " es DESCALIFICADO del campeonato por alcanzar "
                    +"el límite de abandonos("+limiteAbandonos+") !!!");
                System.out.println("@@@");
            }
            System.out.println("@@@");
            contadorPiloto++;
        }
    }

    /**
     * Método que asigna los puntos a los pilotos que han TERMINADO una carrera en un Circuito.
     * Ordena los pilotos que han terminado y asigna los puntos correspondientes al primero, segundo, tercero...
     * La verdadera funcionalidad de este método es la limpieza de código de celebrarCarrera
     */
    public void asignarPuntos(List <Piloto> pilotosTerminado, Circuito circuito){
        //ordenamos de menor a mayor tiempo porque el que menos tiempo ha tardado, ha llegado primero
        Collections.sort(pilotosTerminado, new CMPTiempoResultado());
        for (int i=0; i<pilotosTerminado.size(); i++){
            Piloto piloto = pilotosTerminado.get(i);

            if (i==0){ //el primer piloto en la lista será el que menor tiempo tenga
                piloto.setPuntosEnCircuito(circuito, 10);   //se le asignan 10 puntos al primer piloto
            }
            else if (i==1){
                piloto.setPuntosEnCircuito(circuito, 8);    //se le asignan 8 puntos al segundo piloto
            }
            else if (i==2){
                piloto.setPuntosEnCircuito(circuito, 6);    //se le asignan 6 puntos al tercer piloto
            }
            else if (i==3){
                piloto.setPuntosEnCircuito(circuito, 4);    //se le asignan 4 puntos al cuarto piloto
            }
            else{
                piloto.setPuntosEnCircuito(circuito, 2);    //se le asignan 2 puntos al resto de pilotos
            }
        }
    }

    /**
     * Método que muestra los resultados de una carrera en un Circuito
     * La verdadera funcionalidad de este método es la limpieza de código de celebrarCarrera
     */
    public void mostrarClasificacion(List <Piloto> pilotosAbandono, List <Piloto> pilotosTerminado, Circuito circuito){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++++++++ Clasificación final de la carrera en "+circuito.getNombre()+" +++++++++++++++++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        //mostramos los pilotos que han terminado por orden de clasificación
        int posicion = 1;
        for (Piloto piloto : pilotosTerminado){
            System.out.println("@@@ Posición("+posicion+"): "+piloto.getNombre()+" - Tiempo: "+
                piloto.getTiempoEnCircuito(circuito)+" minutos - Puntos: "+piloto.getPuntosEnCircuito(circuito)+" @@@");
            posicion ++;
        }

        //mostramos los pilotos que han abandonado
        //ordenamos de mayor a menor porque el que el mayor tiempo negativo tenga, más cerca habrá estado de terminar
        Collections.sort(pilotosAbandono, new CMPTiempoResultado());
        for (Piloto piloto : pilotosAbandono){
            System.out.print("¡¡¡ Ha abandonado "+piloto.getNombre()+" - Tiempo: "
                + piloto.getTiempoUltimoResultado() + " - Puntos: 0 !!!");

            if(piloto.getDescalificado()){
                System.out.print(" - Además ha sido descalificado para el resto del Campeonato !!!");
            }
            System.out.println();
        }
    }

    /**
     * Método que permite insertar un circuito indicado por parámetro al Set de circuitos de la organizacion
     * 
     * @param circuito  El circuito que quiere insertarse
     */
    public void insertarCircuito(Circuito circuito){
        circuitos.add(circuito);
    }

    /**
     * Método que pone el campo finalizado a true indicando que no se deben disputar más carreras
     * 
     * Es privado porque la organización debería ser la única que puede dar por finalizado el circuito
     */
    private void finalizarCampeonato(){
        setFinalizado(true);
    }

    //SETTERS
    /**
     * Setter de limiteAbandonos
     * @param    limiteAbandonos    Nuevo valor del campo limiteAbandonos
     */
    private void setLimiteAbandonos(int limAband){limiteAbandonos = limAband;}

    /**
     * Setter de limitePilotos
     * @param    limitePilotos      Nuevo valor del campo limitePilotos
     */
    private void setLimitePilotos(int limPilot){limitePilotos = limPilot;}

    /**
     * Setter de finalizado
     * @param    finalizado      Nuevo valor del campo finalizado
     */
    private void setFinalizado(boolean finalizado){this.finalizado = finalizado;}

    //GETTERS
    /**
     * Getter de limiteAbandonos
     * @return   limiteAbandonos
     */
    public int getLimiteAbandonos(){return limiteAbandonos;}

    /**
     * Getter de limitePilotos
     * @return   limitePilotos
     */
    public int getLimitePilotos()  {return limitePilotos;}

    /**
     * Getter de finalizado
     * @return   finalizado
     */
    public boolean getFinalizado()  {return finalizado;}
}
