package com.aikansh.quizzerrr;

import java.util.List;

import com.aikansh.db.DBHelper;
import com.aikansh.quiz.Questions;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Answer extends Activity {

	int qid=0;
	Questions currentQ;
	List<Questions> queslist;
	TextView ans_tv1,ques_tv1;
	Button btn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_answer);
		ques_tv1=(TextView) findViewById(R.id.ques_ans);
		
		btn=(Button) findViewById(R.id.ans_btn);
		String table_name=getIntent().getStringExtra("table_name");
        DBHelper db=new DBHelper(this);
		queslist=db.getAllQuestions(table_name);
		String answers = com.aikansh.utility.Utility.getAnswers(queslist);
		ques_tv1.setText(answers);
		//setQuestionView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.answer, menu);
		return true;
	}
	private void setQuestionView()
	{
		currentQ=queslist.get(qid);
	ques_tv1.setText((qid+1)+". "+currentQ.getQues());
	ans_tv1.setText(currentQ.getAns());
	if(qid<4){
		qid++;
		setQuestionView();
	}
	
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		switch (keyCode)
		{
		case KeyEvent.KEYCODE_BACK :
			return true;
		}
		
		return super.onKeyDown(keyCode, event);
	}
	
	public void end(View v){
		Intent i=new Intent(Answer.this,Welcome.class);
		startActivity(i);
		finish();
	}

}
