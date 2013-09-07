package com.sample.redditapp;

import com.sample.redditapp.RedditDBHelper.ItemColumns;
import com.sample.redditapp.RedditDBHelper.Tables;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ItemDBManager {
 private static ItemDBManager instance;
 private Context context;
 public ItemDBManager(Context context){
	 this.context = context;
 }
 public static ItemDBManager instance(Context context){
	 if(instance == null)
	 {
		 instance = new ItemDBManager(context);
	 }
	 if(instance.context != context)
	 {
		 instance.context = context;
	 }
	 return instance;
 }
 public boolean save(RedditItem item)
 {
	 RedditDBHelper helper = new RedditDBHelper(context);
	 SQLiteDatabase db = helper.getWritableDatabase();
	 ContentValues values = new ContentValues();
	 values.put(ItemColumns.AUTHOR, item.author);
	 values.put(ItemColumns.THUMBNAIL, item.thumbnail);
	 values.put(ItemColumns.TITLE,item.title);
	 long id = db.insert(Tables.ITEM, null, values);
	 return id>0;
 }
}
