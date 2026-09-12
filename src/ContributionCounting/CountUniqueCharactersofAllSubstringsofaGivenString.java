package ContributionCounting;

import java.util.Arrays;

public class CountUniqueCharactersofAllSubstringsofaGivenString {
    public int uniqueLetterString(String s) {

        // below is lame solution and its brute force and it won't work because its
        // leading to O(n^3)
        // HashMap<Character, Integer> map = new HashMap<>();
        // for(char c: s.toCharArray()){
        // map.put(c, map.getOrDefault(c, 0)+1);
        // }
        // if(map.size()==1) return s.length();
        // int res=0;
        // HashMap<String, Integer> tmap = new HashMap<>();
        // for(int i=0; i<s.length() ; i++) {
        // for(int j=i+1; j<=s.length();j++){
        // int tcount=0;
        // String sub=s.substring(i,j);
        // if(tmap.containsKey(sub)){
        // tcount=tmap.get(sub);
        // } else{
        // tcount=getUniqueCount(sub);
        // tmap.put(sub, tcount);
        // }
        // res+=tcount;
        // }
        // }
        // return res;

        // below is the better solution and its achieved using the previous and next
        // occurance indexes, lets you are at index i= 5 and then character is 'S' and
        // its previous index was i=2 and next index is i=9 then in between i=3-8 the
        // occurance is only once then it contributes (i - prev occurance)*(next - i)

        int n = s.length();
        int[] prev = new int[n];
        int[] next = new int[n];

        int[] idx = new int[26];

        Arrays.fill(idx, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            prev[i] = idx[c];
            idx[c] = i;
        }

        Arrays.fill(idx, n);

        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'A';
            next[i] = idx[c];
            idx[c] = i;
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            res += (i - prev[i]) * (next[i] - i);
        }

        return res;
    }

    // public int getUniqueCount(String s){
    // int[] freq = new int[26];
    // for(int i=0; i<s.length(); i++){
    // int idx=s.charAt(i)-'A';
    // freq[idx]++;
    // }
    // int count=0;
    // for(int c: freq){
    // if(c==1) count++;
    // }
    // return count;
    // }
}
