import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long answer = 0;
        long low = 0;
        long high = times[times.length - 1] * (long) n;
        long mid = 0;
        
        while(low <= high) {
            mid = (low + high) / 2;
            long sum = 0;
            
            for(int i=0; i<times.length; i++) {
                sum += mid / times[i];
            }
            
            if(sum < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}