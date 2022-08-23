class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> allNums = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            int curr = nums[i];
            int diff = target - curr;
            
            if (allNums.containsKey(curr)) {
              return new int[]{ allNums.get(curr), i};
            } else {
                allNums.put(diff, i);
            }
        }
        
        return new int[] {};
    }
    
    public int[] twoSumBadRuntime(int[] nums, int target) {
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
Take 1
Put all nums in a map/set
loop through array at each num if corresponding target-sum exist use  
Fail as we need the idxs of the elements

Take 2
Put all nums in a map<Int, List<Int>>
Fail - inefficient time complexity as we need to remove from the list in the map for duplicates

Take 3
Loop through the array and place the difference in the map with the current element position.
if 


*/