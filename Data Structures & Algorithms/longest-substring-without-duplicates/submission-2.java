class Solution {
     /* CORE LOGIC - Pattern - Dynamic Sliding window

    Duplicate mila
           ↓
     Left se character remove
            ↓
         left++
            ↓
    Duplicate abhi bhi hai?
             ↓
        YES → again remove
         NO  → stop
            ↓
       New character add
    
    HashSet mein current window ke unique characters rakho.
    Right se character add karke window ko expand karo.
    Agar duplicate mile, left se characters remove karte raho (while) jab tak duplicate remove na ho jaye.
    Phir new character add karo aur current window ki length se maximum update karo.
    Key: right = expand, left = shrink, Set = duplicate check.
     */

    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLongestSubstring = 0;
        int left = 0;
        for(char ch : s.toCharArray()){
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
         set.add(ch);
         maxLongestSubstring = Math.max(maxLongestSubstring, set.size());
        }
        return maxLongestSubstring;
    }
}
