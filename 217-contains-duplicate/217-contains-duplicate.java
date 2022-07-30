class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        
        for (int i =0; i < nums.length; i++) {
            int current = nums[i];
            if (numCountMap.containsKey(current)) {
                return true;
            } 
            numCountMap.put(current, 0);
        }
        
        return false;
    }
}