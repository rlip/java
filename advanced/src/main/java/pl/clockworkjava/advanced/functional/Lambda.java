package pl.clockworkjava.advanced.functional;

public class Lambda {
    public static void main(String[] args) {

        Movable m = new Movable() {
            @Override
            public int move(String direction) {
                return 11;
            }
        };

        Movable m2 = (String direction) -> {
            return 11;
        };

        Movable m3 = (String direction) -> 11; // jak jest 1 linijka to nie piszemy return
        Movable m4 =  direction -> 11; // jak jest 1 argument to nie trzeba podawać jego typu

        test("A", m);
        test("B", m3); //to mozna przekazywać

    }

    public static void test(String name, Movable a){

    }
}
