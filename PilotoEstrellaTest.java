

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PilotoEstrellaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PilotoEstrellaTest
{
    /**
     * Default constructor for test class PilotoEstrellaTest
     */
    public PilotoEstrellaTest()
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
        Concentracion normal = Concentracion.NORMAL;
        PilotoEstrella piloto = new PilotoEstrella("Pilotin", normal);
    }
    
    @Test
    public void calcularDestreza(){
        /*assertEquals(2.0, piloto.calcularDestreza);*/
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
}