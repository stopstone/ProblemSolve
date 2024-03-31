import java.util.Arrays;

class Solution {
    public int solution(int[] array, int n) {
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[0] - n) > Math.abs(array[i] - n)) {
                array[0] = array[i];
            }
        }
        return array[0];
    }
}
