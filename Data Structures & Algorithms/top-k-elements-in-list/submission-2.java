class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer,Integer> freq=new HashMap<>();
       int len=nums.length;

       for(int i=0;i<len;i++){
        int value=nums[i];
        if(freq.containsKey(value)){
            freq.put(value,freq.get(value)+1);
        }else{
          freq.put(value,1);  
        }
       }
       List<Integer> result=new ArrayList<>(freq.keySet());
       result.sort((a, b) -> freq.get(b) - freq.get(a));

       int[] output = new int[k];
       for(int i = 0; i < k; i++) {
           output[i] = result.get(i);
       }
       return output;
    }
}
