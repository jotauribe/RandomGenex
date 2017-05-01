package co.random.generator.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guess on 1/5/2017.
 */
public class StatisticalTesterTest {

    @Test
    public void averageTest(){
        RandomNumberSet rns = RectangularNumbersGenerator.generar(4, 5, 7, 8);
        assertTrue(StatisticalTester.averageTest(rns));
    }

}