class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        
        //Simply adding unique value in the SET 
        for(int i = 0; i<n; i++) set.add(nums[i]);

        /* Logical notes - Good Question
           Pehle Set banao taaki kisi number ko quickly check kar sako.
           Har number ko dekho: kya iska previous number (num - 1) Set mein hai?
           Agar previous nahi hai → yahi sequence ka START hai.
           Ab num + 1 se aage badho aur jab tak number milta rahe, length count karo.
           Agar previous hai → skip, kyunki sequence already pehle wale number se start ho chuki hai.
           End mein sabse badi sequence length return karo.
        */

       // Now in out set input would be like this --> [2,20,4,10,3,5], means no duplicate
       int start = 0;
       int longestConsutive = 0;
       for(int num: nums){
          int current = num;
          if(!set.contains(current - 1)){
            int length =1;
            while(set.contains(current + 1)){
                length++;
                current++;
            }
            longestConsutive = Math.max(longestConsutive, length);
          }  
       }
        return longestConsutive;
    }
}
