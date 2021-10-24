import java.util.ArrayList;
import java.util.Scanner;
//Timer idea from:
//https://www.youtube.com/watch?v=qeJXCL6qRQA&list=PLnklCwfTPmxys0fMybXcqUVke7VDjLf7-&index=7


public class ExerciseIntervalTimer {

    public static void main(String[] args) throws InterruptedException{
        
        Scanner scnr = new Scanner(System.in);

        //Variables
        boolean continuing = true;
        boolean continuing2 = true;
        int count = 1;
        boolean end = false;

        //Lists
        ArrayList exerciseList = new ArrayList();
        ArrayList exerciseListSeconds = new ArrayList();
        String exerciseListOutput = "";

        System.out.println("Welcome to the Exercise Interval Timer!");
        
        //Loop of Entire Program
        while (!end) {

            //Startup Loop
            while (continuing) {
                System.out.println("\nTo add an exercise, enter \"a\"");
                System.out.println("To continue, enter \"z\"");
                System.out.println("To quit the program, enter \"q\"");

                String startInput = scnr.nextLine();

                //Add exercise
                if (startInput.equals("a")) { 

                    System.out.println("\nEnter the name of exercise " + count + ".");
                    System.out.println("To add a break, enter \"b\"");
                    System.out.println("To go back, enter \"q\"");

                    String nameInput = scnr.nextLine();

                    //Breaks
                    if (nameInput.equals("b")) {
                        exerciseList.add("Break");

                        System.out.println("\nHow many seconds?");
                        try {
                            int secondsInput = scnr.nextInt();
                            exerciseListSeconds.add(secondsInput);
                            count++;
                        }
                        catch (Exception e){
                            System.out.println("\nPlease enter an integer.");
                        }
                        
                        nameInput = scnr.nextLine();
                    }
                    
                    //Exercises
                    else if (!(nameInput.equals("q"))) {
                        exerciseList.add(nameInput);

                        System.out.println("\nHow many seconds?");

                        try {
                            int secondsInput = scnr.nextInt();
                            exerciseListSeconds.add(secondsInput);
                            count++;
                        }
                        catch (Exception e){
                            System.out.println("\nPlease enter an integer.");
                        }

                        nameInput = scnr.nextLine();
                    }
                }
            
                //Continue
                else if (startInput.equals("z")) { 
                    if (count < 2) {
                        System.out.println("\nEnter at least 1 exercise before continuing.");
                    }
                    else {
                        for (int c = 1; c < count; c++) {
                            exerciseListOutput = exerciseListOutput + c + ". " + exerciseList.get(c - 1) + " for " + exerciseListSeconds.get(c - 1) + " seconds.\n";
                        }
                        continuing = false;
                    }
                    
                }

                //End Program
                else if (startInput.equals("q")) { 
                    System.exit(0);
                }

                else {
                    System.out.println("\nInvalid response.");
                }    
                
            }

            //Exercise Editor
            while (continuing2) {

                System.out.println("\nHere is the list of exercises: ");
                System.out.println(exerciseListOutput);

                System.out.println("To start the exercise timer, enter \"s\"");
                System.out.println("To delete an exercise, enter \"d\"");
                String start = scnr.nextLine();

                //Start Timer
                if (start.equals("s")) {
                    count--;
                    continuing2 = false;
                }

                //Delete Exercise
                else if (start.equals("d")) {

                    if (count == 2) {
                        System.out.println("\nYou only have one exercise to delete.");
                    }

                    else {
                        System.out.println("\nWhich # exercise would you like to delete?");
                        try {
                            int exerciseDelete = scnr.nextInt();

                            exerciseList.remove(exerciseDelete - 1);
                            exerciseListSeconds.remove(exerciseDelete - 1);
                            count--;
                            exerciseListOutput = "";

                            for (int c = 1; c < count; c++) {
                                exerciseListOutput = exerciseListOutput + c + ". " + exerciseList.get(c - 1) + " for " + exerciseListSeconds.get(c - 1) + " seconds.\n";
                                
                            }
                            start = scnr.nextLine();
                        }
                        catch (Exception e) {
                            System.out.println("Invalid response.\n");
                        }
                        
                    }

                }
                
                else {
                    System.out.println("\nInvalid response.");
                }
            }
        
            //Countdown to start
            System.out.println("\nStarting in 3...");
            Thread.sleep(1000);
            System.out.println("2...");
            Thread.sleep(1000);
            System.out.println("1...");
            Thread.sleep(1000);
            System.out.println("Go!");
            Thread.sleep(1000);

            //Interval Timer
            for (int c = 0; c < count; c++) {
                System.out.println("\n" + exerciseList.get(c) + " for " + (int) (exerciseListSeconds.get(c)) + " seconds.");
                String breakChecker = (String) exerciseList.get(c);

                //Break Encouragement
                if (breakChecker.equals("Break")) {
                    int random = (int) (Math.random() * 4);
                    if (random == 0){
                        System.out.println("Don't give up!");
                    }
                    else if (random == 1){
                        System.out.println("Keep pushing!");
                    }
                    else if (random == 2){
                        System.out.println("Don't forget to breathe.");
                    }
                    else {
                        System.out.println("You're doing great!");
                    }
                }

                //Exercise Countdown
                for (int d = (int) (exerciseListSeconds.get(c)); d > 0; d--) {
                    System.out.println(d);
                    Thread.sleep(1000);
                }
            }

            System.out.println("\nWell done!");

            //Reset Variables
            continuing = true;
            continuing2 = true;
            exerciseListOutput = "";
            count++;
        }
    }
}
