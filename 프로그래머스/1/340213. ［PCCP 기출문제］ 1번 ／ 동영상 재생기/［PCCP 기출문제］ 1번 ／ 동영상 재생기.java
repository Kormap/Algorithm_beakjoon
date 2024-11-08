class Solution {
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoSec = convertTimeToSecond(video_len);
        int posSec = convertTimeToSecond(pos);
        int op_startSec = convertTimeToSecond(op_start);
        int op_endSec = convertTimeToSecond(op_end);

        for(String command : commands) {
            // 오프닝구간 체크
            posSec = opGroupCheck(op_startSec, op_endSec, posSec);
            
            if(command.equals("prev")) {
                if(posSec - 10 <= 0) posSec = 0;    // 현재위치가 10초 미만인 경우
                else posSec -= 10;
            } else if(command.equals("next")) {
                if(posSec + 10 >= videoSec) posSec = videoSec;  //남은 시간이 10초미만일 경우
                else posSec += 10;
            }
            
            posSec = opGroupCheck(op_startSec, op_endSec, posSec);
        }
        
        String posMinute = String.valueOf(posSec / 60);
        String posSecond = String.valueOf(posSec % 60);
        
        if(posMinute.length() == 1) posMinute = "0" + posMinute;
        if(posSecond.length() == 1) posSecond = "0" + posSecond;
        
        return posMinute + ":" + posSecond;
    }
    
    public int convertTimeToSecond(String time) {
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }
    
    public int opGroupCheck(int op_startSec, int op_endSec, int posSec) {
        if(posSec >= op_startSec && posSec <= op_endSec){
            return op_endSec;
        }else {
            return posSec;
        }
    }
}