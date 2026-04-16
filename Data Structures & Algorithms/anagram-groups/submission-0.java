class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       List<List<String>> response=new ArrayList<>();
       if(strs.length==0) return response; //empty
       HashMap<String,List<String>> count=new HashMap<>(); 
       for(String s: strs)
       { 
         char[] c=s.toCharArray();
         Arrays.sort(c);
         String str=new String(c);
         if(!count.containsKey(str)){
             count.put(str,new ArrayList<>(List.of(s)));
         }else{
            count.get(str).add(s);
         }
       }
       
        response.addAll(count.values());
    
       return response;
    }
}
