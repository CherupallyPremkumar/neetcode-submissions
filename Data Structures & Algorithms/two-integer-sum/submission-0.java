class Solution {
    public int[] twoSum(int[] nums, int target) {
       int n=nums.length;
       HashMap<Integer,Integer> seen=new HashMap<>();
       for(int i=0;i<n;i++){
           int value=target-nums[i]; 
           if(seen.containsKey(value)){
            return new int[]{seen.get(value),i};
           }
           seen.put(nums[i],i);           
       } 
      return new int[2];
 }
}
