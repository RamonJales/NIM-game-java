package application;

import java.util.Scanner;

import gameRules.rules; 

public class MainProgram {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to the NIM game! Choice: ");
		System.out.println();
		System.out.println("1 - To play a single game");
		System.out.println("2 - To play a championship");
		System.out.print("Option: ");
		int option = sc.nextInt();
		
		if (option == 2) {
			System.out.println();
			System.out.println("You chose a championship!");
			rules.championship();
		}
		else {
			System.out.println();
			rules.match();
		}
		sc.close();
	}
}