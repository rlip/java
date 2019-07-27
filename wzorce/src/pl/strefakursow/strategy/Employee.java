package pl.strefakursow.strategy;

import pl.strefakursow.decorator.Payable;

import java.util.Objects;

public class Employee implements TravelStrategy, JobStrategy, Payable {
    public TravelStrategy travelStrategy;
    public JobStrategy jobStrategy;

    private int salary = 0;

    @Override
    public void doYourJob() {
        jobStrategy.doYourJob();
    }

    @Override
    public void travelToWork(Employee employee) {
        travelStrategy.travelToWork(employee);
    }

    @Override
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


}
