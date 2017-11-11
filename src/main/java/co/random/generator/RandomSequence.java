package co.random.generator;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by JotaUribe on 11/11/2017.
 */
public class RandomSequence implements Iterable{

    private Set<Double> numbers;

    public RandomSequence(){
        numbers = new LinkedHashSet<>();
    }

    public RandomSequence(Set<Double> numbers){
        if(numbers == null)
            throw new IllegalArgumentException("number set can not be null");
        this.numbers = numbers;
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
}
