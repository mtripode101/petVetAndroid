package com.mtripode.pettest1.database;

public abstract class DAOProcessor {
	
	public static final String COLUMN_ID = "_id";
	
	public abstract String defineTableColumnsToCreate();

	public abstract String defineTableNameToCreate();
}
