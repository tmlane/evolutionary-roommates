package com.company;

public class Main {
	public static final int size = 10; // number of students in an individual 
	public static final Student[] students = createStudents(size);

	public static void main(String[] args) {
		int POPULATION_SIZE = 30;
		
		/*Individual aa = new Individual(size);
		System.out.println(aa);
		aa.mutate();
		System.out.println(aa);
		System.out.println(aa.calcRoommateCompatibility(students[0], students[1]));
		*/
		Population pop = new Population(POPULATION_SIZE);
		System.out.println(pop);
		//pop.sortByFitness();
		//System.out.println(pop.selectParent());
		
		for (int i = 0; i < 7; i++){
			Population nextGen = new Population(POPULATION_SIZE);
			for (int j = 0; j < POPULATION_SIZE; j++){
				nextGen.individuals[j] = pop.individuals[0];//pop.selectParent();
				nextGen.individuals[j].mutate();
			}
			System.out.println("Gen " + i + " " + nextGen);
		}

	}

	public static Student[] createStudents(int size) {
		Student result[] = new Student[size];
		for (int i = 0; i < size; i++) {
			result[i] = new Student();
		}
		return result;
	}
}
