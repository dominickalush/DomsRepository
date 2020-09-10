package CandyGame;
import java.io.Console;

import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;

import java.util.Set;

import java.util.HashSet;
	

public class CandyGame {
	 private static int[] totalStudents;

	    private boolean printArray = false;

	    private Scanner userScanner;

	    public CandyGame() {

	        userScanner = new Scanner(System.in);

	    }

	    public int getStudentsNumber(int min, int max) {

	        int randomNumber;

	        System.out.println("Getting the number of Students");

	        System.out.println("Enter a number in between [" + 15 + ", " + 30 + "] inclusive:");

	        while (true) {

	            randomNumber = userScanner.nextInt();

	            if (randomNumber >= 15 && randomNumber <= 30) {

	                break;

	            } else {

	                System.out.println("Must be in [" + 15 + ", " + 30 + "] inclusive! Re-enter:");

	            }

	        }

	        totalStudents = new int[randomNumber];

	        return randomNumber;

	    }

	    public int getRangeOfCandy(int min, int max) {

	        int randomNumber;

	        boolean flag = true;

	        System.out.println("Getting the lower number of starting candy pieces:");

	        System.out.println("Enter an even integer in [" + 4 + ", " + 10 + "] inclusive:");

	        do {

	            randomNumber = userScanner.nextInt();

	            if (randomNumber <= 4 || randomNumber >= 10) {

	                System.out.println("Must be in [" + 4 + ", " + 10 + "] inclusive:");

	            } else if (randomNumber % 2 != 0) {

	                System.out.println("Must be Even and in [" + 4 + ", " + 10 + "] inclusive:");

	            } else {

	                flag = false;

	            }

	        } while (flag == true);

	        // myScanner.close();

	        return randomNumber;

	    }

	    public void handOutCandies(int min, int max) {

	        Random randomGenerator = new Random();

	        for (int i = 0; i < totalStudents.length; i++) {

	            totalStudents[i] = randomGenerator.nextInt(max) + min;

	            if (totalStudents[i] % 2 != 0) {

	                i--;

	                continue;

	            }

	        }

	    }

	    public void printSizeOfClass() {

	        for (int i = 0; i < totalStudents.length; i++) {

	            System.out.print(totalStudents[i] + " ");

	        }

	        System.out.println();

	        System.out.println("Class ready to begin game.");

	        System.out.println("Do you want to print the status after each move? (1 for yes, 0 for no) Enter an integer in [0, 1] inclusive:");

	        Scanner userScanner = new Scanner(System.in);

	        int temp;

	        temp = userScanner.nextInt();

	        if (temp == 0) {

	            printArray = false;

	        } else {

	            printArray = true;

	        }

	        // myScanner.close();

	    }

	    public void passCandy() {

	        while (!testGame()) {

	            int temp = totalStudents[totalStudents.length - 1] / 2;

	            totalStudents[totalStudents.length - 1] = temp;

	            for (int i = totalStudents.length - 2; i >= 0; i--) {

	                totalStudents[i + 1] += totalStudents[i] / 2;

	                totalStudents[i] = totalStudents[i] / 2;

	            }

	            totalStudents[0] += temp;

	            for (int i = 0; i < totalStudents.length; i++) {

	                if (totalStudents[i] % 2 != 0) {

	                    totalStudents[i] += 1;

	                }

	            }

	            if(printArray == true)

	            {

	                for (int i = 0; i < totalStudents.length; i++) {

	                    System.out.print(totalStudents[i] + " ");

	                }

	                System.out.println();

	            }

	        }

	    }

	    public boolean testGame() {

	        int temp  = totalStudents[0];

	        boolean flag = false;

	        for(int i = 0 ; i < totalStudents.length  ; i++)

	        {

	            if(temp != totalStudents[i])

	            {

	                flag = true;

	                break;

	            }

	        }

	        if(flag == false)

	        {

	            return true;

	        }

	        else

	        {

	            return false;

	        }

	    }
}
