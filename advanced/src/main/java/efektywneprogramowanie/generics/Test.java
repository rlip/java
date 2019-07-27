package efektywneprogramowanie.generics;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.IntUnaryOperator;

public class Test
{
    public static void main(String[] args) {
        System.out.println(SquareDigits(9119));
    }

    private static int SquareDigits(int n)
    {
        char[] chars = String.valueOf(n).toCharArray();
        StringBuilder result = new StringBuilder();

        for(char ch : chars){
            int currentVal = Integer.valueOf(String.valueOf(ch));
            int currentPowVal = currentVal * currentVal;
            result.append(currentPowVal);
        }
        return Integer.valueOf(result.toString());
    }
}