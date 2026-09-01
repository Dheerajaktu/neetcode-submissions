class Solution {

/*
    Sabse pehle dekho: algorithm kaunsi extra data structure bana raha hai?
    int, long, boolean, few variables → memory fixed → O(1).
    Stack / Queue / Array / List / Map use ho raha hai → dekho maximum kitne elements store ho sakte hain.
    Agar max n elements store ho sakte hain → O(n).
    Agar sirf kuch fixed elements store hote hain, chahe input bada ho → O(1).
    Agar recursion hai → maximum recursion depth count karo.
    Input array ko normally count mat karo, kyunki woh already given hai.
    Output array ko usually auxiliary space se separate mention karo, depending on the convention being used.
    Worst case dekho, average case nahi.

    Expression normal maths jaisa nahi hai; operator numbers ke baad aata hai.
    Array ko left → right process karo.
    Number mile → stack mein push karo.
    Operator mile → stack se last 2 numbers nikalo.
    Pehla pop = right operand.
    Doosra pop = left operand.
    Calculation karo:
    + → left + right
    - → left - right
    * → left * right
    / → left / right
    Calculated result ko wapas stack mein push karo.
    End mein stack mein sirf final result bachega.
    Final answer = stack.peek().
*/


    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = tokens.length;

        for (int i = 0; i < n; i++) {
            String token = tokens[i];

            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                    int right = stack.pop(); 
                    int left = stack.pop();
                    int result;

                    if(token.equals("+")){
                        result = left + right;
                    }else if(token.equals("-")){
                        result = left - right;
                    }else if(token.equals("*")){
                        result = left * right;
                    }else{
                        result = left / right;
                    }
                    stack.push(result);

            } else {
                int num = Integer.parseInt(token);
                stack.push(num);
            }
        }
        return stack.peek();
    }
}
