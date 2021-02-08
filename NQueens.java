package csc321;
import java.util.Scanner;
//Name: Xinru He

public class NQueens {
	
	 public int[] placeQueens(int n) {
	        int[] arr = new int[n];
	        placeQueensHelper(arr, 0);
	        return arr;
	    }
	    private boolean placeQueensHelper(int[] arr, int r ) {
	        if (r == arr.length) {
	            return true;
	        }
	        for (int i = 0; i < arr.length; i++) {
	            arr[r] = i;
	            if (legalCheck(arr, r)) {
	                if (placeQueensHelper(arr, r+1)) {
	                	System.out.print("true\n");
	                    return true;
	                }
	            }
	        }
	        return false;
	    }

	    private boolean legalCheck(int[] arr, int r) {
	        for (int i = 0; i < r; i++) {
	            if (arr[i] == arr[r]) {
	                return false;
	            }
	            int dif = r - i;
	            if (arr[i] + dif == arr[r]) {
	                return false;
	            }
	            if (arr[i] - dif == arr[r]) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public static void printBoard(int[] arr) {
	         for (int i = 0; i < arr.length; i++) {
	        	 System.out.format("Row %d: ", i+1);  //row number
	             for (int j = 0; j < arr.length; j++) {
	                 if (i == arr[j]) {
	                     System.out.format("%d", j+1);  //position for queen placement on the board
	                 } else {
	                     System.out.print("x"); //x for empty squares on the board
	                 }
	             }
	             System.out.println("");
	         }
	    }

	    @SuppressWarnings("resource")
		public static void main(String[] args) {
	        NQueens nQueens = new NQueens();
			Scanner input = new Scanner(System.in);
	        System.out.print("Enter an integer: ");
	        int N = input.nextInt();
	        printBoard(nQueens.placeQueens(N));
	    }


}
