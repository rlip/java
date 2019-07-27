package pl.clockworkjava.payroll;

import java.util.Optional;
import java.util.ServiceLoader;

public interface PayrollService {

    String getCurrency();

    static PayrollService getInstance(){
        ServiceLoader<PayrollService> services = ServiceLoader.load(PayrollService.class);
        Optional<PayrollService> first = services.findFirst();
        return first.orElseThrow(() -> new RuntimeException("Missing PayrollService implementation"));
        //to samo co:
//        if(first.isPresent()){
//            return first.get();
//        }
//        throw new RuntimeException("Missing PayrollService implementation not found");

    }
}
