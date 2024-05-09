import java.util.Arrays;

class Solution {
    int[] answer;

    public int[] solution(int[] prices) {
        answer = new int[prices.length]; // 정답을 저장할 배열

        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length - 1; j++) {
                if (prices[i] > prices[j])
                    break;
                else answer[i] += 1; // 주식 가격에 변동이 없으면
            }
        }
        return answer;
    }
}