package com.company;

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
		for(int i = 0; i < individuals.length; i++){
			fitnessSum += fitnessPropScore(i);
			if (fitnessSum >= probability){
				return individuals[i];
			}
		}
		throw new UnsupportedOperationException ("Looks like something went wrong with selecting the parent");
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
		answer += "Average Fitness: " + calculateAverageFitness();
		return answer;
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
