

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PilotoNovatoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PilotoNovatoTest
{
    /**
     * Default constructor for test class PilotoNovatoTest
     */
    public PilotoNovatoTest()
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
        PilotoNovato pilotoNo1 = new PilotoNovato("piloto1", Concentracion.NORMAL);
        assertEquals(0.78, pilotoNo1.calcularDestreza(), 0.1);
        PilotoNovato pilotoNo2 = new PilotoNovato("piloto2", Concentracion.ZEN);
        assertEquals(0.94, pilotoNo2.calcularDestreza(), 0.1);
    }
}

