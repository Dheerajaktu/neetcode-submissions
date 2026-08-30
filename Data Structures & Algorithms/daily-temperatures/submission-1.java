class Solution {
  /*
  Pattern: Monotonic Stack
    Har day ke liye future mein first warmer temperature find karna hai.
    Answer = warmer day index - current day index.
    Stack mein temperature nahi, index store karte hain.
    Stack mein woh days rehte hain jo warmer temperature ka wait kar rahe hain.
    Current temperature agar stack.peek() ke temperature se greater hai → us day ka answer mil gaya → pop().
    current - previousDay = kitne days wait kiya.
    Phir current day ko stack mein push() karo.
    Jo indexes end tak stack mein bach gaye → unke liye warmer day nahi mila → result 0.
  */

    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] result = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

         for (int current = 0; current < n; current++) {
            // case check if stack is not empty 
             while(!stack.isEmpty() && temperatures[current] > temperatures[stack.peek()]){
                int previousDay = stack.pop();
                result[previousDay] = current - previousDay;
             }
             stack.push(current);
        }
       return result;
    }
    
}
