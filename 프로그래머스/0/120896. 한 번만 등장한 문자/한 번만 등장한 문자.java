import java.util.Arrays;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] word =  s.split("");

        Arrays.sort(word);
        for (String value : word) {
            int count = 0;
            for (String string : word) {
                if (value.equals(string))
                    count++;
            }
            if (count == 1)
                answer.append(value);
        }
        return answer.toString();
    }
}