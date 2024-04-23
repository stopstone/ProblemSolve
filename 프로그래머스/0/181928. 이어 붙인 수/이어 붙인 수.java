class Solution {
    public int solution(int[] num_list) {
        String even = "";
        String odd = "";

        for (int number : num_list) {
            if (number % 2 == 0)
                even += number;
            else
                odd += number;
        }
        return Integer.parseInt(even) + Integer.parseInt(odd);
    }
}