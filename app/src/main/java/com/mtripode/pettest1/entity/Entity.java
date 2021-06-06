package com.mtripode.pettest1.entity;

import android.os.Parcelable;

/**
 *
 */
public abstract class Entity implements Parcelable{
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
