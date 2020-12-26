package CTCI;

import classesInstance.Line;
import classesInstance.Tuple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Moderate {

	public static void getDescription() {
		System.out.println("Section 16. Moderate");
	}

	private static boolean isBetween(double start, double middle, double end) {
		if (start > end) {
			return end <= middle && middle <= start;
		} else {
			return start <= middle && middle <= end;
		}
	}

	public static Tuple<Double, Double> lineIntersection(Line line1, Line line2) {

		Tuple<Double, Double> retrunPoint = null;
		// Parallel test
		if (line1.getSlope() == line2.getSlope()) {
			return retrunPoint;
		}
		// Find an intersection point
		// y = mx +b
		// y = m(1)x +b(1) = m(2)x +b(2)
		// (b(2) - b(1)) /(m(1)- m(2))
		double valueX = (line2.getYIntercept() - line1.getYIntercept()) / (line1.getSlope() - line2.getSlope());
		// Test to see if the x value is in the range of both lines
		if ((isBetween(line1.getPoint1X(), valueX, line1.getPoint2X()))
				&& (isBetween(line2.getPoint1X(), valueX, line2.getPoint2X()))) {
			double valueY = line1.getYfromX(valueX);
			return new Tuple<>(valueX, valueY);
		}

		return null;
	}

	public static int maxNumber(int left, int right) {

		return 0;
	}

	public static int minumumDistance(int[] left, int[] right) {
		Arrays.sort(left);
		Arrays.sort(right);
		int leftPointer = 0;
		int rightPointer = 0;
		int min = Integer.MAX_VALUE;
		while (leftPointer < left.length && rightPointer < right.length) {

			if (min > Math.abs(left[leftPointer] - right[rightPointer])) {
				min = Math.abs(left[leftPointer] - right[rightPointer]);
				if (min == 0) {
					break;
				}
			}
			if (left[leftPointer] < right[rightPointer]) {
				leftPointer++;
			} else {
				rightPointer++;
			}

		}

		return min;
	}

	public static void numberSwapInPlace(Integer left, Integer right) {
		left = left - right;
		right = left + right;
		left = right - left;
		System.out.println("Finish left: " + left);
		System.out.println("Finish right: " + right);
	}

	enum Tic_Tac_Toe_Piece {
		Empty {
			@Override
			public String toString() {
				return "_";

			}
		},
		X {
			@Override
			public String toString() {
				return "X";

			}
		},
		O {
			@Override
			public String toString() {
				return "O";

			}
		}
	}

	class ConvertNumberToString {

		private String[] smalls = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
				"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
				"Nineteen"};
		private String[] mediums = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
				"Ninety"};
		private String[] bigs = {"", "Thousand", "Million", "Billion"};
		private String hundred = "Hundred";
		private String negativeSign = "Negative";

		ConvertNumberToString() {

		}

		public String processNumber(int startValue) {
			if (startValue == 0) {
				return smalls[0];
			}
			if (startValue >= Integer.MAX_VALUE) {
				return "out of range";
			}
			Stack<String> stack = new Stack<>();
			boolean negative = false;
			int bigCounter = 0;
			if (startValue < 0) {
				negative = true;
				startValue *= -1;
			}

			while (startValue > 0) {

				int process = startValue % 1000;
				if (process != 0) {
					stack.add(bigs[bigCounter]);
				}
				int hundreds = process / 100;

				process = process % 100;
				if (process >= 20) {

					int tens = process / 10;
					int ones = process % 10;
					if (ones != 0) {
						stack.add(smalls[ones]);
					}
					stack.add(mediums[tens]);
				} else {
					if (process != 0) {
						stack.add(smalls[process]);
					}
				}
				if (hundreds != 0) {
					stack.add(hundred);
					stack.add(smalls[hundreds]);
				}

				startValue /= 1000;
				bigCounter++;
			}

			StringBuilder stringBuilder = new StringBuilder();
			if (negative) {
				stringBuilder.append(negativeSign);
			}
			while (!stack.isEmpty()) {

				if (!stack.peek().equals(mediums[0])) {
					stringBuilder.append(" ").append(stack.pop());
				} else {
					stack.pop();
				}
			}
			return stringBuilder.toString().trim();
		}
	}

	class ProcessBook {

		HashMap<String, Integer> table;

		public ProcessBook(String[] book) {
			this.table = new HashMap<>();
			this.setWordFrequency(book);
		}

		public Integer getWordFrequency(String word) {
			return this.table.get(word.toLowerCase().trim());
		}

		private void setWordFrequency(String[] book) {

			for (String word : book) {
				word = word.trim().toLowerCase();
				if (!word.trim().isEmpty()) {
					if (this.table.containsKey(word)) {
						this.table.put(word, this.table.get(word) + 1);
					} else {
						this.table.put(word, +1);
					}
				}
			}
		}
	}

	class Tic_Tac_Toe {
		private Tic_Tac_Toe_Piece lastPlayer;
		private int moves;
		private int size;

		private Tic_Tac_Toe_Piece[][] board;

		Tic_Tac_Toe(int size) {
			this.size = size;
			this.initializeBoard();
			this.moves = size * size;
			this.lastPlayer = Tic_Tac_Toe_Piece.Empty;
		}

		private boolean evaluateBoard(Tic_Tac_Toe_Piece pice, int xCordinate, int yCordinate,
									  Tic_Tac_Toe_Piece[][] board) {
			boolean test = true;
			// column
			for (int index = 0; index < this.size; index++) {
				if (board[xCordinate][index] != pice) {
					test = false;
					break;
				}
			}
			if (test) {
				return test;
			}
			// row
			for (int index = 0; index < this.size; index++) {
				if (board[index][yCordinate] != pice) {
					test = true;
					break;
				}
			}
			if (!test) {
				return !test;
			}
			// diagonal 1
			if (xCordinate == yCordinate) {
				for (int index = 0; index < this.size; index++) {
					if (board[index][index] != pice) {
						test = false;
						break;
					}
				}
			} else {
				test = false;
			}
			if (test) {
				return test;
			}
			// diagonal 1
			if ((xCordinate + yCordinate) == this.size) {

				for (int index = 1; index <= this.size; index++) {
					if (board[this.size - index][index - 1] != pice) {
						test = true;
						break;
					}
				}
			} else {
				test = true;
			}
			return !test;
		}

		public void initializeBoard() {
			this.board = new Tic_Tac_Toe_Piece[this.size][this.size];
			for (int row = 0; row < this.size; row++) {
				for (int column = 0; column < this.size; column++) {
					this.board[row][column] = Tic_Tac_Toe_Piece.Empty;
				}
			}
		}

		public void placePice(Tic_Tac_Toe_Piece pice, int xCordinate, int yCordinate) {
			if (this.moves == 0) {
				System.out.format("Sorry, this game is over.\n", pice);
				return;
			}
			if ((xCordinate < 0) || (yCordinate < 0) || (xCordinate >= this.size) || (yCordinate >= this.size)) {
				System.out.format("Invalid locaton placement '(%s, %s)'.\n", xCordinate, yCordinate);
				return;
			}
			if (pice == Tic_Tac_Toe_Piece.Empty) {
				System.out.format("Invalid piece placement '%s'.\n", Tic_Tac_Toe_Piece.Empty);
				return;
			}

			if (this.lastPlayer == Tic_Tac_Toe_Piece.Empty) {
				this.lastPlayer = pice;
			} else if (pice == this.lastPlayer) {
				System.out.format("Player '%s' can not go twice in a row, try again.\n", pice);
				return;
			}
			if (this.board[xCordinate][yCordinate] == Tic_Tac_Toe_Piece.Empty) {
				this.board[xCordinate][yCordinate] = pice;
				this.moves--;
				this.lastPlayer = pice;
			} else {
				System.out.format("That space is occupied, place again.\n", pice);
				return;
			}

			if (evaluateBoard(pice, xCordinate, yCordinate, board)) {
				System.out.format("Player '%s' has won.\n", pice);
				this.moves = 0;
			}
			printBoard();
		}

		private void printBoard() {
			System.out.println(this.toString());
		}

		public void resetBoard() {
			this.initializeBoard();
			this.moves = size * size;
			this.lastPlayer = Tic_Tac_Toe_Piece.Empty;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			for (Tic_Tac_Toe_Piece[] entry : this.board) {
				builder.append("[");
				if (entry.length > 0) {
					builder.append(entry[0]);
					if (entry.length > 1) {
						for (int i = 1; i < entry.length; i++) {
							builder.append("\t");
							builder.append(entry[i]);
						}
					}
				}
				builder.append("]\n");
			}
			return builder.toString();
		}
	}

}
