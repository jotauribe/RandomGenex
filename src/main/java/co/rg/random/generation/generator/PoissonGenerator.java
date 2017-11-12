package co.rg.random.generation.generator;

import co.rg.random.generation.sequence.RandomSequence;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created on 11/11/2017
 * By Jota Uribe
 **/
public class PoissonGenerator implements NumberGenerator {

    private RandomSequence randomSequence;

    private Iterator sequenceIterator;

    private Set<Interval> intervals;

    private int lambda;

    public PoissonGenerator(RandomSequence randomSequence,
                            int lambda) {

        sequenceIterator = randomSequence.iterator();
        this.randomSequence = randomSequence;
        this.lambda = lambda;
        calculateIntervals();
    }

    private void calculateIntervals(){
        intervals = new LinkedHashSet();
        double lowerLimit = 0;
        double upperLimit = Math.exp(-lambda)* Math.pow(lambda, 0);
        //System.out.println(String.format( "%.8f", lowerLimit ));
        intervals.add(new Interval(lowerLimit, upperLimit, 0));

        for (int i = 1; i < 30; i++){
            lowerLimit = upperLimit;
            double n = (Math.exp(-lambda)* Math.pow(lambda, i));
            BigDecimal bn = BigDecimal.valueOf(n);
            BigDecimal result = bn.divide(factorialOf(i), 8, RoundingMode.HALF_EVEN);
            upperLimit = result.doubleValue() + lowerLimit;
            intervals.add(new Interval(lowerLimit, upperLimit, i));
        }
    }

    public BigDecimal factorialOf(int number){
        if (number == 1)
            return BigDecimal.valueOf(1);
        BigDecimal originalNumber = BigDecimal.valueOf(number);
        return originalNumber.multiply(factorialOf(number - 1));
    }

    @Override
    public Double nextValue() {
        if(hasNextValue()){
            double nextValue = (Double)sequenceIterator.next();
            for (Interval i : intervals){
                if(i.isInTheInterval(nextValue))
                    return i.value;
            }
        }

        return null;
    }

    @Override
    public boolean hasNextValue() {
        return sequenceIterator.hasNext();
    }

    public class Interval{

        private double lowerLimit;

        private double upperLimit;

        private double value;

        public Interval(double lowerLimit, double upperLimit, int value) {
            if(lowerLimit > upperLimit)
                throw  new IllegalArgumentException("Invalids limits");
            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
            this.value = value;
        }

        public boolean isInTheInterval(double number){
            return (number >= lowerLimit && number < upperLimit);
        }
    }

}
