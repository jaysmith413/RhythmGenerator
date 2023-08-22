package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RhythmGenerator {

    private final String WHOLE_NOTE = "Whole ";

    private final String DOTTED_HALF_NOTE = "DottedHalf ";
    private final String HALF_NOTE = "Half ";

    private final String DOTTED_QUARTER_NOTE = "DottedQuarter ";
    private final String QUARTER_NOTE = "Quarter ";
    private final String EIGHTH_NOTE = "Eighth ";

    private List<Integer> numericDurations = new ArrayList<>();

    private List<String> notesInExercise = new ArrayList<>();


    public void generateNumericDurations(int meter) {
        Random rand = new Random();
        int sum = 0;
        boolean keepGoing = true;

        //generate random int to represent duration in number of eighth notes, using meter * 2 + 1 to set
        //upper bound.
        int randomNumber = rand.nextInt((meter * 2) + 1);

        while (keepGoing) {

            //different notes have different preference rules related to the placement in the measure
            //see readme for more
            if (randomNumber == 1 || randomNumber == 2 || (randomNumber == 3 && sum % 2 == 0) || (randomNumber
                == 4 && sum % 2 == 0) || (randomNumber == 6 && sum != 1) || randomNumber == 8) {
                numericDurations.add(randomNumber);
                sum += randomNumber;
            }
            if (sum == meter * 2) {
                keepGoing = false;
            }
            //reset randomNumber subtracting sum from upper bound
            randomNumber = rand.nextInt((meter * 2 + 1) - sum);
        }
    }
    public void convertNumericDurationsToNoteStrings() {
        //set numeric durations to String duration note values that a human can read
        for (int eachInt : numericDurations) {
            if (eachInt == 1) {
                notesInExercise.add(EIGHTH_NOTE);
            } else if (eachInt == 2) {
                notesInExercise.add(QUARTER_NOTE);
            } else if (eachInt == 3){
                notesInExercise.add(DOTTED_QUARTER_NOTE);
            } else if (eachInt == 4) {
                notesInExercise.add(HALF_NOTE);
            } else if (eachInt == 6){
                notesInExercise.add(DOTTED_HALF_NOTE);
            } else if (eachInt == 8) {
              notesInExercise.add(WHOLE_NOTE);
            }
        }
    }
    public void printNotesToFile(int meter, int i) {
        //print notesInExercise to a file
        File rhythmsFile = new File("rhythms.txt");

        if (!rhythmsFile.exists()) {
            try {
                rhythmsFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(rhythmsFile, true))) {

            //print measure number and meter at the beginning of each line
            writer.print((i + 1) + ") " + meter + "/4 ");
            writer.flush();

            //print each note string for the measure
            for (String eachNote : notesInExercise) {
                writer.print(eachNote);
                writer.flush();
            }
            writer.println();
            writer.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
