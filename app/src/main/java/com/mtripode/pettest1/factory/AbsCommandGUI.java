package com.mtripode.pettest1.factory;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import com.mtripode.pettest1.abscomponent.CommandGUI;

public abstract class AbsCommandGUI extends CommandGUI {

	private Hashtable internParams;
	private Hashtable actualParams;
	private String name;
	private Form from;

	public AbsCommandGUI(String name) {
		super();
		this.name = name;
	}

	public AbsCommandGUI(String name, Hashtable params) {
		this(name);
		this.internParams = params;
	}

	protected abstract Vector executeImpl(Hashtable params) throws Exception;

	@Override
	public void execute(Hashtable params) {
		Vector errors = null;

		this.actualParams = new Hashtable(2);
		if (this.internParams == null) {
			if (params != null) {
				this.actualParams = params;
			}
		} else { // se modifica -> hace un volcado de datos
			Enumeration en;
			en = this.internParams.keys();
			while (en.hasMoreElements()) {
				Object key = (Object) en.nextElement();
				this.actualParams.put(key, this.internParams.get(key));

			}
			if (params != null) {
				en = params.keys();
				while (en.hasMoreElements()) {
					Object key = (Object) en.nextElement();
					this.actualParams.put(key, params.get(key));
				}// while
			}// if params
		}// else
		try {
			errors = this.executeImpl(this.actualParams);
		} catch (Throwable e) {
			this.error(e);
		}
		if (errors != null && !errors.isEmpty()) {
		}

	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public CommandGUI setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public boolean success() {
		return true;
	}

	public void error(Throwable e) {
		final String msg;

		e.printStackTrace();

		// uif.alert(msg);

	}

	public Hashtable getParams() {
		return this.internParams;
	}

	public Form getForm() {
		return this.from;
	}

	public void setForm(Form form) {
		this.from = form;
	}
}
