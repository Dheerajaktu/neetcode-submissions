class Solution {
    /* 
    Firstly I Thouht:: I thought simple I will find length of input is length is even means pair is valid else not valid. But i failed here. it didn't work.
    
    Second thought :: 

    
    */
    public boolean isValid(String s) {
        int len = s.length();
        if (s.length() % 2 != 0) return false;
        
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }else{
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(ch == ')' && top != '(') return false;

                if(ch == '}' && top != '{') return false;
                
                if(ch == ']' && top != '[') return false;
            }
        }
      return stack.isEmpty(); 
    }
}
