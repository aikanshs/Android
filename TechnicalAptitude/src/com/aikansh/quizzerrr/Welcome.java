package com.aikansh.quizzerrr;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends Activity {

	TextView tv;
	Button btn1,btn2;
	Animation slide;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		 btn1=(Button) findViewById(R.id.button1);
	        btn2=(Button) findViewById(R.id.button2);
	        tv=(TextView) findViewById(R.id.weltv);
	        slide=AnimationUtils.loadAnimation(getBaseContext(), R.anim.slidedown);
	        tv.startAnimation(slide);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}
	public void aptitude(View v){
        Intent i1 = new Intent(Welcome.this,Aptitude.class);
        startActivity(i1);
    }
    public void plang(View v){
        Intent i2 = new Intent(Welcome.this,Test.class);
        i2.putExtra("table_name","GeneralKnowl");
        startActivity(i2);
    	//Toast.makeText(this,"Questions Not Uploaded,Please try Later",Toast.LENGTH_LONG).show();
    }
    public void exit(View v){
    	Intent intent=new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
    }

}
