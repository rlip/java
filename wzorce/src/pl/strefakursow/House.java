package pl.strefakursow;

public class House {
    private String address;
    private Integer floorsNumber;
    private Integer doorsNumber;
    private Integer windowsNumber;

    private House(String address, Integer floorsNumber, Integer doorsNumber, Integer windowsNumber) {      //CTRL + i - builder
        this.address = address;
        this.floorsNumber = floorsNumber;
        this.doorsNumber = doorsNumber;
        this.windowsNumber = windowsNumber;
    }


    public static class HouseBuilder {
        private String address;
        private Integer floorsNumber = 1;
        private Integer doorsNumber = 5;
        private Integer windowsNumber = 3;

        public HouseBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public HouseBuilder setFloorsNumber(Integer floorsNumber) {
            this.floorsNumber = floorsNumber;
            return this;
        }

        public HouseBuilder setDoorsNumber(Integer doorsNumber) {
            this.doorsNumber = doorsNumber;
            return this;
        }

        public HouseBuilder setWindowsNumber(Integer windowsNumber) {
            this.windowsNumber = windowsNumber;
            return this;
        }

        public House build() {
            return new House(address, floorsNumber, doorsNumber, windowsNumber);
        }
    }

    public String getAddress() {
        return address;
    }

    public Integer getFloorsNumber() {
        return floorsNumber;
    }

    public Integer getDoorsNumber() {
        return doorsNumber;
    }

    public Integer getWindowsNumber() {
        return windowsNumber;
    }
}