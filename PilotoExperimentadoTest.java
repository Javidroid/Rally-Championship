

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PilotoExperimentadoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PilotoExperimentadoTest
{
    /**
     * Default constructor for test class PilotoExperimentadoTest
     */
    public PilotoExperimentadoTest()
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
        PilotoExperimentado pilotoEx1 = new PilotoExperimentado("piloto1", Concentracion.NORMAL);
        assertEquals(0.82, pilotoEx1.calcularDestreza(), 0.1);
        PilotoExperimentado pilotoEx2 = new PilotoExperimentado("piloto2", Concentracion.ZEN);
        assertEquals(0.97, pilotoEx2.calcularDestreza(), 0.1);
    }
}

