

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CocheResistenteTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CocheResistenteTest
{
    /**
     * Default constructor for test class CocheResistenteTest
     */
    public CocheResistenteTest()
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
    public void calcularVelocidadRealTest()
    {
      PilotoExperimentado pilotoEx1 = new PilotoExperimentado("piloto1", Concentracion.ZEN);
      CircuitoReal circuito1 = new CircuitoReal ("SilverStone", Complejidad.ALTA,
                                                 Distancia.LARGA);
      CocheRapido cocheRapid = new CocheRapido ("Renault", Velocidad.TORTUGA, 
                                                Combustible.NORMAL);
       
      assertEquals(155.29, cocheRapid.calcularVelocidadReal(pilotoEx1, circuito1 ), 0.3);
   
     PilotoExperimentado pilotoEx2 = new PilotoExperimentado("piloto2", Concentracion.DESPISTADO);
     CircuitoReal circuito2 = new CircuitoReal ("Interlagos", Complejidad.BAJA,
                                               Distancia.CORTA);
     CocheRapido cocheRapid2 = new CocheRapido ("Seat", Velocidad.LENTA, 
                                               Combustible.ESCASO);
       
     assertEquals(186.48, cocheRapid2.calcularVelocidadReal(pilotoEx2, circuito2 ), 0.3);
      
    }
    
}
