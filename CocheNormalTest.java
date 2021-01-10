

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CocheNormalTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CocheNormalTest
{
    /**
     * Default constructor for test class CocheNormalTest
     */
    public CocheNormalTest()
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
      PilotoExperimentado pilotoEx1 = new PilotoExperimentado("piloto1", Concentracion.DESPISTADO);
      CircuitoReal circuito1 = new CircuitoReal ("Mónaco", Complejidad.MEDIA,
                                                 Distancia.INTERMEDIA);
      CocheRapido cocheRapid = new CocheRapido ("Seat", Velocidad.NORMAL, 
                                                Combustible.NORMAL);
       
      assertEquals(156.29, cocheRapid.calcularVelocidadReal(pilotoEx1, circuito1 ), 0.5);
   
      PilotoExperimentado pilotoEx2 = new PilotoExperimentado("piloto2", Concentracion.CONCENTRADO);
      CircuitoReal circuito2 = new CircuitoReal ("Funji Speedway", Complejidad.BAJA,
                                                 Distancia.CORTA);
      CocheRapido cocheRapid2 = new CocheRapido ("Seat", Velocidad.NORMAL, 
                                                Combustible.ESCASO);
       
      assertEquals(237.4, cocheRapid2.calcularVelocidadReal(pilotoEx2, circuito2 ), 0.5);
      
    }}