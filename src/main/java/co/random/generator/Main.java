package co.random.generator;

import java.util.stream.DoubleStream;

/**
 * Created on 10/11/2017
 * By Jota Uribe
 **/
public class Main {

    public static void main(String[] args){

        int seed = 4, multiplier = 5, additiveConstant = 7, modulus = 8;

        DoubleStream doubleStream = DoubleStream.iterate(
                seed, previousNumber -> (((multiplier*previousNumber + additiveConstant) % modulus)/modulus)
        );

        doubleStream.forEach(System.out::println);

    }

}
