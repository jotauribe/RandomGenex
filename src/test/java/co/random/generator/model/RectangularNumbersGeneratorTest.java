package co.random.generator.model;

import org.apache.commons.math3.distribution.NormalDistribution;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by DiazHerrera on 30/04/2017.
 */
public class RectangularNumbersGeneratorTest {
    @Test
    public void generar() throws Exception {
        RandomNumberSet rns = RectangularNumbersGenerator.generar(4, 5, 7, 8);
        int size = rns.size();
        assertEquals(8, size);
    }

}