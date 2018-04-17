package com.company;

public class Population {
	final int SIZE = Main.size;
	Student[] students = new Student[SIZE];

	//for initial population
	//initial population
	public Population()
	{
		for(int i = 0; i<SIZE;i++)
		{
			students[i] = new Student();
		}


		//popDiff is total compatability difference
		double popDiff = 0;
		for (int i = 0; i < SIZE; i+=2){
			double diff = calcFitness(students[i],students[i+1]);
			popDiff =+ diff;
			System.out.println("Compatability score of Pair " + (i+1) + " " + diff +"\n");
		}
		popDiff /= (SIZE/2);
		System.out.println(popDiff);
	}


	public double calcFitness(Student s1, Student s2)
	{
		//calculate total distance
		double sumDiff = 0;
		for(int i=0;i< s1.answers.length;i++)
		{
			double x = s1.answers[i] - s2.answers[i];
			double diff = Math.abs(x);
			diff = diff/5; //sloppy way of taking percentage, will add parameters when questions might have different weight/more than 5 answers
			//System.out.println(s1.answers[i] +"   "+  s2.answers[i] );
			//System.out.println("Q" + (i+1) + " Compatability: " + (1-diff));
			sumDiff += 1-diff;
		}
		sumDiff = sumDiff/4;

		return sumDiff;
	}

	//mutation switches a few indexes in partners



}
