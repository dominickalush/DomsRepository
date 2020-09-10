package CandyGame;
import java.io.Console;

import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;

import java.util.Set;

import java.util.HashSet;
	
/**
 * 
 * @author Dominic Kalush
 *
 */
public class CandyGame {
	 private static int[] totalStudents;

	    private boolean printArray = false;

	    private Scanner userScanner;

	    public CandyGame() {

	        userScanner = new Scanner(System.in);

	    }
/**
 * A method to get an integer from the user in the range from a lower limit to an upper limit
inclusive. This method should receive the two limits as parameters. The integer returned
from this method is the number of students playing the game.
 * @param min
 * @param max
 * @return
 */
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
/**
 * A method to get an even integer in the range from an even (i.e. not odd) lower limit to an
even upper limit inclusive. Again, the upper and lower limits should be passed to this

CSCI 235 Fall 2020

method. (The lower and upper limits passed to the method are the limits for the lower even
number which in this case are 4 and 10.)
 * @param min
 * @param max
 * @return
 */
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
/**
 * A method that will distribute a number of pieces of candy to an array of integers
(representing the students). The number given to each “student” must be random, even,
and between two specified even limits inclusive. You will need to pass the lower and upper
limits to this method.
 * @param min
 * @param max
 */
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
/**
 * A method to print an array of integers on one line in a field width of size 4.
 */
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
/**
 * A method that will pass the candy as described in the game. In essence, you are using an
array to represent a circle. Portions (specifically half) of each element in the array are getting
added to the element on the right, except for the last element, a portion of which gets
added to the first.
 */
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
/**
 * A method to test whether or not the game is over. It should return true if all values in the
array are the same, otherwise, it should return false.
 * @return
 */
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
