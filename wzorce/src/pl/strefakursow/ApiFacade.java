package pl.strefakursow;

import pl.strefakursow.adapter.OffitialTrippingEmployee;
import pl.strefakursow.decorator.DeadLinieBonus;
import pl.strefakursow.decorator.FreqBonus;
import pl.strefakursow.decorator.Payable;
import pl.strefakursow.decorator.SpecialBonus;
import pl.strefakursow.strategy.BikeTravelStrategy;
import pl.strefakursow.strategy.DoctorJobStrategy;
import pl.strefakursow.strategy.Employee;

public class ApiFacade {
    public Employee createDoctor(int i) {
        Employee mike = new Employee();
        mike.travelStrategy = new BikeTravelStrategy();
        mike.jobStrategy = new DoctorJobStrategy();

        OffitialTrippingEmployee ofMike = new OffitialTrippingEmployee(mike); //rozszerzeamy fukcjonalność mika nie zmieniająć jego klasy
        ofMike.goToClient();


        mike.setSalary(i);

        System.out.println("zarobki" + mike.getSalary());
        System.out.println("zarobki" + new FreqBonus(new DeadLinieBonus(new SpecialBonus(mike))).getSalary());


        return mike;
    }

    public void pushDoctorToJob(Employee mike) {
        mike.travelToWork(mike);
    }

    public int countSalary(Employee mike){
        Payable employ = mike;
        if(mike.getSalary() > 8000) {
            employ = new SpecialBonus(mike);
        }
        if(mike.travelStrategy instanceof BikeTravelStrategy){
            employ = new FreqBonus(employ);
        }
       return employ.getSalary();
    }
}
