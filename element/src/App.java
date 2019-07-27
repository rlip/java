import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;


class Machine {

    public String toString() {
        return "I am a machine";
    }

    public void start() {
        System.out.println("Machine started");
    }
}

class Camera extends Machine {

    @Override
    public String toString() {
        return "I am a Camera";
    }

    @Override
    public void start() {
        System.out.println("photo :)");
    }
}

interface Plant {
    void grow();
}

public class App {

    public static void main(String[] args) {
        //stary styl

        //nowy styl
        ArrayList<String> strings = new ArrayList<>();

        strings.add("cat");
        strings.add("dog");

        String animal = strings.get(1);
        System.out.println(animal);

        ArrayList<Machine> machines = new ArrayList<>();
        machines.add(new Machine());
        machines.add(new Machine());

        ArrayList<Camera> cameras = new ArrayList<>();
        machines.add(new Camera());
        machines.add(new Camera());

        // może być więcej argumentów
        HashMap<Integer, String> map = new HashMap<>();

        showList4(machines);
        showList4(cameras);

        //anonimowe klasy
        Machine machine1 = new Machine() {
          @Override public void start(){
              System.out.println("nadpisałem :P");
          }
        };
        machine1.start();

        Plant plant1 = new Plant() { //można zastapić poniższym, ale tylko jak jest 1 motoda interfejsu
            @Override
            public void grow() {
                System.out.println("Plant1 growing");
            }
        };
        Plant plant2 = () -> System.out.println("Plant2 growing");
        plant1.grow();
        plant2.grow();
    }

    private static void showList1(@NotNull ArrayList<Machine> list) {
        for (Machine value : list) {
            System.out.println(value);
        }
    }

    private static void showList2(@NotNull ArrayList<?> list) {
        for (Object value : list) {
            System.out.println(value);
        }
    }

    private static void showList3(@NotNull ArrayList<? extends Machine> list) { //machine albo jego dziecko
        for (Machine value : list) {
            System.out.println(value);
            value.start();
        }
    }

    private static void showList4(@NotNull ArrayList<? super Camera> list) { //kamera albo rodzic kamery
        for (Object value : list) {
            System.out.println(value);
        }
    }
}
