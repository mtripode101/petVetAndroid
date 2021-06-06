package com.mtripode.pettest1.abscomponent;

import java.util.Vector;

public final class StringUtils {

    public static final String NULL = "";

    /**
     * <p>
     * The maximum size to which the padding constant(s) can expand.
     * </p>
     */
    private static final int PAD_LIMIT = 8192;

    /**
     * <p>
     * An array of <code>String</code> s used for padding.
     * </p>
     * <p>
     * Used for efficient space padding. The length of each String expands as
     * needed.
     * </p>
     */
    private static final String[] PADDING = new String[Character.MAX_VALUE];

    /**
     * <p>
     * Centers a String in a larger String of size <code>size</code>. Uses a
     * supplied character as the value to pad the String with.
     * </p>
     * 
     * <p>
     * If the size is less than the String length, the String is returned. A
     * <code>null</code> String returns <code>null</code>. A negative size
     * is treated as zero.
     * </p>
     * 
     * <pre>
     * 
     *  StringUtils.center(null, *, *)     = null
     *  StringUtils.center(&quot;&quot;, 4, ' ')     = &quot;    &quot;
     *  StringUtils.center(&quot;ab&quot;, -1, ' ')  = &quot;ab&quot;
     *  StringUtils.center(&quot;ab&quot;, 4, ' ')   = &quot; ab&quot;
     *  StringUtils.center(&quot;abcd&quot;, 2, ' ') = &quot;abcd&quot;
     *  StringUtils.center(&quot;a&quot;, 4, ' ')    = &quot; a  &quot;
     *  StringUtils.center(&quot;a&quot;, 4, 'y')    = &quot;yayy&quot;
     *  
     * </pre>
     * 
     * @param str
     *            the String to center, may be null
     * @param size
     *            the int size of new String, negative treated as zero
     * @param padChar
     *            the character to pad the new String with
     * @return centered String, <code>null</code> if null String input
     * @since 2.0
     */
    public static String center(String str, int size, char padChar) {
        if (str == null || size <= 0) {
            return str;
        }
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str;
        }
        str = leftPad(str, strLen + pads / 2, padChar);
        str = rightPad(str, size, padChar);
        return str;
    }

    /**
     * @deprecated use TypeUtils
     * @param str
     * @return
     */
    public static boolean isNull(String str) {
        return TypeUtils.isNull(str);
    }

    /**
     * @param qty
     * @return <code>true</code> if qty is <code>null</code>, the empty
     *         string or <code>"0"</code>
     */
    public static boolean isZero(String qty) {
        return isNull(qty) || "0".equals(qty);
    }

    public static boolean isEmpty (String str){
        return isNull(str) || str.length() == 0;
    }

    /**
     * <p>
     * Left pad a String with a specified character.
     * </p>
     * 
     * <p>
     * Pad to a size of <code>size</code>.
     * </p>
     * 
     * <pre>
     * 
     *  StringUtils.leftPad(null, *, *)     = null
     *  StringUtils.leftPad(&quot;&quot;, 3, 'z')     = &quot;zzz&quot;
     *  StringUtils.leftPad(&quot;bat&quot;, 3, 'z')  = &quot;bat&quot;
     *  StringUtils.leftPad(&quot;bat&quot;, 5, 'z')  = &quot;zzbat&quot;
     *  StringUtils.leftPad(&quot;bat&quot;, 1, 'z')  = &quot;bat&quot;
     *  StringUtils.leftPad(&quot;bat&quot;, -1, 'z') = &quot;bat&quot;
     *  
     * </pre>
     * 
     * @param str
     *            the String to pad out, may be null
     * @param size
     *            the size to pad to
     * @param padChar
     *            the character to pad with
     * @return left padded String or original String if no padding is necessary,
     *         <code>null</code> if null String input
     * @since 2.0
     */
    public static String leftPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (pads > PAD_LIMIT) {
            return leftPad(str, size, String.valueOf(padChar));
        }
        return padding(pads, padChar).concat(str);
    }

    /**
     * <p>
     * Left pad a String with a specified String.
     * </p>
     * 
     * <p>
     * Pad to a size of <code>size</code>.
     * </p>
     * 
     * <pre>
     * 
     *  StringUtils.leftPad(null, *, *)      = null
     *  StringUtils.leftPad(&quot;&quot;, 3, &quot;z&quot;)      = &quot;zzz&quot;
     *  StringUtils.leftPad(&quot;bat&quot;, 3, &quot;yz&quot;)  = &quot;bat&quot;
     *  StringUtils.leftPad(&quot;bat&quot;, 5, &quot;yz&quot;)  = &quot;yzbat&quot;
     *  StringUtils.leftPad(&quot;bat&quot;, 8, &quot;yz&quot;)  = &quot;yzyzybat&quot;
     *  StringUtils.leftPad(&quot;bat&quot;, 1, &quot;yz&quot;)  = &quot;bat&quot;
     *  StringUtils.leftPad(&quot;bat&quot;, -1, &quot;yz&quot;) = &quot;bat&quot;
     *  StringUtils.leftPad(&quot;bat&quot;, 5, null)  = &quot;  bat&quot;
     *  StringUtils.leftPad(&quot;bat&quot;, 5, &quot;&quot;)    = &quot;  bat&quot;
     *  
     * </pre>
     * 
     * @param str
     *            the String to pad out, may be null
     * @param size
     *            the size to pad to
     * @param padStr
     *            the String to pad with, null or empty treated as single space
     * @return left padded String or original String if no padding is necessary,
     *         <code>null</code> if null String input
     */
    public static String leftPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (padStr == null || padStr.length() == 0) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (padLen == 1 && pads <= PAD_LIMIT) {
            return leftPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen) {
            return padStr.concat(str);
        } else if (pads < padLen) {
            return padStr.substring(0, pads).concat(str);
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return new String(padding).concat(str);
        }
    }

    public static boolean like(String str, String patern) {
        int i;

        if (str == null || patern == null || str.length() == 0) {
            return false;
        }
        if (patern.length() == 0) {
            return true;
        }

        str = str.toLowerCase();
        patern = patern.toLowerCase();
        i = str.indexOf(patern.charAt(0));
        while (i != -1) {
            if (str.regionMatches(false, i, patern, 0, patern.length())) {
                return true;
            }
            i = str.indexOf(patern.charAt(0), i + 1);
        }
        return false;
    }

    /**
     * @param string
     * @return
     */
    public static String nil(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        } else {
            return str;
        }
    }

    /**
     * <p>
     * Returns padding using the specified delimiter repeated to a given length.
     * </p>
     * 
     * <pre>
     * 
     *  
     *   
     *    
     *       StringUtils.padding(0, 'e')  = &quot;&quot;
     *       StringUtils.padding(3, 'e')  = &quot;eee&quot;
     *       StringUtils.padding(-2, 'e') = IndexOutOfBoundsException
     *     
     *    
     *   
     *  
     * </pre>
     * 
     * @param repeat
     *            number of times to repeat delim
     * @param padChar
     *            character to repeat
     * @return String with repeated character
     * @throws IndexOutOfBoundsException
     *             if <code>repeat &lt; 0</code>
     */
    private static String padding(int repeat, char padChar) {
        // be careful of synchronization in this method
        // we are assuming that get and set from an array index is atomic
        String pad = PADDING[padChar];
        if (pad == null) {
            pad = String.valueOf(padChar);
        }
        while (pad.length() < repeat) {
            pad = pad.concat(pad);
        }
        PADDING[padChar] = pad;
        return pad.substring(0, repeat);
    }

    /**
     * <p>
     * Right pad a String with a specified character.
     * </p>
     * 
     * <p>
     * The String is padded to the size of <code>size</code>.
     * </p>
     * 
     * <pre>
     * 
     *  
     *   
     *       StringUtils.rightPad(null, *, *)     = null
     *       StringUtils.rightPad(&quot;&quot;, 3, 'z')     = &quot;zzz&quot;
     *       StringUtils.rightPad(&quot;bat&quot;, 3, 'z')  = &quot;bat&quot;
     *       StringUtils.rightPad(&quot;bat&quot;, 5, 'z')  = &quot;batzz&quot;
     *       StringUtils.rightPad(&quot;bat&quot;, 1, 'z')  = &quot;bat&quot;
     *       StringUtils.rightPad(&quot;bat&quot;, -1, 'z') = &quot;bat&quot;
     *    
     *   
     *  
     * </pre>
     * 
     * @param str
     *            the String to pad out, may be null
     * @param size
     *            the size to pad to
     * @param padChar
     *            the character to pad with
     * @return right padded String or original String if no padding is
     *         necessary, <code>null</code> if null String input
     * @since 2.0
     */
    public static String rightPad(String str, int size, char padChar) {
        if (str == null) {
            return null;
        }
        int pads = size - str.length();
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (pads > PAD_LIMIT) {
            return rightPad(str, size, String.valueOf(padChar));
        }
        return str.concat(padding(pads, padChar));
    }

    /**
     * <p>
     * Right pad a String with a specified String.
     * </p>
     * 
     * <p>
     * The String is padded to the size of <code>size</code>.
     * </p>
     * 
     * <pre>
     * 
     *  
     *       StringUtils.rightPad(null, *, *)      = null
     *       StringUtils.rightPad(&quot;&quot;, 3, &quot;z&quot;)      = &quot;zzz&quot;
     *       StringUtils.rightPad(&quot;bat&quot;, 3, &quot;yz&quot;)  = &quot;bat&quot;
     *       StringUtils.rightPad(&quot;bat&quot;, 5, &quot;yz&quot;)  = &quot;batyz&quot;
     *       StringUtils.rightPad(&quot;bat&quot;, 8, &quot;yz&quot;)  = &quot;batyzyzy&quot;
     *       StringUtils.rightPad(&quot;bat&quot;, 1, &quot;yz&quot;)  = &quot;bat&quot;
     *       StringUtils.rightPad(&quot;bat&quot;, -1, &quot;yz&quot;) = &quot;bat&quot;
     *       StringUtils.rightPad(&quot;bat&quot;, 5, null)  = &quot;bat  &quot;
     *       StringUtils.rightPad(&quot;bat&quot;, 5, &quot;&quot;)    = &quot;bat  &quot;
     *   
     *  
     * </pre>
     * 
     * @param str
     *            the String to pad out, may be null
     * @param size
     *            the size to pad to
     * @param padStr
     *            the String to pad with, null or empty treated as single space
     * @return right padded String or original String if no padding is
     *         necessary, <code>null</code> if null String input
     */
    public static String rightPad(String str, int size, String padStr) {
        if (str == null) {
            return null;
        }
        if (padStr == null || padStr.length() == 0) {
            padStr = " ";
        }
        int padLen = padStr.length();
        int strLen = str.length();
        int pads = size - strLen;
        if (pads <= 0) {
            return str; // returns original String when possible
        }
        if (padLen == 1 && pads <= PAD_LIMIT) {
            return rightPad(str, size, padStr.charAt(0));
        }

        if (pads == padLen) {
            return str.concat(padStr);
        } else if (pads < padLen) {
            return str.concat(padStr.substring(0, pads));
        } else {
            char[] padding = new char[pads];
            char[] padChars = padStr.toCharArray();
            for (int i = 0; i < pads; i++) {
                padding[i] = padChars[i % padLen];
            }
            return str.concat(new String(padding));
        }
    }

    //	public static void main(String[] args) {
    //		String tmp[] = split("�CSP KARTMAX�36908�", '�');
    //
    //		for (int i = 0; i < tmp.length; i++) {
    //			System.out.println(i + ": " + tmp[i]);
    //		}
    //	}

    public static final String[] split(String str, char separator) {
        Vector v = new Vector();
        int start = 0;
        int i = 0;
        int len;

        if (str == null || str.length() == 0) {
            return new String[0];
        }
        len = str.length();

        while (i < len) {
            if (str.charAt(i) == separator) {
                if (start != i) {
                    v.addElement(str.substring(start, i));
                } else {
                    v.addElement(null);
                }
                start = ++i;
                continue;
            }
            i++;
        }
        if (start != i) {
            v.addElement(str.substring(start, i));
        } else {
            v.addElement(null);
        }

        String[] ret = new String[v.size()];
        v.copyInto(ret);

        return ret;
    }

    private StringUtils() {
        // Empty
    }

}
