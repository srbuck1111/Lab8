package co.grandcircus;

import java.util.Scanner;

public class IceBreakerWithExtraSteps {

	public static void main(String[] args) {

		String[][] students = new String[10][3];

		students[0][0] = "Dave";   students[0][1] = "Detroit";         students[0][2] = "Pizza";
		students[1][0] = "Charles";students[1][1] = "Southfield";      students[1][2] = "Pizza";
		students[2][0] = "Bart";   students[2][1] = "Juno";            students[2][2] = "Pizza";
		students[3][0] = "Jake";   students[3][1] = "Royal Oak";       students[3][2] = "Pizza";
		students[4][0] = "Ben";    students[4][1] = "Clarkston";       students[4][2] = "Cookies";
		students[5][0] = "Tara";   students[5][1] = "Royal Oak";       students[5][2] = "Pizza";
		students[6][0] = "Porter"; students[6][1] = "Bloomfield Hills";students[6][2] = "Pizza";
		students[7][0] = "Ryan";   students[7][1] = "Southfield";      students[7][2] = "Pizza";
		students[8][0] = "Nathan"; students[8][1] = "Denver";          students[8][2] = "Pizza";
		students[9][0] = "Bailey"; students[9][1] = "Juno";            students[9][2] = "Pizza";
		
		Scanner scan = new Scanner(System.in);

		String ans = "Y";

		while (ans.equalsIgnoreCase("Y")) {
			
			int numAns = 0;
			
			System.out.println("Welcome to our Java class. Which student would you like to learn more about?");
			
			for (int i = 0; i < students.length; i++) {
				
				System.out.println((i+1) + ". " + students[i][0]);
				
			}
			
			numAns = Validator.getInt(scan , "Answer: " , 1 , students.length + 1);
			
			System.out.println("Student " + numAns + " is " + students[numAns - 1][0] + ". What would you like to know about them?");
			
			ans = Validator.getString(scan , "Favorite food or hometown: ");
			
			while (!ans.equalsIgnoreCase("favorite food") && !ans.equalsIgnoreCase("hometown")) {
				
				System.out.print("That student's " + ans + " has dematerialized. Please try again."
						+ "\nEnter hometown or favorite food: ");
				ans = Validator.getString(scan , "Favorite food or hometown: ");
				
			}
			
			System.out.println(studentInfo(students, numAns, ans));
			
			ans = Validator.getString(scan , "Again? (y/n)");

		}

		scan.close();
		
	}

	private static String studentInfo(String[][] arr, int name, String choice) {
		
		String sentence = null;
		
		if (choice.equalsIgnoreCase("hometown")) {
			
			sentence = " lives in " + arr[name - 1][1] + ".";
			
		} else if (choice.equalsIgnoreCase("favorite food")){
			
			sentence = "'s favorite food is " + arr[name - 1][2] + ".";
			
		} else {
		
			return "How did you get here?";
			
		}
		
		return arr[name - 1][0] + sentence;
		
	}
	
}
