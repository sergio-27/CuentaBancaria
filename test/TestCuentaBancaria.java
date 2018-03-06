/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import gestion.CuentaBancaria;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//import static para poder utilizar metodos de otra clase sin necesidad de pone su nomnbre
import static org.junit.Assert.*;

/**
 *
 * @author alu2015018
 */
public class TestCuentaBancaria {

    public TestCuentaBancaria() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    CuentaBancaria cta;

    @Before
    public void setUp() throws Exception {
        cta = new CuentaBancaria(cantMin);
    }

    @After
    public void tearDown() {
        cta = null;
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    //diferencia que espero entre el esperado y el actual
    static final double DELTA = 0.001;
    static final double cantMin = 50;

    @Test(expected = Exception.class)
    public void testCheckAccountCreation() throws Exception {
        new CuentaBancaria(49);
    }

    @Test
    public void testCrearCuenta() {

        double real = cta.getSaldo();

        assertEquals(cantMin, real, DELTA);
    }

    //ha de obtener la anotacion test, sin argumentos y void
    @Test
    public void testIngresos() {
        //1.Setup consiste en configurar lo que queremos probar, 2. llamada al SUT(Subject Under Test), 3. Comprobaciones

        //2
        cta.ingreso(100);

        //comprobacion
        //el tercer paramentro es una constante que indica el margen de error que queremos obtener
        double esperado = 100 + cantMin;
        double actual = cta.getSaldo();
        assertEquals(esperado, actual, DELTA);
    }
    
    @Test(expected = Exception.class)
    public void testReintegroError() throws Exception{
        cta.reintegro(cantMin + 1);
    }
    
    @Test
    public void testReintegroSucces() throws Exception{
        cta.reintegro(cantMin);
    }
    
    
}
