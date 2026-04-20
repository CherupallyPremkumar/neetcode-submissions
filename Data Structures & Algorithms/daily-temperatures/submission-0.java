class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;  
        int[] result=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<n; i++){
            int currValue = temperatures[i];
            while( !stack.isEmpty() && currValue > temperatures[stack.peek()]){
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return result;
    }
}
