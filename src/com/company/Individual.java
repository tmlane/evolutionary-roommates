package com.company;

import java.util.Random;

/*
 * An Individual is the set of roommates parents.
 * It is an array with indexes that point to the students array in Main
 * 
 * 
 */

public class Individual {
	int[] pairings;
	private final Student[] students = Main.students;
	int size;

	public Individual(int roommateCount) {
		size = roommateCount;
		pairings = new int[size]; //note to Trevor: becuase using single arrays instead of 2d arrays
		for (int i = 0; i < size; i++) {
			pairings[i] = i;
		}
		for(int i =0;i<5;i++) {
			mutate();
		}
	}
	
	public double calculateTotalFitness(){
		/*
		 * Returns the average fitness of all roommate pairings
		 */
		double total = 0;
		for (int i =0; i < size; i += 2){
			Student roommate1 = students[pairings[i]];
			Student roommate2 = students[pairings[i+1]];
			double compatibility = calcRoommateCompatibility(roommate1, roommate2);
			total += compatibility;
			//System.out.println("Compatability score of Pair " + (i/2) + " " + compatibility + "\n");
		}
		// size / 2 is the number of pairings
		total = total / (size / 2);
		return total;
	}
	

	public double calcRoommateCompatibility(Student s1, Student s2) {
		double compatibility = 0;
		for (int i = 0; i < s1.answers.length; i++) {
			double x = s1.answers[i] - s2.answers[i];
			double diff = Math.abs(x);
			diff = diff / 5; // five is the current max of any question
			// sloppy way of taking percentage, will add
			// parameters when questions might have
			// different weight/more than 5 answers
			// System.out.println(s1.answers[i] +" "+ s2.answers[i] );
			// System.out.println("Q" + (i+1) + " Compatability: " + (1-diff));
			compatibility += 1 - diff;
		}
		double averageCompatibility = compatibility / s1.answers.length; // length the number of questions
		return averageCompatibility;
	}

	// mutation switches a two random people
	public void mutate(){
		int spot1 = randomBetween(0, size - 1);
		int spot2 = randomBetween(0, size - 1);

		int temp = pairings[spot1];
		pairings[spot1] = pairings[spot2];
		pairings[spot2] = temp;
	}
	
	// Generates a random number between min and max inclusive
	public int randomBetween(int min, int max){
		return new Random().nextInt(max) + min;
	}
	
	public String toString(){
		String result = "Total Fitness: " + String.format("%.2f", calculateTotalFitness());
		result += "\tPairs: ";
		for (int i = 0; i < size; i++){
			result += pairings[i] + " ";
		}
		return result;
	}

}
