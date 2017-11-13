package co.rg.Exercises.E512;

import java.util.LinkedList;

/**
 * Created on 12/11/2017
 * By Jota Uribe
 **/
public class ServiceQueue {

    private LinkedList<Client> clients;


    public ServiceQueue(){
        clients = new LinkedList();
    }

    public void add(Client client){
        clients.addLast(client);
    }

    public Client next(){
        Client firstClient = clients.getFirst();
        return clients.getFirst();

    }

    public boolean isEmpty(){
        return clients.isEmpty();
    }

    public int size(){
        return clients.size();
    }
}
