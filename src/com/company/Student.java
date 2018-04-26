package com.company;

import java.util.HashMap;
import java.util.Random;

public class Student {

	// the Student class has
	// three fields
	public String Name;
	public String ID;
	double[] answers = new double[4];

	public HashMap<String, Integer> Answers;

	// the Student class has
	// one constructor
	/*
	 * public Student(String Name, String ID, double<String, Integer> Answers) {
	 * this.Name = Name; this.ID = ID; this.Answers = Answers; }
	 */

	public Student() {
		/*
		 * If no parameters are given generate a random student!
		 */
		this.Name = "Tester Mctesty";
		this.ID = "0000000";
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		Random rand = new Random();
		hmap.put("Q1", rand.nextInt(5) + 1);
		hmap.put("Q2", rand.nextInt(5) + 1);
		hmap.put("Q3", rand.nextInt(5) + 1);
		hmap.put("Q4", rand.nextInt(5) + 1);
		this.Answers = hmap;
		this.answers[0] = hmap.get("Q1");
		this.answers[1] = hmap.get("Q2");
		this.answers[2] = hmap.get("Q3");
		this.answers[3] = hmap.get("Q4");
	}

	public Student(String[] dataArray)
	{
	this.Name = dataArray[0];
	this.ID = dataArray[1];
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
	hmap.put("Q1",Integer.parseInt(dataArray[2]));
	hmap.put("Q2",Integer.parseInt(dataArray[3]));
	hmap.put("Q3",Integer.parseInt(dataArray[4]));
	hmap.put("Q4",Integer.parseInt(dataArray[5]));
	this.Answers = hmap;
	this.answers[0] = hmap.get("Q1");
	this.answers[1] = hmap.get("Q2");
	this.answers[2] = hmap.get("Q3");
	this.answers[3] = hmap.get("Q4");


	}

	public void printInfo() {
		System.out.println("Name: " + this.Name + "ID: " + this.ID);
		System.out.println("Answers: " + this.Answers);

	}

}
