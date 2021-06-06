/*
 * Created on Jul 25, 2012
 */
package com.mtripode.pettest1.abscomponent;

import java.util.Vector;

public interface Table {

    public void addRow(Object data[]);
    
    public void addRow(Object data[], Vector commands);

    public void setColumnInfo(TableColumn col[]);

    public void setShowGrid(boolean showGrid);
    
    public void setAddVerticalSeparator (boolean separator);
}
