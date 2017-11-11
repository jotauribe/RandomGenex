package co.random.generator;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * Created by DiazHerrera on 30/04/2017.
 */
public class RandomNumberGenerator {

    private int seed;

    private int multiplier;

    private int increment;

    private int modulus;

    public RandomNumberGenerator(int seed,
                                 int multiplier,
                                 int increment,
                                 int modulus) {

        this.seed = seed;
        this.multiplier = multiplier;
        this.increment = increment;
        this.modulus = modulus;
    }

    public RandomSequence generate() {

        LinkedHashSet<Double> randomNumbers = DoubleStream
                .iterate(seed, previousNumber -> generationStrategy(previousNumber))
                .limit(modulus)
                .map(n -> n/modulus)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet<Double>::new));

        return new RandomSequence(randomNumbers);

    }

    public double generationStrategy(double i){
        return ((multiplier*i + increment) % modulus);
    }
}
