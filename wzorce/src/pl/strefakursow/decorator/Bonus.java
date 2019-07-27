package pl.strefakursow.decorator;

public abstract class Bonus implements Payable{

    private Payable payable;

    Bonus(Payable payable){
        this.payable = payable;
    }

    public int getSalary() {
        return payable.getSalary() + getPaidBonus(payable.getSalary());
    }

    abstract protected int getPaidBonus(int salary);
}
