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
        UniformGenerator serviceTimeTwoGenerator = GeneratorFactory.createUniformGenerator(200, 1, 2);




        double arrivalTimesSummation = 0;
        double totalArrivals = 0;
        double averageTimeInSystem = 0;
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
            }

            double summation = 0;
            for(Client c: clients){
                summation += c.timeInSystem();
                //System.out.println("time in system " + c.timeInSystem());
            }
            double average = arrivals == 0? 0: summation/arrivals;
            averageTimeInSystem += average;
            System.out.println("PROMEDIO TIEMPO EN SISTEMA  " + average);
            System.out.println("PROMEDIO TOTAL TIEMPO EN SISTEMA  " + averageTimeInSystem/counter);

        }


    }

}
