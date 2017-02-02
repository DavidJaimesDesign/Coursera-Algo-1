import java.util.Iterator;
import java.util.NoSuchElementException;



public class RandomizedQueue<E> implements Iterable<E> {
    private int size;
    private Node head, tail;

    private class Node<E>{
        public Node<E> left, right;
        private final E item;

        public Node(E item){
            if(item == null) throw new NoSuchElementException();
        }   

        public void connectRight(Node<E> other){
            if(other == null) throw new NoSuchElementException();
            this.right = other;
            other.left = this;
        } 
    }

    private class RandomizedQueueIterator implements Iterator<E>  {
        Node<E> current = head;

        public boolean hasNext(){
            return current != null;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
       
        public E next(){
            if(!hasNext()) throw new NoSuchElementException();
            int random = StdRandom.uniform(this.size);
            E item = current.item;
            for(int i = 0; i < random; i++){
                E item = current.item;
                current = current.right;
            }
            
            return item;
        }
    }
    public RandomizedQueue(){                 // construct an empty randomized queue
        this.size = 0;
    }

    public boolean isEmpty(){                 // is the queue empty?
        return size == 0;
    }

    public int size(){                        // return the number of items on the queue
        return this.size;
    }

    public void enqueue(Item item){           // add the item
        if(item == null) throw new NoSuchElementException();
        Node<E> prevhead = head;
        Node<E> newhead  = new Node<E>(item);

        if(prevhead != null) {
            prevhead.connectRight(newhead);
        }else{
            tail = newhead;
        }

        head = newhead;
        this.size++;
    }

    public Item dequeue(){                    // remove and return a random item
        if(size == 0) throw new NoSuchElementException();
        Node<E> deleteVal = head.next();
        Node<E> right = deleteVal.right;
        Node<E> left  = deleteVal.left;
        
        if(deleteVal != tail){
            right.left = left;
            left.right = right;
        }else{
            deleteVal.left = null;
        }
        this.size--;

        return deleteval.item;
    }
    public Item sample(){                     // return (but do not remove) a random item
        return head.next();
    }
    public Iterator<Item> iterator(){         // return an independent iterator over items in random order
        return new RandomizedQueueIterator();
    }
    public static void main(String[] args){   // unit testing (optional)
    }
}
