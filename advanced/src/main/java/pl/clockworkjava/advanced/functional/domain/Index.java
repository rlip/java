package pl.clockworkjava.advanced.functional.domain;

final public class Index {
    private String name;

    public Index(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Index{" +
                "name='" + name + '\'' +
                '}';
    }
}
