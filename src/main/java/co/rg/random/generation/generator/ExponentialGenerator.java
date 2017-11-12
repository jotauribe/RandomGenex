package co.rg.random.generation.generator;

import co.rg.random.generation.sequence.RandomSequence;

import java.util.Iterator;

/**
 * Created on 12/11/2017
 * By Jota Uribe
 **/
public class ExponentialGenerator implements NumberGenerator {

    private RandomSequence randomSequence;

    private Iterator sequenceIterator;

    private double mean;

    public ExponentialGenerator(RandomSequence randomSequence,
                                double mean) {

        sequenceIterator = randomSequence.iterator();
        this.randomSequence = randomSequence;
        this.mean = mean;
    }

    @Override
    public Double nextValue() {
        if (!hasNextValue())
            return null;
        double nextValue = -(mean) * Math.log((Double)sequenceIterator.next());
        if (Double.isInfinite(nextValue))
            return 0d;
        return nextValue;
    }

    @Override
    public boolean hasNextValue() {
        return sequenceIterator.hasNext();
    }
}
