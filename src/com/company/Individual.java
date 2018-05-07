package com.company;

import java.util.Random;
import java.util.Comparator;

/*
 * An Individual is the set of roommates parents.
 * It is an array with indexes that point to the students array in Main
 * 
 * 
 */

public class Individual {
	int[] pairings;
	private final Student[] students = Main.students;
	private int size;

	public Individual(int roommateCount) {
		size = roommateCount;
		pairings = new int[size];

		for (int i = 0; i < size; i++) {
			pairings[i] = i;
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
		// number_of_students / 2 is the number of pairings
		total = total / (size / 2);
		return total;
	}
	

	public double calcRoommateCompatibility(Student s1, Student s2) {
		double compatibility = 0;
		int numQuestions = s1.answers.length;
		for (int i = 0; i < numQuestions; i++) {
			double x = s1.answers[i] - s2.answers[i];
			double diff = Math.abs(x);

			diff = diff / 100; // four is the max difference in any question
			// sloppy way of taking percentage, will add
			// parameters when questions might have
			// different weight/more than 5 answers
			// System.out.println(s1.answers[i] +" "+ s2.answers[i] );
			// System.out.println("Q" + (i+1) + " Compatability: " + (1-diff));
			compatibility += 1 - diff;
		}
		double averageCompatibility = compatibility / numQuestions; // length the number of questions
		return averageCompatibility;
	}

	// mutation switches a two random people
	public void mutate(){
		if (Math.random() > 1-Main.MUTATION_PROBABILITY){
			int spot1 = randomBetween(0, size - 1);
			int spot2 = randomBetween(0, size - 1);
	
			int temp = pairings[spot1];
			pairings[spot1] = pairings[spot2];
			pairings[spot2] = temp;
		}
	}
	
	// Generates a random number between min and max inclusive
	public int randomBetween(int min, int max){
		return new Random().nextInt(max) + min;
	}
	
	public String toString(){
		String result = "Total Fitness: " + String.format("%.2f", calculateTotalFitness());
		/*result += "\tPairs: ";
		for (int i = 0; i < size; i++){
			result += pairings[i] + " ";
		}*/
		return result;
	}

	public static Comparator<Individual> fitnessAscending = new Comparator<Individual>(){
		public int compare(Individual s1, Individual s2){
			return Double.compare(s1.calculateTotalFitness(), s2.calculateTotalFitness());
		}
	};

}
