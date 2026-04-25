class Solution {
    public int search(int[] nums, int target) {
     //   -1 0 2 4 6 8 . 3
     //.   |     |   | 
        int left=0,right=nums.length;
        while(left < right){
            int mid = (right + left) / 2;
            if(nums[mid]==target) return mid;
            else if(nums[mid] > target) right = mid;
            else left = mid + 1;
        }   
        return -1; 
    }
}
