/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.Jogo;
import junit.framework.TestCase;

/**
 *
 * @author Emerson
 */
public class ControllerJogosTest extends TestCase {
    
    public ControllerJogosTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of encontraRecorde method, of class ControllerJogos.
     */
    public void testEncontraRecorde() {
        System.out.println("* ControllerJogosTest: testEncontraRecorde()");
        int numJogoAnt = 3;
        int num = 4;
        int placar = 24;
        int minimo = 10;
        int maximo = 24;
        int quebraMin = 1;
        int quebraMax = 1;
        ControllerJogos instance = new ControllerJogos();
        Jogo expResult = new Jogo(4,24,10,24,1,1);
        Jogo result = instance.encontraRecorde(numJogoAnt, num, placar, minimo, maximo, quebraMin, quebraMax);
        assertEquals(expResult,result);
    }
}
