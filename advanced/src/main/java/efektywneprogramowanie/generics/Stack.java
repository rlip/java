package efektywneprogramowanie.generics;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<E> {
    private E[] elements;
    private final static int DEFAULT_IITIAL_CAPACITY = 10;
    private int size;

    @SuppressWarnings("unchecked") // by nie było warningu rzutowania
    public Stack() {
        // Elementy tablicy zawierają tylko obiekty E pochodzące z push(E).
        // Jest to wystarczające dla zachowania bezpieczeństwa typów,
        // ale w czasie działania typem tablicy nie będzie E[], lecz Object[]!
        elements = (E[]) new Object[DEFAULT_IITIAL_CAPACITY]; // nie można tworzyć tablicy elementów E, trzeba albo tak zrzutować
        //albo można też trzymać tablicę object[], wtedy przy popie tylko zrzutować
    }

    void push(E element) {
        ensureCapacity();
        elements[size++] = element;
    }

    E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E lastElement = elements[--size];
        elements[size] = null;
        return lastElement;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
