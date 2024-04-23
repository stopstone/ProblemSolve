class Solution {
    public String solution(String code) {
        String ret = "";
        boolean mode = false;
        
        for(int idx = 0; idx < code.length(); idx++) {
            char c = code.charAt(idx);
            
            if(c == '1')
                mode = !mode;
            else{
                if(idx % 2 == 0 && !mode)
                    ret += c;
                if(idx % 2 != 0 && mode)
                    ret += c;     
            }
        }
        
        if(ret.length() == 0) {
            ret = "EMPTY";
        }
        return ret;
    }
}