
import java.util.*;
/**
 * Clase que inicializa la simulación con datos con los que 
 * el campeonato termina de forma normal
 * 
 * @author profesores DP 
 * @version 20/21
 */
public class DatosCampeonatoCompleto{
    public DatosCampeonatoCompleto(){        
        System.out.println("*********************************************************************************************************");
        System.out.println("*****************ESTA SIMULACIÓN CONCLUYE NORMALMENTE COMPLETÁNDOSE TODAS LAS CARRERAS*******************");        
        System.out.println("*********************************************************************************************************\n");

        initData();
    }

    private void initData()
    {
        //organizador debe ser una instancia única con la siguiente configuración:
        // Circuitos ordenados de forma descendente de acuerdo a su distancia
        Organizacion organizacion = Organizacion.getInstancia(Collections.reverseOrder(new CMPDistanciaCircuito()), 3, 6);

        //creamos y añadimos los circuitos del campeonato:
        //Crear circuito portugal con nombre:”Portugal" - complejidad:MEDIA - distancia:INTERMEDIA);
        //además, acciones necesarias para que portugal sea un circuito con:
        //Gravilla y Nocturno
        //añadir circuito portugal a circuitos de la organización
        Circuito portugal = new CircuitoReal("Portugal", Complejidad.MEDIA, Distancia.INTERMEDIA);
        portugal = new Gravilla(portugal);
        portugal = new Nocturno(portugal);
        organizacion.insertarCircuito(portugal);

        //Crear circuito cerdena con nombre:”Cerdeña" - complejidad:ALTA - distancia:CORTA);
        //además, acciones necesarias para que cerdena sea un circuito con:
        //Gravilla y Mojado
        //añadir circuito cerdena a circuitos de la organización
        Circuito cerdena = new CircuitoReal("Cerdeña", Complejidad.ALTA, Distancia.CORTA);
        portugal = new Gravilla(cerdena);
        portugal = new Mojado(cerdena);
        organizacion.insertarCircuito(cerdena);

        //Crear circuito australia con nombre:”Australia" - complejidad:BAJA - distancia:LARGA);
        //además, acciones necesarias para que australia sea un circuito con:
        //Gravilla 
        //añadir circuito australia a circuitos de la organización
        Circuito australia = new CircuitoReal("Australia", Complejidad.BAJA, Distancia.LARGA);
        australia = new Gravilla(australia);
        organizacion.insertarCircuito(australia);

        //Crear circuito corcega con nombre:”Córcega" - complejidad:MEDIA - distancia:INTERMEDIA);
        //además, acciones necesarias para que corcega sea un circuito con:
        //Nocturno y Gravilla
        //añadir circuito corcega a circuitos de la organización    
        Circuito corcega = new CircuitoReal("Córcega", Complejidad.MEDIA, Distancia.INTERMEDIA);
        corcega = new Nocturno(corcega);
        corcega = new Gravilla(corcega);
        organizacion.insertarCircuito(corcega);

        //Crear circuito finlandia con nombre:”Finlandia" - complejidad:ALTA - distancia:CORTA);
        //además, acciones necesarias para que finlandia sea un circuito con:
        //Nocturno, Frío y Mojado
        //añadir circuito finlandia a circuitos de la organización
        Circuito finlandia = new CircuitoReal("Finlandia", Complejidad.ALTA, Distancia.CORTA);
        finlandia = new Nocturno(finlandia);
        finlandia = new Frio(finlandia);
        finlandia = new Mojado(finlandia);
        organizacion.insertarCircuito(finlandia);

        //Crear circuito alemania con nombre:”Alemania" - complejidad:MEDIA - distancia:INTERMEDIA);
        //además, acciones necesarias para que alemania sea un circuito con:
        //Mojado
        //añadir circuito alemania a circuitos de la organización
        Circuito alemania = new CircuitoReal("Alemania", Complejidad.MEDIA, Distancia.INTERMEDIA);
        alemania = new Mojado(alemania);
        organizacion.insertarCircuito(alemania);

        //Crear circuito chile con nombre:”Chile" - complejidad:ALTA - distancia:CORTA);
        //además, acciones necesarias para que chile sea un circuito con:
        //Gravilla
        //añadir circuito chile a circuitos de la organización
        Circuito chile = new CircuitoReal("Chile", Complejidad.ALTA, Distancia.CORTA);
        chile = new Gravilla(chile);
        organizacion.insertarCircuito(chile);

        
        // System.out.println(portugal.mostrarCaracteristicas());
        // System.out.println(cerdena.mostrarCaracteristicas());
        // System.out.println(australia.mostrarCaracteristicas());
        // System.out.println(corcega.mostrarCaracteristicas());
        // System.out.println(finlandia.mostrarCaracteristicas());
        // System.out.println(alemania.mostrarCaracteristicas());
        // System.out.println(chile.mostrarCaracteristicas());


        //creamos e inscribimos a las escuderías que participarán en el campeonato:    
        //Crear escuderia peugeot con nombre:"Peugeot"
        //ordenaciónPilotos: ASCENDENTE por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
        //ordenaciónCoches: ASCENDENTE por Combustible restante del Coche , en caso de empate por nombre);
        //peugeot se inscribe en campeonato
        Escuderia peugeot = new EscuderiaReal("Peugeot", new SortByTotalPuntos(), true, new SortByDeposito(), true);

        //escudería citroen 
        //Crear escuderia citroen con nombre:"Citroen"      
        //ordenaciónPilotos: DESCENDENTE por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
        //ordenaciónCoches: DESCENDENTE por Combustible restante del Coche , en caso de empate por nombre);
        //citroen se inscribe en campeonato
        Escuderia citroen = new EscuderiaReal("Citroen", new SortByTotalPuntos(), false, new SortByDeposito(), false);

        //escudería seat       
        //Crear escuderia seat con nombre:"Seat"
        //ordenaciónPilotos: ASCENDENTE por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
        //ordenaciónCoches: ASCENDENTE por Combustible restante del Coche , en caso de empate por nombre);
        //seat se inscribe en campeonato
        Escuderia seat = new EscuderiaReal("Seat", new SortByTotalPuntos(), true, new SortByDeposito(), true);

        // peugeot.toString();
        // citroen.toString();
        // seat.toString();


        //creamos los pilotos y los coches de cada escudería 
        //coches y pilotos de citroen
        //añadir a citroen un CocheResistente(nombre:"Citröen C5" - velocidad:RAPIDA - combustible:ELEFANTE);
        //añadir a citroen un CocheRapido(nombre:"Citröen C4" - velocidad:RAPIDA - combustible:ESCASO);
        //añadir a citroen un Coche(nombre:"Citröen C3" - velocidad:RAPIDA - combustible:ESCASO);
        //añadir a citroen un PilotoExperimentado(nombre:"Loeb" - concentración: NORMAL));
        //añadir a citroen un PilotoEstrella(nombre:"Makinen" - concentración: ZEN));
        //añadir a citroen un PilotoNovato(nombre:"Auriol" - concentración: NORMAL));
        citroen.insertarCoche(new CocheResistente("Citröen C5", Velocidad.RAPIDO, Combustible.ELEFANTE));
        citroen.insertarCoche(new CocheRapido("Citröen C4", Velocidad.RAPIDO, Combustible.ESCASO));
        citroen.insertarCoche(new CocheNormal("Citröen C3", Velocidad.RAPIDO, Combustible.ESCASO));
        citroen.insertarPiloto(new PilotoExperimentado("Loeb", Concentracion.NORMAL));
        citroen.insertarPiloto(new PilotoEstrella("Makinen", Concentracion.ZEN));
        citroen.insertarPiloto(new PilotoNovato("Auriol", Concentracion.NORMAL));

        //coches y pilotos de seat
        //añadir a seat un CocheResistente(nombre:"Seat Tarraco" - velocidad:TORTUGA - combustible:GENEROSO);
        //añadir a seat un CocheRapido(nombre:"Seat Ateca" - velocidad:GUEPARDO - combustible:GENEROSO);
        //añadir a seat un Coche(nombre:"Seat Arona" - velocidad:RAPIDA - combustible:ESCASO);
        //añadir a seat un PilotoExperimentado(nombre:"Ogier" - concentración: NORMAL));
        //añadir a seat un PilotoEstrella(nombre:"McRae" - concentración: CONCENTRADO));
        //añadir a seat un PilotoNovato(nombre:"Blomquist" - concentración: DESPISTADO));
        seat.insertarCoche(new CocheResistente("Seat Tarraco", Velocidad.TORTUGA, Combustible.GENEROSO));
        seat.insertarCoche(new CocheRapido("Seat Ateca", Velocidad.GUEPARDO, Combustible.GENEROSO));
        seat.insertarCoche(new CocheNormal("Seat Arona", Velocidad.RAPIDO, Combustible.ESCASO));
        seat.insertarPiloto(new PilotoExperimentado("Ogier", Concentracion.NORMAL));
        seat.insertarPiloto(new PilotoEstrella("McRae", Concentracion.CONCENTRADO));
        seat.insertarPiloto(new PilotoNovato("Blomquist", Concentracion.DESPISTADO));

        //coches y pilotos de peugeot
        //añadir a peugeot un CocheResistente(nombre:"Peugeot 5008" - velocidad:LENTA - combustible:GENEROSO);
        //añadir a peugeot un CocheRapido(nombre:"Peugeot 3008" - velocidad:GUEPARDO - combustible:NORMAL);
        //añadir a peugeot un Coche(nombre:"Peugeot 2008" - velocidad:NORMAL - combustible:ESCASO);
        //añadir a peugeot un PilotoExperimentado(nombre:"Kankunnen" - concentración: CONCENTRADO));
        //añadir a peugeot un PilotoEstrella(nombre:"Sainz" - concentración: ZEN ));
        //añadir a peugeot un PilotoNovato(nombre:"Sordo" - concentración: DESPISTADO));
        peugeot.insertarCoche(new CocheResistente("Peugeot 5008", Velocidad.LENTA, Combustible.GENEROSO));
        peugeot.insertarCoche(new CocheRapido("Peugeot 3008", Velocidad.GUEPARDO, Combustible.NORMAL));
        peugeot.insertarCoche(new CocheNormal("Peugeot 2008", Velocidad.NORMAL, Combustible.ESCASO));
        peugeot.insertarPiloto(new PilotoExperimentado("Kankunnen", Concentracion.CONCENTRADO));
        peugeot.insertarPiloto(new PilotoEstrella("Sainz", Concentracion.ZEN));
        peugeot.insertarPiloto(new PilotoNovato("Sordo", Concentracion.DESPISTADO));

        //inscribimos las escuderías al final porque al inscribir se guardan los pilotos en el mapa
        //y tienen que estar cargados los pilotos en la escuderia
        peugeot.inscribirse();
        citroen.inscribirse();
        seat.inscribirse();
    }

}
