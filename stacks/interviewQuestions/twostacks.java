public class Queue<E> {
    private Stack<E> input = new Stack<E>;
    private Stack<E> output = new Stack<E>;

    public void queue(E item) {
        input.push(item);
    }

    public E dequeue(){
        if(output.isEmpty(){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }

        return output.pop();
    }
}
