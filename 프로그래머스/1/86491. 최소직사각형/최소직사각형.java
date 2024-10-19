class Solution {
    public int solution(int[][] sizes) {
        int size = sizes.length;
        int maxW = 0;
        int maxH = 0;
        
        // 가로,세로 재정렬(큰쪽을 가로, 작은쪽을 세로로)
        for(int i = 0; i < size; i++){
            int w = 0;    //가로
            int h = 0;    //세로
            
            w = Math.max(sizes[i][0],sizes[i][1]);
            h = Math.min(sizes[i][0],sizes[i][1]);
            
            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }
        
        int answer = maxW * maxH;
        System.out.println(answer);
        return answer;
    }
}