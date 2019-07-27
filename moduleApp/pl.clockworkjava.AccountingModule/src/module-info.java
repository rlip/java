module pl.clockworkjava.AccountingModule {
    requires java.logging; // używa logera
    requires pl.clockworkjava.PayrollService; // tu jest sam interfejs serwisu
    exports pl.clockworkjava.accounting; // to że jest paczka accounting tego modułu jest widoczna na zewnątrz accounting


}