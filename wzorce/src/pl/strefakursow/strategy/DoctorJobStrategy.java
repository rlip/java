package pl.strefakursow.strategy;

public class DoctorJobStrategy implements JobStrategy {
    @Override
    public void doYourJob() {
        System.out.println("Work as doctor");
    }
}
