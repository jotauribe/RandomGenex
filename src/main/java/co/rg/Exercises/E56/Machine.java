package co.rg.Exercises.E56;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created on 12/11/2017
 * By Jota Uribe
 **/
public class Machine {

    private List<Component>components;

    private double operationTime;

    private double disconnectionTime;

    private double lifetime;

    private int usedComponentsCounter;

    public Machine(List<Component> components, double lifetime) {
        this.lifetime = lifetime;
        operationTime = 0;
        disconnectionTime = 0;
        usedComponentsCounter = components.size();
        this.components = components;
        updateOperationTime();
    }

    private void updateOperationTime(){
        Component damagedComponent = components.get(0);
        int index = 0;
        for(int i = 0; i < components.size(); i++){
            if(components.get(i).remainingLifetime() < damagedComponent.remainingLifetime()) {
                damagedComponent = components.get(i);
                index = i;
            }
        }
        components.remove(damagedComponent);
        updateComponentsOperationalTime(damagedComponent.remainingLifetime());
        operationTime += damagedComponent.remainingLifetime();

    }

    private void updateOperationTime2(){
        Component damagedComponent = components.get(0);
        for(int i = 0; i < components.size(); i++){
            if(components.get(i).remainingLifetime() < damagedComponent.remainingLifetime()) {
                damagedComponent = components.get(i);
            }
        }
        operationTime += damagedComponent.remainingLifetime();

    }

    private void updateComponentsOperationalTime(double operationTime){
        for(int i = 0; i < components.size(); i++){
            components.get(i).updateOperationTime(operationTime);
        }
    }

    public void replaceDamagedComponent(Component component){
        components.add(component);
        usedComponentsCounter++;
        updateOperationTime();
        disconnectionTime += 1;
    }

    public void replaceAllComponents(List<Component> components){
        this.components = components;
        usedComponentsCounter += 4;
        updateOperationTime2();
        disconnectionTime += 2;
    }

    public boolean isLifetimeFulfilled(){
        return operationTime < lifetime;
    }

    public double getOperationTime() {
        return operationTime;
    }

    public double getDisconnectionTime() {
        return disconnectionTime;
    }

    public double getLifetime() {
        return lifetime;
    }

    public int getUsedComponentsCounter() {
        return usedComponentsCounter;
    }

    private void showComponents(){
        components.forEach(c ->System.out.print("Component lifetime " + c.remainingLifetime()+ "   -   "));
        System.out.println();
    }
}
