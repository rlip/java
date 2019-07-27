package pl.clockworkjava.polishpayroll;

public class PayrollServiceImpl implements pl.clockworkjava.payroll.PayrollService {
    @Override
    public String getCurrency() {
        return "PLN";
    }
}
