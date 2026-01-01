// User function Template for Java
class Pair{
    String first;
    int second;
    public Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        // Code here
        HashSet<String> hs = new HashSet<>();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(String word: wordList){
            hs.add(word);
        }
        if(hs.contains(startWord)){
            hs.remove(startWord);
        }
        
        if(!hs.contains(targetWord)) return ans;
        
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> al = new ArrayList<>();
        al.add(startWord);
        q.add(al);
        
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<String> used = new ArrayList<>();
            for(int k = 0; k < size; k++){
                
                ArrayList<String> words = q.poll();
                String s = words.get(words.size() - 1);
                
                if(s.equals(targetWord)){
                    ans.add(words);
                    continue;
                }
            
                for(int i = 0; i < s.length();i++){
                    StringBuilder sb = new StringBuilder(s);
                    for(int j = 0; j < 26; j++){
                        char c = (char)('a' + j);
                        sb.setCharAt(i, c);
                        String mid = sb.toString();
                        if(hs.contains(mid)){
                            ArrayList<String> lis = new ArrayList<>(words);
                            used.add(mid);
                            lis.add(mid);
                            q.add(lis);
                            
                        }
                    }
                }
            }
            
            for(String it: used){
                hs.remove(it);
            }
            
            if(!ans.isEmpty()) break;
        }
        return ans;
    }
}