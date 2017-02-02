import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

public class Deque<E> implements Iterable<E> {
   private int size;
   private Node head,tail;
   
   private class Node<E>{
       public Node<E> left, right;
       private final E item;
       
       public Node(E item){
           if(item == null) throw new NoSuchElementException();
           this.item = item;
       }
       
       public void connectRight(Node<E> other){
           if(other == null) throw new NoSuchElementException();
           this.right = other;
           other.left = this;
       }
   }
   
   private class DequeIterator<E> implements Iterator<E> {
       private Node<E> current = head;
       
       public boolean hasNext(){
           return current != null;
       }
       
       public void remove(){
           throw new UnsupportedOperationException();
       }
       
       public E next(){
           if(!hasNext()) throw new NoSuchElementException();
           E item = current.item;
           current = current.right;
           return item;
       }
   }
   
   public Deque() {                           // construct an empty deque
       this.size = 0;
   }
   public boolean isEmpty() {                // is the deque empty?
       return size == 0;
   }
   public int size() {                      // return the number of items on the deque
       return size;
   }
   public void addFirst(E item) {         // add the item to the front
       if(item == null) throw new NoSuchElementException();
       Node<E> prevhead = head;
       Node<E> newhead  = new Node<E>(item);
       if(prevhead != null){
           prevhead.connectRight(newhead);
       } else {
           tail = newhead;
       }
       
       head = newhead;
       this.size++;
   }
   public void addLast(E item) {           // add the item to the end
       if(item == null) throw new NoSuchElementException();
       Node<E> prevtail = tail;
       Node<E> newtail  = new Node<E>(item);
       
       if(prevtail != null){
           newtail.connectRight(prevtail);
       } else {
           tail = newtail;
       }
       
       tail = newtail;
       this.size++;
   }
   public E removeFirst() {               // remove and return the item from the front
       if(size == 0) throw new NoSuchElementException();
       Node<E> prevhead = head;
       head = prevhead.left;
    
       if(head != null){
           head.right = null;
       } 
       
       this.size--;
       return prevhead.item;
   }
   
   public E removeLast() {               // remove and return the item from the end
       if(size == 0) throw new NoSuchElementException();
       Node<E> prevtail = tail;
       tail = prevtail.right;
           
       if(tail != null){
           tail.left = null;
       }
       this.size--;
       return prevtail.item;
   }
   
   public Iterator<E> iterator() {        // return an iterator over items in order from front to end
       return new DequeIterator();
   }
   public static void main(String[] args) {  // unit testing (optional)
   }
}
