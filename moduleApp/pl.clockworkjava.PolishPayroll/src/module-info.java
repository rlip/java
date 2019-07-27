module pl.clockworkjava.PolishPayroll {
    requires pl.clockworkjava.PayrollService;
    provides pl.clockworkjava.payroll.PayrollService with pl.clockworkjava.polishpayroll.PayrollServiceImpl;
    //ten moduł dostarcza implementacji do tego serwisu
}