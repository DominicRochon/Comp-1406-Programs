import java.util.Random;

public class Tutorial02{

	// an array of strings to use
	public static String[] words = {"cat", "dog", "eel", "owl", "fox", "kitten", "puppy", "elver", "owlet", "kit"};

	public static void strings(){
		int longestLen = 0;
		String longestWord = "";
		int totalChars = 0;
		for (String p: words){
			System.out.print(p.substring(0,1).toUpperCase());
			System.out.println(p.substring(1).toLowerCase());
			totalChars += p.length();
			if (p.length() > longestLen){
				longestWord = p;
				longestLen = p.length();
			}
		}

		System.out.println("The longest word is " + longestWord.toUpperCase());
		System.out.println("There were " + totalChars + " chars in total.");
	}
	
	public static int[][] rollRandomDice(int n, long seed){
		Random d1 = new Random();
		Random d2 = new Random();
		int n1;
		int n2;

		int[][] rolls = new int[6][6];

		for (int i = 0; i < n; i++){
			n1 = d1.nextInt(6);
			n2 = d2.nextInt(6);

			rolls[n1][n2]++;
		}
		return rolls;
	}
	
	public static void diceRollResults(int[][] rolls){
		int numRolls = 0;
		int[] distribution = new int[12];
		int count1 = 0;
		int count2 = 0;
		for (int[] p: rolls){
			System.out.println(java.util.Arrays.toString(p));
			for (int k: p){
				numRolls += k;
				distribution[count1 + count2 + 1]+= k;
				count2++;
			}
			count1++;
			count2 = 0;
		}
		System.out.println("\nNumber of rolls: " + numRolls);

		for (int i = 1; i < distribution.length; i++){
			System.out.println("Percentage of " + (i+1) + " rolled is: " + (float)distribution[i]*100/numRolls + "%");
		}
	}
	

	public static void testPoint2D(){
		Point2D p = new Point2D();
		Point2D bo = new Point2D();
		p.x = -7;
		p.y = -4;
		bo.x = 17;
		bo.y = 6.5;
		System.out.print( "magnitude of point " );
		System.out.print( p.toString() );
		System.out.println( " is " + p.magnitude() );
		System.out.print( "Distance between point " );
		System.out.print( p.toString() );
		System.out.print( " and " );
		System.out.print( bo.toString() );
		System.out.println( " is " + p.distance(bo) );
	}

	
	public static void main(String[] args){
		// Question 1
		System.out.println("Question 1\n----------");
		strings();

		// Question 2
		System.out.println("\nQuestion 2\n----------");
		int[][] rolls = rollRandomDice(100000, 0);
		diceRollResults(rolls);
		
		// Question 3
		System.out.println("\nQuestion 3\n----------");
		testPoint2D();
	
	}
	
}