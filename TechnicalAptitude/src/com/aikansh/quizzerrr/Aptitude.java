package com.aikansh.quizzerrr;

import java.util.List;

import com.aikansh.db.DBHelper;
import com.aikansh.quiz.Questions;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Aptitude extends Activity {

	Button Apti_btn1,Apti_btn2,Apti_btn3,Apti_btn4,Apti_btn5,Apti_btn6;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aptitude);
		Apti_btn1=(Button) findViewById(R.id.Apti_button1);
		Apti_btn2=(Button) findViewById(R.id.Apti_button2);
		//Apti_btn3=(Button) findViewById(R.id.Apti_button3);
		Apti_btn4=(Button) findViewById(R.id.Apti_button4);
		Apti_btn5=(Button) findViewById(R.id.Apti_button5);
		Apti_btn6=(Button) findViewById(R.id.Apti_button6);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aptitude, menu);
		return true;
	}
	public void testactv(View v){
		
		switch (v.getId()) {
		case R.id.Apti_button1:
			
			//Bundle b=new Bundle();
			//b.putString("table_name","Percentage");
			Intent i1=new Intent(Aptitude.this,Test.class);
			i1.putExtra("table_name", "Percentage");
			startActivity(i1);
			finish();
			break;
		case R.id.Apti_button2:
			Intent i2=new Intent(Aptitude.this,Test.class);
			i2.putExtra("table_name", "Numbers");
			startActivity(i2);
			finish();
			break;
       /* case R.id.Apti_button3:
        	Intent i3=new Intent(Aptitude.this,Test.class);
        	i3.putExtra("table_name", "SI_CI");
			startActivity(i3);
			break;*/
        case R.id.Apti_button4:
        	Intent i4=new Intent(Aptitude.this,Test.class);
        	i4.putExtra("table_name", "RatioProportion");
			startActivity(i4);
			finish();
			break;
       case R.id.Apti_button5:
    	   Intent i5=new Intent(Aptitude.this,Test.class);
    	   i5.putExtra("table_name", "Time_Speed_Work");
			startActivity(i5);
			finish();
			break;
       case R.id.Apti_button6:
    	   Intent i6=new Intent(Aptitude.this,Test.class);
    	   i6.putExtra("table_name", "Verbal_Reasoning");
			startActivity(i6);
			finish();
			break;

		default:
			break;
		}
	}

}
