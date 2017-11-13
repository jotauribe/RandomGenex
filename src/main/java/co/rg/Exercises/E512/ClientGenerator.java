package co.rg.Exercises.E512;

import co.rg.random.generation.generator.NumberGenerator;

/**
 * Created on 12/11/2017
 * By Jota Uribe
 **/
public class ClientGenerator {

    double arrivalTime;

    private int counter;

    public ClientGenerator(double arrivalTime) {
        this.arrivalTime = arrivalTime;
        this.counter = 1;
    }

    public Client nextClient(){
        Client newCient = new Client(counter, counter*arrivalTime);
        counter++;
        return newCient;
    }



}
