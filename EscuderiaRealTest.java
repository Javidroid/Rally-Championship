

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class EscuderiaRealTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EscuderiaRealTest
{
    /**
     * Default constructor for test class EscuderiaRealTest
     */
    public EscuderiaRealTest()
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
    public void insertarPilotosTest()
    {
        EscuderiaReal escuderi2 = new EscuderiaReal("escuderia1", new SortByTotalPuntos(), true,  new SortByDeposito(), true);
        PilotoEstrella pilotoEs1 = new PilotoEstrella("piloto1", Concentracion.NORMAL);
        PilotoEstrella pilotoEs2 = new PilotoEstrella("piloto2", Concentracion.DESPISTADO);
        PilotoExperimentado pilotoEx1 = new PilotoExperimentado("piloto3", Concentracion.CONCENTRADO);
        PilotoNovato pilotoNo1 = new PilotoNovato("piloto4", Concentracion.ZEN);
        PilotoExperimentado pilotoEx2 = new PilotoExperimentado("piloto5", Concentracion.ZEN);
        escuderi2.insertarPiloto(pilotoEs1);
        escuderi2.insertarPiloto(pilotoEs2);
        escuderi2.insertarPiloto(pilotoEx1);
        escuderi2.insertarPiloto(pilotoNo1);
        escuderi2.insertarPiloto(pilotoEx2);
        
        assertEquals(5, escuderi2.getPilotos().size());
    }

    @Test
    public void insertarCochesTest()
    {
        EscuderiaReal escuderi1 = new EscuderiaReal("escuderia2", new SortByTotalPuntos(), false, new SortByDeposito(), false);
        CocheNormal cocheNor1 = new CocheNormal("coche1", Velocidad.TORTUGA, Combustible.NORMAL);
        CocheRapido cocheRap1 = new CocheRapido("coche2", Velocidad.RAPIDO, Combustible.GENEROSO);
        CocheRapido cocheRap2 = new CocheRapido("coche3", Velocidad.GUEPARDO, Combustible.ESCASO);
        CocheResistente cocheRes1 = new CocheResistente("coche4", Velocidad.LENTA, Combustible.ELEFANTE);
        CocheResistente cocheRes2 = new CocheResistente("coche5", Velocidad.NORMAL, Combustible.NORMAL);
        escuderi1.insertarCoche(cocheNor1);
        escuderi1.insertarCoche(cocheRap1);
        escuderi1.insertarCoche(cocheRap2);
        escuderi1.insertarCoche(cocheRes1);
        escuderi1.insertarCoche(cocheRes2);
        assertEquals(5, escuderi1.getCoches().size());
    }
}


