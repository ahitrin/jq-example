package com.github.ahitrin.jqexample;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import java.util.List;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
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

    @Property public void onlyTheLastSwitchHasEffect(List<Boolean> sequence) {
        assumeTrue(sequence.size() > 0);
        final LightSwitch lightSwitch = new LightSwitch();
        sequence.forEach(state -> lightSwitch.switchLight(state));
        assertEquals(sequence.get(sequence.size() - 1), lightSwitch.hasLight());
    }

    @Property public void singleSwitchWithGeneratorsWorksFine(@From(SwitchActionGenerator.class) SwitchAction action) {
        LightSwitch lightSwitch = new LightSwitch();
        LightSwitchModel model = new LightSwitchModel();
        action.apply(lightSwitch, model);
        assertEquals(lightSwitch.hasLight(), model.hasLight);
    }

    @Property public void onlyTheLastActionHasEffectWithGenerator(List<@From(SwitchActionGenerator.class) SwitchAction> sequence) {
        assumeTrue(sequence.size() > 0);
        final LightSwitch lightSwitch = new LightSwitch();
        final LightSwitchModel model = new LightSwitchModel();
        sequence.forEach(action -> action.apply(lightSwitch, model));
        assertEquals(model.hasLight, lightSwitch.hasLight());
    }
}
