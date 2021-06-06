/*
 * Created on Jun 14, 2006
 */
package com.mtripode.pettest1.abscomponent;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author marcosd
 * 
 *         Jun 14, 2006 Entrepids S.A. PowerChannels 4J
 */
public class Format {

    public static final int AUTO = 0;

    public static final int DATE = 1;

    public static final int DATE_TIME = 3;

    private static final DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);

    private static final DateFormat tf = DateFormat.getTimeInstance(DateFormat.MEDIUM);

    public static final int TIME = 2;

    public static String format(float f) {
        return toString(f);
    }

    public static String format(int i) {
        return String.valueOf(i);
    }

    /**
     * @param dtShippingExpected
     * @return
     */
    public static String format(Date date, int type) {
        String d = "";
        String t = "";

        if (type != TIME) {
            d = df.format(date);
        }
        if (type == TIME || type == DATE_TIME) {
            t = tf.format(date);
        }

        return d + t;
    }

    public static String format(long l) {
        return String.valueOf(l);
    }

    public static String format(Object object, int type) {
        String s = "";

        if (object == null) {
            return s;
        }

        if (object instanceof Date) {
            s = format((Date) object, type);
        } else if (type >= DATE && type <= DATE_TIME) {
            formatDate(((Long) object).longValue(), type);
        } else if (object instanceof Number) {
            s = format(((Number) object).floatValue());
        } else {
            s = String.valueOf(object);
        }
        return s;
    }

    public static String format(String s) {
        return s == null ? "" : s;
    }

    public static String formatDate(long date, int type) {
        if (TypeUtils.isNull(date)) {
            return format(null, type);
        }

        return format(new Date(date), type);
    }

    public static String formatQty(float f) {
        return toString(f, "psales.orders.decimalDigits");
    }

    /**
     * @param f
     * @return
     */
    public static String toString(float f) {
        return toString(f, "psales.ui.decimalDigits");
    }

    public static String toString(float f, int numOfDecimals, char decimalSeparator, char groupSeparator) {
        StringBuffer buffer = new StringBuffer();
        boolean negative = f < 0f;
        String parts[] = new String[3];
        String tmp[];
        String str;
        int exponent;
        int decPointPos;

        if (Float.isNaN(f)) {
            return "";
        }
        if (Float.isInfinite(f)) {
            return "\u221E";
        }

        if (negative) {
            f = -f;
            buffer.append('-');
        }
        str = String.valueOf(f);
        tmp = StringUtils.split(str, 'E');
        if (tmp.length > 1) {
            parts[2] = tmp[1];
        }
        tmp = StringUtils.split(tmp[0], '.');
        parts[0] = tmp[0];
        parts[1] = tmp[1];

        if (parts[2] != null) {
            exponent = Integer.parseInt(parts[2]);
        } else {
            exponent = 0;
        }

        if (exponent >= 0) {
            parts[1] = StringUtils.rightPad(parts[1], exponent + numOfDecimals, '0');
        } else {
            parts[0] = StringUtils.leftPad(parts[0], -exponent, '0');
            parts[1] = StringUtils.rightPad(parts[1], numOfDecimals, '0');
        }

        buffer.append(parts[0]);
        buffer.append(parts[1]);
        decPointPos = parts[0].length() + exponent;
        if (decPointPos == 0) {
            buffer.insert(0, '0');
            decPointPos++;
        }
        decPointPos += (negative ? 1 : 0);
        if (numOfDecimals > 0) {
            buffer.insert(decPointPos, decimalSeparator);
            buffer.setLength(decPointPos + numOfDecimals + 1);
        } else {
            buffer.setLength(decPointPos);
        }
        if (!TypeUtils.isNull(groupSeparator)) {
            for (int i = decPointPos - 3; (i > 1 && negative) || (i > 0 && !negative); i -= 3) {
                buffer.insert(i, groupSeparator);
            }
        }
        return buffer.toString();
    }

    /**
     * @param f
     * @param cfgNumOfDec
     * @return
     */
    public static String toString(float f, String cfgNumOfDec) {

        int numOfDecimals;
        char decimalSeparator;
        char groupseparator;


       return Format.toString(f, 2, ',', '.');
    }

    /**
     *  
     */
    private Format() {
        super();
    }
}
