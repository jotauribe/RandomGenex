package co.random.generator;

import java.util.stream.DoubleStream;

/**
 * Created on 10/11/2017
 * By Jota Uribe
 **/
public class Main {

    public static void main(String[] args){

        int seed = 4, multiplier = 5, additiveConstant = 7, modulus = 8;

        //RandomNumberGenerator rng = new RandomNumberGenerator(97, 81, 93, 151);
        //RandomSequence randomSequence = rng.generate();
        //System.out.println(randomSequence.size());

        RandomSequenceGenerator randomSequenceGenerator = new RandomSequenceGenerator(8);
        RandomSequence randomSequence = randomSequenceGenerator.generate();
        randomSequence.stream().forEach(System.out::println);


    }

}
