package com.sample.redditapp;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Processor {
	
	public static List<RedditItem> process(JSONObject response) throws JSONException {
		// TODO Auto-generated method stub
		
		JSONArray children = response.getJSONObject("data").getJSONArray("children");
		
		List<RedditItem> items = new ArrayList<RedditItem>();
		
		for(int i = 0; i< children.length(); i++)
		{
			JSONObject data = children.getJSONObject(i).getJSONObject("data");
			
			RedditItem item = new RedditItem();
			item.author = data.getString("author");
			item.thumbnail = data.getString("thumbnail");
			item.title = data.getString("title");
			
			items.add(item);
			ReditDBManager.instance().save(item);
		}
		
		return items;
	}

}
