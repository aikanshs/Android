package com.aikansh.quizzerrr;

import java.util.List;

import com.aikansh.db.DBHelper;
import com.aikansh.quiz.Questions;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Test extends Activity implements android.view.View.OnClickListener{

	TextView timertv,ques;
	Chronometer cr;
	RadioButton rb1,rb2,rb3,rb4;
	Button next,previous,finish;
	long starttime=0,milli;
	int sec,min,score=0,qid=0;
	String table_name;
	Questions currentQ;
	RadioGroup grp;
	RadioButton ans;
	List<Questions> queslist;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);
		cr=(Chronometer) findViewById(R.id.timer);
		rb1=(RadioButton) findViewById(R.id.option1);
		rb2=(RadioButton) findViewById(R.id.option2);
		rb3=(RadioButton) findViewById(R.id.option3);
		rb4=(RadioButton) findViewById(R.id.option4);
		next=(Button) findViewById(R.id.next);
	   // previous=(Button) findViewById(R.id.previous);
	    ques=(TextView) findViewById(R.id.ques);
	    next.setOnClickListener(this);
	   // previous.setOnClickListener(this);
	    finish=(Button) findViewById(R.id.finish);
	    finish.setOnClickListener(this);
		DBHelper db1=new DBHelper(this);
		grp=(RadioGroup) findViewById(R.id.options);
		table_name=getIntent().getStringExtra("table_name");
		queslist=db1.getAllQuestions(table_name);
		currentQ=queslist.get(qid);
		
		setQuestionView();
	}

	private void setQuestionView()
	{
	ques.setText((qid+1)+". "+currentQ.getQues());
	rb1.setText(currentQ.getOpt1());
	rb2.setText(currentQ.getOpt2());
	rb3.setText(currentQ.getOpt3());
	rb4.setText(currentQ.getOpt4());
	cr.start();
	
	grp.clearCheck();
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 
		
		
		 ans=(RadioButton) findViewById(grp.getCheckedRadioButtonId());
		
		
		
		switch (v.getId()) {
		case R.id.next:
			
			if(qid<5){
				if(ans!=null){
				if(currentQ.getAns().equals(ans.getText()))
					 score++;}
				else{}
				
				qid++;
			}
			else
			Toast.makeText(this,"Click Finish to end the test",Toast.LENGTH_LONG).show();
			if(qid<5){
			currentQ=queslist.get(qid);
			setQuestionView();
			}
	       break;
		/*case R.id.previous:
			if(qid>=1){
				qid--;
				score--;
			currentQ=queslist.get(qid);
			setQuestionView(b);
			}
			break;*/
		case R.id.finish:
			    if(qid<4){
			    	if(ans!=null)
			    	if(currentQ.getAns().equals(ans.getText()))
					 score++;
			    	else{
			    		
			    	}
			    	}
			cr.stop();
			String s=(String) cr.getText();
			Intent i=new Intent(Test.this,Result.class);
			i.putExtra("final_score", score);
			i.putExtra("table_name",table_name);
			i.putExtra("time",s);
			startActivity(i);
			finish();
			break;
		}
	}	
}
