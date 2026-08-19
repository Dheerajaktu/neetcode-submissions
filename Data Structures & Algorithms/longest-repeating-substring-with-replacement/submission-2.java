class Solution {
    /*
    Pattern: Dynamic Sliding Window + Frequency Map.  Good questions
    right se window expand karo aur character ki frequency map mein count karo. 
    Window mein most frequent character ki count maxFreq rakho.
     windowSize - maxFreq = kitne characters replace karne padenge.
     Agar required replacements > k → window invalid, left se shrink karo.
     Valid window ki maximum length maxLength mein store karo.
     */
    public int characterReplacement(String s, int k) {
       
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0; 
        int maxLengthWindow = 0; int maxFreq = 0;
        int n = s.length();

        for(int i = 0;i <n; i++){
            char ch = s.charAt(i);// i --> right 
            
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            //finding maximum frequency from map
            maxFreq = Math.max(maxFreq, map.get(ch));
            

            while((i - left + 1) - maxFreq > k){
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;//shirinking from left;
            }
            // Current valid window
            maxLengthWindow = Math.max(maxLengthWindow, i - left + 1);
            
        }
       return maxLengthWindow;
    }
}
