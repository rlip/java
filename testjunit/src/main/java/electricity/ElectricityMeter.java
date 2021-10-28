package electricity;


import java.util.Calendar;

public class ElectricityMeter {
    private float kwh = 0;
    private int centsForKwh = 0;

    private boolean tariffOn = false;
    private float kwhTariff = 0;
    private int centsForTariff = 0;

    private int electricityTariffStartHour = 0;
    private int electricityTariffEndHour = 0;

    public void addKwh(float kwhToAdd) {
        if (isTariffNow()) {
            kwhTariff += kwhToAdd;
        } else {
            kwh += kwhToAdd;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectricityMeter)) return false;

        ElectricityMeter that = (ElectricityMeter) o;

        if (Float.compare(that.kwh, kwh) != 0) return false;
        if (centsForKwh != that.centsForKwh) return false;
        if (tariffOn != that.tariffOn) return false;
        if (Float.compare(that.kwhTariff, kwhTariff) != 0) return false;
        if (centsForTariff != that.centsForTariff) return false;
        if (electricityTariffStartHour != that.electricityTariffStartHour) return false;
        return electricityTariffEndHour == that.electricityTariffEndHour;
    }

    @Override
    public int hashCode() {
        int result = (kwh != +0.0f ? Float.floatToIntBits(kwh) : 0);
        result = 31 * result + centsForKwh;
        result = 31 * result + (tariffOn ? 1 : 0);
        result = 31 * result + (kwhTariff != +0.0f ? Float.floatToIntBits(kwhTariff) : 0);
        result = 31 * result + centsForTariff;
        result = 31 * result + electricityTariffStartHour;
        result = 31 * result + electricityTariffEndHour;
        return result;
    }

    private boolean isTariffNow() {
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        return hour > electricityTariffStartHour && hour < electricityTariffEndHour;
    }

    /**
     * @return How much more expensive is normal price comparing to tariff in percentages
     */
    public int getHowMoreExpensiveNormalIs() {
        return (centsForKwh * 100 / centsForTariff) - 100;
    }

    public float getKwh() {
        return kwh;
    }

    void setCentsForKwh(int centsForKwh) {
        this.centsForKwh = centsForKwh;
    }

    void setTariffOn(boolean tariffOn) {
        this.tariffOn = tariffOn;
    }

    void setCentsForTariff(int centsForTariff) {
        this.centsForTariff = centsForTariff;
    }

    void setElectricityTariffStartHour(int electricityTariffStartHour) {
        this.electricityTariffStartHour = electricityTariffStartHour;
    }

    void setElectricityTariffEndHour(int electricityTariffEndHour) {
        this.electricityTariffEndHour = electricityTariffEndHour;
    }
}
