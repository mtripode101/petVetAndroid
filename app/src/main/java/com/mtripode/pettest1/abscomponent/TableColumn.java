/*
 * Created on Jul 25, 2012
 */
package com.mtripode.pettest1.abscomponent;

public class TableColumn extends TableResume {

    public String title;

    public int width = 1;

    public int height = -1;

    public boolean merge;

    private Margins margins;

    public class Margins {
        private int left;

        private int top;

        private int right;

        private int bottom;

        public Margins() {

        }

        public int getLeft() {
            return this.left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getTop() {
            return this.top;
        }

        public void setTop(int top) {
            this.top = top;
        }

        public int getRight() {
            return this.right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getBottom() {
            return this.bottom;
        }

        public void setBottom(int bottom) {
            this.bottom = bottom;
        }
    }

    public TableColumn() {
        super();
    }

    /**
     * 
     * @param title
     * @param width
     * @param visible
     */
    public TableColumn(String title, int width, boolean visible, int type) {
        this(title, width, visible,1, false, type);
    }
 
    /**
     * 
     * @param title
     * @param width
     * @param visible
     * @param align
     * @param merge
     */
    public TableColumn(String title, int width, boolean visible, int align, boolean merge, int type) {
        super();
        this.title = title;
        this.width = width;
        this.visible = visible;
        this.align = align;
        this.merge = merge;
        this.type = type;
    }

    public TableColumn(String title, int width, boolean visible, int align, int type) {
        this(title, width, visible, align, false, type);
    }

    public TableColumn(String title, int width, int height, boolean visible, int align, int type) {
        this(title, width, visible, align, false, type);
    	this.height = height;
    }
    public Margins getMargins() {
        if (this.margins == null) {
            this.margins = new Margins();
        }
        return this.margins;
    }

    public void setMargins(Margins margins) {
        this.margins = margins;
    }

}
