class Solution {
    public int evalRPN(String[] tokens) {
        int l=tokens.length;
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<l;i++){
                switch(tokens[i]){
                     case "+":
                            stack.push(stack.pop() + stack.pop());
                      break;
                      case "-":
                           int b = stack.pop(); // The second operand
                           int a = stack.pop();  
                            stack.push(a - b);
                      break;
                      case "*":
                             stack.push(stack.pop() * stack.pop());
                      break;
                      case "/":
                           int divisor = stack.pop(); // The second operand
                           int dividend = stack.pop();  
                            stack.push(dividend / divisor);
                      break;
                      default:  
                          stack.push(Integer.parseInt(tokens[i]));
                        break;
                }
            }
        return stack.peek();
    }

}
