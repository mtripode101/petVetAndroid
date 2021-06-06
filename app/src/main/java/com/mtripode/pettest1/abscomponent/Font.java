/*
 * Created on Aug 21, 2012
 */
package com.mtripode.pettest1.abscomponent;

public class Font {

    public static final Font DEFAULT = new Font();

    public static String DEFAULT_FONT_NAME;

    public static int DEFAULT_FONT_SIZE;

    private static final FontFactory FONT_FACTORY;

    static {
        try {
            FONT_FACTORY = (FontFactory) Class.forName("com.mtripode.training.abscomponent.DeviceFontFactory").newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.toString());
        }
    }

    public boolean bold;

    public boolean italic;

    private String name;

    private int size = TypeUtils.NULL_INT;

    public Object getDeviceFont() {
        return FONT_FACTORY.getDeviceFont(this);
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name == null ? DEFAULT_FONT_NAME : this.name;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return TypeUtils.isNull(this.size) ? DEFAULT_FONT_SIZE : this.size;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param size
     *            the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
}
