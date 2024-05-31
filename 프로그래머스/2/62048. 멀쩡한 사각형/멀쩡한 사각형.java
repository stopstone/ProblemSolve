class Solution {
    public long solution(int w, int h) {
        long rectangle = w * h; // 기존의 사각형 너비
        long gcd = gcd(w, h);
        
        return ((long) w * (long) h) - (w + h - gcd);
    }
    
    private long gcd(int w, int h) {
        int gcd = 0;
        int temp = 0;
        if(w > h) {
            temp = w;
            w = h;
            h = temp;
        }
        
        for(int i = 1; i <= w; i++) {
            if(w % i == 0 && h % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}

// 그래프로도 풀 수 있을 것 같지만 다른 방식으로 풀어봐야지
// 대각선을 그으려면 4칸짜리 블럭 4개가 사용된다.
// 블럭 4칸의 높이는 3이다.

