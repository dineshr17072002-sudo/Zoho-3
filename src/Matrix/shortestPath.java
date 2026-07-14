package Matrix;

import java.util.*;
public class shortestPath {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number(m n): ");
        int n = sc.nextInt();
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        //Enter adventure
        System.out.println("Enter the adventure number(m n): ");
        int aRow = sc.nextInt();
        int aCol = sc.nextInt();
        matrix[aRow][aCol] = 'A';

        //Enter adventure
        System.out.println("Enter the distance number(m n): ");
        int dRow = sc.nextInt();
        int dCol = sc.nextInt();
        matrix[dRow][dCol] = 'D';


        //MATRIX
        System.out.println("MATRIX: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int output=Method(aRow,aCol,dCol,dRow);
        System.out.println("Shortest Path: "+output);
    }
    public static int Method(int aRow, int aCol, int dCol, int dRow) {
        return Math.abs(aRow-dRow)+Math.abs(aCol-dCol);
    }
}