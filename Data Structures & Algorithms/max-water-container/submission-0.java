class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int max=0;
       // 0 1 2 3 4 5 6 7
        //1,7,2,5,4,7,3,6
      //  |             | 
        while(left<right){
            int minValue=Math.min(height[left],height[right]);
            int diff=right-left;
            max=Math.max(minValue*diff,max);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
