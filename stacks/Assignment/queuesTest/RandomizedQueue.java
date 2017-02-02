import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;


public class RandomizedQueue<E> implements Iterable<E> {
    private int size;
    private E[] queue;
    private int capacity;
    
    private class RandomizedQueueIterator implements Iterator<E>  {
      E current = queue[size];
      
      public boolean hasNext(){
           return current != null;
       }
       
       public void remove(){
           throw new UnsupportedOperationException();
       }
       
       public E next(){
           if(!hasNext()) throw new NoSuchElementException();
           int random = StdRandom.uniform(size());
           return queue[random];
       }
    }
    
    private void capIncrease(){
      int newCap = capacity * 2;
      E[] newQueue = (E[]) new Object[newCap];
      for(int i = 0; i < size(); i ++){
        newQueue[i] = queue[i];
      }
      
      queue = newQueue;
    }
    
    private void capDecrease(){
      int newCap = capacity/4;
      E[] newQueue = (E[]) new Object[newCap];
      for(int i = 0; i < size(); i++){
        newQueue[i] = queue[i];
      }
      
      queue = newQueue;
    }
    
    public RandomizedQueue(){                 // construct an empty randomized queue
        this.size = 0;
        this.capacity = 0;
        this.queue = (E[]) new Object[capacity];
    }

    public boolean isEmpty(){                 // is the queue empty?
        return size == 0;
    }

    public int size(){                        // return the number of items on the queue
        return this.size;
    }

    public void enqueue(E item){           // add the item
       if(item == null) throw new NoSuchElementException();
    }

    public E dequeue(){                    // remove and return a random item
      if(size == 0) throw new NoSuchElementException();
      return queue[0];
    }
    public E sample(){                     // return (but do not remove) a random item
      return queue[StdRandom.uniform(size)];
    }
    public Iterator<E> iterator(){         // return an independent iterator over items in random order
        return new RandomizedQueueIterator();
    }
    public static void main(String[] args){   // unit testing (optional)
    }
}
