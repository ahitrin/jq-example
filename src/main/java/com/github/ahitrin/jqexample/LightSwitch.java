package com.github.ahitrin.jqexample;

/**
 * @author Andrey Hitrin
 * @since 07.06.16
 */
public class LightSwitch {
    private boolean light;
    private int drmCounter = 0;

    public boolean hasLight() {
        return light;
    }

    public void switchLight(boolean newState) {
        drmCounter++;
        if (drmCounter > 5) {
            throw new RuntimeException("It's time to pay the MegaSwitch INC");
        }
        light = newState;
    }
}
