package co.random.generator;

import java.util.stream.IntStream;

/**
 * Created on 11/11/2017
 * By Jota Uribe
 **/
public class RandomSequenceGenerator {

    private int size;

    int seed;

    int multiplier;

    int increment;

    int modulus;

    public RandomSequenceGenerator(int size){
        this.size = size;
    }

    public RandomSequence generate(){

        modulus = nextPrime(size);

        for(; modulus > 0; modulus++){
            for(increment = modulus - 1; increment > 0; increment--){
                for(multiplier = modulus - 1; multiplier > 0; multiplier--){
                    for(seed = 7; seed < modulus; seed++){
                        RandomNumberGenerator rng = new RandomNumberGenerator(seed, multiplier, increment, modulus);
                        RandomSequence rs = rng.generate();

                        if (rs.size()>= size) {
                            System.out.println("SIZE: " + rs.size()
                                    + " SEED: " + seed
                                    + " MULTIPLIER: " + multiplier
                                    + " INCREMENT: " + increment
                                    + " MODULUS: " + modulus);
                            return rs;
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
