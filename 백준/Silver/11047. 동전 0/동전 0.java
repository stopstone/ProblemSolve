import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int k = sc.nextInt();
        int[] moneys = new int[N];


        // 배열 뒤부터 저장하여 큰 값을 앞에 오도록 구현한다.
        for (int i = moneys.length - 1; i >= 0; i--) {
            moneys[i] = sc.nextInt();
        }

        int coin = 0;
        for (int money : moneys) {
            coin += k / money;
            k %= money;
        }

        System.out.print(coin);
    }
}