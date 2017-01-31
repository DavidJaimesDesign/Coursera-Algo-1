public class StackWithMax<E>{
    private Stack<E> stack = new Stack<E>;
    private Stack<E> stackMax = new Stack<E>;

    public void queue(E item){
        if(stack.empty()){
            stack.push(item);
            stackMax.push(item);
        } else {
            if(item > stackMax.peek()){
                stack.push(item);
                stackMax.push(item);
            }else{
                stack.push(item)
            }
        }
    }

    public void dequeue(){
        if(stack.peek() == stackMax.peek()){
            stack.pop();
            stackMax.pop();
        }else{
            stack.pop();
        }
    }

    public int stackMax(){
        return stackMax.peek();
    }
}
