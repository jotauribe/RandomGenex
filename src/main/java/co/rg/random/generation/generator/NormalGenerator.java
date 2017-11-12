package co.rg.random.generation.generator;

import co.rg.random.generation.sequence.RandomSequence;

import java.util.Iterator;

/**
 * Created on 11/11/2017
 * By Jota Uribe
 **/
public class NormalGenerator implements NumberGenerator{

    private RandomSequence randomSequence;

    private Iterator sequenceIterator;

    private double mean;

    private double variance;

    public NormalGenerator(RandomSequence randomSequence,
                           double mean,
                           double variance) {

        sequenceIterator = randomSequence.iterator();
        this.randomSequence = randomSequence;
        this.mean = mean;
        this.variance = variance;
    }

    public boolean hasNextValue(){
        return sequenceIterator.hasNext();
    }

    public Double nextValue(){
        double summation = 0;
        int counter = 0;
        while( counter < 12
                && sequenceIterator.hasNext() ){

            summation += (Double)sequenceIterator.next();
            counter++;
        }
        double nextValue = mean + variance*(summation - 6);
        return nextValue;
    }
}
