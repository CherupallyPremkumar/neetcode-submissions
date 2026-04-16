class Solution {                                                                                                                                                                                                                               
      public int[] productExceptSelf(int[] nums) {                                                                                                                                                                                               
          int l = nums.length;                                                                                                                                                                                                                   
          int[] prefix = new int[l];                                                                                                                                                                                                             
          int[] suffix = new int[l];                                                                                                                                                                                                             

          //1,2,4,6

          //1,2,8,48                                                                                                                                                                                                          
          prefix[0] = 1;                                                                                                                                                                                                                         
          for (int i = 1; i < l; i++) {                                                                                                                                                                                                          
              prefix[i] = prefix[i - 1] * nums[i - 1];            
          }                               

          suffix[l - 1] = 1;                                                                                                                                                                                                                     
          for (int j = l - 2; j >= 0; j--) {
              suffix[j] = suffix[j + 1] * nums[j + 1];                                                                                                                                                                                           
          }                                                       

          int[] result = new int[l];                                                                                                                                                                                                             
          for (int k = 0; k < l; k++) {
              result[k] = prefix[k] * suffix[k];                                                                                                                                                                                                 
          }                                                       

          return result;                                                                                                                                                                                                                         
      }
  }                       