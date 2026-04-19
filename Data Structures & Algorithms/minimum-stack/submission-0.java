class MinStack {

    int[] stack;
    int[] order;
    int size;
    static Integer THREADSHOLD=10;

    public MinStack() {
        stack=new int[THREADSHOLD];
        order=new int[THREADSHOLD];
        size=0;
    }
    
    public void push(int val) {
        if(size == stack.length){
            THREADSHOLD*=2;
            stack = Arrays.copyOf(stack, THREADSHOLD);
            order = Arrays.copyOf(order, THREADSHOLD);
        }
        stack[size]=val;
        
        this.setMin(size,this.stack,val,this.order);
        size++;
    }

    private void setMin(int size, int[] stack,int val,int[] order){
        if(size==0){
            order[size]=val;
        }else {
            order[size] = Math.min(val, order[size - 1]);
        }
    }
    
    public void pop() {
            size--;
    }
    
    public int top() {
          return stack[size - 1];
    }
    
    public int getMin() {
        return order[size - 1];
    }
}
