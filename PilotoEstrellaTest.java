

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
    public void calcularDestrezaTest()
    {
        PilotoEstrella pilotoEs1 = new PilotoEstrella("piloto1", Concentracion.NORMAL);
        assertEquals(0.85, pilotoEs1.calcularDestreza(), 0.2);
        PilotoEstrella pilotoEs2 = new PilotoEstrella("piloto2", Concentracion.ZEN);
        assertEquals(1.00, pilotoEs2.calcularDestreza(), 0.2);
    }
}

