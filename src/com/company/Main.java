package com.company;

public class Main {
	public static final int size = 10;
	public static final Student[] students = createStudents(size);

	public static void main(String[] args) {
		/*Individual i = new Individual(size);
		System.out.println(i);
		i.mutate();
		System.out.println(i);
		*/
		Population pop = new Population(5);

		// Matches matches = new Matches();
	}

	public static Student[] createStudents(int size) {
		Student result[] = new Student[size];
		for (int i = 0; i < size; i++) {
			result[i] = new Student();
		}
		return result;
	}
}
