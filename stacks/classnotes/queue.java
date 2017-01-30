public calss LinkedQueueOfStrings {
    private Node first, last;

    private class Node{
        //same as stack of strings
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(String item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldLast.next = last
    }

    public String dequeue(){
        String item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        return item
    }
}
