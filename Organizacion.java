
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
    
    private int limiteAbandonos;
    private int limitePilotos;
    private boolean finalizado; //booleano que indica si el torneo tiene que acabar por tener <= 1 pilotos
    
    //TreeSet porque los Circuitos son únicos y tienen orden.
    //Este orden es estático: se asigna al inicio y no se modifica en RunTime
    private Set <Circuito> circuitos;    
    
    //HashSet porque no se repiten ni tienen orden.
    private Set <Escuderia> escuderias;  

    //ArrayList porque requiere orden
    private List <Piloto>   pilotosCarrera;
    
    //HashMap para almacenar el valor de la escudería
    //Esta es una estructura auxiliar para almacenar la escudería a la que pertenece cada piloto
    private Map <Piloto, Escuderia> mapaPilotosEscuderia;
    /**
     * Constructor de Organizacion sin parámetros(privado por uso de Singleton)
     */
    private Organizacion()
    {
        circuitos            = new TreeSet <Circuito>();
        escuderias           = new HashSet <Escuderia>();
        pilotosCarrera       = new ArrayList <Piloto>();
        mapaPilotosEscuderia = new HashMap <Piloto, Escuderia>();
    }
    
    /**
     * Constructor de Organizacion parametrizado
     */
    public Organizacion(int limiteAbandonos, int limitePilotos)
    {
        setLimiteAbandonos(limiteAbandonos);
        setLimitePilotos(limitePilotos);
        setFinalizado(false);
        
        
        circuitos            = new TreeSet <Circuito>();
        escuderias           = new HashSet <Escuderia>();
        pilotosCarrera       = new ArrayList <Piloto>();
        mapaPilotosEscuderia = new HashMap <Piloto, Escuderia>();
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

        List <Piloto> pilotos;
        pilotos = escuderia.getPilotos(); 
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
        //Iteramos sobre las escuderias para inscribir los posibles pilotos. MÁX: limitePilotos
        Iterator <Escuderia> it = escuderias.iterator();
        while(it.hasNext() && pilotosCarrera.size() <= limitePilotos){
            Escuderia es = it.next();
            Piloto pilotoCandidato;
            
            pilotoCandidato = es.enviarPiloto();
            if(pilotoCandidato != null){
                pilotosCarrera.add(pilotoCandidato); //añadimos un piloto no nulo
            }
        }

        if (pilotosCarrera.size() > 1){
            System.out.println("********************************************************************************************************");
            System.out.println("******************************** Pilotos que van a competir en "+circuito.getNombre()+" *******************************");
            System.out.println("********************************************************************************************************");
        
            for (Piloto piloto : pilotosCarrera){
                System.out.println(piloto.toString());
            }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++++++++++ Comienza la carrera en "+circuito.getNombre()+" ++++++++++++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            
            
            Collections.sort(pilotosCarrera, new CMPPuntosTotalesPiloto());
            
            int contadorPiloto = 1;
            for(Piloto piloto : pilotosCarrera){
                System.out.println("@@@ Piloto " + contadorPiloto + " de " + limitePilotos);
                
                System.out.println(piloto.toString() + " con \n"); //mostrarmos las CARACTERÍSTICAS del PILOTO
                System.out.println(piloto.getCocheAsignado().toString()); //mostrarmos las CARACTERÍSTICAS del COCHE
                
                System.out.println("+++ Con estas condiciones es capaz de correr a " +
                + piloto.getCocheAsignado().calcularVelocidadReal(piloto, circuito) +" km/hora +++");
                
                piloto.conducir(circuito); //circuito es el Circuito que se ha pasado por parámetro
                
                if(piloto.getCarrerasAbandonadas() >= limiteAbandonos){
                    piloto.descalificar();
                    
                    System.out.println("@@@");
                    System.out.println("¡¡¡ " +piloto.getNombre()+ " es DESCALIFICADO del campeonato por alcanzar "
                    +"el límite de abandonos("+limiteAbandonos+") !!!");
                    System.out.println("@@@");
                }
                
            }
            
            
            for (Piloto piloto : pilotosCarrera){
                if(piloto.getTiempoEnCircuito(circuito) < 0){
                    piloto.setPuntosEnCircuito(circuito, 0);
                }
                else{
                    //Ordenamos los pilotos según su tiempo obtenido
                }
            }

            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+++++++++++++++++ Clasificación final de la carrera en "+circuito.getNombre()+" +++++++++++++++++");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            //mostrar pilotos ordenados por posición
        }
        else {
            finalizarCampeonato(); //llamamos al método que pone el valor finalizado a true para parar de hacer carreras
            
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
        //todo
        
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println("||||||||||||||||||| CIRCUITOS DEL CAMPEONATO |||||||||||||||||||");
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        
        //ordenamos los circuitos:
        //Collections.sort
        for (Circuito circuito : circuitos){
            circuito.toString();
        }
        
        //Mostramos cada escudería
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        System.out.println("%%%%%%%% ESCUDERÍAS DEL CAMPEONATO %%%%%%%%");
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        
        for (Escuderia escuderia : escuderias){
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println("%%% "+escuderia.getNombre()+" %%%");
            
            //mostramos los pilotos de cada escudería
            for (Piloto piloto : escuderia.getPilotos()){
                System.out.println(piloto.toString());
            }
            for (Coche coche : escuderia.getCoches()){
                System.out.println(coche.toString());
            }
            System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        }
        
        System.out.println("\n");
        
        Iterator <Circuito> itCir = circuitos.iterator();
        while (itCir.hasNext() && !finalizado){
            int turno = 1;
            Circuito circuito = itCir.next();
            
            System.out.println("********************************************************************************************************");
            System.out.println("*** CARRERA<"+turno+"> EN " + circuito.mostrarCaracteristicas() + "***");
            System.out.println("********************************************************************************************************");
            
            celebrarCarrera(circuito);
            
            turno++;
        }
        
        //Que comience la Ceremonia de Entrega de Premios del Campeonato
        entregarPremios();
    }
    
    /**
     * Método que se encarga de 
     * 
     * @param circuito  El circuito que quiere insertarse
     */
    public void entregarPremios(){
        
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
