# Rhythm Generator

This application allows users to generate rhythms in 2/4, 3/4, and 4/4 time.

## Project Description

This command-line program asks the user for a time signature and number of measures to generate and uses that input to print auto-generated rhythms to a text file. The user may repeat the process and append as many rhythms as they wish. The RhythmGenerator class performs the calculations using certain constraints (see below) to print to the file. After random numbers are gererated and saved to an array list in the generateNumericDurations method, that list is used to convert random numbers to strings in the convertNumericDurationsToNoteStrings method. From there, the strings are printed to a txt file in the printNotesToFile method. The file can be used by the user to notate, perform, or integrate with another program. I used this rhythm generator to integrate with my "Rhythm Ruler" game.

### Constraints

Rhythm Generator is meant to generate simple rhythms appropriate for beginners in music notation. Therefore, certain constraints are placed on the construction of rhythms. The method, generateNumericDurations, uses a random number variable bound to either 8 beats (4/4 and 2/4) or 6 beats (3/4). This random number can at any point in the exercise be 1 (eighth note) or 2 (quarter note) as long as there are enough eighth-note durations remaining in the measure (8 total for 4/4, 4 total for 2/4, and 6 total for 3/4). As a result of this constraint, random number 8 can only be used in 4/4. Furthermore, random number 3 (dotted quarter note), random number 4 (half note), and random number 6 (dotted half note) can only occur on the beat (random number % 2 = 0) because otherwise the rhythm would be too advanced for a beginner. 

### Future Features

I plan to expand this rhythm generator to account for more advanced rhythms and time signatures. A user may choose a different difficulty level and generate rhythms that have fewer and/or different constraints.
