class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length + 1];
        int preNumber = num_list[num_list.length - 2];
        int lastNumber = num_list[num_list.length - 1];
        
        for(int i =0; i < answer.length - 1; i++) {
            answer[i] = num_list[i];
        }
        
        if(lastNumber > preNumber) {
            answer[answer.length - 1] = lastNumber - preNumber;
        } else {
            answer[answer.length - 1] = lastNumber * 2;            
        }

        return answer;
    }
}