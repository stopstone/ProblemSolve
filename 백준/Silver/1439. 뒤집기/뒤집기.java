import java.util.*;

public class Main {
    // 0 에서 1을 마주쳤을 때 뒤집는다 -> 전체를 0으로 만들기 위한 작업
    // 1 에서 0을 마주쳤을 때 뒤집는다 -> 전체를 1로 만들기 위한 작업

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int result = reverseToNumber(s);

        System.out.println(result);
    }

    // 문자열을 같은 숫자 한 줄로 뒤집는 메서드
    private static int reverseToNumber(String s) {
        int countToAllZero = 0;
        int countToAllOne = 0;

        if (s.charAt(0) == '0') {
            countToAllOne++;
        } else if (s.charAt(0) == '1') {
            countToAllZero++;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                if (s.charAt(i + 1) == '1') {
                    countToAllZero++;
                } else if (s.charAt(i + 1) == '0') {
                    countToAllOne++;
                }
            }
        }
        return Math.min(countToAllOne, countToAllZero);
    }
}
