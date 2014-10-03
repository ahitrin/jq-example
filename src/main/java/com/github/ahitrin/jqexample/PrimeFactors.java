package com.github.ahitrin.jqexample;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Andrey Hitrin
 * @since 25.09.14
 */
public class PrimeFactors
{
    public static List<Integer> extract(Integer number)
    {
        List<Integer> factors = new ArrayList<>();
        for (int divisor = 2; divisor < Math.sqrt(number) - 2; divisor++) {
            while ((number > divisor) && (number % divisor == 0)) {
                factors.add(divisor);
                number = number / divisor;
            }
        }
        factors.add(number);
        return factors;
    }
}
