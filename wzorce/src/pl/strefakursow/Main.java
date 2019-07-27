package pl.strefakursow;

import pl.strefakursow.adapter.OffitialTrippingEmployee;
import pl.strefakursow.decorator.DeadLinieBonus;
import pl.strefakursow.decorator.FreqBonus;
import pl.strefakursow.decorator.Payable;
import pl.strefakursow.decorator.SpecialBonus;
import pl.strefakursow.models.FamilyHouse;
import pl.strefakursow.observer.Mainclass;
import pl.strefakursow.strategy.BikeTravelStrategy;
import pl.strefakursow.strategy.DoctorJobStrategy;
import pl.strefakursow.strategy.Employee;

import java.util.Observable;
import java.util.Observer;

public class Main {

    public static void main(String[] args) {

//        observerPatern();
        Mainclass.run();


        ApiFacade facade = new ApiFacade();
        Employee mike = facade.createDoctor(10000);
        facade.pushDoctorToJob(mike);
        System.out.println("zarobki" + facade.countSalary(mike));


    }


    private static void observerPatern() {
        Observable observavleValue = new Observable(){
            @Override
            public void notifyObservers(Object arg) {
                super.setChanged();
                super.notifyObservers(arg);
            }
        };

        observavleValue.addObserver((o, arg) -> System.out.println("1 - " + arg.toString()));

        observavleValue.addObserver(new Observer(){

            @Override
            public void update(Observable o, Object arg) {
                System.out.println("2 - " + arg.toString());
            }
        });

        observavleValue.notifyObservers(54);
    }

    private static void creationPatterns() {
        //BUILDER
        House myHouse = new House.HouseBuilder()
                .setAddress("słomiana")
                .setFloorsNumber(1)
                .setDoorsNumber(3)
                .setWindowsNumber(12)
                .build();

        //STATYCZNE MOTODY WYTWÓRCZE
        //metody from (na podstawie), of (z, np. json, xml), valueOf (jest wartością), instanceOf

        boolean isTrue = true;
        Boolean.valueOf(isTrue);

//        FamilyHouse familyHouse = FamilyHouse.from(myHouse);
    }
}
