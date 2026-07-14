package Matrix;

import java.util.Scanner;

public class Drangeon {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = '*';
            }
        }
        //Enter adventure
        System.out.println("Enter the adventure number(m n): ");
        int aRow = sc.nextInt();
        int aCol = sc.nextInt();
        matrix[aRow][aCol] = 'A';

        //Enter MONSTAR
        System.out.println("Enter the monstar number(m n): ");
        int mRow = sc.nextInt();
        int mCol = sc.nextInt();
        matrix[mRow][mCol] = 'M';

        //Enter trigger
        System.out.println("Enter the trigger number(m n): ");
        int tRow = sc.nextInt();
        int tCol = sc.nextInt();
        matrix[tRow][tCol] = 'T';

        //Enter Reward
        System.out.println("Enter the Reward number(m n): ");
        int rRow = sc.nextInt();
        int rCol = sc.nextInt();
        matrix[rRow][rCol] = 'R';

        //ENTER THE PITS
        System.out.println("Enter the nos pits:");
        int pits=sc.nextInt();
        for(int i=0;i<pits;i++) {
            System.out.println("Enter the pits: " + (i+1)+ "position of (row col):");
            int pRow = sc.nextInt();
            int pCol = sc.nextInt();
            matrix[pRow][pCol] = 'P';
        }

        System.out.println("Matrix:");
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();


        }
        int ad2tri=Math.abs(aRow-tRow)+Math.abs(aCol-tCol);
        int mons2tri=Math.abs(mRow-tRow)+Math.abs(mCol-tCol);
        int ad2re=Math.abs(rRow-tRow)+Math.abs(rCol-tCol);
        int mons2re=Math.abs(mRow-rRow)+Math.abs(mCol-rCol);

        if(ad2tri<mons2tri){
            System.out.println("advengere will reach to trigger and salfly");
            System.out.println("Monster will frozen");

        }else if(ad2re>mons2re){
            System.out.println("Monster will reach to trigger");
            System.out.println("Trigger will deactivate");
        }else if(ad2re<mons2re){
            System.out.println("advengere will reach tresare salfly");
        }else{
            System.out.println("monster will catch");
        }
        sc.close();

    }
}