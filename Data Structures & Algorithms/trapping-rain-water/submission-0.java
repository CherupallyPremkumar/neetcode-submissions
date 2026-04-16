class Solution {
    public int trap(int[] height) {
        int leftMax=0,rightMax=0;
        int left=0,right=height.length-1;
        int totalWater=0;

        while(left<right){
            leftMax=Math.max(leftMax,height[left]);
            rightMax=Math.max(rightMax,height[right]);
            //can i put loigic here
            if(height[left]<height[right]){
                totalWater+=Math.min(leftMax,rightMax)-height[left];
                left++;
            }else{
                totalWater+=Math.min(leftMax,rightMax)-height[right];
                right--;
            }
        }

        return totalWater;
    }
}
