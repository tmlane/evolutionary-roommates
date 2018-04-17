package com.company;

public class Population {
  int SIZE = Main.size;
  Student[] students = new Student[SIZE];
  int[][] pairs = new int[SIZE/2][2];
  //SIZE/2 could cause problems, added extra variable just to be safe
  int pairSize = SIZE/2;
  double pair[] = new double[pairSize];


    //for initial population
    //initial population
  public Population()
  {
      for(int i = 0; i<SIZE;i++)
      {
          students[i] = new Student();
      }

    //making initial pairs going down list, pretty messing, you can probably do it much simpler
      for(int i = 0,j=1,k=0; i<pairSize;i++)
      {
          pairs[i][0] = k;
          pairs[i][1] = j;
          j += 2;
          k+=2;
      }
     //I think that we should have a pair class

//popDiff is total compatability difference
  double popDiff = 0;
      for(int i = 0; i< pairSize; i++)
  {
      pair[i] = calcFitness(students[pairs[i][0]],students[pairs[i][1]]);
      System.out.println("Compatability score of Pair " + (i+1) + " " + pair[i]);
      popDiff += pair[i];
  }
  popDiff = popDiff/pairSize;
  System.out.println(popDiff);
  }


  public double calcFitness(Student s1,Student s2)
  {
      //calculate total distance
    double sumDiff = 0;
    for(int i=0;i< s1.answers.length;i++)
      {
          double x = s1.answers[i] - s2.answers[i];
          double diff = Math.abs(x);
          diff = diff/5; //sloppy way of taking percentage, will add parameters when questions might have different wweight/mmore than 5 answers
          System.out.println("Q" + (i+1) + " Compatability: " +diff);
           sumDiff += diff;
      }
      sumDiff = sumDiff/4;

      return sumDiff;
  }

//mutation switches a few indexes in partners



}
