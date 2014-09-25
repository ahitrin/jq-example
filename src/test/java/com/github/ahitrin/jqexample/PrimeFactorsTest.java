package com.github.ahitrin.jqexample;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isIn;
import static org.junit.Assume.assumeThat;

import java.util.Arrays;
import java.util.List;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

/**
 * @author Andrey Hitrin
 * @since 25.09.14
 */
@RunWith(Theories.class)
public class PrimeFactorsTest
{
    @Theory public void primeNumberIsItsOwnFactor(@ForAll @InRange(minInt = 1, maxInt = 50) Integer number) {
        List<Integer> firstPrimeNumbers = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);
        assumeThat(number, isIn(firstPrimeNumbers));

        List<Integer> factors = PrimeFactors.extract(number);
        assertThat(factors, hasItem(number));
    }
}
