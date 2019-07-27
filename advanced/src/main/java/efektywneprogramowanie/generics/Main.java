package efektywneprogramowanie.generics;

import java.util.*;
import java.util.function.UnaryOperator;

public class Main {

    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        stack.push("Ania");
        stack.push("ma");
        stack.push("Kota");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        ///////////////////////////////////////////////
        Set<String> set1 = new LinkedHashSet<>(Arrays.asList("Ania", "jest przeurocza"));
        Set<String> set2 = new LinkedHashSet<>(Arrays.asList("Aga", "jest prześliczna"));

        union(set1, set2).forEach(System.out::println);
        ///////////////////////////////////////////////
        String[] strings = { "juta", "konopie", "nylon" };

        UnaryOperator<String> sameString = identityFunction();
        for (String s : strings)
            System.out.println(sameString.apply(s));
        Number[] numbers = { 1, 2.0, 3L };
        UnaryOperator<Number> sameNumber = identityFunction();
        for (Number n : numbers)
            System.out.println(sameNumber.apply(n));
    }


    private static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new LinkedHashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // Wzorzec fabryki singletonów uogólnionych
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;
    @SuppressWarnings("unchecked")
    private static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    // Zwraca maksymalną wartość z kolekcji, korzysta z rekurencyjnego wiązania typów
    private static <E extends Comparable<E>> E max(Collection<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("Pusta kolekcja");
        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        return result;
    }

}
