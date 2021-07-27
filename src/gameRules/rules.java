package gameRules;

import java.util.Scanner;

public class rules {
	
	public static int userChoosesMove(int totalPieces, int piecesLimit) {
		Scanner sc = new Scanner(System.in);
		
		int userMove;
		
		while (true) {
			System.out.print("How many pieces are you going to take out? ");
			userMove = sc.nextInt();
			
			if (userMove > piecesLimit || userMove < 1) {
				System.out.println();
				System.out.println("Ops! Invalid move, try again!");
				System.out.println();
			}
			else {
				break;
			}
		}
		sc.close();
		
		return userMove;
	}
	
	public static int computerChoosesMove(int totalPieces, int piecesLimit) {
		
		int computerMove = 1;
		
		while (computerMove != piecesLimit) {
			if ((totalPieces - computerMove) % (piecesLimit + 1) == 0) {
				return computerMove;
			}
			else {
				computerMove++;
			}
		}
		return computerMove;
	}
	
	public static void match() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Starting pieces of the game: ");
		int totalPieces = sc.nextInt();
		System.out.print("Limit of pieces per move: ");
		int piecesLimit = sc.nextInt();
		
		boolean computerTurn = false;
		
		if (totalPieces % (piecesLimit + 1) == 0) {
			System.out.println();
			System.out.println("You start!");
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println();
			System.out.println("Computer start!");
			computerTurn = true;
		}
		
		while (totalPieces > 0) {
			if (computerTurn) {
				int removedPiecesComputer = computerChoosesMove(totalPieces, piecesLimit);
				totalPieces -= removedPiecesComputer;
				if (removedPiecesComputer == 1) {
					System.out.println();
					System.out.println("The computer removed one piece!");
				}
				else {
					System.out.println();
					System.out.printf("The computer removed %d piece!\n", removedPiecesComputer);
				}
				computerTurn = false;
			}
			else {
				int removedPiecesUser = userChoosesMove(totalPieces, piecesLimit);
				totalPieces -= removedPiecesUser;
				if (removedPiecesUser == 1) {
					System.out.println();
					System.out.println("The computer removed one piece!");
				}
				else {
					System.out.println();
					System.out.printf("The computer %d pieces!\n", removedPiecesUser);
				}
				computerTurn = true;
			}
			if (totalPieces == 1) {
				System.out.println("Now only one piece remains on the board.");
			}
			else if (totalPieces != 0){
				System.out.printf("Now only %d piece remains on the board.\n", totalPieces);
				System.out.println();
			}
		}
		System.out.println("End game! Computer won!");
		sc.close();
	}
	
	public static void championship() {
		for (int i = 1; i <= 4; i++) {
			System.out.println();
			System.out.printf("**** Round %d ****\n", i);
			System.out.println();
			match();
		}
		System.out.println();
		System.out.println("Score: You 0 X 3Computer");
	}
}