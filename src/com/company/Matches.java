package com.company;

public class Matches {
    int SIZE = Main.size;
    Population[] matches = new Population[SIZE];
    public Matches()
    {
        for(int i=0;i<SIZE;i++)
        {
            matches[i] = new Population();
        }
    }

}
