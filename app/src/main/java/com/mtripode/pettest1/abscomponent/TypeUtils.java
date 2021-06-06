/*
 * Created on May 8, 2006
 */
package com.mtripode.pettest1.abscomponent;

/**
 * @author marcosd
 * 
 *         May 8, 2006 Entrepids S.A. PowerChannels 4J
 */
public final class TypeUtils {

    public static final char NULL_CHAR = Character.MIN_VALUE;

    public static final double NULL_DOUBLE = Double.MIN_VALUE;

    public static final float NULL_FLOAT = Float.MIN_VALUE;

    public static final int NULL_INT = Integer.MIN_VALUE;

    public static final long NULL_LONG = Long.MIN_VALUE;

    public static final String NULL_STRING = null;

    public static boolean isNull(char c) {
        return c == NULL_CHAR;
    }

    /**
     * @param f
     * @return
     */
    public static boolean isNull(double f) {
        return f == NULL_DOUBLE;
    }

    /**
     * @param f
     * @return
     */
    public static boolean isNull(float f) {
        return f == NULL_FLOAT;
    }

    public static boolean isNull(int i) {
        return i == NULL_INT;
    }

    public static boolean isNull(long l) {
        return l == NULL_LONG;
    }

    /**
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        return str == null || str.length() == 0;
    }

    public static float parseFloat(String str) {
        if (isNull(str)) {
            return NULL_FLOAT;
        }
        return Float.parseFloat(str);
    }

    public static long parseLong(String str) {
        if (isNull(str)) {
            return NULL_LONG;
        }
        return Long.parseLong(str);
    }

    private TypeUtils() {
        // Empty
    }
}
