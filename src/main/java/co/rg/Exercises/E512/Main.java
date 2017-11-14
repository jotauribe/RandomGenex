package co.rg.Exercises.E512;

import co.rg.random.generation.generator.ExponentialGenerator;
import co.rg.random.generation.generator.GeneratorFactory;
import co.rg.random.generation.generator.PoissonGenerator;
import co.rg.random.generation.generator.UniformGenerator;

import java.util.LinkedList;

/**
 * Created on 12/11/2017
 * By Jota Uribe
 **/
public class Main {

    public static void main(String[] args){

        //Generador para los tiempos de llegadas
        PoissonGenerator arrivalTimeGenerator = GeneratorFactory.createPoissonGenerator(30, 20);

        //Generador para el tiempo de servicio en primera estacion
        ExponentialGenerator serviceTimeOneGenerator = GeneratorFactory.createExponentialGenerator(1500, 2);

        //Generador para el tiempo de servicio en la segunda estacion
        UniformGenerator serviceTimeTwoGenerator = GeneratorFactory.createUniformGenerator(1500, 1, 2);




        double arrivalTimesSummation = 0;
        double totalArrivals = 0;
        double timeInSystemSummation = 0;
        double counter = 0;

        while (arrivalTimeGenerator.hasNextValue()){
            counter++;

            double arrivals = arrivalTimeGenerator.nextValue();
            double arrivalTime = arrivals == 0? 0: 60/arrivals;

            //Generador de clientes
            ClientGenerator clientGenerator = new ClientGenerator(arrivalTime);

            LinkedList<Client> clients = new LinkedList<>();

            for (int i = 1; i <= arrivals; i++){

                //Llego un cliente
                Client client = clientGenerator.nextClient();
                System.out.println("client "+i+" arrival time =  "+client.getArrivalTime());


                if(clients.isEmpty()){
                    double serviceTime = serviceTimeOneGenerator.nextValue();
                    client.setServiceTime(serviceTime);
                    client.setServiceStartTime(client.getArrivalTime());
                }
                else{
                    client.setServiceTime(serviceTimeOneGenerator.nextValue());
                    client.setServiceStartTime(Double.max(client.getArrivalTime(), clients.getLast().exitTime()));
                }
                clients.add(client);
                System.out.println("client "+i+" service start time = "+client.getServiceStartTime());
                System.out.println("client "+i+" exit time "+i+" = "+client.exitTime());
                System.out.println("----------------------------------------------------");

            }

            double summation = 0;
            for(Client c: clients){
                summation += c.timeInSystem();
                //System.out.println("time in system " + c.timeInSystem());
            }
            double average = arrivals == 0? 0: summation/arrivals;
            timeInSystemSummation += average;




            //SEGUNDA PARTE
            if (!clients.isEmpty()) {
                System.out.println();
                System.out.println("");
                System.out.println("SEGUNDA PARTE");
                clientGenerator.setNextClients(clients);
                LinkedList<Client> clients2 = new LinkedList<>();

                for (int i = 1; i <= arrivals; i++){

                    //Llego un cliente
                    Client client = clientGenerator.nextClient();


                    if(clients2.isEmpty()){
                        double serviceTime = serviceTimeTwoGenerator.nextValue();
                        client.setServiceTime(serviceTime);
                        client.setServiceStartTime(client.getArrivalTime());
                    }
                    else{
                        client.setServiceTime(serviceTimeTwoGenerator.nextValue());
                        client.setServiceStartTime(Double.max(client.getArrivalTime(), clients2.getLast().exitTime()));
                        client.setTotalTime(client.getTotalTime() + client.timeInSystem());
                    }
                    clients2.add(client);
                    System.out.println("client "+i+" arrival time =  "+client.getArrivalTime());
                    System.out.println("client "+i+" service start time = "+client.getServiceStartTime());
                    System.out.println("client "+i+" service time = "+client.getServiceTime());
                    System.out.println("client "+i+" exit time  = "+client.exitTime());
                    System.out.println("client "+i+" total time in system  = "+client.getTotalTime());
                    System.out.println("----------------------------------------------------");
                }
                System.out.println();

                double summation2 = 0;
                for(Client c: clients2){
                    summation2 += c.timeInSystem();
                    //System.out.println("time in system " + c.timeInSystem());
                }
                double average2 = arrivals == 0? 0: summation2/arrivals;
                timeInSystemSummation += average2;
            }

        }
        //FIN WHILE
        System.out.println("\n\n COUNTER: "+counter + " corridas");
        System.out.println("\n\n TIEMPO PROMEDIO EN SISTEMA: "+timeInSystemSummation/counter + " minutos");


    }

}
