package pl.strefakursow.decorator;

public class DeadLinieBonus extends Bonus {
    public DeadLinieBonus(Payable payable) {
        super(payable);
    }

    @Override
    protected int getPaidBonus(int salary) {
        return (int) (salary * 0.1f);
    }


}
