package com.company;
import java.util.*;
import java.util.concurrent.*;
import java.io.*;

public class Main {
	public static Student[] students;

	/// Configurations/////////////////////////

	static int POPULATION_SIZE = 30;
	static String DATA_FILE = "src/com/company/realSampleData.csv";
	static double MUTATION_PROBABILITY = 1.0/1200.0*3;
	static int NUM_GENERATIONS = 500;
	static int PRINT_SEPARATION = 100; // Print every ? generations
	static int ELITISM_LEVEL = 1; // Select next gen from top ? individuals
	

	public static void main(String[] args) throws IOException {
		try {
			students = createStudents();
		} catch (IOException error) {
			System.out.println(error);
		}
		long startTime = System.nanoTime();  
    
		ExecutorService executor = Executors.newFixedThreadPool(4);

		for (int i = 0; i < 10; i++){
			GeneticAlgoRun a = new GeneticAlgoRun(POPULATION_SIZE, DATA_FILE, MUTATION_PROBABILITY, NUM_GENERATIONS, ELITISM_LEVEL);
			executor.submit(a);
		}

		// Need to figure out a way to figure out when all the executors are finished
		// https://www.programcreek.com/java-api-examples/?class=java.util.concurrent.Executors&method=newWorkStealingPool
		
		System.out.println("hi");

		long estimatedTime = System.nanoTime() - startTime;
		System.out.println(estimatedTime);
		

		
//		
//		/*Individual aa = new Individual(number_of_students);
//		System.out.println(aa);
//		aa.mutate();
//		System.out.println(aa);
//		System.out.println(aa.calcRoommateCompatibility(students[0], students[1]));
//		*/
//		Population pop = new Population(POPULATION_SIZE, true);
//		System.out.println(pop);
//		//pop.sortByFitness();
//		//System.out.println(pop.selectParent());
//		
//		for (int i = 0; i < NUM_GENERATIONS; i++){
//			Population nextGen = new Population(POPULATION_SIZE, false);
//			pop.sortFitnessNew();
//			if (i%PRINT_SEPARATION == 0) System.out.println("Gen " + i + " " + pop);
//			if(pop.individuals[pop.individuals.length-1].calculateTotalFitness() == 1.0){
//				System.out.println("Winner! " + i + " " + pop);
//				break;
//			}
//
//			/*boolean printDiffs = false;
//			if (i == 1000){
//				printDiffs = true;
//				for (int t = 0; t < pop.individuals.length; t++){
//					System.out.println(pop.individuals[t]);
//				}
//			}*/
//			for (int j = 0; j < POPULATION_SIZE; j++){
//				nextGen.individuals[j] = new Individual(pop.selectParent());
//
//				int r = new Random().nextInt(students.length); // between 0 and number of students - 1
//				//double before = nextGen.individuals[j].calculateTotalFitness();
//				for (int a = 0; a < r; a++){
//					nextGen.individuals[j].mutate();
//				}
//				//double after = nextGen.individuals[j].calculateTotalFitness();
//				
//				//if (printDiffs) System.out.println(before + " " + after);
//			}
//			pop = nextGen;
//		}
//
//		System.out.println("Gen last " + pop);
	}

	public static Student[] createStudents() throws IOException {
		int number_of_students = 0;
		List<Student> list = new ArrayList<>();

		BufferedReader CSVFile = new BufferedReader(new FileReader(DATA_FILE));
		String dataRow = CSVFile.readLine();

		while (dataRow != null) {
			number_of_students++;
			String[] dataArray = dataRow.split(",");
			list.add(new Student(dataArray));
			dataRow = CSVFile.readLine();
		}
		CSVFile.close();

		if (number_of_students % 2 > 0)
			throw new Error("please enter an even number of students");

		Student result[] = new Student[number_of_students];

		for (int j = 0; j < number_of_students; j++) {
			result[j] = list.get(j);
		}

		return result;
	}
}
