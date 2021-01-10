------------------------------------------------------------------------
Este proyecto es la simulación de unos Rallys de Carreras para la 
asignatura Desarrollo de Programas, de la Universidad de Extremadura.
------------------------------------------------------------------------

PROJECT TITLE: Rally Championship
PURPOSE OF PROJECT: Sacar un 10 en DP
VERSION or DATE: 16/11/2020
HOW TO START THIS PROJECT: Leerse el enunciado y hacer un esqueleto de las clases
AUTHORS: Javier Florido, Eugenia Andújar y Carmen Martín
USER INSTRUCTIONS:



TO-DO LIST:
    
    Revisar la Doc tanto de las clases como de las interfaces
    
    Hacer método que quite capas del decorator    
    
    Hacer las pruebas con JUnit de cada método público (interface) de:
        //Circuito
        //Coche
        //Piloto
        //Escuderia
        -Organizacion
        **Usar Fixtures    
    
        cambiar la responsabilidad de mostrar cosas
     
INFORMARSE: 
    
    Aprendido: Como hacer en la escudería para usar el strategy para anidar comparadores de forma arbitraria.
    Porque en el pseudocódigo siempre se anida por puntos, destreza y nombre. ¿y si se quisiera
    anidar por concentracion, nombre y después carreras terminadas?
    
    Aprendido: Tengo muchos comparadores y SortBy, pero porque el enunciado lo pide y no se si es correcto o qué
            
    Aprendido: Cómo ordenar los circuitos usando treeMap y cuándo se ordenan. De hecho, al mandar los datos da error gordo
    
    
    
NOTAS:
    
****DONE:

    CIRCUITO        ESTÁ COMPLETAMENTE TERMINADO Y (salvo excepción) NO HAY QUE TOCAR NADA
    
    COCHE           ESTÁ COMPLETAMENTE TERMINADO Y (salvo excepción) NO HAY QUE TOCAR NADA
    
    PILTO           ESTÁ COMPLETAMENTE TERMINADO Y (salvo añadir métodos) NO HAY QUE TOCAR NADA
    
    ESCUDERÍA       ESTÁ COMPLETAMENTE TERMINADO Y (salvo excepción) NO HAY QUE TOCAR NADA
    
    ORGANIZACIÓN    ESTÁ COMPLETAMENTE TERMINADO PERO HAY QUE REVISAR QUE ESTÉ TODO BIEN
    
****
    

    instanceof sólo se usa en el método equals
    
    Un buen uso del Map sería de Pilotos, Escudería porque
    cuando están en una carrera como que pierden la escudería que les manda
    
    Escudería usa doblemente el patrón Strategy
    
    Hay que usar al menos un List, Set (escuderias de organizacion) Y Map (piloto,escuderia).
    
    ESTRUCTURAS (de collections):
        //Piloto.resultados es un ArrayList de clase Resultado
        
        //Organizacion.circuitos requiere orden (List)
        //Organizacion.escuderias puede ser un Set (para que no se repitan)
        //Organizacion.pilotosCarrera (List porque hay que ordenar los pilotos)
        //Usar el mapa para guardar TODOS los pilotos con su escudería
        
        //Escuderia.pilotos: Importa el orden así que probablemente List
        //Escuderia.coches: igual que arriba
        ***Para estos dos últimos, se requiere orden, por tanto habrá que
        ***usar sort y, por tanto, habrá que usar el Comparator
            
    
        En piloto.infoResultados hay que hacer una serie de métodos donde, 
        dado un circuito te da su tiempo para que el organizador calcule los puntos
        y se los asigne
        Los puntos no pueden darse sin que la clase organizadora los asigne porque depende
        del resto de pilotos. Entonces hay que tener otro método que lo asigne
        Para asignar los puntos la organización tiene que buscar el circuito
        que coincida con el de los resultados del piloto Y COMPARAR CON EQUALS
