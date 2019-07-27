package pl.strefakursow.models;

public class FamilyHouseBuilder {
    private String address;
    private Integer floorsNumber;

    public FamilyHouseBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public FamilyHouseBuilder setFloorsNumber(Integer floorsNumber) {
        this.floorsNumber = floorsNumber;
        return this;
    }

    public FamilyHouse createFamilyHouse() {
        return new FamilyHouse(address, floorsNumber);
    }
}