package co.random.generation;

/**
 * Created on 10/11/2017
 * By Jota Uribe
 **/
public class Main {

    public static void main(String[] args){

        int seed = 4, multiplier = 5, additiveConstant = 7, modulus = 8;

        //RandomSequenceGenerator rng = new RandomSequenceGenerator(97, 81, 93, 151);
        //RandomSequence randomSequence = rng.next();
        //System.out.println(randomSequence.size());

        RandomSequenceFactory randomSequenceFactory = new RandomSequenceFactory(8);
        RandomSequence randomSequence = randomSequenceFactory.create();
        randomSequence.stream().forEach(System.out::println);
        randomSequence = randomSequenceFactory.create();
        System.out.println(); System.out.println();
        randomSequence.stream().forEach(System.out::println);


    }

}
