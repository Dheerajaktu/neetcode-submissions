class Solution {

/*
    Pehle s1 ke har character ki frequency count karo.
    s2 mein s1.length() size ki fixed window rakho.
    Right se character add karo; window badi ho jaye to left wala character remove karo.
    Har window mein check karo: kya s1 aur current window ki character frequencies same hain?
    Same mil gaya → true; poori s2 check ho gayi → false.
    Remember: `Permutation mein order matter nahi karta, character ki frequency matter karti hai.**

For the 2 HashMap approach:

    Time Complexity: O(n)
    s2 ko ek baar traverse karte hain. HashMap comparison practically O(1) because characters limited hain (max 26 lowercase letters).
    Space Complexity: O(1)
    HashMaps mein maximum 26 characters store honge.

    Final: TC = O(n) | SC = O(1)

*/
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> freqMapS1 = new HashMap<>();
        HashMap<Character, Integer> freqMapS2 = new HashMap<>();
        int left = 0;

        for(char ch: s1.toCharArray()){
            freqMapS1.put(ch, freqMapS1.getOrDefault(ch, 0)+ 1);
        }

        for(int right = 0; right<s2.length(); right++){
            char ch = s2.charAt(right);

             // Add right character
            freqMapS2.put(ch, freqMapS2.getOrDefault(ch, 0) + 1);

            while(right - left + 1 > s1.length()){
                 char leftChar = s2.charAt(left);
                 freqMapS2.put(leftChar, freqMapS2.get(leftChar) - 1 );

                // Remove key if frequency becomes 0
                if (freqMapS2.get(leftChar) == 0) {
                    freqMapS2.remove(leftChar);
                }
                left++;
            }

             // Compare frequencies
            if (freqMapS1.equals(freqMapS2)) {
                return true;
            }

        }
        return false;
    }
}
