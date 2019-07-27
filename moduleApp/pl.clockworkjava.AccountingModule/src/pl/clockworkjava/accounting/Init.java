package pl.clockworkjava.accounting;

import pl.clockworkjava.payroll.PayrollService;

import java.util.logging.Logger;

public class Init {

    public static final Logger LOG = Logger.getLogger(Init.class.getName());

    public static void init() {
        LOG.info("Moduł accounting został zainicjalizowany");
        PayrollService instance = PayrollService.getInstance();
        System.out.println(instance.getCurrency());


    }
}
