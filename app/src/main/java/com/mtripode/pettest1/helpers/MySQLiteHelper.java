package com.mtripode.pettest1.helpers;

import com.mtripode.pettest1.enumeration.DbConfig;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

	public static final String COLUMN_ID = "_id";

	public MySQLiteHelper(Context context) {
		super(context, DbConfig.DATABASE.name(),
				DbConfig.dbDefaultCursorFactory, DbConfig.dbDefaultVersion);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		final String sqlCmdStart = "CREATE TABLE ";
		final String primaryKeyCmd = " (ID integer primary key autoincrement, ";
		final String sqlCmdEnd = ");";
		String createQuery = "";
		//db.execSQL(createQuery); // table TableTraining
		//db.execSQL(createQuery); // table TableAccount
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
	
	@Override
	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onCreate(db);
	}
}
