class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;

        for (String string : dic) {
            int index = 0;
            for (String s : spell) {
                if (string.contains(s)) index++;
                if (index == spell.length) answer = 1;
            }
        }
        return answer;
    }
}