package Java.Code.CTCI.CTCI_SOURCE.other.Ch_17_Hard.Q17_24_Max_Submatrix;

import Java.Code.CTCI.CTCI_SOURCE.other.CtCILibrary.AssortedMethods;

public class Tester {
  public static void main(String[] args) {
    int[][] matrix = AssortedMethods.randomMatrix(10, 10, -5, 5);
    AssortedMethods.printMatrix(matrix);
    SubMatrix subA = QuestionA.getMaxMatrix(matrix);
    System.out.println(subA.toString());
    SubMatrix subB = QuestionB.getMaxMatrix(matrix);
    System.out.println(subB.toString());
    SubMatrix subC = QuestionC.getMaxMatrix(matrix);
    System.out.println(subC.toString());
  }
}
