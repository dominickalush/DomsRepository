/**
 * 
 */
package CandyGame;

/**
 * @author domin
 *
 */
public class Controller {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  CandyGame newGame = new CandyGame();

	        int totalStudents = newGame.getStudentsNumber(15, 30 );

	        int min = newGame.getRangeOfCandy(4, 10);

	        int max = newGame.getRangeOfCandy(6 + 2, 6 + 50 );

	        newGame.handOutCandies(4, 10);

	        newGame.printSizeOfClass();

	        newGame.passCandy();


	}

}
