

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CircuitoGravillaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CircuitoGravillaTest
{
    /**
     * Default constructor for test class CircuitoGravillaTest
     */
    public CircuitoGravillaTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void getValorComplejidadTest()
    {
     CircuitoReal circuito1 = new CircuitoReal ("Sepang", Complejidad.MEDIA,
                                                 Distancia.INTERMEDIA);
     assertEquals(1.25, circuito1.getValorComplejidad(), 0.1);
     
     CircuitoReal circuito2 = new CircuitoReal ("Nurburgring", Complejidad.BAJA,
                                                 Distancia.INTERMEDIA);
     assertEquals(1, circuito2.getValorComplejidad(), 0.1);
    

    }
    
    @Test
    public void getValorDistanciaTest()
    {
     CircuitoReal circuito1 = new CircuitoReal ("Sepang", Complejidad.ALTA,
                                                 Distancia.CORTA);
     assertEquals(250.0, circuito1.getValorDistancia(), 0.1);
     
     CircuitoReal circuito2 = new CircuitoReal ("Nurburgring", Complejidad.BAJA,
                                                 Distancia.CORTA);
     assertEquals(250.0, circuito2.getValorDistancia(), 0.1);
        
    }
}
