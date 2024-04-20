import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        
        // 초기화
        int[][] patterns = {
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };
        int[] score = new int[3];
        ArrayList<Integer> answer = new ArrayList<>();
        
        
        // 수포자 답안과 정답 채점
        for(int i=0; i < answers.length; i++) {
            for(int j=0; j < patterns.length; j++) {
                if(answers[i] == patterns[j][i % patterns[j].length]) {
                    score[j]++;
                }
            }
        }
        
        int maxScore = Arrays.stream(score).max().getAsInt();
        for(int i=0; i < score.length; i++) {
            if(score[i] == maxScore)
                answer.add(i + 1);
        }
        
        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}