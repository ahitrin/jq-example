package com.github.ahitrin.jqexample;

/**
 * @author Andrey Hitrin
 * @since 07.06.16
 */
public class LightSwitch {
    private boolean light;

    public boolean hasLight() {
        return light;
    }

    public void switchLight(boolean newState) {
        light = newState;
    }
}
