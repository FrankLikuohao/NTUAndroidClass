package com.example.simpleui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

			

public class MessageActivity extends ListActivity {
	
	private ProgressDialog progress;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_message);

		String text = getIntent().getStringExtra("text");
		boolean isChecked = getIntent().getBooleanExtra("checkbox", false);
		
		progress = new ProgressDialog(this);
		 		progress.setTitle("Loading...");
		 		progress.show();
		 
		ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("TestObject");
		 		query.findInBackground(new FindCallback<ParseObject>() {
		 			@Override
		 			public void done(List<ParseObject> result, ParseException e) {
		 				// TODO Auto-generated method stub
		 				String[] data = new String[result.size()];
		 				for (int i = 0; i < result.size(); i++) {
		 					data[i] = result.get(i).getString("text");
		 					//�Y���^��null �h�|�t�η��� �]�L�k��� error: NullPointerException 
		 				}
		 				ArrayAdapter<String> adapter = new ArrayAdapter<String>(
		 						MessageActivity.this,
		 						android.R.layout.simple_list_item_1, data);
		 				setListAdapter(adapter);
		 			}
		 		});
		 
		 		progress.dismiss();
	}

	
	
	
	
	
}