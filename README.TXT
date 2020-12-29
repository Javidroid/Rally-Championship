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



NOTAS:
    
****DONE:

    CIRCUITO        ESTÁ COMPLETAMENTE TERMINADO Y (salvo excepción) NO HAY QUE TOCAR NADA
    
    COCHE           ESTÁ COMPLETAMENTE TERMINADO Y (salvo excepción) NO HAY QUE TOCAR NADA
    
    PILTO           ESTÁ COMPLETAMENTE TERMINADO Y (salvo añadir métodos) NO HAY QUE TOCAR NADA
    
    ESCUDERÍA       - (Faltan métodos por implementar)
    
    ORGANIZACIÓN    - (Faltan métodos por definir e implementar)
    
****
    

    instanceof sólo se usa en el método equals
    
    Un buen uso del Map sería de Pilotos, Escudería porque
    cuando están en una carrera como que pierden la escudería que les manda
    
    Escudería usa doblemente el patrón Strategy
    
    Hay que usar al menos un //List, Set (escuderias de organizacion) Y Map (piloto,escuderia).
    
    ESTRUCTURAS (de collections):
        //Piloto.resultados es un ArrayList de clase Resultado
        
        Organizacion.circuitos requiere orden (List)
        Organizacion.escuderias puede ser un Set (para que no se repitan)
        Organizacion.pilotos (cada piloto podría ser un Map<Piloto,Escuderia>)
            y este a su vez un Set de estos Map
        
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

TO-DO LIST:
        
    Revisar que están todos los métodos definidos en la interface
    
    Usar el patrón Strategy en Escudería para mandar pilotos y coches
    
    Implementar los métodos de las interfaces (FALTA: Escuderia)
    
    Hacer las clases de prueba
    
    Hacer la clase RallyDemo
    
    Revisar la Doc tanto de las clases como de las interfaces
    
    Función MATH.ROUND en las operaciones matemáticas
    
    Para eliminar el resultado de una carrera (por descalificación) se usa un Iterator
  **De esto hay que buscar para qué hay que borrar una carrera por descalificación  
    
    Hacer método que quite capas del decorator
       
    Clase Comparator:
    Repasar apuntes de la clase Comparator, Sort y demás para ordenar Collections e implementar
    
    BajarseDelCoche: pone a nulo el coche del piloto.
    
    
HECHO: 

    !!!REVISAR!!!: 
    -Hacer el patrón decorator en circuito (complicacionesExtra)
    -Implementar método conducir de PilotoAbstracto  
    -Ver estructuras para pilotos y coches en Escuderia
        (probablemente List para usar el Sort y el iterator)
    -REVISAR EN SUBCLASES DE PILOTO:
    Función Math de redondeo a los métodos que devuelvan 
    directamente un valor (usandolo razonablemente, por ejemplo en getDestreza)   
     
                    
    
    
    

    
    
