class Solution {
    public int solution(String my_string) {
        int answer = 0;

        String intStr = my_string.replaceAll("[^0-9]", " ");
        for (String s : intStr.split(" ")) {
            if (!s.isBlank())
                answer += Integer.parseInt(s);
        }
        return answer;
    }
}