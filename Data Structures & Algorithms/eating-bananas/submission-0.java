class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         
        int max = max(piles);

        int left = 1, right = max;

        int min = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            int hours = findHours(piles, mid);
            
            min = Math.min(min, hours);
            if(hours > h){
                left = mid + 1;
            }else{
                right= mid - 1;
            }
        }
      return left;
    }

   private int max(int[] piles){
      int max = Integer.MIN_VALUE;
        for(int pile : piles){
            max = Math.max(max, pile);
        }
        return max;
    }
   private int findHours(int[] piles, int k){

        int hours = 0;

        for(int pile : piles){

            hours += (pile + k - 1) / k;

        }

        return hours;

    }
}
