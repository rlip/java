package pl.strefakursow.adapter;

import pl.strefakursow.strategy.Employee;

public class OffitialTrippingEmployee {
    private Employee employee;

    public OffitialTrippingEmployee(Employee employee) {

        this.employee = employee;
    }

    public void goToClient() {
        employee.travelToWork(employee);
        System.out.println("Travel to Klient");
    }
}
