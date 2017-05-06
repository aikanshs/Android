package com.aikansh.quizzerrr;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Result extends Activity implements OnClickListener{

	int score;
	String table_name,time;
	TextView result_tv1,result_tv2,result_tv3;
	Button res_btn1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		result_tv1=(TextView) findViewById(R.id.restv1);
		result_tv2=(TextView) findViewById(R.id.restv2);
		result_tv3=(TextView) findViewById(R.id.restv3);
		time=getIntent().getStringExtra("time");
	    score=getIntent().getIntExtra("final_score",0);
	    res_btn1=(Button) findViewById(R.id.resbtn1);
		String scr= "Your Score: "+score;
		String s="Time taken: "+time;
		result_tv3.setText(s);
		result_tv1.setText(scr);
		
		res_btn1.setOnClickListener(this);
		table_name=getIntent().getStringExtra("table_name");
		
		calc();
	}

	
	void calc(){
		switch(score){
		case 5: result_tv2.setText("Your Performance:  Excellent");
		break;
		case 4: result_tv2.setText("Your Performance:  Very Good");
		break;
		case 3: result_tv2.setText("Your Performance:  Good");
		break;
		case 2: result_tv2.setText("Your Performance:  Average");
		break;
		case 1: result_tv2.setText("Your Performance:  Poor");
		break;
		default: result_tv2.setText("Please take the test");
		break;
		}
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i=new Intent(Result.this,Answer.class);
		i.putExtra("table_name",table_name );
		startActivity(i);
		finish();
		
	}

}
