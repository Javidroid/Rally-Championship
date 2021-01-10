         
        
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CocheRapidoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CocheRapidoTest
{
    /**
     * Default constructor for test class CocheRapidoTest
     */
    public CocheRapidoTest()
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
      PilotoExperimentado pilotoEx1 = new PilotoExperimentado("piloto1", Concentracion.NORMAL);
      CircuitoReal circuito1 = new CircuitoReal ("Yas Marina", Complejidad.ALTA,
                                                 Distancia.INTERMEDIA);
      CocheRapido cocheRapid1 = new CocheRapido ("Renault", Velocidad.GUEPARDO, 
                                                Combustible.GENEROSO);
       
      assertEquals(157.44, cocheRapid1.calcularVelocidadReal(pilotoEx1, circuito1 ), 0.1);
       
      
      PilotoExperimentado pilotoEx2 = new PilotoExperimentado("piloto2", Concentracion.CONCENTRADO);
      CircuitoReal circuito2 = new CircuitoReal ("Montmeló", Complejidad.BAJA,
                                                 Distancia.INTERMEDIA);
      CocheRapido cocheRapid2 = new CocheRapido ("Coupé", Velocidad.RAPIDO, 
                                                Combustible.GENEROSO);
       
      assertEquals(248.4, cocheRapid2.calcularVelocidadReal(pilotoEx2, circuito2 ), 0.1);
    }
}
