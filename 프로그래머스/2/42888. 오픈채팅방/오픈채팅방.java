import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> users = new HashMap<String, String>();
        ArrayList<String[]> log = new ArrayList<String[]>();

        for(String rec : record) {
            String[] info = rec.split(" ");

            if(info[0].equals("Leave")) {
                log.add(new String[]{info[1], "님이 나갔습니다."});
            }
            else if(info[0].equals("Enter")) {
                users.put(info[1], info[2]);
                log.add(new String[]{info[1], "님이 들어왔습니다."});
            }
            else if(info[0].equals("Change")) {
                users.replace(info[1], info[2]);
            }
        }

        String[] answer = new String[log.size()];
        for(int i = 0; i < log.size(); i++) {
            String[] temp = log.get(i);
            answer[i] = users.get(temp[0]) + temp[1];
        }
        return answer;
    }
}