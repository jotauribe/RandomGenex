package co.rg.random.generation.generator;

import co.rg.random.generation.sequence.RandomSequence;

import java.util.Iterator;

/**
 * Created on 12/11/2017
 * By Jota Uribe
 **/
public class UniformGenerator implements NumberGenerator {

    private RandomSequence randomSequence;

    private Iterator sequenceIterator;

    private double lowerLimit;

    private double upperLimit;

    public UniformGenerator(RandomSequence randomSequence,
                            double lowerLimit,
                            double upperLimit) {
        sequenceIterator = randomSequence.iterator();
        this.randomSequence = randomSequence;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    @Override
    public Double nextValue() {
        if(hasNextValue()){
            return ((upperLimit - lowerLimit)*(double)sequenceIterator.next()) + lowerLimit;
        }
        return null;
    }

    @Override
    public boolean hasNextValue() {
        return sequenceIterator.hasNext();
    }
}
