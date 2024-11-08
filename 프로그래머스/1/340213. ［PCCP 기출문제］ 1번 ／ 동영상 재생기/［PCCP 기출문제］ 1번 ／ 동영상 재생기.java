class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 명령
        String nowPos = pos;

        for(String command : commands) {
            nowPos = openingHandle(nowPos, op_start, op_end);
            if(command.equals("prev")) {
                 // prev 일 경우
                nowPos = prevMove(video_len, nowPos);
            } else if(command.equals("next")) {
                // next 일 경우(오프닝 구간인 경우 오프닝이 끝나는 위치로)
                nowPos = nextMove(video_len, nowPos, op_start, op_end);
            }
            nowPos = openingHandle(nowPos, op_start, op_end);
        }
        
        String answer = nowPos;
        return answer;
    }
    
    // 10초 전으로 이동
    public String prevMove(String video_len, String pos) {
        String prefix = "0";
        
        // video_len 을 분, 초로 split
        String[] videoTime = video_len.split(":");
        int minute = Integer.parseInt(videoTime[0]);    //분
        int second = Integer.parseInt(videoTime[1]);    //초
        
        String[] posVideoTime = pos.split(":");
        int posMinute = Integer.parseInt(posVideoTime[0]);    //분
        int posSecond = Integer.parseInt(posVideoTime[1]);    //초
        
        //현재위치가 10초 미만일 경우 0분 0초로 이동
        if(posMinute == 0 && posSecond < 10) {
            posSecond = 0;
        } else {    //10초 전으로 이동
            //10초 전으로 이동 시 -1분이 되어야 하는 경우(01:04 -> 00:54)
            if(posSecond - 10 < 0) {
                posMinute -= 1;
                posSecond = (60 - 10) + posSecond;
            } else {
                posSecond = posSecond - 10;
            }
        }

        String nowMinute = Integer.toString(posMinute);
        String nowSecond = Integer.toString(posSecond);
        if(nowMinute.length() == 1){
           nowMinute = prefix + nowMinute;
        }
        if(nowSecond.length() == 1){
            nowSecond = prefix + nowSecond;
        }
        
        String nowPos = nowMinute.concat(":").concat(nowSecond);
        return nowPos;
    }
    
    // 10초 후로 이동
    public String nextMove(String video_len, String pos, String op_start, String op_end) {
        String prefix = "0";
        
        // video_len 을 분, 초로 split
        String[] videoTime = video_len.split(":");
        int minute = Integer.parseInt(videoTime[0]);    //분
        int second = Integer.parseInt(videoTime[1]);    //초
        
        String[] posVideoTime = pos.split(":");
        int posMinute = Integer.parseInt(posVideoTime[0]);    //분
        int posSecond = Integer.parseInt(posVideoTime[1]);    //초
        
        // 남은 시간이 10초 미만인지 확인
        int remainingSeconds = (minute - posMinute) * 60 + (second - posSecond);
        if (remainingSeconds < 10) {
            posMinute = minute;
            posSecond = second;
        } else {    //10초 후로 이동
            //10초 후로 이동 시 60초 이상인 경우
            if(posSecond + 10 >= 60) {
                posMinute += 1;
                posSecond = (posSecond + 10) % 60;;
            } else {
                posSecond = posSecond + 10;
            }
        }

        String nowMinute = Integer.toString(posMinute);
        String nowSecond = Integer.toString(posSecond);
        if(nowMinute.length() == 1){
           nowMinute = prefix + nowMinute;
        }
        if(nowSecond.length() == 1){
            nowSecond = prefix + nowSecond;
        }
        
        String nowPos = nowMinute.concat(":").concat(nowSecond);
        return nowPos;
    }
    
    public String openingHandle(String nowPos, String op_start, String op_end) {
        String[] posVideoTime = nowPos.split(":");
        int posMinute = Integer.parseInt(posVideoTime[0]);    //분
        int posSecond = Integer.parseInt(posVideoTime[1]);    //초
        
        String[] op_startTime = op_start.split(":");
        int op_startMinute = Integer.parseInt(op_startTime[0]);    //분
        int op_startSecond = Integer.parseInt(op_startTime[1]);    //초
        
        String[] op_endTime = op_end.split(":");
        int op_endMinute = Integer.parseInt(op_endTime[0]);    //분
        int op_endSecond = Integer.parseInt(op_endTime[1]);    //초
        
        // 현재 위치가 오프닝 구간 안에 있는지 확인
        if ((posMinute > op_startMinute || (posMinute == op_startMinute && posSecond >= op_startSecond)) &&
            (posMinute < op_endMinute || (posMinute == op_endMinute && posSecond <= op_endSecond))) {
            posMinute = op_endMinute;
            posSecond = op_endSecond;
        }
        
        String prefix = "0";
        String nowMinute = Integer.toString(posMinute);
        String nowSecond = Integer.toString(posSecond);
        if(nowMinute.length() == 1){
           nowMinute = prefix + nowMinute;
        }
        if(nowSecond.length() == 1){
            nowSecond = prefix + nowSecond;
        }
        
        nowPos = nowMinute.concat(":").concat(nowSecond);
        return nowPos;
    }
}