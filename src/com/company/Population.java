package com.company;
import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;
import java.util.Random;

public class Population {
	Individual[] individuals;

	public Population(int individualCount) {
		individuals = new Individual[individualCount];
		for (int i = 0; i < individualCount; i++) {
			individuals[i] = new Individual(Main.size);
			//System.out.println(individuals[i]);
			//System.out.println(individuals[i].calculateTotalFitness());
		}
		//sortByFitness(); // We don't want to sort by fitness until after mutation
		//System.out.println(this);
	}
	
	public Individual selectParent(){
		double probability = Math.random();
		double fitnessSum = 0;
		/*
		for(int i = 0; i < individuals.length; i++) {
			System.out.println("indiv:" + i + "rankscore: " + linearRankScore(i, 4));
		}
		*/
		/*for(int i = 0; i < individuals.length; i++){

			fitnessSum += linearRankScore(i,2);
			//fitnessSum += exponentialRankScore(i);
			//fitnessSum += fitnessPropScore(i);

			if (fitnessSum >= probability){

				return individuals[i];
			}
		}*/
		int r = new Random().nextInt(5); // between 0 and 4.
		return individuals[r];

		//throw new UnsupportedOperationException ("Looks like something went wrong with selecting the parent");
	}
	
	public double fitnessPropScore(int individualIndex){
		return individuals[individualIndex].calculateTotalFitness()/this.calculateTotalFitnesss();
	}

	public double calculateTotalFitnesss() {
		double total = 0;
		for (int i = 0; i < individuals.length; i++) {
			total += individuals[i].calculateTotalFitness();
		}
		return total;
	}
	
	public String toString(){
		String answer = "";
		for (int i = 0; i < individuals.length; i++) {
		//	answer += individuals[i] + "\n";
		}
		answer += "Average Fitness: \t" + calculateAverageFitness();
		answer += "\t" + individuals[individuals.length-1].calculateTotalFitness();
		return answer;
	}

	public double calculateAverageFitness() {
		return calculateTotalFitnesss() / individuals.length;
	}

	public void sortFitnessNew(){
		Arrays.sort(individuals, Individual.fitnessAscending);
	}

	//create method to sort individuals by fitness
	public void sortByFitness()
	{
		boolean swapped = true;
		int j = 0;
		Individual tmp;
		while (swapped)
		{
			swapped = false;
			j++;
			for(int i = 0; i < individuals.length - j; i++)
			{
				if(individuals[i].calculateTotalFitness() < individuals[i+1].calculateTotalFitness())
				{
					tmp = individuals[i];
					individuals[i] = individuals[i+1];
					individuals[i+1] = tmp;
					swapped = true;
				}
			}
		}

	}

	public double linearRankScore(int individualIndex, double scale){
// If we don't already have a rank sorted array then make one

		double s = scale;
		double mew = individuals.length;
		int i = individualIndex;
		double PselLR = (2-s)/mew + (2*i*(s-1))/(mew*(mew-1));
		return PselLR;
	}


	public double exponentialRankScore(int individualIndex) {
// If we don't already have a rank sorted array then make oneif (this.sorted == null) {
		double exponentialTotalforC = 0;
// Calculates the sum of rankings for c in this function
		for (int i = 0; i < individuals.length; i++) {
			exponentialTotalforC += (1 - Math.pow(Math.E, i));
		}

		int i = individualIndex;
		double c = exponentialTotalforC;
		double score = (1 - Math.pow(Math.E, i)) / c;
		return score;
	}


	//create method to assign linear ranking selection probability

}
