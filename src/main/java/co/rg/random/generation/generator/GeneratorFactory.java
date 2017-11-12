package co.rg.random.generation.generator;

import co.rg.random.generation.sequence.RandomSequence;
import co.rg.random.generation.sequence.RandomSequenceFactory;

/**
 * Created on 12/11/2017
 * By Jota Uribe
 **/
public class GeneratorFactory {

    public static NormalGenerator createNormalGenerator(int size, double mean, double deviation){
        size = size*12;
        RandomSequenceFactory rsf = new RandomSequenceFactory(size);
        RandomSequence randomSequence = rsf.create();
        NormalGenerator normalGenerator = new NormalGenerator(randomSequence, mean, deviation);
        return normalGenerator;
    }

    public static ExponentialGenerator createExponentialGenerator(int size, double mean){
        RandomSequenceFactory rsf = new RandomSequenceFactory(size);
        RandomSequence randomSequence = rsf.create();
        ExponentialGenerator exponentialGenerator = new ExponentialGenerator(randomSequence, mean);
        return exponentialGenerator;
    }

    public static PoissonGenerator createPoissonGenerator(int size, double mean){
        RandomSequenceFactory rsf = new RandomSequenceFactory(size);
        RandomSequence randomSequence = rsf.create();
        PoissonGenerator poissonGenerator = new PoissonGenerator(randomSequence, (int)mean);
        return poissonGenerator;
    }

}
