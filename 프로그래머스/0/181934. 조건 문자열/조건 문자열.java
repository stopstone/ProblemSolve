    class Solution {
        public int solution(String ineq, String eq, int n, int m) {
            int answer = 0;

            switch (ineq) {
                case "<":
                    if (eq.equals("="))
                        answer = n <= m ? 1 : 0;
                    else
                        answer = n < m ? 1 : 0;
                    break;
                case ">":
                    if (eq.equals("="))
                        answer = n >= m ? 1 : 0;
                    else
                        answer = n > m ? 1 : 0;
                    break;
            }
            return answer;
        }
    }