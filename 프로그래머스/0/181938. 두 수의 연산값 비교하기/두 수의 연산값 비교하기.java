class Solution {
    public int solution(int a, int b) {
        if(Integer.parseInt(a+""+b) == 2 * a * b)
            return Integer.parseInt(a+""+b);
        return Math.max(Integer.parseInt(a+""+b), 2*a*b);
    }
}