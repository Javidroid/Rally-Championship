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
    
    Implementar los métodos de las interfaces
    
    Hacer la clase RallyDemo (está en el pseudocódigo)
    
    Revisar la Doc tanto de las clases como de las interfaces
    
    Función MATH.ROUND en las operaciones matemáticas
    
    Para eliminar el resultado de una carrera (por descalificación) se usa un Iterator
  **De esto hay que buscar para qué hay que borrar una carrera por descalificación  
    
    Hacer método que quite capas del decorator
    
    Traducir pseudocódigo de archivos para estudiantes
    Luego hay que meterlo en la carpeta del proyecto
    
    Rellenar el formato de salida a partir de la plantilla en donde corresponda
    
    Hacer las pruebas con JUnit de cada método público (interface) de:
        -Circuito
        -Coche
        -Piloto
        -Escuderia
        -Organizacion
        **Usar Fixtures    
    
     
     Repasar que la doc de las clases SortBy___ y CMP___ está totalmente correcta
     
     Modificar los toString para que coincidan con las características del fichero de salida
     
     Ver cómo se hace para que se reduzca el combustible de reserva sin que de primeras abandone por falta de 
     combustible (pilotoAbstracto.conducir()
     
     Ver cómo se hace para que las salidas, en vez de por pantalla sean (también) por un fichero
     
     Comparadores de circuito y ordenar estos por el criterio que se indica
     tal vez se pueda llamar a un collection.sort.(lista, [instancia_del_comparador_pasada_por_parámetro]);
     
     Hacer que cuando se mande un piloto a la carrera, salga de la lista de pilotos en escudería para prevenir nosequé
     Luego, cuando se termine la carrera, la organización mande de nuevo a los pilotos y coche a su escudería.
     Por tanto, también habrá que quitar el coche de la lista y devolverlo cuando el piloto se baje del coche
     en piloto.bajarseDelCoche();
    
    
    
INFORMARSE: 
    cómo se haría el comparador por cada parámetro sin llenar de clases el proyecto
    
    cómo van los datos de entrada, cuándo se crean los pilotos y los coches porque me resulta
    raro que se creen desde la propia escudería
    
    Si en pilotosCarrera se puede hacer un Set de Map o sería contraproducente porque
    Map en sí ya es una colección de key única
    
    En el Strategy de Escudería: se pueden tener el comparador y el método que ordena en la misma clase
    o habría que hacer las clases comparadoras totalmente aparte, y luego cada estrategia de ordenación aparte
            
    A qué se refiere en la celebración de la carrera de campeonato (al final) que cada piloto se devuelve
    a su escudería. ¿No sería una referencia lo que almacena?
    
    La estructura de organizacion.pilotosCarrera es simplemente un map? o una lista para que se pueda ordenar
    pero luego, cada elemento de la lista es un Map? cosa que no tendría mucho sentido porque lo que
    realmente tiene que almacenar es un KeyValue, no un map entero
    
    Qué hay que hacer exactamente en el método de organización que "permite" inscribirse a las escuderias
    y luego que las escuderías tengan un método para inscribirse
    (supongo que cuando creas la instancia de escuderia, tienes que llamar al método inscribirse y luego
    la propia organización almacena todos los datos en sus estructuras
    
    cómo llamar a la instancia de Organizacion desde fuera de esta clase sin que 
    diga que puede que no se haya inicializado (llamando directamente desde el nombre
    de la clase?)
    
    Cómo asignar los puntos al piloto y como se ordena por tiempo en la carrera
    
    
NOTAS:
    
****DONE:

    CIRCUITO        ESTÁ COMPLETAMENTE TERMINADO Y (salvo excepción) NO HAY QUE TOCAR NADA
    
    COCHE           ESTÁ COMPLETAMENTE TERMINADO Y (salvo excepción) NO HAY QUE TOCAR NADA
    
    PILTO           ESTÁ COMPLETAMENTE TERMINADO Y (salvo añadir métodos) NO HAY QUE TOCAR NADA
    
    ESCUDERÍA       ESTÁ COMPLETAMENTE TERMINADO Y (salvo excepción) NO HAY QUE TOCAR NADA
    
    ORGANIZACIÓN    Faltan métodos por implementar
    
****
    

    instanceof sólo se usa en el método equals
    
    Un buen uso del Map sería de Pilotos, Escudería porque
    cuando están en una carrera como que pierden la escudería que les manda
    
    Escudería usa doblemente el patrón Strategy
    
    Hay que usar al menos un //List, Set (escuderias de organizacion) Y Map (piloto,escuderia).
    
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
    
    Hacer que, cuando las escuderías se inscriban, se guarden los pilotos en el Mapa
    
    Ver cómo se hace para que se reduzca el combustible de reserva sin que de primeras abandone por falta de 
    combustible (pilotoAbstracto.conducir()
     
                    
    
    
    

    
    
