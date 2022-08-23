class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashSet<Integer> allNums = new HashSet<>();
        // for (int num : nums) {
            // allNums.add(num);
        // }
        // int firstIdx = 0;
        // int lastIdx = 0;
        // for (int i=0; i < nums.length(); i++) {
        //     int curr = nums[i];
        //     if (allNums.contains(target - curr)) {
        //         firstIdx = i;
        //         lastIdx = 
        //     }
        // }
        
        HashMap<Integer, List<Integer>> allNums = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            int curr = nums[i];
            
            if (allNums.containsKey(curr)) {
                List<Integer> existing  = allNums.get(curr);
                existing.add(i);
                allNums.put(curr, existing);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                allNums.put(curr, list);
            }
        }
        
        
        int firstIdx = 0;
        int lastIdx = 0;
        
        for (int i=0; i < nums.length; i++) {
            int curr = nums[i];
            int diff = target - curr;
            firstIdx = i;
            
            if (allNums.containsKey(diff) && curr != diff) {
                lastIdx = allNums.get(diff).get(0);
                allNums.get(diff).remove(0);
                break;
            } else if (allNums.containsKey(diff) && curr == diff && allNums.get(diff).size() > 1){
                allNums.get(diff).remove(0);
                lastIdx = allNums.get(diff).get(0);
                break;
            }
        }
        
        return new int[] {firstIdx, lastIdx};
        
        
    }
}

/*
Put all nums in a map/set
loop through array at each num if corresponding target-sum exist use  
Fail as we need the idxs of the elements



*/