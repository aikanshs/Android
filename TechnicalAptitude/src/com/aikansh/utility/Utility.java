package com.aikansh.utility;

import java.util.List;

import com.aikansh.quiz.Questions;


public class Utility {

	public static String getAnswers(List<com.aikansh.quiz.Questions> questions) {
		int question = 1;
		StringBuffer sb = new StringBuffer();
		
		for (Questions q : questions){
			sb.append("Q").append(question).append(") ").append(q.getQues()).append("? \n\n");
			sb.append("Answer : ").append(q.getAns()).append("\n\n");
			question ++;
		}
		
		return sb.toString();
	}
}
