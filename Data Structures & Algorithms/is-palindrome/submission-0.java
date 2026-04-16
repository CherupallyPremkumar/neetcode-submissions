class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0 || s.length()==1) return true;

        int left=0,right=s.length()-1;
        System.out.println(right);

        while(left<right){
    
            while(left<right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
                System.out.println(left);
            }

            while(left<right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
                System.out.println(right);
            }
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
