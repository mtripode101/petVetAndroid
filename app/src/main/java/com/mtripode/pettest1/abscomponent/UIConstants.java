package com.mtripode.pettest1.abscomponent;

import java.util.Hashtable;


/**
 * Use this file to define implementation independent UI constants.
 * 
 */

public class UIConstants {

    public static final char ALIGN_CENTER_CHAR = 'C';

    public static final Character ALIGN_CENTER = new Character(ALIGN_CENTER_CHAR);

    public static final char ALIGN_LEFT_CHAR = 'L';

    public static final Character ALIGN_LEFT = new Character(ALIGN_LEFT_CHAR);

    public static final char ALIGN_RIGHT_CHAR = 'R';

    public static final Character ALIGN_RIGHT = new Character(ALIGN_RIGHT_CHAR);

    /**
     * Indicates if graphic element is shown hilighted when focus is received.
     * Asociated with a Boolean
     */
    // public static String AT_HILIGHT = "HIGHLIGHT";

    /**
     * Indicates the style used to show an element. Styles must be created and
     * associated with factory to be used. Asociated to a String
     */
    public static String AT_STYLE = "STYLE";

    public static final Boolean FALSE = Boolean.FALSE;

    public static byte FIREBRICK = 30;

    public static byte FONT_CASUAL = 2;

    public static byte FONT_CONDENSED = 3;

    /** LARGE */
    // public static byte FONT_L = 3;
    /** MEDIUM */
    // public static byte FONT_M = 2;
    /**
     * FONT_X Fonts sizes recognized by system. Used to make implementation
     * independent of underlaying support. Font size is converted by specific
     * component factory.
     */
    /** SMALL */
    // public static byte FONT_S = 1;
    public static byte FONT_SANSSERIF = 4;

    public static byte FONT_SERIF = 1;

    /**
     * Fonts recognized by system. Used to make implementation independent of
     * underlaying support. Font styles are converted by specific component
     * factory
     */
    public static byte FONT_SYSTEM = 0;

    /** EXTRA LARGE */
    // public static byte FONT_XL = 4;
    /**
     * 
     */
    public static final int INPUT_DATE = 4;

    public static final int INPUT_DATE_TIME = 3;

    public static final int INPUT_FLOAT = 2;

    public static final int INPUT_INTEGER = 1;

    public static final int INPUT_TIME = 5;

    public static final int INPUT_URL = 6;

    public static final int INPUT_STRING = 0;

    public static String MENU = "MNU";

    public static String ONCHANGE = "CG";

    /** events/commands recognized by system */
    public static String ONCLICK = "CK";

    /**
     * remove all screens in stack, but the first one when showing the next
     * screen
     */
    public static byte SCREEN_CLEAR = -1;

    /** add screen to stack. No clean action */
    public static byte SCREEN_KEEP = 1;

    /** remove last screen shown when showing the next screen */
    public static byte SCREEN_REPLACE = 0;

    /**
     * default style name. Can be redefined if desired. This style is used when
     * creating UI elements and no style is provided
     */
    public static final String STYLE_DEFAULT = "_DF";

    public static final Boolean TRUE = new Boolean(true);

    public static byte NO_COLOR = Byte.MIN_VALUE;

    public static String REFRESH_COMMAND = "refCommand";

    public static String REFRESH_PARAMS = "refParams";

    public static final Hashtable YES_NO_SELECT = new Hashtable(4);

    public static final int TEXT_BOTTOM = 'b';

    public static final int TEXT_RIGHT = 'r';
    
    public static final int TEXT_NO_PADDING = 't';

    public static final Object LIST = new Object();

    public static final String AT_FONT_BOLD = "fntBld";

    public static final String AT_FONT_ITALIC = "fntItlc";

    public static final Object CLOSE_COMMAND = "clCmd";

    public static final int LABEL_LEFT = 0;

    public static final int LABEL_UP = 1;

    public static final int LABEL_RIGHT = 2;

    public static final int LABEL_BOTTOM = 3;

    public static final int LABEL_AS_HINT = 4;

    public static final int ICON_NO_ICON = 0;

    public static final int ICON_NEW = 1;

    public static final int ICON_SAVE = 2;

    public static final int ICON_BUY = 3;

    public static final int ICON_COPY = 4;

    public static final int ICON_REMOVE = 5;

    public static final int ICON_PRINT = 6;

    public static final int ICON_CONFIRM = 7;

    public static final int ICON_VALORICE = 8;

    public static final int ICON_SYNCHRONIZE = 9;

    public static final int ICON_FULL_SYNCHRONIZE = 10;

    public static final int ICON_DETAIL = 11;

    public static final int ICON_CHOOSE_ACCOUNT = 12;

}
