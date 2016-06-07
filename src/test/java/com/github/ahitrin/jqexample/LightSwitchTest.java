package com.github.ahitrin.jqexample;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * @author Andrey Hitrin
 * @since 07.06.16
 */
@RunWith(JUnitQuickcheck.class)
public class LightSwitchTest {
    @Property public void allOK(boolean state) {
        LightSwitch aSwitch = new LightSwitch();
        aSwitch.switchLight(state);
        assertEquals(state, aSwitch.hasLight());
    }
}
