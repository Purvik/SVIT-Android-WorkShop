package com.purvik.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHandler extends SQLiteOpenHelper {
	
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "contacts";

	// Table name - Contacts
	private static final String TABLE_NAME = "contactNumbers";

	// Contacts Table Columns names
	private static final String KEY_ID = "_id";
	private static final String KEY_NAME = "_name";
	private static final String KEY_PHONE_NO = "_phone_number";
	
	

	public DBHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		//Create DataBase
		String CREATE_CONTACT_NUMBERS_TABLE = "CREATE TABLE " + TABLE_NAME + "("
				+ KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ KEY_NAME + " TEXT," 
				+ KEY_PHONE_NO + " TEXT" + ")";
		
		db.execSQL(CREATE_CONTACT_NUMBERS_TABLE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

		// Create tables again
		onCreate(db);

	}
	
	//Add Contact Details To Table
	
	void addContact(Contact contact){
		
		//get DB to Write
		SQLiteDatabase db = this.getWritableDatabase();
		
		// set vlaues to be inserted in DB
		ContentValues value = new ContentValues();
		value.put(KEY_NAME, contact.get_name());
		value.put(KEY_PHONE_NO, contact.get_phone_number());
		
		// insert values to DB
		db.insert(TABLE_NAME, null, value);
		db.close();
		
		
	}
	
	

}
