class Solution {
    public String findOrder(String[] words) {
        // code here
        
        ArrayList<ArrayList<Character>> adj = new ArrayList<>();
        int [] ind = new int [26];
        boolean [] has = new boolean[26];
        HashSet<String> hs = new HashSet<>();
        for(int i = 0; i < 26; i++){
            adj.add(new ArrayList<Character>());
        }
        
        for(String word: words){
            for(Character c: word.toCharArray()){
                has[c - 'a'] = true;
            }
        }
        for(int i = 1; i < words.length; i++){
            String s1 = words[i - 1];
            int l1 = s1.length();
            String s2 = words[i];
            int l2 = s2.length();
            boolean mismatched = false;
            int j = 0;
            while(j < Math.min(l1, l2)){
                Character c1 = s1.charAt(j);
                Character c2 = s2.charAt(j);
                int i1 = c1 -'a';
                int i2 = c2 -'a';

                String pair = c1 + "_" + c2;
                if((c1 != c2)){
                    if(!hs.contains(pair)){
                        adj.get(i1).add(c2);
                        hs.add(pair);
                        ind[i2]++;
                    }
                    mismatched = true;
                    break;
                }
                j++;
            }
            if(!mismatched && l1 > l2) return "";
        }
        int count = 0;
        for(int i = 0; i< 26; i++){
            if(has[i]){
                count++;
            }
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < 26; i++){
            if(has[i] && (ind[i] == 0)){
                q.add(i);
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!q.isEmpty()){
            int v = q.poll();
            char V = (char)(v + 'a');
            sb.append(V);
            for(Character c: adj.get(v)){
                int i = c -'a';
                ind[i]--;
                if(ind[i] == 0){
                    q.add(i);
                }
            }
        }
        if(sb.length() != count) return "";
        return sb.toString();
    }
}