package co.rg.Exercises.E56;

/**
 * Created on 12/11/2017
 * By Jota Uribe
 **/
public class Component {

    public double lifetime;

    public double operationTime;

    public Component(double lifetime) {
        this.lifetime = lifetime;
        operationTime = 0;
    }

    public void updateOperationTime(double operationTime){
        this.operationTime += operationTime;
    }

    public double remainingLifetime(){
        return lifetime - operationTime;
    }
}
