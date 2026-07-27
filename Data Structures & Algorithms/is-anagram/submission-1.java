class Solution {
    public boolean isAnagram(String s, String t) {

      if(s.length() != t.length()) return false;

      HashMap<Character, Integer> map = new HashMap<>();

      for(char ch: s.toCharArray()){
        map.put(ch, map.getOrDefault(ch, 0) + 1);
      } 

      for(char ch: t.toCharArray()){
        if(!map.containsKey(ch)) return false;
        
        /* Updating frequency to -1 */
        map.put(ch, map.get(ch) - 1);

        /* If map empty means, no key, value present */
        if (map.get(ch) < 0) return false; 

      }

     return true;
    }
}
