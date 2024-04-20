import java.util.Scanner;

public class Solution {
    static Scanner sc;
    static int[][] arr;
    static int[] sum;
    static final int SIZE = 10;

    public static void main(String[] args) {


        sc = new Scanner(System.in);
        int t = sc.nextInt();
        arr = new int[t][SIZE];
        sum = new int[t];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = sc.nextInt();

                if (arr[i][j] % 2 != 0) {
                    sum[i] += arr[i][j];
                }
            }
            printResult(i);
        }
    }

    private static void printResult(int i) {
        System.out.printf("#%d %d", (i + 1), sum[i]);
        System.out.println();
    }
}