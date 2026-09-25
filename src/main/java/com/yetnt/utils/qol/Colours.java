package com.yetnt.utils.qol;

import java.awt.Color;

/**
 * Abstract class which simply holds helper methods to fuck around with colours
 * <p>
 *     From <a href="https://github.com/yetnt/j3engine">J3Engine</a>
 * </p>
 * @see Color
 * @author Lehlogonolo Poole
 */
public abstract class Colours {
    /**
     * Overrides the alpha channel of a colour by setting it to a new one effectively
     * discarding the old value, or setting it if it did not exist prior.
     * @param original The original colour
     * @param alpha The alpha value between 0 and 255
     * @return A new colour with the new alpha applied.
     */
    public static Color alphaChannel(Color original, int alpha) {
        return new Color(original.getRed(), original.getGreen(), original.getBlue(), alpha);
    }
}