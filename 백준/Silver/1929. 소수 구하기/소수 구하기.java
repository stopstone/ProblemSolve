import java.util.Scanner;

class Main {
    static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        findIsPrimeNumber(n, m);
    }

    private static void findIsPrimeNumber(int n, int m) {
        boolean[] isNotPrime = new boolean[n + 1];
        isNotPrime[0] = isNotPrime[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isNotPrime[j] = true;  // i의 배수들은 모두 소수 아님
                }
            }
        }

        for (int i = m; i <= n; i++) {
            if (!isNotPrime[i]) {
                System.out.println(i);
            }
        }
    }
}