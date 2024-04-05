class Solution {
    public String[] solution(String my_str, int n) {
        String[] answer = new String[(my_str.length() + n - 1) / n];

        for(int i = 0; i < answer.length; i++){
            int end = Math.min(n * i + n, my_str.length());
            answer[i] = my_str.substring((n * i), end);
        }
        return answer;
    }
}