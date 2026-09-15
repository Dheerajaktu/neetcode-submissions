class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
                Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n2 = nums2.length;

        //finding the NGE of nums2 
        for (int i = n2 - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                map.put(nums2[i], stack.peek());
            } else {
                map.put(nums2[i], -1);
            }
            stack.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}