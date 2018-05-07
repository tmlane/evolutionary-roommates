package com.company;

public class Student {

    // the Student class has three fields
    public String Name;
    public String ID;
    double[] answers;

    //public HashMap<String, Integer> Answers;

    // the Student class has
    // one constructor
    /*
     * public Student(String Name, String ID, double<String, Integer> Answers) {
     * this.Name = Name; this.ID = ID; this.Answers = Answers; }
     */

    public Student(String[] dataArray) {
        answers = new double[dataArray.length];
        this.Name = dataArray[0];
        this.ID = dataArray[1];

        for (int i = 0; i < dataArray.length; i++) {
            this.answers[i] = Integer.parseInt(dataArray[2]);
        }
    }
}
