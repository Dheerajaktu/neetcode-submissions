class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        //creating frequency map here
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        /*
        @Author:: Dheeraj!
        Now, we've frequency map but problem is here map doesn't guarentee of order -
        And questions is demanding most top frequent element means number which is -
        occures most so we need to use here something that will maintain order (asc or desc)
        for this scneario we will use PriorityQueue.
        NOTE - In java Heap is implemented by using PriorityQueue.
        so In java PriorityQueue gives defaul asc order means we need to sorting in desc order
        then we will able to find the most occurred elemt in the PQ. 
        */

        /* Note - in heap we will copare on the basis of frequency.
        */

        //Let's create PriorityQueue Here on the basis of frequency
        PriorityQueue<Map.Entry<Integer, Integer>> heap = 
                             new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        //Now we will keep only k elements in map rest will remove.
        //Basically, taking key and value both from map as entrySet().
        // values would be like this:: (1,3), (2,2) & (3,1)
        // Note - initially heap is []
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            heap.offer(entry);
            //putting check on the basis of K.
            if(heap.size() > k) heap.poll();
        }

        // NOTE - You can also simply add entire map into heap 
        // and like this :: addAll(map.entrySet());
        // But make sure whenver you're initliazing heap so you need to use desc order 
        // like b.getValue() - a.getValue() in constructor.
        // And in last simple store heap data into result array till kth length.
        

        // Preparing result here
        int result[] = new int[k];
        for(int i = k-1; i>=0; i--){
            result[i] = heap.poll().getKey();
        }

        return result;
    }
}
