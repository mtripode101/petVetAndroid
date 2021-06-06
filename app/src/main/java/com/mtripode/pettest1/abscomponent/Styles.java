/*
 * Created on Aug 19, 2009
 */
package com.mtripode.pettest1.abscomponent;

import java.util.Enumeration;
import java.util.Hashtable;

public class Styles {

    static class InmutableHashtable extends Hashtable {

        public InmutableHashtable() {
            super();
        }

        public InmutableHashtable(int c) {
            super(c);
        }

        public synchronized Object put(Object k, Object v) {
            throw new RuntimeException(getClass().getName() + ": put prohibido");
        }

        protected synchronized Object put1(Object k, Object v) {
            return super.put(k, v);
        }

        public synchronized void clear() {
            throw new RuntimeException(getClass().getName() + ": clear prohibido");
        }

        public synchronized Object remove(Object o) {
            throw new RuntimeException(getClass().getName() + ": remove prohibido");
        }

        public Object clone() {
            Hashtable clone = new Hashtable(this.size() * 4 / 3 + 1);
            Enumeration keys = this.keys();

            while (keys.hasMoreElements()) {
                Object k = (Object) keys.nextElement();

                clone.put(k, this.get(k));
            }
            return clone;
        }

        synchronized InmutableHashtable putAll(InmutableHashtable t) {
            Enumeration keys = t.keys();

            while (keys.hasMoreElements()) {
                Object k = (Object) keys.nextElement();

                this.put1(k, t.get(k));
            }
            return this;
        }
    }

    public static final StyleI TABLE_ROW_ODD;

    public static final StyleI TABLE_ROW_EVEN = new StyleI();

    public static final StyleI LABEL_ERROR_CENTER;

    public static final StyleI TABLE_ROW_TITLE;

    public static final StyleI LABEL = new StyleI();

    public static final StyleI LABEL_WITH_FOCUS;

    public static final StyleI INPUT = new StyleI();

    public static final StyleI INPUT_INTEGER;

    public static final StyleI INPUT_FLOAT;

    public static final StyleI INPUT_DATE;

    public static final StyleI BUTTON = new StyleI();

    public static final StyleI ERROR = new StyleI();

    public static final StyleI LABEL_ERROR;

    public static final StyleI INPUT_PRODUCT_CODE;

    public static final StyleI INPUT_ACCOUNT_CODE;

    public static final StyleI LABEL_PARTIAL;

    public static final StyleI INPUT_DATETIME;

    public static final StyleI INPUT_255;

    public static final StyleI INPUT_63;

    public static final StyleI INPUT_URL;

    public static final StyleI LABEL_DATE;

    public static final StyleI LABEL_DATE_TIME;

    public static final StyleI LABEL_TIME;

    // public static final StyleI TABLE_ROW_EVEN_LABEL_DATE;

    // public static final StyleI TABLE_ROW_ODD_LABEL_DATE;

    public static final StyleI TABLE_ROW_EVEN_ERROR;

    public static final StyleI TABLE_ROW_ODD_ERROR;

    public static final StyleI LABEL_RIGHT;

    public static final StyleI INPUT_20;

    public static final StyleI WINDOW_STYLE = new StyleI();

    public static final StyleI LINK;

    public static final StyleI INPUT_READ_ONLY;