HECHO: 

    !!!REVISAR!!!: 
    -Hacer el patrón decorator en circuito (complicacionesExtra)
    
    -Implementar método conducir de PilotoAbstracto  
    
    -Ver estructuras para pilotos y coches en Escuderia
        (probablemente List para usar el Sort y el iterator)
    
        -REVISAR EN SUBCLASES DE PILOTO:
    Función Math de redondeo a los métodos que devuelvan 
    directamente un valor (usandolo razonablemente, por ejemplo en getDestreza)
    
    -BajarseDelCoche: pone a nulo el coche del piloto.
    
    Revisar que están todos los métodos definidos en la interface
    
    Usar el patrón Strategy en Escudería para ordenar pilotos y coches
    
    Clase Comparator:
    Repasar apuntes de la clase Comparator, Sort y demás para ordenar Collections e implementar
    
    Método que inscribe a la escudería en el campeonato (???)
     
    ¿Método para añadir coches y pilotos a la escudería?
    
    Ver cómo se hace para que se reduzca el combustible de reserva sin que de primeras abandone por falta de 
    combustible (pilotoAbstracto.conducir()
    
    Hacer que, cuando las escuderías se inscriban, se guarden los pilotos en el Mapa
    
    revisar el metodo enviarPiloto() en escudería para que ponga a null el piloto/coche si no encuentra
    
    Ver cómo se hace para que se reduzca el combustible de reserva sin que de primeras abandone por falta de 
    combustible (pilotoAbstracto.conducir()
     
    Modificar los toString para que coincidan con las características del fichero de salida
    
    Implementar los métodos de las interfaces
    
    Comparadores de circuito y ordenar estos por el criterio que se indica
    tal vez se pueda llamar a un collection.sort.(lista, [instancia_del_comparador_pasada_por_parámetro]);
    
    Hacer que cuando se mande un piloto a la carrera, salga de la lista de pilotos en escudería para prevenir nosequé
    Luego, cuando se termine la carrera, la organización mande de nuevo a los pilotos y coche a su escudería.
    Por tanto, también habrá que quitar el coche de la lista y devolverlo cuando el piloto se baje del coche
    en piloto.bajarseDelCoche();
        
    hacer que el método organizacion.cargarPilotosCarrera() itere sobre las escuderías hasta el límite de pilotos
    o hasta que no haya más pilotos enviables
     
    Ver cómo se hace para que las salidas, en vez de por pantalla sean (también) por un fichero

    ver si es buena idea hacer métodos SortBy para ordenar la lista que sea 
    
    Rellenar el formato de salida a partir de la plantilla en donde corresponda
    
    controlar que, una vez se iteren las escuderías y siga habiendo plazas para la carrera, se vuelva a iterar sobre
    las escuderías para que manden a otro piloto
    
    Hacer la clase RallyDemo (está en el pseudocódigo)
    
    Ver si hace falta eliminar los pilotos y los coches de las escuderias al mandarlos a la organización
    o si no es necesario llevando un control adecuado. Básicamente saber si se pasan por copia o por referencia los punteros
    
    aligerar el método entregarPremios llamando a submétodos
    
    Función MATH.ROUND en las operaciones matemáticas
     
    Traducir pseudocódigo de archivos para estudiantes 
    
    REVISAR: Método que carga los pilotos que van a conducir: no me convence mucho, es muy forzado
    
    metodo calcularVelocidad, en caso de ser coche rapido reduce la nitro un par de veces y esto hay que corregirlo
    
    Repasar que la doc de las clases SortBy___ y CMP___ está totalmente correcta
    
    revisar el funcionamiento de la nitro en cocheRapido
    
    (Hecho:Traducir pseudocódigo de archivos para estudiantes)
    Luego hay que meterlo en la carpeta del proyecto
     
    hacer bien los hashcode de escudería
    
    arreglar el bug que guarda los resultados con numeros redondeados
    
    usar el getClassName para los pilotos y coches subclase
    
    Errores Solucionados:
     piloto 5 (ogier) de la carrera en australia se le asigna un coche erróneo y hace que no finalice 
     (comparador mal asignado. Se puso sortByCombustible y se tenia que haber puesto SortByDeposito)
     
     a Loeb (posición 3 de carrera en australia) no se le asignan puntos (se queda en -1)
     (Al asignar los puntos había un bucle for tal que i<pilotosCarrera.size(). entonces se quedaba uno suelto)
     
     breakpoint en linea 421 de organizacion para ver cuándo se inserta un coche nulo y un piloto doble
     (dentro del metodo de devolverPilotos)
     
     corregir: muestra algunas carreras sin redondear el tiempo (los resultados negativos)
     
     Revisar que el formato de plantilla de salida es correcto
     
     tal vez ordenar los coches dentro de la escuderia --> hacer un método juntar coches y pilotos para mostrar los resultados

     IMPORTANTE: asegurarse de que todos los métodos públicos de cada clase estén en su interfaz
     
     
     
     
     
     
     
     
     
     
     
     
    
    
    
     
     
     
                    
    
    
    

    
    
