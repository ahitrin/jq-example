package com.github.ahitrin.jqexample;

import com.pholser.junit.quickcheck.ForAll;
import com.pholser.junit.quickcheck.generator.InRange;
import java.math.BigInteger;
import java.util.List;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.Every.everyItem;
import static org.junit.Assume.assumeThat;

/**
 * @deprecated This example uses <b>old version of JUnit-QuickCheck</b>. Please take a look at the newer example, {@link LightSwitchTest}
 * @author Andrey Hitrin
 * @since 25.09.14
 */
@RunWith(Theories.class)
@Deprecated
public class PrimeFactorsTest
{
    @Theory public void primeNumberIsItsOwnFactor(@ForAll @InRange(minInt = 2, maxInt = Integer.MAX_VALUE) Integer number) {
        assumeThat(number, isProbablySimple());

        List<Integer> factors = PrimeFactors.extract(number);
        assertThat(factors, hasItem(number));
    }

    @Theory public void productOfFactorsShouldBeEqualToNumber(@ForAll @InRange(minInt = 2, maxInt = Integer.MAX_VALUE) Integer number) {
        List<Integer> factors = PrimeFactors.extract(number);
        Integer product = 1;
        for (Integer factor: factors)
            product = product * factor;
        assertThat(product, is(number));
    }

    @Theory public void everyFactorShouldBeSimple(@ForAll @InRange(minInt = 2, maxInt = Integer.MAX_VALUE) Integer number) {
        List<Integer> factors = PrimeFactors.extract(number);
        assertThat(factors, everyItem(isProbablySimple()));
    }

    @Theory public void everyFactorShouldBeSimpleEspeciallyForSmallNumbers(@ForAll @InRange(minInt = 2, maxInt = 200) Integer number) {
        everyFactorShouldBeSimple(number);
    }

    private Matcher<Integer> isProbablySimple()
    {
        return new BaseMatcher<Integer>()
        {
            @Override
            public boolean matches(Object item)
            {
                return (item instanceof Integer) &&
                    (BigInteger.valueOf((Integer) item).isProbablePrime(5));
            }

            @Override
            public void describeTo(Description description)
            {
                description.appendText("prime number");
            }
        };
    }
}
