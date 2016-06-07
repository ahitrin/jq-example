package com.github.ahitrin.jqexample;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

/**
 * @author Andrey Hitrin
 * @since 07.06.16
 */
public class SwitchActionGenerator extends Generator<SwitchAction> {
    public SwitchActionGenerator(Class<SwitchAction> type) {
        super(type);
    }

    @Override
    public SwitchAction generate(SourceOfRandomness random, GenerationStatus status) {
        return new SwitchAction() {
            @Override
            public void apply(LightSwitch lightSwitch) {
                lightSwitch.switchLight(random.nextBoolean());
            }
        };
    }
}
