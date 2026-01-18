class Solution {
    public int numberOfSubstrings(String s) {
        
        int n = s.length();

        int left = 0, right = 0;
        int [] count = new int [3];
        int ans = 0;
        while(left < n && right < n){
            
            while(right < n && (count [0] == 0 || count [1] == 0 || count [2] == 0)){
                char c = s.charAt(right);
                right++;
                switch(c){
                    case 'a':
                        count[0]++;
                        break;
                    case 'b':
                        count[1]++;
                        break;
                    default:
                        count[2]++;
                        break;
                }
            }
            
            while(left < right && (count [0] != 0 && count [1] != 0 && count [2] != 0)){
                char c = s.charAt(left);
                ans += (n - right + 1);
                left ++;
                
                switch(c){
                    case 'a':
                        count[0]--;
                        break;
                    case 'b':
                        count[1]--;
                        break;
                    default:
                        count[2]--;
                        break;
                }
            }
        }
        return ans;
    }
}