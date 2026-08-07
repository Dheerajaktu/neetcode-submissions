class Solution {
    // TC:: O(s)
    // SC:: O(1) 

    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() -1;

        while(start < end){
            //case 1:: Skip non-alphanumeric characters from left
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
                continue;
            }
            //case 2:: Skip non-alphanumeric characters from right 
            if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
                continue;
            }
            //case 3:: checking if character are equal or not both side
            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                return false;
            } 
            start++;
            end--;
        }
        return true;
    }
}
