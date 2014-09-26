package com.github.ahitrin.jqexample;

import java.util.Arrays;
import java.util.List;

/**
 * @author Andrey Hitrin
 * @since 25.09.14
 */
public class PrimeFactors
{
    public static List<Integer> extract(Integer number)
    {
        if (number % 2 == 0)
            return Arrays.asList(2, number / 2);
        if (number % 3 == 0)
            return Arrays.asList(3, number / 3);
        return Arrays.asList(number);
    }
}
