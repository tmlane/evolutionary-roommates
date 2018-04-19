package com.company;

public class Population {
	Individual[] individuals;

	public Population(int individualCount) {
		individuals = new Individual[individualCount];
		for (int i = 0; i < individualCount; i++) {
			individuals[i] = new Individual(10);
			//System.out.println(individuals[i]);
			//System.out.println(individuals[i].calculateTotalFitness());
		}
		sortByFitness();
		for (int i = 0; i < individualCount; i++) {
			System.out.println(individuals[i]);
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



	//create method to assign linear ranking selection probability

}
