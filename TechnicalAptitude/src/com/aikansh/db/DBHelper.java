package com.aikansh.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.aikansh.quiz.Questions;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {

	private static final String Database_Name="Quiz";
	private static final String table1="Percentage";
	private static final String table2="Numbers";
	// String table3="gk";
	private static final String table4="RatioProportion";
	private static final String table5="Time_Speed_Work";
	private static final String table6="Verbal_Reasoning";
	private static final String table7="GeneralKnowl";
	private static final String key_id="id";
	private static final String key_ques="ques";
	private static final String key_ans="answer";
	private static final String key_opt1="opt1";
	private static final String key_opt2="opt2";
	private static final String key_opt3="opt3";
	private static final String key_opt4="opt4";
	private SQLiteDatabase dbase1;
	private static final int version=2;
	private static final String sql1="create table "+table1+
			"(" + key_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			key_ques + " text, "+key_opt1+" text, "+key_opt2+" text, "+
			key_opt3+" text, "+key_opt4+" text, "+key_ans+" text );";
	private static final String sql2="create table "+table2+
			"(" + key_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			key_ques + " text, "+key_opt1+" text, "+key_opt2+" text, "+
			key_opt3+" text, "+key_opt4+" text, "+key_ans+" text );";
	 /*String sql3="create table "+table3+
			"("+key_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
			key_ques+" text, "+key_opt1+" text, "+key_opt2+" text, "+
			key_opt3+" text, "+key_opt4+" text, "+key_ans+" text );";*/
	private static final String sql4="create table "+table4+
			"("+key_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
			key_ques+" text, "+key_opt1+" text, "+key_opt2+" text, "+
			key_opt3+" text, "+key_opt4+" text, "+key_ans+" text );";
	private static final String sql5="create table "+table5+
			"("+key_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
			key_ques+" text, "+key_opt1+" text, "+key_opt2+" text, "+
			key_opt3+" text, "+key_opt4+" text, "+key_ans+" text );";
	private static final String sql6="create table "+table6+
			"("+key_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
			key_ques+" text, "+key_opt1+" text, "+key_opt2+" text, "+
			key_opt3+" text, "+key_opt4+" text, "+key_ans+" text );";
	private static final String sql7="create table "+table7+
			"("+key_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
			key_ques+" text, "+key_opt1+" text, "+key_opt2+" text, "+
			key_opt3+" text, "+key_opt4+" text, "+key_ans+" text );";
	
	public DBHelper(Context context) {
		super(context, Database_Name,null, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		dbase1=arg0;
		
		arg0.execSQL(sql1);
		arg0.execSQL(sql2);
		arg0.execSQL(sql7);
		arg0.execSQL(sql4);
		arg0.execSQL(sql5);
		arg0.execSQL(sql6);
		
		addquestions();
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		arg0.execSQL("DROP TABLE IF EXISTS Percentage");
		arg0.execSQL("DROP TABLE IF EXISTS Numbers");
		arg0.execSQL("DROP TABLE IF EXISTS RatioProportion");
		arg0.execSQL("DROP TABLE IF EXISTS Time_Speed_Work");
		arg0.execSQL("DROP TABLE IF EXISTS Verbal_Reasoning");
		arg0.execSQL("DROP TABLE IF EXISTS GeneralKnowl");
		onCreate(arg0);
	}
	public void addquestions(){
		Questions q1=new Questions("The Santabil shop offers that get a T-shirt free on the " +
				"purchase of every three T-shirts. But they mark-up the price of the T-shirts " +
				"by 60%. If a customer buys three T-shirts, then what is the profit or loss " +
				"percentage for the store?","20%", "44%", "25%", "30%","20%");
				this.addquestions(q1,table1);
		/*Questions q2=new Questions("In a stockpile of products produced by three machines M1, M2 and M3, 40% and 30% were manufactured by M1 and M2 and the rest by"+
 " M3. 3% of the products of M1 are defective, 1% of the products of M2 is defective, while 95% of the products of M3 are not defective."+ 
 "What is the percentage of defective products in the stockpile?","30%","3%","32.7%","9%","3%");
				this.addquestions(q2,table1);	
		Questions q3=new Questions("If the difference between the CI and the SI at the end of 2 " +
				"years is Rs. 100, what is the principal? Rate is 5% per annum in both the cases. " +
				"(Assume same principal for both the cases.","Rs. 50,000","Rs. 40,000","Rs. 10,000",
				"None of these", "Rs. 40,000");*/
		//this.addquestions(q3,table1);
		Questions q4=new Questions("If the difference of CI and SI on a certain sum of money for 3 years at 5% per annum is Rs. 122. Find the sum.", "Rs. 16,000","Rs. 16,500","Rs. 16,383","Rs. 16,400", "Rs. 16,000");
		this.addquestions(q4,table1);
		/*Questions q5=new Questions("The price of petrol is increased by 25%. By what percent " +
				"should a car owner reduce the consumption of petrol so that his expenditure on " +
				"petrol remains constant?", "25","30","50","20","20");
		this.addquestions(q5,table1);*/
		Questions q6=new Questions("Answer each question using the following instructions:" +
		"\n "+""+"Mark(1) if the question can be answered by using the statement A alone but not by using " +
		"the statement B alone. "+"\n"+"Mark(2) if the question can be answered by using the " +
		"statement B alone but not by using the statement A alone."+"\n"+
"Mark (3) if the question can be answered by using either of the statements alone."+"\n"+
"Mark (4) if the question can be answered by using both the statements together but not by either of the statements alone."+"\n"+
"Thirty per cent of the employees of a call centre are males. Ten per cent of the female employees have an engineering background. What is"+ 
"the percentage of male employees with engineering background?"+"\n"+

"A.	Twenty five per cent of the employees have engineering background."+"\n"+
"B.	Number of male employees having an engineering background is 20% more than the number of female employees having an engineering background.", "(1)", "(2)","(3)","(4)","(3)");
		this.addquestions(q6,table1);
		/*Questions q7=new Questions("Mr. Upendra gives an amount of Rs 8,000 each to Gaurav and Atul. If the amount given to Gaurav becomes Rs.9,331.20 in two years and the"+ 
"amount given to Atul becomes Rs.10,077.70 in three years, then what is the rate of interest per annum (Assume interest was compounded annually)?", "7%", "8%","7.5%","9%","8%");
		this.addquestions(q7,table1);*/
		Questions q8=new Questions("If  A=(X/2%)of Y/4 and B=(Y/2%)of X/4 then which of the following is true?", " A is smaller than B", "A is greater than B","If X is greater than Y, then A is greater than B.","None of these","None of these");
		this.addquestions(q8,table1);
		Questions q9=new Questions("Answer each question using the following instructions:"+"\n"+
"Mark (1) if the question can be answered by using the statement A alone but not by using the statement B alone."+"\n"+
"Mark (2) if the question can be answered by using the statement B alone but not by using the statement A alone."+"\n"+
"Mark (3) if the question can be answered by using either of the statements alone."+"\n"+
"Mark (4) if the question can be answered by using both the statements together but not by either of the statements alone."+"\n"+
"In a particular school, sixty students were athletes. Ten among them were also among the top academic performers. How many top academic performers were in the school?"+"\n"+
"A.	Sixty per cent of the top academic performers were not athletes."+"\n"+
"B.	All the top academic performers were not necessarily athletes.", "(1)", "(2)","(3)","(4)","(1)");
		this.addquestions(q9,table1);
		/*Questions q10=new Questions("A book was sold for a certain sum and there was a loss of 20%. Had it been sold for Rs. 3 more, then there would have been a profit of 30%."+
 "If it was sold for Rs. 6.60, then the profit/loss percentage would have been", "Profit 10%", "Profit 8.33%","Loss 8.33%","Loss 10%","Profit 10%");
		this.addquestions(q10,table1);
		Questions q11=new Questions("The graph of the cost of providing school dinners versus the number of children is a straight line not passing through the origin and"+
 "increases as the number of pupils increases. For 200 students the cost is Rs. 9 each, for 300 students the cost is Rs. 8 each. The cost per"+ 
 "student can never be below.", "Rs. 8", "Rs. 7","Rs. 6","Rs. 10","Rs. 6");
		this.addquestions(q11,table1);*/
		
		Questions q12=new Questions("The sum of four numbers is 253. The ratio of the first to the second is 2 : 3. The ratio of the second to the third is 5 : 6. The"+ 
"ratio of the third to the fourth is 8 : 9. What is the average of the second and the third number?","70","84","60","None of these","None of these");
		this.addquestions(q12,table4);
		Questions q13=new Questions("A sum of money is divided among A, B and C such that their shares are in the proportion of. If the share of A is 2,040, then what"+ 
"is the total sum of money?", "5,520","7,820","9,200", "6,900","7,820");
		this.addquestions(q13,table4);
		Questions q14=new Questions("Two jars contain milk and water in the ratio 5 : 4 and 2 : 1 respectively. What volume should be taken out from the first jar if volumes"+
 "have to be taken out from both jars so as to fill up a third 30 L jar with milk to water in the ratio 1 : 1?", "7.5 L","15 L","15.5 L","Impossible situation ","Impossible situation ");
		this.addquestions(q14,table4);
		Questions q15=new Questions("Two dogs cost as much as 5 cats, 6 cats cost as much as 10 goats and 8 goats cost as much as 2 horses. If the cost of a horse is Rs 48,"+
 "then what is the cost of 5 dogs?","Rs. 200","Rs. 250","Rs. 225","Rs. 300","Rs. 250");
		this.addquestions(q15,table4);
		Questions q16=new Questions("Megha went to a mall and spent 60% of total money she had, on clothes and 60% of remaining on food. She is left with Rs. 256."+ 
"Find how much money did Megha carry to the mall?","Rs. 1,800","Rs. 1,540","Rs. 1,600","Rs. 1,440","Rs. 1,600");
		this.addquestions(q16,table4);
		Questions q17=new Questions("Taps A and B can fill a tank in 12 min and 15 min respectively. If both are opened and A is closed after 3 min, how long will it take"+ 
"for B to fill the tank hereafter?","7 min 45 s","7 min 15 s","8 min 5 s","8 min 15 s","8 min 15 s");
		this.addquestions(q17,table5);
		Questions q18=new Questions("Ram and Shyam run a race between points A and B, 5 km apart, Ram starts at 9 a.m. from A at a speed of 5 km/hr, reaches B, and"+ 
"returns to A at the same speed, Shyam starts at 9:45 a.m. from A at a speed of 10 km/hr, reaches B and comes back to A at the same speed."+"\n"+"At what time does Shyam over take Ram?","10:20 a.m.","10:30 a.m.","10:40 a.m.","10:50 a.m.","10:30 a.m.");
		this.addquestions(q18,table5);
		Questions q19=new Questions("A train travels at a uniform speed of 15 km/hr. If the speed had been 10 km/hr more, it would have taken 8 hours less to cover the distance"+
 "between stations A and B. What is the distance (in km) between A and B?","100","300"," 250","200","300");
		this.addquestions(q19,table5);
		Questions q20=new Questions("Anu climbs uphill at the rate of 4 km/hr and travels downhill at the rate of 8 km/hr. Find her average speed.","5.5 km/hr","6 km/hr","5.3 km/hr","6.5 km/hr","5.3 km/hr");
		this.addquestions(q20,table5);
		Questions q21=new Questions("If a person can run along the perimeter of an equilateral triangle in 63 minutes, then in how many minutes can he run along the circle"+
 "which circumscribes the mentioned triangle?","62.2 minutes"," minutes","38.1 minutes ","46.66 minutes","76.2 minutes");
		this.addquestions(q21,table5);
		Questions q22=new Questions("How many integral pairs (x, y) exist such that x 2 + y 2 - 2x - 4y + 5 = 0?","Two","Three","Four","One","One");
		this.addquestions(q22,table2);
		Questions q23=new Questions("If a, b, c and d are all different natural numbers from 10 to 15, then what is the smallest value of (a + b)(c + d)?","515","529","521","525","525");
		this.addquestions(q23,table2);
		Questions q24=new Questions("Let x, y and z be distinct integers. x and y are odd and positive, and z is even and positive. Which one of the following statements"+
" cannot be true?","y(x - z)2 is even"," y2(x - z) is odd","y(x - z) is odd","z(x - y)2 is even"," y2(x - z) is odd");
		this.addquestions(q24,table2);
		Questions q25=new Questions("Answer the questions on the basis of the information given below."+
"The seven basic symbols in a certain numeral system and their respective values are as follows:"+"\n"+
"I = 1, V = 5, X = 10, L = 50, C = 100, D = 500 and M = 1000"+
"In general, the symbols in the numeral system are read from left to right, starting with the symbol representing the largest value; the same symbol cannot occur continuously more than three times; the value of " +
"the numeral is the sum of the values of the symbols. For example, XXVII = 10 + 10 + 5 + 1 + 1 = 27. An exception to the left-to-right reading occurs when a symbol is followed immediately by a symbol of greater value; then the smaller value " +
"is subtracted from the larger. For example, XLVI = (50 ' 10) + 5 + 1 = 46."+"\n\n"+
"The value of the numeral MCMXCIX is","1999","1899","1989","1889","1999");
		this.addquestions(q25,table2);
		Questions q26=new Questions("The cost of 1 dozen apple and 1 kg orange is Rs.20, while the cost of 1 dozen orange and 1 kg apple is Rs.16. Also, the cost of an"+
 "apple and an orange is Rs.3. If 1 kg of apple and 1 kg of orange have m and n (m and n are integers) of the same kind of fruits respectively,"+
" then the minimum value of ‘m’ will be","6","7","8","Data inconsistent","Data inconsistent");
		this.addquestions(q26,table2);
		Questions q27=new Questions("Direction for Question : The following question has a paragraph from which the last sentence has been deleted. From the given options,"+ 
"choose the one that completes the paragraph in the most appropriate way."+"\n\n"+
"In terms of productivity, employees fall somewhere on a bell-shaped curve. At the bottom of the curve are the loafers and goof-offs."+ 
"In the middle is the silent majority that does just enough to get by. At the top are the relative few who are motivated to achieve. When you"+ 
"understand the dynamics of any such group, you understand that a modest amount of hard work will put you beyond both the terminally slothful"+ 
"and the lump-along middle crowd. Just by being modestly ambitious, you will rise to the top third of almost any organization. __________________","But getting up the last few rungs of that ladder will be tough," +
		" because the few you are competing against are competing hard."," Chances are, they are as smart and talented as you, with the same (or more) basic " +
				"resources.","They may even have better contacts, but there is one thing they don?t have more of, and that " +
						"is time.","If you can use your time more effectively than they use theirs, you will move ahead of them. ","But getting up the last few rungs of that ladder will be tough, because the few you are competing against are competing hard.");
		this.addquestions(q27,table6);
		
		Questions q28=new Questions("Direction for Question: The following question has a paragraph with one italicized word that does not make sense. Choose the most appropriate"+
 "replacement for that word from the options given below the " +
 "paragraph."+"\n\n"+"Snakes have always been associated negatively in the minds of most people. Commonly believed to be poisonous and dangerous,"+ 
"they are also viewed as a slimy, ugly and hostile species. I have rarely seen anyone look at a snake in the wild with delight and calm. "+
"Most of us, with killifb notions, have despised this beautiful creature without understanding it.","preconceived","disparate","common","convoluted","preconceived");
		this.addquestions(q28,table6);
		Questions q29=new Questions("Direction for question: In the following sentences, the main statement is followed by four sentences each. Select a pair of sentences"+ 
"that relate logically to the given statement."+"\n\n"+"Either Sam is ill, or he is drunk."+"\n"+ 
"A. Sam is ill.	"+"\n"+"B. Sam is not ill."+"\n"+"C. Sam is drunk."+"\n"+
"D. Sam is not drunk.","AB","DA","AC","CD","DA");
		this.addquestions(q29,table6);
		Questions q30=new Questions("The existence of mandatory requirements for teaching such as a Ed degree is not responsible for the acute shortage of teachers in schools."+ 
"A major factor responsible for this is that the pay scale of teachers is very low and this acts as a deterrent for those considering the"+
 "teaching profession as a career. Other options prove to be much more " +
 "lucrative."+"\n"+"Which of the following, if true, strengthens the argument in the passage?","Many teachers, already employed, would not have been employed by schools if the " +
 		"current legal requirements were considered.","Most of those entering the teaching profession are highly educated in comparison to standards " +
 "in the past.","A recent survey has concluded that many teachers are leaving the profession because of the low " +
 "pay scales.","Some teachers feel that compulsory qualifications like the Ed are responsible for shortage of teaching " +
 "staff.","A recent survey has concluded that many teachers are leaving the profession because of the low pay scales.");
		this.addquestions(q30,table6);
		Questions q31=new Questions("Each question has a set of four sequentially ordered statements. "+
"Each statement can be classified as one of the following:"+"\n"+
"- Facts, which deal with pieces of information that one has heard, seen or read, and which are open to discovery or verification (the answer option indicates such a statement with an 'F')."+"\n"+
"- Inferences, which are conclusions drawn about the unknown, on the basis of the known (the answer option indicates such a statement with an 'I')."+"\n"+
"- Judgements, which are opinions that imply approval or disapproval of persons, objects, situations and occurrences in the past, the present or the future (the answer option indicates such a statement " +
"with a 'J')"+"\n\n"+"Select the answer option that best describes the set of four " +
"statements."+"\n\n"+"1.Poachers have killed three Asiatic lions in the rare animal?s only natural habitat."+"\n"+ 
"2.	The bones are used for traditional Chinese medicine and the claws are worn by some men as pendants in the hope of increasing their virility."+"\n"+ 
"3.	The number of lions in Gir had risen to 359 in 2005 from 327 in 2001, a government census showed. "+"\n"+
"4.	As seen from incidents over the past few years, the animals may face other dangers besides poaching.","JFIJ","FFFI","JIIJ","IFFJ","FFFI");
		this.addquestions(q31,table6);
		Questions q32=new Questions("The Muziris Heritage Project is the tourism project of which state" +
				" of India?", "Tamil Nadu","Karnataka","Odisha","Kerala","Kerala");
		this.addquestions(q32,table7);
		Questions q33=new Questions("Who has been appointed as the new chairman of the International Association of Athletics " +
				"Federations (IAAF)? ","Justin Gatlin","Rozle Prezelj","Lamine Diack","Sebastian Coe","Rozle Prezelj");
		this.addquestions(q33,table7);
		
		Questions q34=new Questions("WHICH BODY OF UNO GIVES ADVISORY OPINION ON LEGAL MATTERS TO THE BODIES AND " +
				"SPECIAL AGENCIES OF THE UNO?","The Security Council","International Court of Justice","Trusteeship Council","Secretariat","International Court of Justice");
		this.addquestions(q34,table7);
		Questions q35=new Questions("WHICH OF THE FOLLOWING AGENCIES RELATED TO THE UNITED NATION WAS IN EXISTENCE BEFORE THE SECOND " +
				"WORLD WAR?","Food and Agricultural Organisation","International Monetary Fund","World Health Organisation","International Labour Organisation","International Labour Organisation");
		this.addquestions(q35,table7);
		Questions q36=new Questions("WHICH MISSILE IS DESIGNED TO DEFEND LARGE INSTALLATION LIKE OIL-FIELDS ETC. AGAINST ENEMY AIR " +
				"ATTACKS?","Akash","Nag","Agni"," Prithvi","Akash");
		this.addquestions(q36,table7);
	}
	public void addquestions(Questions quest,String table_name){
		ContentValues con=new ContentValues();
		con.put(key_ques, quest.getQues());
		con.put(key_opt1, quest.getOpt1());
		con.put(key_opt2, quest.getOpt2());
		con.put(key_opt3, quest.getOpt3());
		con.put(key_opt4, quest.getOpt4());
		con.put(key_ans, quest.getAns());
		dbase1.insert(table_name, null, con);
	}
	public List<Questions> getAllQuestions(String table_name) {
		List<Questions> quesList = new ArrayList<Questions>();
		// Select All Query
		String selectQuery = "SELECT * FROM " +table_name;
		dbase1=this.getReadableDatabase();
		Cursor cursor = dbase1.rawQuery(selectQuery, null);
		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
		do {
		Questions quest = new Questions();
		quest.setId(cursor.getInt(0));
		quest.setQues(cursor.getString(1));
		quest.setAns(cursor.getString(6));
		quest.setOpt1(cursor.getString(2));
		quest.setOpt2(cursor.getString(3));
		quest.setOpt3(cursor.getString(4));
		quest.setOpt4(cursor.getString(5));
		Collections.shuffle(quesList);
		quesList.add(quest);
		} while (cursor.moveToNext());
		}
		// return quest list
		return quesList;
		}

}
