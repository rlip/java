package electricity;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

//to też można anulować @Disabled
class ElectricityMeterTest {

    @Test
    void addKwh_newMeter_properAction() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.addKwh(1);
        Assertions.assertEquals(1, electricityMeter.getKwh());
    }

    @Test
    void addKwh_newMeter2_properAction() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.addKwh(1);
        electricityMeter.addKwh(4);
        Assertions.assertEquals(5, electricityMeter.getKwh(), "should be 5");
    }
// 2 sposób
    @Disabled("Not implemented yet") //todo assure is proper
    @Test
    void kwhCounterIncreaseIfNew() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.addKwh(1);
        Assertions.assertEquals(1, electricityMeter.getKwh());
    }
// 3 sposób
    @Test
    void givenNewMeterWhenMeterFirstAdditionThenProperCounter() { //given when then
        //Given(Arrange) - sekcja założeń początkowych
        ElectricityMeter electricityMeter = new ElectricityMeter();
        //When(Act) - akcje, które musza się wydarzyć, żeby można było sprawdzić
        electricityMeter.addKwh(1);
        //Then(Assert) - sprawdzenie
        Assertions.assertEquals(1, electricityMeter.getKwh());
    }

    @Test()
    void getHowMoreExpensiveNormalIs() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            ElectricityMeter electricityMeter = new ElectricityMeter();
            electricityMeter.setCentsForKwh(90);
            electricityMeter.getHowMoreExpensiveNormalIs();
        });

    }
}