class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //im trying new soluttion 
       HashMap<Integer,Integer> freq=new HashMap<>();
       for(int n=0;n<nums.length;n++){
        freq.put(nums[n],freq.getOrDefault(nums[n],0)+1);
       }

       List<Integer>[] buckets=new List[nums.length+1];
       
       for(var entry: freq.entrySet()){
        int key=entry.getKey();
        int value=entry.getValue();
        if(buckets[value]==null){
            buckets[value]=new ArrayList<>();
        }
        buckets[value].add(key);
       }

       int[] result=new int[k];
       int index =0;
       for(int i=buckets.length-1;i>=0;i--){
          if(buckets[i]!=null){
            for(int a: buckets[i]){
                result[index++]=a;
                if(index==k) return result;
            }
          }
       }
       return result;
    }

    //    List<Integer>[] buckets = new List[nums.length + 1];
    //    for(var entry : freq.entrySet()){
    //     int key= entry.getKey();
    //     int value=entry.getValue();
    //     if(buckets[value]==null){
    //         bucket[value]=new ArrayList<>();
    //     }
    //     buckets[value].add(key);
    //    } 

    //    List<Integer> result=new ArrayList<>(freq.keySet());
    //    result.sort((a, b) -> freq.get(b) - freq.get(a));

    //    int[] output = new int[k];
    //    for(int i = 0; i < k; i++) {
    //        output[i] = result.get(i);
    //    }
    //    return output;
    // }
}
