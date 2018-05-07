package com.company;
import java.util.*;


import java.io.*;

public class Main {
	public static int size;// = 20*2; // number of students in an individual
	//public static final Student[] studentsRandom = createRandomStudents(size);
	public static  Student[] students;
	public static void main(String[] args) throws IOException {

		try {
			 students = createStudents();
		}
		catch (IOException error)
		{
			System.out.println(error);
		}

		int POPULATION_SIZE = 100;
		
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
		
		for (int i = 0; i < 10000000; i++){
			Population nextGen = new Population(POPULATION_SIZE);

			pop.sortFitnessNew();
			if (i%10000 == 0) System.out.println("Gen " + i + " " + pop);
			//pop.sortByFitness();
			//Arrays.sort(pop.individuals, Individual.fitnessAscending);

			for (int j = 0; j < POPULATION_SIZE; j++){
				nextGen.individuals[j] = pop.selectParent();



				int r = new Random().nextInt(size); // between 0 and 4.
				//if (i%10000 == 0) System.out.print(", " + r);

				for (int a = 0; a < r; a++){
					nextGen.individuals[j].mutate();
				}
			}
		}

		System.out.println("Gen last " + pop);
	}

	public static Student[] createRandomStudents(int size) {
		Student result[] = new Student[size];
		for (int i = 0; i < size; i++) {
			result[i] = new Student();
		}
		return result;
	}

	public static Student[] createStudents() throws IOException {
		List<Student> list = new ArrayList<Student>();


		BufferedReader CSVFile = new BufferedReader(new FileReader("src/com/company/data.csv"));
		String dataRow = CSVFile.readLine();
		int i = 0; //i = counter
		while(dataRow != null)
		{
			String[] dataArray = dataRow.split(",");
			//result[i] = new Student(dataArray);
			list.add(new Student(dataArray));
			i++;
			dataRow = CSVFile.readLine();
		}
		CSVFile.close();
		Main.size = i;
		if (Main.size % 2 > 0) throw new Error("please enter an even number of students");
		Student result[] = new Student[Main.size];
		for (int j = 0; j < Main.size; j++){
			result[j] = list.get(j);
		}

		return result;
	}
}
