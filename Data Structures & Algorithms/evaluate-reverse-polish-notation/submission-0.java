class Solution {
    public int evalRPN(String[] tokens) {
        int l=tokens.length;
        Stack<Integer> stack=new Stack<>();

        String rpn="-+*/";
        for(int i=0;i<l;i++){
            if(!rpn.contains(tokens[i])){
                 stack.push(Integer.parseInt(tokens[i]));
                 continue;
            }
                int b = stack.pop(); // The second operand
                int a = stack.pop(); 
                switch(tokens[i]){
                     case "+":
                            stack.push(a + b);
                      break;
                      case "-":
                            stack.push(a - b);
                      break;
                      case "*":
                             stack.push(a * b);
                      break;
                      case "/":
                            stack.push(a / b);
                      break;
                      default:   
                }
                
            }
        return stack.peek();
    }

}
