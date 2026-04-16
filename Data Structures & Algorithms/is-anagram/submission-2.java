class Solution {
    public boolean isAnagram(String s, String t) {
      //brute force
    //  char[] charArray=s.toCharArray();
    //  char[] charArray2=t.toCharArray();
    //  Arrays.sort(charArray);
    //  Arrays.sort(charArray2);
    //  return Arrays.equals(charArray,charArray2);

     // best but not acceptable by google need more optminal
    //   if(s.length()!=t.length()) return false;
    //  HashMap<Character,Integer> countChar=new HashMap<>();

    //  for(char c: s.toCharArray()){
    //    countChar.put(c,countChar.getOrDefault(c,0)+1);
    //  }

    //  for(char c: t.toCharArray()){
    //    if(!countChar.containsKey(c)) return false;
    //    countChar.put(c,countChar.get(c)-1);
    //    if(countChar.get(c)==0) countChar.remove(c);
    //  }
    // return countChar.isEmpty();
    // }

    //
    if(s.length()!=t.length()) return false;
    int[] count=new int[26];
    for(int i=0;i<s.length();i++){
       count[s.charAt(i)-'a']++;
       count[t.charAt(i)-'a']--;
    }
    for(int c: count){
      if(c!=0) return false;
    }
   return true;
    }
}
