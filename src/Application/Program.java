package Application;

import java.util.Scanner;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ChessMatch chessmatch = new ChessMatch();
		
		while(true) {
			
			UI.printBoard(chessmatch.getpieces());	
			System.out.println();
			System.out.print("Source: ");
			ChessPosition source = UI.readChessPosition(input);
			
			System.out.printf("\n Target: ");
			ChessPosition target = UI.readChessPosition(input);
			ChessPiece capturedPiece = chessmatch.performChessMove(source, target);
		}
	}

}
