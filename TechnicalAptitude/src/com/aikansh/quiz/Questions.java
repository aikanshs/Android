package com.aikansh.quiz;

public class Questions {

	private int id;
	private String ques="";
	private String opt1="";
	private String opt2="";
	private String opt3="";
	private String opt4="";
	private String ans="";
	
	public Questions(){
		
	}
	public Questions(String Ques,String Opt1,String Opt2,String Opt3,String Opt4,String Ans){
		ques=Ques;
		opt1=Opt1;
		opt2=Opt2;
		opt3=Opt3;
		opt4=Opt4;
		ans=Ans;
	}
	//getter mehods
	public int getId(){
		return id;
		
	}
	public String getQues(){
		return ques;
	}
	public String getOpt1(){
		return opt1;
	}
	public String getOpt2(){
		return opt2;
	}
	public String getOpt3(){
		return opt3;
	}
	public String getOpt4(){
		return opt4;
	}
	
	public String getAns(){
		return ans;
	}
	//setter methods
	public void setId(int Id){
	   id=Id;
		
	}
	public void setQues(String Ques){
		 ques=Ques;
	}
	public void setOpt1(String Opt1){
		opt1=Opt1;
	}
	public void setOpt2(String Opt2){
		opt2=Opt2;
	}
	public void setOpt3(String Opt3){
	    opt3=Opt3;
	}
	public void setOpt4(String Opt4){
	    opt4=Opt4;
	}
	public void setAns(String Ans){
		 ans=Ans;
	}
	
}
