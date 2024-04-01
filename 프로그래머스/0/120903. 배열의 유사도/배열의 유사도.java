import java.util.Arrays;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;

        Arrays.sort(s1);
        Arrays.sort(s2);

        if (s1.length < s2.length) {
            String[] temp = s1;
            s1 = s2;
            s2 = temp;
        }

        for (int i = 0; i < s1.length; i++) {
            for (int j = 0; j < s2.length; j++) {
                if (s1[i].equals(s2[j])) {
                    answer++;
                }
            }
        }
        return answer;
    }
}