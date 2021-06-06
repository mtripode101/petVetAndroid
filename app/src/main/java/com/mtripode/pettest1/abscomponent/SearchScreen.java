/*
 * Created on Oct 3, 2012
 */
package com.mtripode.pettest1.abscomponent;

import java.util.List;
import java.util.Vector;

public interface SearchScreen extends Screen {

	public abstract class VectorDataAdaptor implements DataAdaptor {

		protected List data;

		public VectorDataAdaptor(List data) {
			this.data = data;
		}

		public int size() {
			return this.data == null ? 0 : this.data.size();
		}

		public Object getObject(int position) {
			return this.data.get(position);
		}
	}

	public interface DataAdaptor {
		public Object[] get(int position);

		public int size();

		public Object getObject(int position);

		public Object getObjectKey(int position);

		public String getKeyParamName();

		public Vector getItemCommands(int position);
	}

	public void setDataAdaptor(DataAdaptor adaptor);

	public void setColumnInfo(TableColumn[] tableColumns);

	public abstract void setClickCommand(CommandGUI clickCommand);

}
