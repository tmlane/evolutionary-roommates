package com.company;
import java.util.*;
import java.io.*;

public class Main {
	public static int number_of_students = 0; // number of students in an individual. zero until read from file
	public static  Student[] students;

	/// Configurations/////////////////////////

	static int POPULATION_SIZE = 30;
	static String DATA_FILE = "src/com/company/realSampleData.csv";
	static double MUTATION_PROBABILITY = .5;
	static int NUM_GENERATIONS = 10000000;
	static int PRINT_SEPARATION = 100; // Print every ? generations

	public static void main(String[] args) throws IOException {
		try {
			students = createStudents();
		} catch (IOException error) {
			System.out.println(error);
		}
		
		/*Individual aa = new Individual(number_of_students);
		System.out.println(aa);
		aa.mutate();
		System.out.println(aa);
		System.out.println(aa.calcRoommateCompatibility(students[0], students[1]));
		*/
		Population pop = new Population(POPULATION_SIZE, true);
		System.out.println(pop);
		//pop.sortByFitness();
		//System.out.println(pop.selectParent());
		
		for (int i = 0; i < NUM_GENERATIONS; i++){
			Population nextGen = new Population(POPULATION_SIZE, false);

			pop.sortFitnessNew();
			if (i%PRINT_SEPARATION == 0) System.out.println("Gen " + i + " " + pop);

			boolean printDiffs = false;
			if (i == 1000){
				printDiffs = true;
				for (int t = 0; t < pop.individuals.length; t++){
					System.out.println(pop.individuals[t]);
				}
			}
			for (int j = 0; j < POPULATION_SIZE; j++){
				nextGen.individuals[j] = pop.selectParent();

				int r = new Random().nextInt(number_of_students); // between 0 and number of students - 1
				double before = nextGen.individuals[j].calculateTotalFitness();
				for (int a = 0; a < r; a++){
					nextGen.individuals[j].mutate();
				}
				double after = nextGen.individuals[j].calculateTotalFitness();
				if (printDiffs) System.out.println(before + " " + after);
			}
		}

		System.out.println("Gen last " + pop);
	}

	public static Student[] createStudents() throws IOException {
		List<Student> list = new ArrayList<>();

		BufferedReader CSVFile = new BufferedReader(new FileReader(DATA_FILE));
		String dataRow = CSVFile.readLine();

		while(dataRow != null)
		{
			Main.number_of_students++;
			String[] dataArray = dataRow.split(",");
			list.add(new Student(dataArray));
			dataRow = CSVFile.readLine();
		}
		CSVFile.close();

		if (Main.number_of_students % 2 > 0) throw new Error("please enter an even number of students");

		Student result[] = new Student[Main.number_of_students];

		for (int j = 0; j < Main.number_of_students; j++){
			result[j] = list.get(j);
		}

		return result;
	}
}
