package co.rg.Exercises.E56;

import co.rg.random.generation.generator.GeneratorFactory;
import co.rg.random.generation.generator.NormalGenerator;

import java.util.List;

/**
 * Created on 12/11/2017
 * By Jota Uribe
 **/
public class Main {

    public static void main(String[] args){
        performFirstStrategy();
        System.out.println();
        System.out.println();
        performSecondStrategy();

    }

    private static void performFirstStrategy() {
        //Creamos el generador de variables aleatorias distribuidas normalmente
        NormalGenerator normalGenerator = GeneratorFactory.createNormalGenerator(400, 600, 100);
        //Creamos el proveedor de componentes
        ComponentProvider componentProvider = new ComponentProvider(normalGenerator);

        List<Component> components;
        Machine machine;
        try {
            components = componentProvider.getNewComponents(4);
            machine = new Machine(components, 40000);
            int counter = 0;
            while(machine.isLifetimeFulfilled()){
                Component newComponent = componentProvider.getNewComponent();
                machine.replaceDamagedComponent(newComponent);
            }
            System.out.println(":::::STRATEGY 1:::::");
            System.out.println("Operation time: " + machine.getOperationTime());
            System.out.println("Used components: " + machine.getUsedComponentsCounter());
            System.out.println("Disconnection time: " + machine.getDisconnectionTime());
            double componentsCost = machine.getUsedComponentsCounter()*200;
            System.out.println("Components cost: " + componentsCost);
            double disconnectionCost = machine.getDisconnectionTime()*100;
            System.out.println("Disconnection cost: " + disconnectionCost);
            double totalCost = disconnectionCost + componentsCost;
            System.out.println("Total cost: " + totalCost);

        } catch (ComponentProviderException e) {
            System.out.print(e.getMessage());
        }
    }

    private static void performSecondStrategy() {
        //Creamos el generador de variables aleatorias distribuidas normalmente
        NormalGenerator normalGenerator = GeneratorFactory.createNormalGenerator(400, 600, 100);
        //Creamos el proveedor de componentes
        ComponentProvider componentProvider = new ComponentProvider(normalGenerator);

        List<Component> components;
        Machine machine;
        try {
            components = componentProvider.getNewComponents(4);
            machine = new Machine(components, 40000);
            while(machine.isLifetimeFulfilled()){
                List<Component> newComponents = componentProvider.getNewComponents(4);
                machine.replaceAllComponents(newComponents);
            }
            System.out.println(":::::STRATEGY 2:::::");
            System.out.println("Operation time: " + machine.getOperationTime());
            System.out.println("Used components: " + machine.getUsedComponentsCounter());
            System.out.println("Disconnection time: " + machine.getDisconnectionTime());
            double componentsCost = machine.getUsedComponentsCounter()*200;
            System.out.println("Components cost: " + componentsCost);
            double disconnectionCost = machine.getDisconnectionTime()*100;
            System.out.println("Disconnection cost: " + disconnectionCost);
            double totalCost = disconnectionCost + componentsCost;
            System.out.println("Total cost: " + totalCost);

        } catch (ComponentProviderException e) {
            System.out.print(e.getMessage());
        }
    }

}
