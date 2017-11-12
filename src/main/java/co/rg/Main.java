package co.rg;

import co.rg.random.generation.generator.ExponentialGenerator;
import co.rg.random.generation.generator.GeneratorFactory;
import co.rg.random.generation.generator.NormalGenerator;
import co.rg.random.generation.generator.PoissonGenerator;
import co.rg.random.generation.sequence.RandomSequence;
import co.rg.random.generation.sequence.RandomSequenceFactory;

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

        //RandomSequenceFactory randomSequenceFactory = new RandomSequenceFactory(8);
        //RandomSequence randomSequence = randomSequenceFactory.create();
        //randomSequence.stream().forEach(System.out::println);
        //randomSequence = randomSequenceFactory.create();
        //System.out.println(); System.out.println();
        //randomSequence.stream().forEach(System.out::println);

        //NormalGenerator normalGenerator = GeneratorFactory.createNormalGenerator(150, 600, 100);
        //ExponentialGenerator exponentialGenerator;

        //System.out.print(PoissonGenerator.factorialOf(15));

        /**
        int counter = 0;
        double summation = 0;
        while(normalGenerator.hasNextValue()){
            counter++;
            double nextValue =  normalGenerator.nextValue();
            summation += nextValue;
            System.out.println(counter + " - " + nextValue);
        }
        System.out.println(summation/(double)counter);
         */

        /**
        PoissonGenerator pg = GeneratorFactory.createPoissonGenerator(10, 8);
        int counter = 0;
        double summation = 0;
        while(counter < 100){
            counter++;
            double nextValue =  pg.nextValue();
            summation += nextValue;
            System.out.println(counter + " - " + nextValue);
        }
        System.out.println(" MEDIA " + summation/(double)10);
         */

        ExponentialGenerator pg = GeneratorFactory.createExponentialGenerator(10000, 2);
        int counter = 0;
        double summation = 0;
        while(pg.hasNextValue()){
            counter++;
            double nextValue =  pg.nextValue();
            summation += nextValue;
            System.out.println(counter + " - " + nextValue);
        }
        System.out.println(" MEDIA " + summation/(double)10);

    }

}
