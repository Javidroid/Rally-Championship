

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CircuitoNocturnoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CircuitoNocturnoTest
{
    /**
     * Default constructor for test class CircuitoNocturnoTest
     */
    public CircuitoNocturnoTest()
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
     CircuitoReal circuito1 = new CircuitoReal ("Yas Marina", Complejidad.ALTA,
                                                 Distancia.INTERMEDIA);
     assertEquals(1.5, circuito1.getValorComplejidad(), 0.1);
     
     CircuitoReal circuito2 = new CircuitoReal ("Singapur", Complejidad.BAJA,
                                                 Distancia.INTERMEDIA);
     assertEquals(1, circuito2.getValorComplejidad(), 0.1);
        
    }
    
    @Test
    public void getValorDistanciaTest()
    {
     CircuitoReal circuito1 = new CircuitoReal ("Yas Marina", Complejidad.ALTA,
                                                 Distancia.LARGA);
     assertEquals(300.0, circuito1.getValorDistancia(), 0.1);
     
     CircuitoReal circuito2 = new CircuitoReal ("Singapur", Complejidad.BAJA,
                                                 Distancia.LARGA);
     assertEquals(300.0, circuito2.getValorDistancia(), 0.1);
        
    }
}