    static {
        LABEL.setOpaque(false);
        LABEL.setTableShowGrid(false);

        LABEL_PARTIAL = LABEL.derive();
        LABEL_PARTIAL.setLabelTruncateContent(true);

        LABEL_RIGHT = LABEL.derive();
        LABEL_RIGHT.setAlignment(UIConstants.ALIGN_RIGHT_CHAR);

        LABEL_WITH_FOCUS = LABEL.derive();
        LABEL_WITH_FOCUS.setFocusable(true);

        INPUT.setFgColor(Color.BLACK);
        INPUT.setShowBorders(true);
        INPUT.setOpaque(false);
        INPUT.setFocusable(true);

        INPUT_URL = INPUT.derive();
        INPUT_URL.setInputType(UIConstants.INPUT_URL);

        INPUT_255 = INPUT.derive();
        INPUT_255.setMaxCharInput(255);

        INPUT_63 = INPUT.derive();
        INPUT_63.setMaxCharInput(63);

        INPUT_20 = INPUT.derive();
        INPUT_20.setMaxCharInput(20);

        INPUT_INTEGER = INPUT.derive();
        INPUT_INTEGER.setInputType(UIConstants.INPUT_INTEGER);

        INPUT_FLOAT = INPUT.derive();
        INPUT_FLOAT.setInputType(UIConstants.INPUT_FLOAT);

        INPUT_DATE = INPUT.derive();
        INPUT_DATE.setInputType(UIConstants.INPUT_DATE);

        INPUT_DATETIME = INPUT_DATE.derive();
        INPUT_DATETIME.setInputType(UIConstants.INPUT_DATE_TIME);

        INPUT_READ_ONLY = INPUT.derive();
        INPUT_READ_ONLY.setFocusable(false);

        LABEL_DATE = LABEL.derive();
        LABEL_DATE.setFocusable(false);
        LABEL_DATE.setInputType(UIConstants.INPUT_DATE);

        LABEL_TIME = LABEL_DATE.derive();
        LABEL_TIME.setInputType(UIConstants.INPUT_TIME);

        LABEL_DATE_TIME = LABEL_DATE.derive();
        LABEL_DATE_TIME.setInputType(UIConstants.INPUT_DATE_TIME);

        ERROR.setFgColor(Color.RED);
        ERROR.setOpaque(false);
        ERROR.setAlignment(UIConstants.ALIGN_CENTER_CHAR);

        LABEL_ERROR = LABEL.derive();
        LABEL_ERROR.setFgColor(Color.RED);

        LABEL_ERROR_CENTER = LABEL_ERROR.derive();
        LABEL_ERROR_CENTER.setAlignment(UIConstants.ALIGN_CENTER_CHAR);

        INPUT_PRODUCT_CODE = INPUT.derive();

        INPUT_ACCOUNT_CODE = INPUT.derive();

        TABLE_ROW_EVEN.setFgColor(Color.BLACK);
        TABLE_ROW_EVEN.setBgColor(new Color(0xFFEFEFEF));
        TABLE_ROW_EVEN.setTableShowGrid(true);
        TABLE_ROW_EVEN.setOpaque(true);

        TABLE_ROW_EVEN_ERROR = TABLE_ROW_EVEN.derive();
        TABLE_ROW_EVEN_ERROR.setFgColor(Color.RED);
        // TABLE_ROW_EVEN_LABEL_DATE = clone(LABEL_DATE).putAll(TABLE_ROW_EVEN);

        TABLE_ROW_ODD = TABLE_ROW_EVEN.derive();
        TABLE_ROW_ODD.setFgColor(Color.BLACK);
        TABLE_ROW_ODD.setBgColor(new Color(0xFFE7E7E7));

        TABLE_ROW_ODD_ERROR = TABLE_ROW_ODD.derive();
        TABLE_ROW_ODD_ERROR.setFgColor(Color.RED);
        // TABLE_ROW_ODD_LABEL_DATE = clone(LABEL_DATE).putAll(TABLE_ROW_ODD);

        TABLE_ROW_TITLE = TABLE_ROW_EVEN.derive();
        TABLE_ROW_TITLE.setBgColor(new Color((byte) 0x5A, (byte) 0x59, (byte) 0xA5));
        TABLE_ROW_TITLE.setFgColor(Color.WHITE);
        TABLE_ROW_TITLE.setAlignment(UIConstants.ALIGN_CENTER_CHAR);

        WINDOW_STYLE.setFgColor(Color.WHITE);
        WINDOW_STYLE.setBgColor(new Color((byte) 0x1f, (byte) 0x18, (byte) 0x39));
        WINDOW_STYLE.setOpaque(true);
        WINDOW_STYLE.setTableShowGrid(false);

        BUTTON.setFocusable(true);

        LINK = LABEL_WITH_FOCUS.derive();
    }

}
