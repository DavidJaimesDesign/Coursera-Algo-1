public class LinkedStackofStrings {
    private Node first = null;

    private class Node{
        String item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(String item){
        Node oldfirst = first;//this sets the old first value
        first = new Node();//this creates a new node that will be first
        first.item = item;//this sets the new nodes value
        first.next = oldfirst;//this sets the next value for the new first node to the old node
    }

    public String pop(){
        String item = first.item;
        first = first.next;
        return item
    }
}
