package co.rg.Exercises.E512;

/**
 * Created on 12/11/2017
 * By Jota Uribe
 **/
public class Client {

    private int index;

    private double arrivalTime;

    private double serviceStartTime;

    private double serviceTime;


    public Client(int index, double arrivalTime) {
        this.index = index;
        this.arrivalTime = arrivalTime;
    }

    public double exitTime(){
        return serviceStartTime + serviceTime;
    }

    public double timeInSystem(){
        return exitTime() - arrivalTime;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(double arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getServiceStartTime() {
        return serviceStartTime;
    }

    public void setServiceStartTime(double serviceStartTime) {
        this.serviceStartTime = serviceStartTime;
    }

    public double getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(double serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (index != client.index) return false;
        return Double.compare(client.arrivalTime, arrivalTime) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = index;
        temp = Double.doubleToLongBits(arrivalTime);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
