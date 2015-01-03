package com.example.sqlite;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;


public class Database extends SQLiteOpenHelper
{
	
	 private static final String  DATABAE_NAME="MyDatabase";
	 private static final int DATABASE_VERSION=3;
	 
	 private static final String CONTACT="My_Table";
	 private static final String CONTACT_ID="_id";
	 private static final String CONTACT_FNAME="FirstName";
	 private static final String CONTACT_LNAME="LastName";
	 private static final String CONTACT_CITY="City";
	 private static final String CONTACT_EMAIL="Email";
	 private static final String CONTACT_NO="No";
	/* private static final String USERNAME="username";
	 private static final String PASSWORD="password";*/
	 private static final String IMAGE="Photo";
	 
	 public static final String APP_NAME = "AdvancedSearch";
	 
	 
	  Bundle bundle;
	
	 private static final String DATABASE_CREATE = "Create Table " + CONTACT+ "(" 
	         + CONTACT_ID+ " integer primary key autoincrement," 
			 + CONTACT_FNAME+ " text," 
			 + CONTACT_LNAME+ " text,"
			 + CONTACT_CITY+ " text," 
			 + CONTACT_EMAIL+ " text," 
			 + CONTACT_NO+ " text," 
		     + IMAGE+ " BLOB)";
	 

	public Database(Context context)
	{
		super(context, DATABAE_NAME, null, DATABASE_VERSION);
		
	}
	
	@Override 
	public void onCreate(SQLiteDatabase db)
	{
		
		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		// TODO Auto-generated method stub
		db.execSQL("Drop Table if exists " +CONTACT);
		onCreate(db);
	}
	
	public void InsertData(List list)
	{
		SQLiteDatabase db=this.getWritableDatabase();
		ContentValues cv=new ContentValues();
		
		cv.put(CONTACT_FNAME, list.FirstName);
		cv.put(CONTACT_LNAME, list.LastName);
		cv.put(CONTACT_CITY, list.City);
		cv.put(CONTACT_EMAIL, list.Email);
		cv.put(CONTACT_NO, list.No);
	
		cv.put(IMAGE, list.image);
		
		
		db.insert(CONTACT, null, cv);
		db.close();
		
	}
	
	
	public ArrayList<List> GetData()
	{
		SQLiteDatabase db=this.getReadableDatabase();
		ArrayList<com.example.sqlite.List> array=new ArrayList<com.example.sqlite.List>();
		String q="select * from " + CONTACT;
		Cursor cr = db.rawQuery(q, null);
		cr.moveToFirst();
		
		
		while(cr.isAfterLast()==false)
		{
			List list=new List();
			
			list.setFname(cr.getString(cr.getColumnIndex(CONTACT_FNAME)));
			list.setLname(cr.getString(cr.getColumnIndex(CONTACT_LNAME)));
			list.setCity(cr.getString(cr.getColumnIndex(CONTACT_CITY)));
			list.setMail(cr.getString(cr.getColumnIndex(CONTACT_EMAIL)));
			list.setNo(cr.getString(cr.getColumnIndex(CONTACT_NO)));
		    list.setImage(cr.getBlob(cr.getColumnIndex(IMAGE)));
			
			array.add(list);
			cr.moveToNext();
		}
		System.out.println("array size in getdata is : "+array.size());
		return array ;
	}
	
	
	
	
	
	
	
	

}
