package co.random.generation;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Created by JotaUribe on 11/11/2017.
 */
public class RandomSequence implements Iterable{

    private int seed;

    private int multiplier;

    private int increment;

    private int modulus;

    private Set<Double> numbers;

    public RandomSequence(int seed,
                          int multiplier,
                          int increment,
                          int modulus) {

        this.seed = seed;
        this.multiplier = multiplier;
        this.increment = increment;
        this.modulus = modulus;
        generateNumbers();
    }

    private void generateNumbers(){
        numbers = DoubleStream
                .iterate(seed, previousNumber -> generationStrategy(previousNumber))
                .limit(modulus)
                .map(n -> n/modulus)
                .boxed()
                .collect(Collectors.toCollection(LinkedHashSet<Double>::new));
    }

    public double generationStrategy(double i){
        return ((multiplier*i + increment) % modulus);
    }

    public static RandomSequence next(int size){
        RandomSequenceFactory generator = new RandomSequenceFactory(size);
        return generator.create();
    }

    public boolean add(Double number){
        return numbers.add(number);
    }

    public int size(){
        return numbers.size();
    }

    public double mean(){
        double summation = numbers
                .stream()
                .mapToDouble(i -> i.doubleValue())
                .sum();

        return summation/(double)size();
    }

    public Stream<Double> stream(){
        return numbers.stream();
    }

    @Override
    public Iterator iterator() {
        return numbers.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RandomSequence that = (RandomSequence) o;

        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return numbers.hashCode();
    }
}
