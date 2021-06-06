package com.mtripode.pettest1.abscomponent;

import android.view.ViewGroup.LayoutParams;


/**
 * This class is used to define the styles used in an apllication. Styles are
 * managed by builderFactory, and must be asociated with it before you can use
 * the style in any graphic compo. A style includes a fontSize and style (both
 * defined in Constants) and a backgroud and foregrond color (also defined in
 * Constants).
 * 
 * @author rodrigod
 */
public class StyleI {

    private int maxCharInput = Integer.MAX_VALUE;

    private char alignment = UIConstants.ALIGN_LEFT_CHAR;

    private Color bgColor = Color.WHITE;

    private Color fgColor = Color.BLACK;

    private String name;

    private Font font = Font.DEFAULT;

    private boolean showBorders;

    private boolean focusable;

    private boolean closeable = true;
    
    private float alpha = 1;

    private int height = TypeUtils.NULL_INT;

    private int width = TypeUtils.NULL_INT;

    private int inputType;

    private boolean labelTruncateContent;

    private String title;

    private boolean tableShowGrid = true;

    private boolean opaque;

    private int textPosition;

    private Color textColor;

    private String backgroundImage;

    private String drawable_style;
    
    private ShadowLayer shadowLayer;
    
    private int paramWidth = LayoutParams.MATCH_PARENT;
    
    private int paramHeight = LayoutParams.MATCH_PARENT;

    public static final StyleI DEFAULT = new StyleI() {

        public String getName() {
            return UIConstants.STYLE_DEFAULT;
        }

        public Color getFgColor() {
            return Color.BLACK;
        }

        public Color getBgColor() {
            return Color.WHITE;
        }

        public char getAlignment() {
            return UIConstants.ALIGN_LEFT_CHAR;
        }

        public boolean showBorders() {
            return false;
        }

        public boolean focusable() {
            return false;
        }

        public boolean closeable() {
            return true;
        }

        public int getHeight() {
            return TypeUtils.NULL_INT;
        }

        public int getWidth() {
            return TypeUtils.NULL_INT;
        }

        public int getInputType() {
            return UIConstants.INPUT_STRING;
        }

        public int getMaxCharInput() {
            return TypeUtils.NULL_INT;
        }

        public boolean labelTruncateContent() {
            return false;
        }

        public String getTitle() {
            return null;
        }

        public boolean tableShowGrid() {
            return true;
        }

        public boolean opaque() {
            return false;
        }

        public Font getFont() {
            return Font.DEFAULT;
        }
    };

    public StyleI() {
        this((String) null);
    }

    public StyleI(String name) {
        super();
        this.name = name;
    }

    public StyleI(StyleI style) {
        this.alignment = style.alignment;
        this.backgroundImage = style.backgroundImage;
        this.bgColor = style.bgColor;
        this.closeable = style.closeable;
        this.fgColor = style.fgColor;
        this.focusable = style.focusable;
        this.font = style.font;
        this.height = style.height;
        this.inputType = style.inputType;
        this.labelTruncateContent = style.labelTruncateContent;
        this.maxCharInput = style.maxCharInput;
        this.name = style.name;
        this.opaque = style.opaque;
        this.showBorders = style.showBorders;
        this.tableShowGrid = style.tableShowGrid;
        this.textPosition = style.textPosition;
        this.title = style.title;
        this.width = style.width;
    }

    public char getAlignment() {
        return this.alignment;
    }

    public Color getBgColor() {
        return this.bgColor;
    }

    public Color getFgColor() {
        return this.fgColor;
    }

    public String getName() {
        return this.name;
    }

    public void setAlignment(char alignment) {
        this.alignment = alignment;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    public void setFgColor(Color fgColor) {
        this.fgColor = fgColor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Font getFont() {
        return this.font;
    }

    public boolean showBorders() {
        return this.showBorders;
    }

    public boolean focusable() {
        return this.focusable;
    }

    public boolean closeable() {
        return this.closeable;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getInputType() {
        return this.inputType;
    }

    public int getMaxCharInput() {
        return this.maxCharInput;
    }

    public boolean labelTruncateContent() {
        return this.labelTruncateContent;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean tableShowGrid() {
        return this.tableShowGrid;
    }

    public boolean opaque() {
        return this.opaque;
    }

    public StyleI derive() {
        StyleI clon = new StyleI(this);

        return clon;
    }

    /**
     * @return the showBorders
     */
    public boolean isShowBorders() {
        return this.showBorders;
    }

    /**
     * @param showBorders
     *            the showBorders to set
     */
    public void setShowBorders(boolean showBorders) {
        this.showBorders = showBorders;
    }

    /**
     * @return the focusable
     */
    public boolean isFocusable() {
        return this.focusable;
    }

    /**
     * @param focusable
     *            the focusable to set
     */
    public void setFocusable(boolean focusable) {
        this.focusable = focusable;
    }

    /**
     * @return the closeable
     */
    public boolean isCloseable() {
        return this.closeable;
    }

    /**
     * @param closeable
     *            the closeable to set
     */
    public void setCloseable(boolean closeable) {
        this.closeable = closeable;
    }

    /**
     * @return the labelTruncateContent
     */
    public boolean isLabelTruncateContent() {
        return this.labelTruncateContent;
    }

    /**
     * @param labelTruncateContent
     *            the labelTruncateContent to set
     */
    public void setLabelTruncateContent(boolean labelTruncateContent) {
        this.labelTruncateContent = labelTruncateContent;
    }

    /**
     * @return the tableShowGrid
     */
    public boolean isTableShowGrid() {
        return this.tableShowGrid;
    }

    /**
     * @param tableShowGrid
     *            the tableShowGrid to set
     */
    public void setTableShowGrid(boolean tableShowGrid) {
        this.tableShowGrid = tableShowGrid;
    }

    /**
     * @return the opaque
     */
    public boolean isOpaque() {
        return this.opaque;
    }

    /**
     * @param opaque
     *            the opaque to set
     */
    public void setOpaque(boolean opaque) {
        this.opaque = opaque;
    }

    /**
     * @param maxCharInput
     *            the maxCharInput to set
     */
    public void setMaxCharInput(int maxCharInput) {
        this.maxCharInput = maxCharInput;
    }

    /**
     * @param font
     *            the font to set
     */
    public void setFont(Font font) {
        this.font = font;
    }

    /**
     * @param height
     *            the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @param width
     *            the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param inputType
     *            the inputType to set
     */
    public void setInputType(int inputType) {
        this.inputType = inputType;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public int getTextPosition() {
        return this.textPosition;
    }

    /**
     * @param textPosition
     *            the textPosition to set
     */
    public void setTextPosition(int textPosition) {
        this.textPosition = textPosition;
    }

    public String getBackgroundImage() {
        return this.backgroundImage;
    }

    /**
     * @param backgroundImage
     *            the backgroundImage to set
     */
    public void setBackgroundImage(String backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public Color getTextColor() {
        return this.textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    public String getDrawable_style() {
        return this.drawable_style;
    }

    public void setDrawable_style(String drawable_style) {
        this.drawable_style = drawable_style;
    }

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

	public ShadowLayer getShadowLayer() {
		return shadowLayer;
	}

	public void setShadowLayer(ShadowLayer shadowLayer) {
		this.shadowLayer = shadowLayer;
	}

	public int getParamWidth() {
		return paramWidth;
	}

	public void setParamWidth(int paramWidth) {
		this.paramWidth = paramWidth;
	}

	public int getParamHeight() {
		return paramHeight;
	}

	public void setParamHeight(int paramHeight) {
		this.paramHeight = paramHeight;
	}

}
