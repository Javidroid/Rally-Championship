

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrganizacionTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class OrganizacionTest
{
    /**
     * Default constructor for test class OrganizacionTest
     */
    public OrganizacionTest()
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
    public void hayPilotosDisponiblesTest()
    {
        Organizacion organiza2 = Organizacion.getInstancia();
        assertEquals(false, organiza2.hayPilotosDisponibles());
    }

    @Test
    public void mostrarEscuderias()
    {
        Organizacion.getInstancia();
        Organizacion organiza1 = Organizacion.getInstancia();
        organiza1.mostrarEscuderias();
    }

    @Test
    public void inscribirEscuderiasTest()
    {
        EscuderiaReal escuderi1 = new EscuderiaReal("escuderia1", new SortByTotalPuntos(), true, new SortByDeposito(), true);
        EscuderiaReal escuderi2 = new EscuderiaReal("escuderia2", new SortByTotalPuntos(), false, new SortByDeposito(), false);
        EscuderiaReal escuderi3 = new EscuderiaReal("escuderia3", new SortByTotalPuntos(), true, new SortByDeposito(), false);
        Organizacion organiza1 = Organizacion.getInstancia();
        organiza1.inscribirEscuderia(escuderi1);
        organiza1.inscribirEscuderia(escuderi2);
        organiza1.inscribirEscuderia(escuderi3);
        organiza1.mostrarEscuderias();
    }
}



