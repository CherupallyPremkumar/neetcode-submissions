class Solution {

    public String encode(List<String> strs) {
        //str1 str2  
        StringBuilder strB=new StringBuilder();
        for(String s: strs){
            int len=s.length();
            strB.append(len+"#"+s);
        }
        return strB.toString();
    }

    public List<String> decode(String str) { 
        List<String> result=new ArrayList<>();
        int len=str.length(); 
        //22#bsajdbsakjdbsakdsadsadksandkjas10#kckkdsakdna
        for(int i=0;i<len;){
           StringBuilder s=new StringBuilder();
           while('#'!=(str.charAt(i))){
               s.append(str.charAt(i));
               i++;
           }
           i++;
           int strLen=Integer.parseInt(s.toString());
           result.add(str.substring(i,i+strLen));
           i+=strLen;
        }
        return result;
    }
}
