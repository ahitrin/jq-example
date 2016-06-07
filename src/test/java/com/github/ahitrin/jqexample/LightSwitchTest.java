package com.github.ahitrin.jqexample;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import java.util.List;
import org.junit.Ignore;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

/**
 * @author Andrey Hitrin
 * @since 07.06.16
 */
@RunWith(JUnitQuickcheck.class)
public class LightSwitchTest {
    @Property public void singleSwitchWorksFine(boolean state) {
        LightSwitch aSwitch = new LightSwitch();
        aSwitch.switchLight(state);
        assertEquals(state, aSwitch.hasLight());
    }

    @Ignore("broken for now")
    @Property public void onlyTheLastSwitchHasEffect(List<Boolean> sequence) {
        assumeTrue(sequence.size() > 0);
        final LightSwitch lightSwitch = new LightSwitch();
        for (boolean state: sequence) {
            lightSwitch.switchLight(state);
        }
        assertEquals(sequence.get(sequence.size() - 1), lightSwitch.hasLight());
    }

    @Property public void singleSwitchWithGeneratorsWorksFine(@From(SwitchActionGenerator.class) SwitchAction action) {
        LightSwitch lightSwitch = new LightSwitch();
        action.apply(lightSwitch);
        assertTrue(lightSwitch.hasLight());
    }
}
