class Solution {
    public int solution(int[] num_list) {
        int multiResult = 1;
        int sumResult = 0;
        
        for (int number : num_list) {
            multiResult *= number;
            sumResult += number;
        }
        
        if (multiResult < (sumResult * sumResult))
            return 1;
        else
            return 0;
    }
}