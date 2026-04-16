class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result =new ArrayList<>();
        List<Integer> current=new ArrayList<>();

        findSubset(0,nums,current, result);
        return result;
        
    }

    void findSubset(int k,int[] nums,List<Integer> current, List<List<Integer>> result){
        
            result.add(new ArrayList<>(current));
           
        
        for(int i=k;i<nums.length;i++){
            current.add(nums[i]);
            findSubset(i+1,nums,current,result);
            current.remove(current.size()-1);
        }
        return;
    }
}
