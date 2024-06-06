import java.util.*;

class Solution {
    final static String COMMAND_ENTER = "Enter";
    final static String COMMAND_LEAVE = "Leave";
    final static String COMMAND_CHANGE = "Change";
    final static String ENTER_MESSAGE = "님이 들어왔습니다.";
    final static String LEAVE_MESSAGE = "님이 나갔습니다.";
    final static String ERROR_MESSAGE = "[ERROR] 다시 시도해주세요.";
    final static String DELIMITER = " ";
    
    HashMap<String, String> users;
    ArrayList<String[]> log;
    String[] info;
    String[] answer;
    
    
    public String[] solution(String[] record) {
        users = new HashMap<String, String>();
        log = new ArrayList<String[]>();

        for(String rec : record) {
            info = rec.split(DELIMITER);

            if(info[0].equals(COMMAND_ENTER)) {
                enterToUserInfo();
            }
            else if(info[0].equals(COMMAND_LEAVE)) {
                leaveToUserInfo();
            }
            else if(info[0].equals(COMMAND_CHANGE)) {
                changeToUserInfo();
            }
        }

        generateUserLogTable();
        return answer;
    }
    
    private void enterToUserInfo() {
        users.put(info[1], info[2]);
        log.add(new String[]{info[1], ENTER_MESSAGE});
    }
    
    private void leaveToUserInfo() {
        log.add(new String[]{info[1], LEAVE_MESSAGE});
    }
    
    private void changeToUserInfo() {
        if(users.containsKey(info[1])) {
            users.replace(info[1], info[2]);
        } else {
            System.out.println(ERROR_MESSAGE);
        }
    }
    
    private void generateUserLogTable() {
        answer = new String[log.size()];
        
        for(int i = 0; i < log.size(); i++) {
        String[] temp = log.get(i);
        answer[i] = users.get(temp[0]) + temp[1];
        }
    }
}