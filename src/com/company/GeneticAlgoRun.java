package com.company;

import java.util.Random;

public class GeneticAlgoRun implements Runnable{
	String DATA_FILE;
	double MUTATION_PROBABILITY;
	int POPULATION_SIZE, NUM_GENERATIONS, PRINT_SEPARATION, ELITISM_LEVEL;
	
	public GeneticAlgoRun(int POPULATION_SIZE, String DATA_FILE, double MUTATION_PROBABILITY, 
			int NUM_GENERATIONS, int ELITISM_LEVEL){
		this.POPULATION_SIZE = POPULATION_SIZE;
		this.DATA_FILE = DATA_FILE;
		this.MUTATION_PROBABILITY = MUTATION_PROBABILITY;
		this.NUM_GENERATIONS = NUM_GENERATIONS;
		this.ELITISM_LEVEL = ELITISM_LEVEL;
		
		
	}

	public void runGenerations() {
		// Create the first population
		Population pop = new Population(POPULATION_SIZE, true);

		for (int i = 0; i < NUM_GENERATIONS; i++) {
			pop.sortFitnessNew();

			if (i%1 == 0) System.out.println(i + "\t" + pop);
			if (pop.individuals[pop.individuals.length - 1].calculateTotalFitness() == 1.0) {
				System.out.println("Winner! " + i + " " + pop);
				break;
			}
			pop = createNextGen(pop);
		}

		//System.out.println("Gen last " + pop);

	}

	private void mutatexTimes(Individual indiv, int times){
		for (int a = 0; a < times; a++) indiv.mutate();
	}
	
	private Population createNextGen(Population oldGeneration){
		Population nextGen = new Population(POPULATION_SIZE, false);
		for (int j = 0; j < POPULATION_SIZE; j++){
			nextGen.individuals[j] = new Individual(oldGeneration.selectParent());
			int r = new Random().nextInt(Main.students.length); // between 0 and number of students - 1
			mutatexTimes(nextGen.individuals[j], r);
		}
		return nextGen;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		runGenerations();
	}
	

}
