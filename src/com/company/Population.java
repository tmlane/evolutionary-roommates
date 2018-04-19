package com.company;

public class Population {
	Individual[] individuals;

	public Population(int individualCount) {
		individuals = new Individual[individualCount];
		for (int i = 0; i < individualCount; i++) {
			individuals[i] = new Individual(10);
			System.out.println(individuals[i]);
			//System.out.println(individuals[i].calculateTotalFitness());
		}
		System.out.println("Average Fitness: " + calculateTotalFitnesss());
	}

	public double calculateTotalFitnesss() {
		double total = 0;
		for (int i = 0; i < individuals.length; i++) {
			total += individuals[i].calculateTotalFitness();
		}
		return total;
	}

	public double calculateAverageFitness() {
		return calculateTotalFitnesss() / individuals.length;
	}

}
