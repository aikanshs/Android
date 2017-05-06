package com.aikansh.quizzerrr;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class Programming extends Activity {

	ImageButton ibtn1,ibtn2,ibtn3,ibtn4,ibtn5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_programming);
		ibtn1=(ImageButton) findViewById(R.id.ib1);
		ibtn2=(ImageButton) findViewById(R.id.ib2);
		ibtn3=(ImageButton) findViewById(R.id.ib3);
		ibtn4=(ImageButton) findViewById(R.id.ib4);
		ibtn5=(ImageButton) findViewById(R.id.ib5);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.programming, menu);
		return true;
	}

	public void testactv(View v){
		switch (v.getId()) {
		case R.id.ib1:
			Intent i1=new Intent(Programming.this,Test.class);
			startActivity(i1);
			break;
		case R.id.ib2:
			Intent i2=new Intent(Programming.this,Test.class);
			startActivity(i2);
			break;
		case R.id.ib3:
			Intent i3=new Intent(Programming.this,Test.class);
			startActivity(i3);
			break;
		case R.id.ib4:
			Intent i4=new Intent(Programming.this,Test.class);
			startActivity(i4);
			break;
		case R.id.ib5:
			Intent i5=new Intent(Programming.this,Test.class);
			startActivity(i5);
			break;

		default:
			break;
		}
	}
}
