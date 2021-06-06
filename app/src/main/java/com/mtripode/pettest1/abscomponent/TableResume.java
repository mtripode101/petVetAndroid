/*
 * Created on Feb 4, 2013
 */
package com.mtripode.pettest1.abscomponent;

public class TableResume {

    public boolean visible = true;

    public int align;

    public int type;

    public Object value;

    protected TableResume() {
        super();
    }

    /**
     * @param value
     * @param visible
     * @param align
     * @param type
     */
    protected TableResume(Object value, boolean visible, int align, int type) {
        super();
        this.value = value;
        this.visible = visible;
        this.align = align;
        this.type = type;
    }

}
