class Solution {
    public int trap(int[] height) {
        // int leftMax=0,rightMax=0;
        // int left=0,right=height.length-1;
        // int totalWater=0;

        // while(left<right){
        //     leftMax=Math.max(leftMax,height[left]);
        //     rightMax=Math.max(rightMax,height[right]);
        //     //can i put loigic here
        //     if(height[left]<height[right]){
        //         totalWater+=Math.min(leftMax,rightMax)-height[left];
        //         left++;
        //     }else{
        //         totalWater+=Math.min(leftMax,rightMax)-height[right];
        //         right--;
        //     }
        // }

        // return totalWater;
        int n=height.length;
        int totalWater=0;
        int[] prefix=new int[n];
        int[] sufix=new int[n];

        prefix[0]=height[0];
        for(int i=1;i<n;i++){
             prefix[i] = Math.max(prefix[i-1], height[i]);
        }

        sufix[n-1]=height[n-1];
        for(int j=n-2;j>=0;j--){
              sufix[j]= Math.max(sufix[j+1],height[j]);
        }

        for(int k=0;k<n-1;k++){
            int value=Math.min(prefix[k],sufix[k])-height[k];
            totalWater+=value;
        
        }
        return totalWater;
    }
}
