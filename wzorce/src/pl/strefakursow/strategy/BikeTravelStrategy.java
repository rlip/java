package pl.strefakursow.strategy;

public class BikeTravelStrategy implements TravelStrategy {
    @Override
    public void travelToWork(Employee employee) {
        System.out.println(employee.toString() + " is travel by bike");
    }
}
