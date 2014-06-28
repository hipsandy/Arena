package com.hipsandy.problems;

public class DiamondPrinter {

	public static void main(String[] args) {
		printDiamond(9);
	}
	
	public static void printDiamond(int maxStarsInRow) {
		if (maxStarsInRow < 0 || (maxStarsInRow % 2) == 0) {
			throw new IllegalArgumentException("Diamonds can only be printed with odd number of sparkles in each row");
		}
		int maxRows = (maxStarsInRow + 1) / 2;
		// Print upper pyramid
		for (int r = 1; r <= maxRows; r++) {
			print(r, maxRows);
		}
		
		// Print INVERTED lower pyramid of size (maxRows - 1)
		for (int r = maxRows - 1; r > 0; r--) {
			print(r, maxRows);
		}
	}
	
	private static void print(int r, int maxRows) {
		int numberOfStars = 2 * r - 1;
		int indentation = maxRows - r;
		printIndentation(indentation);
		printStars(numberOfStars);
		System.out.println();
	}

	private static void printIndentation(int spaces) {
		while(spaces > 0 ) {
			System.out.print(" ");
			spaces--;
		}
	}

	private static void printStars(int stars) {
		while(stars > 0 ) {
			System.out.print("*");
			stars--;
		}
		
	}

}
