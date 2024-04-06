class Solution {
    public String solution(String polynomial) {
        int x = 0;
        int num = 0;

        for (String s : polynomial.split(" ")) {
            if (s.contains("x"))
                x += s.equals("x") ? 1 : Integer.parseInt(s.replaceAll("x", ""));
            else if (!s.equals("+")) {
                num += Integer.parseInt(s);
            }
        }
        return (x != 0 ? x > 1 ? x + "x" : "x" : "")
                + (num != 0 ? (x != 0 ? " + " : "")
                + num : x == 0 ? "0" : "");
    }
}