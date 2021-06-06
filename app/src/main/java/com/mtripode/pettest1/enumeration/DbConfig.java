package com.mtripode.pettest1.enumeration;

import android.database.sqlite.SQLiteDatabase.CursorFactory;

public enum DbConfig {
	DATABASE, TABLE_ACCOUNT;

	public static final int dbDefaultVersion = 1;
	public static final CursorFactory dbDefaultCursorFactory = null;

	/** use it to separate values while creating SQL statements */
	public static final String COMMA = ",";
	/** use it to save it as a null value */
	public static final String NULL = " NULL ";
	/** use it to save integers, primary keys */
	public static final String INTEGER = " INTEGER ";
	/** use it to save doubles, floats */
	public static final String REAL = " REAL ";
	/** use it to save text, varchar, char */
	public static final String TEXT = " TEXT ";
	/** use it to save fotos, videos, audio, data etc. */
	public static final String BLOB = " BLOB ";

	public enum TableAccount {
		ID, NAME, LAST_NAME, MAIL, WEIGHT, HEIGHT, SEX, DATEBIRTHDAY;
		public static String generateCreateTableStatement() {
			final String c0 = NAME.name() + TEXT + COMMA;
			final String c1 = LAST_NAME.name() + TEXT + COMMA;
			final String c2 = MAIL.name() + TEXT + COMMA;
			final String c3 = SEX.name() + TEXT + COMMA;
			final String c4 = DATEBIRTHDAY.name() + TEXT;
			final String creteStatement = c0 + c1 + c2 + c3 + c4;
			return creteStatement;
		}
	}

}
