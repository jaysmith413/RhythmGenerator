package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        String keepGoing = "Y";

        System.out.println("Welcome to the Rhythm Generator!\n");


        while(keepGoing.equalsIgnoreCase("Y")) {

            //get user input for time signature
            System.out.println("Select a time signature: \n2) 2/4\n3) 3/4\n4) 4/4");
            String timeSignature = userInput.nextLine();
            int meter = Integer.parseInt(timeSignature);

            //get user input for number of measures
            System.out.println("How many measures do you want to generate? ");
            String numberOfMeasures = userInput.nextLine();
            int numMeasures = Integer.parseInt(numberOfMeasures);

            //incrementer
            int i = 0;

            //generate measures
            while (i < numMeasures) {
                RhythmGenerator g = new RhythmGenerator();
                g.generateNumericDurations(meter);
                g.convertNumericDurationsToNoteStrings();
                g.printNotesToFile(meter, i);
                i++;
            }

            System.out.println("Do you want to generate more rhythms? (Y/N) ");
            keepGoing = userInput.nextLine();
        }
        System.out.println("Check rhythms.txt for your rhythms.");
        System.out.println("Thank you for using the Rhythm Generator!");
    }
}