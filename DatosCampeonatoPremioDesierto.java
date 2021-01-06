/**
 * Clase que inicializa la simulación con datos con los que 
 * el campeonato termina antes por estar todos los pilotos descalificados
 * 
 * @author profesores DP 
 * @version 20/21
 */
public class DatosCampeonatoPremioDesierto{
    public DatosCampeonatoPremioDesierto(){        
        System.out.println("*********************************************************************************************************");
        System.out.println("****ESTA SIMULACIÓN CONCLUYE ANTES DE FINALIZAR EL CAMPEONATO CON TODOS LOS PILOTOS DESCALIFICADOS****");        
        System.out.println("*********************************************************************************************************\n");

        initData();
    }


    private void initData()
    {
        //organizador debe ser una instancia única con la siguiente configuración:
        //LimiteAbandonos=1, LimitePilotos=3, 
        // Circuitos ordenados de forma descendente de acuerdo a su distancia

        //creamos y añadimos los circuitos del campeonato:
        //Crear circuito portugal con nombre:”Portugal" - complejidad:MEDIA - distancia:INTERMEDIA);
        //además, acciones necesarias para que portugal sea un circuito con:
        //Gravilla y Nocturno
        //añadir circuito portugal a circuitos de la organización

        //Crear circuito cerdena con nombre:”Cerdeña" - complejidad:ALTA - distancia:CORTA);
        //además, acciones necesarias para que cerdena sea un circuito con:
        //Gravilla y Mojado
        //añadir circuito cerdena a circuitos de la organización

        //Crear circuito australia con nombre:”Australia" - complejidad:BAJA - distancia:LARGA);
        //además, acciones necesarias para que australia sea un circuito con:
        //Gravilla 
        //añadir circuito australia a circuitos de la organización

        //Crear circuito corcega con nombre:”Córcega" - complejidad:MEDIA - distancia:INTERMEDIA);
        //además, acciones necesarias para que corcega sea un circuito con:
        //Nocturno y Gravilla
        //añadir circuito corcega a circuitos de la organización		

        //Crear circuito finlandia con nombre:”Finlandia" - complejidad:ALTA - distancia:CORTA);
        //además, acciones necesarias para que finlandia sea un circuito con:
        //Nocturno, Frío y Mojado
        //añadir circuito finlandia a circuitos de la organización

        //Crear circuito alemania con nombre:”Alemania" - complejidad:MEDIA - distancia:INTERMEDIA);
        //además, acciones necesarias para que alemania sea un circuito con:
        //Mojado
        //añadir circuito alemania a circuitos de la organización

        //Crear circuito chile con nombre:”Chile" - complejidad:ALTA - distancia:CORTA);
        //además, acciones necesarias para que chile sea un circuito con:
        //Gravilla
        //añadir circuito chile a circuitos de la organización

        //creamos e inscribimos a las escuderías que participarán en el campeonato:    
        //Crear escuderia peugeot con nombre:"Peugeot"
        //ordenaciónPilotos: descendente por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
        //ordenaciónCoches: ascendente por Combustible restante del Coche , en caso de empate por nombre);
        //peugeot se inscribe en campeonato

        //escudería citroen 
        //Crear escuderia citroen con nombre:"Citroen"		
        //ordenaciónPilotos: ascendente por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
        //ordenaciónCoches: ascendente por Combustible restante del Coche , en caso de empate por nombre);
        //citroen se inscribe en campeonato

        //escudería seat       
        //Crear escuderia seat con nombre:"Seat"
        //ordenaciónPilotos: descendente por Puntos del Piloto, en caso de empate por Destreza, en caso de empate por nombre
        //ordenaciónCoches: ascendente por Combustible restante del Coche , en caso de empate por nombre);
        //seat se inscribe en campeonato

        //creamos los pilotos y los coches de cada escudería 
        //coches y pilotos de citroen
        //añadir a citroen un CocheResistente(nombre:"Citröen C5" - velocidad:RAPIDA - combustible:ELEFANTE);
        //añadir a citroen un CocheRapido(nombre:"Citröen C4" - velocidad:RAPIDA - combustible:ESCASO);
        //añadir a citroen un Coche(nombre:"Citröen C3" - velocidad:RAPIDA - combustible:ESCASO);
        //añadir a citroen un PilotoExperimentado(nombre:"Loeb" - concentración: NORMAL));
        //añadir a citroen un PilotoEstrella(nombre:"Makinen" - concentración: ZEN));
        //añadir a citroen un PilotoNovato(nombre:"Auriol" - concentración: NORMAL));

        //coches y pilotos de seat
        //añadir a seat un CocheResistente(nombre:"Seat Tarraco" - velocidad:TORTUGA - combustible:GENEROSO);
        //añadir a seat un CocheRapido(nombre:"Seat Ateca" - velocidad:GUEPARDO - combustible:GENEROSO);
        //añadir a seat un Coche(nombre:"Seat Arona" - velocidad:RAPIDA - combustible:ESCASO);
        //añadir a seat un PilotoExperimentado(nombre:"Ogier" - concentración: NORMAL));
        //añadir a seat un PilotoEstrella(nombre:"McRae" - concentración: CONCENTRADO));
        //añadir a seat un PilotoNovato(nombre:"Blomquist" - concentración: DESPISTADO));

        //coches y pilotos de peugeot
        //añadir a peugeot un CocheResistente(nombre:"Peugeot 5008" - velocidad:LENTA - combustible:GENEROSO);
        //añadir a peugeot un CocheRapido(nombre:"Peugeot 3008" - velocidad:GUEPARDO - combustible:NORMAL);
        //añadir a peugeot un Coche(nombre:"Peugeot 2008" - velocidad:NORMAL - combustible:ESCASO);
        //añadir a peugeot un PilotoExperimentado(nombre:"Kankunnen" - concentración: CONCENTRADO));
        //añadir a peugeot un PilotoEstrella(nombre:"Sainz" - concentración: ZEN ));
        //añadir a peugeot un PilotoNovato(nombre:"Sordo" - concentración: DESPISTADO));

    }

}
