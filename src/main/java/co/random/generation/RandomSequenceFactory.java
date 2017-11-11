package co.random.generation;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created on 11/11/2017
 * By Jota Uribe
 **/
public class RandomSequenceFactory {

    private int size;

    private int seed;

    private int multiplier;

    private int increment;

    private int modulus;

    private Set<RandomSequence> randomSequences;

    public RandomSequenceFactory(int size){
        this.size = size;
        randomSequences = new LinkedHashSet();
    }

    public RandomSequence create(){

        modulus = nextPrime(size);

        //TODO Wrap this in a parallel stream
        for(; modulus > 0; modulus++){
            for(increment = modulus - 1; increment > 0; increment--){
                for(multiplier = modulus - 1; multiplier > 0; multiplier--){
                    for(seed = 7; seed < modulus; seed++){
                        RandomSequence randomSequence = new RandomSequence(
                                seed,
                                multiplier,
                                increment,
                                modulus
                        );

                        if (randomSequence.size() >= size
                                && randomSequences.add(randomSequence)) {
                            //System.out.println("SIZE: " + randomSequence.size()
                            //        + " SEED: " + seed
                            //        + " MULTIPLIER: " + multiplier
                            //        + " INCREMENT: " + increment
                            //        + " MODULUS: " + modulus);
                            return randomSequence;
                        }
                    }
                }
            }
        }

        return null;
    }

    private int nextPrime(int startingPoint){
        int next = startingPoint;
        if(isPrime(next))
            return next;
        return nextPrime(startingPoint + 1);

    }

    private boolean isPrime(int number){
        int divisor = number - 1;

        while(divisor > 1){
            if(number%divisor == 0)
                return false;
            divisor--;
        }
        return true;
    }

}
