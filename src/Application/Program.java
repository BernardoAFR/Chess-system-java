package Application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ChessMatch chessmatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		
		
		while(!chessmatch.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessmatch, captured);	
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(input);
				
				boolean[][] possibleMoves = chessmatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessmatch.getpieces(), possibleMoves);
				
				System.out.printf("\n Target: ");
				ChessPosition target = UI.readChessPosition(input);
				
				ChessPiece capturedPiece = chessmatch.performChessMove(source, target);
			
				if(capturedPiece != null)
					captured.add(capturedPiece);
				
				if(chessmatch.getPromotedPiece() != null) {
					System.out.println("Enter piece for promotion (B/N/R/Q): ");
					String type = input.nextLine().toUpperCase();
					while(!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
						System.out.println("Invalid value! CEnter piece for promotion (B/N/R/Q): ");
						type = input.nextLine().toUpperCase();
					}
					chessmatch.replacePromotedPiece(type);
				}
			}
			catch(ChessException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				input.nextLine();
			}
			
		}
		UI.clearScreen();
		UI.printMatch(chessmatch, captured);
		
	}

}
