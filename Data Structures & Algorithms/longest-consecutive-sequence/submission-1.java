class Solution {
    public int longestConsecutive(int[] nums) {
      if(nums.length==0) return 0;         
      HashSet<Integer> set=new HashSet<>();
      for(int i:nums) 
         set.add(i);
  
      int longest=0;
      for(int num:nums){
        int currNum=num;
        if(set.contains(currNum-1)) continue;
        int length=1;
        while(set.contains(currNum+1)){
          currNum+=1;
          length+=1;
        }
        longest=Math.max(longest,length);
      }
      return longest;
    }
}
