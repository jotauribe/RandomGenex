package co.rg.Exercises.E512;

import co.rg.random.generation.generator.NumberGenerator;

import java.util.LinkedList;
import java.util.List;

/**
 * Created on 12/11/2017
 * By Jota Uribe
 **/
public class ClientGenerator {

    double arrivalTime;

    private int counter;

    private LinkedList<Client> nextClients;

    public ClientGenerator(double arrivalTime) {
        this.arrivalTime = arrivalTime;
        this.counter = 1;

    }

    public Client nextClient(){
        if(nextClients == null){
            Client newClient = new Client(counter, counter * arrivalTime);
            counter++;
            return newClient;
        }
        Client nextClient = nextClients.get(0);
        nextClients.remove(0);
        return nextClient;
    }

    public void setNextClients(LinkedList<Client> nextClients){

        LinkedList<Client> nextClientsCopy = new LinkedList<>();
        for(Client client : nextClients){
            Client newClient = new Client(client.index, client.exitTime());
            newClient.setTotalTime(client.timeInSystem());
            nextClientsCopy.add(newClient);
        }
        this.nextClients = nextClientsCopy;
    }



}
