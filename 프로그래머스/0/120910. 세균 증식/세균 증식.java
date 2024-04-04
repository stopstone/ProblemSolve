import java.util.stream.IntStream;

class Solution {
    public int solution(int n, int t) {
        Integer result = IntStream.range(0, t).reduce(n,(total, num) -> 2 * total);
        return result.intValue();
    }
}