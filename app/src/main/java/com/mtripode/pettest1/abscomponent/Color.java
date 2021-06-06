/*
 * Created on Aug 31, 2009
 */
package com.mtripode.pettest1.abscomponent;

public class Color {

    public static final Color BLACK = new Color((byte) 0, (byte) 0, (byte) 0);

    private static final int RED_MASK = 0x00FF0000;

    private static final int ALPHA_MASK = 0xFF000000;

    private static final int RED_OFFSET = 16;

    private static final int ALPHA_OFFSET = 24;

    private static final int GREEN_MASK = 0x0000FF00;

    private static final int GREEN_OFFSET = 8;

    private static final int BLUE_MASK = 0x000000FF;

    private static final int BLUE_OFFSET = 0;

    public static final Color DARKGRAY = new Color(0x585858);

    public static final Color DGRAY = new Color((byte) 58, (byte) 58, (byte) 58);

    public static final Color WHITE = new Color((byte) 255, (byte) 255, (byte) 255);

    public static final Color WHITESMOKE = new Color((byte) 248, (byte) 248, (byte) 248);

    public static final Color WHITE_LABEL = new Color((byte) 246, (byte) 246, (byte) 246);

    public static final Color RED = new Color((byte) 255, (byte) 0, (byte) 0);

    public static final Color VIOLET_FG = new Color((byte) 41, (byte) 41, (byte) 41);

    public static final Color VIOLET_TXT = new Color((byte) 242, (byte) 183, (byte) 248);

    public static final Color BORDER_GAUGE = new Color((byte) 168, (byte) 0, (byte) 255);

    public static final Color LIGHTGREY = new Color(0xd3d3d3);

    public static final Color NO_COLOR = null;

    public static final Color DARKBLUE = new Color(0x00008b);

    byte r;

    byte g;

    byte b;

    byte a = (byte) 0xFF;

    /**
     * @param r
     * @param g
     * @param b
     */
    public Color(byte r, byte g, byte b) {
        super();
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color(int color) {
        this.a = (byte) ((color & ALPHA_MASK) >> ALPHA_OFFSET);
        this.r = (byte) ((color & RED_MASK) >> RED_OFFSET);
        this.g = (byte) ((color & GREEN_MASK) >> GREEN_OFFSET);
        this.b = (byte) ((color & BLUE_MASK) >> BLUE_OFFSET);
    }

    public int getInt() {
        return ((int) (this.a & 0xFF) << ALPHA_OFFSET) | ((int) (this.r & 0xFF) << RED_OFFSET)
                | ((int) (this.g & 0xFF) << GREEN_OFFSET) | ((int) (this.b & 0xFF) << BLUE_OFFSET);
    }
}
