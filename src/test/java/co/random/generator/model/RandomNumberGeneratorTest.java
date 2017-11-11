package co.random.generator.model;

import co.random.generator.RandomSequence;
import co.random.generator.RandomNumberGenerator;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by DiazHerrera on 30/04/2017.
 */
public class RandomNumberGeneratorTest {
    @Test
    public void generate() throws Exception {
        //RandomNumberGenerator rng = new RandomNumberGenerator(7, 7, 7, 10);
        RandomNumberGenerator rng = new RandomNumberGenerator(94, 81, 89, 100);
        RandomSequence rns = rng.generate();
        int size = rns.size();
        rns.stream()
           .forEach(System.out::println);
        assertEquals(100, size);
    }

    //@Test
    public void math(){
        NormalDistribution nd = new NormalDistribution(0, 1);
        double  d = 1 - 0.83;
        double cp = nd.inverseCumulativeProbability(d + (1-d)/2);
        BigDecimal bd = new BigDecimal(cp);
        System.out.print(bd.toPlainString());
        assertEquals(1.96, cp, 0.005);
    }

}