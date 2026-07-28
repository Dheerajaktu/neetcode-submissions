class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        /*
         Core Logic :: Simply travse string one by one 
         then take single string at a time and convert that into char array 
         then sort char array the make again back to string 
         then check in map same key is not present in then 
         add into map and value as list.
        */

        for(String str: strs){
            char[] ch = str.toCharArray();

            Arrays.sort(ch);
            String key = new String(ch);

            map.putIfAbsent(key, new ArrayList<String>());
            map.get(key).add(str);


        }
        return new ArrayList<>(map.values());
    }
}
