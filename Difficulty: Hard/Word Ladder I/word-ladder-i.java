class Pair{
    String first;
    int second;
    public Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int wordLadderLength(String startWord, String targetWord,
                                String[] wordList) {
        // Code here
        HashSet<String> hs = new HashSet<>();
        for(String word: wordList){
            hs.add(word);
        }
        if(hs.contains(startWord)){
            hs.remove(startWord);
        }
        
        if(!hs.contains(targetWord)) return 0;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(startWord, 1));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            String s = p.first;
            if(s.equals(targetWord)){
                return p.second;
            }
            StringBuilder sb = new StringBuilder(s);
            for(int i = 0; i < s.length();i++){
                char m = s.charAt(i);
                for(int j =0; j < 26; j++){
                    char c = (char)('a' + j);
                    sb.setCharAt(i, c);
                    String mid = sb.toString();
                    
                    if(hs.contains(mid)){
                        hs.remove(mid);
                        q.add(new Pair(mid, p.second + 1));
                    }
                }
                sb.setCharAt(i,m);
            }
        }
        return 0;
    }
}