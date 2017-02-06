import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;
import edu.princeton.cs.algs4.StdRandom;


public class RandomizedQueue<Item> implements Iterable<Item> {
    private int size;
    private  Item[] queue;
    
    private class RandomizedQueueIterator implements Iterator<Item>  {
      private int current = 0;
      private int[] shuffledIndexes = new int[size];
        
      public boolean hasNext() {
        if(current == 0){
          for(int i = 0; i < size; i++){
            shuffledIndexes[i] = i;
            StdRandom.shuffle(shuffledIndexes);
          }
        }
        return current < size;
      }
      
      public Item next(){
        if(current == 0){
          for(int i = 0; i < size; i++){
            shuffledIndexes[i] = i;
            StdRandom.shuffle(shuffledIndexes);
          }
          if(current >= size || size() == 0) throw new java.util.NoSuchElementException();
        }
        return queue[shuffledIndexes[current++]];
      }
      public void remove(){
        throw new java.lang.UnsupportedOperationException();
      }
    }
    private void capIncrease(){
      int newCap = queue.length * 2;
      //System.out.println(newCap);
      Item[] newQueue = (Item[]) new Object[newCap];
      int index = 0;
      for(Item i : queue){
        newQueue[index++] = i;
      }
      this.queue = newQueue;
    }
    
    private void capDecrease(){
      int newCap = queue.length/4;
      Item[] newQueue = (Item[]) new Object[newCap];
      for(int i = 0; i < size(); i++){
        newQueue[i] = queue[i];
      }
      
      this.queue = newQueue;
    }
    
    public RandomizedQueue(){                 // construct an empty randomized queue
        this.size = 0;
        this.queue = (Item[]) new Object[1];
    }

    public boolean isEmpty(){                 // is the queue empty?
        return size == 0;
    }

    public int size(){                        // return the number of items on the queue
        return this.size;
    }

    public void enqueue(Item item){           // add the item
       if(item == null) throw new NoSuchElementException();
       if(size + 1 > queue.length){
         capIncrease();
       }
       queue[size++] = item;
    }

    public Item dequeue(){                    // remove and return a random item
      if(size == 0) throw new NoSuchElementException();
      int i = StdRandom.uniform(size);
      Item ret = queue[i];
      queue[i] = queue[--size];
      queue[size] = null;
      if(queue.length/4 > size){
        capDecrease();
      }
      
      return ret;
    }
    public Item sample(){                     // return (but do not remove) a random item
      return queue[StdRandom.uniform(size)];
    }
    public Iterator<Item> iterator(){         // return an independent iterator over items in random order
        return new RandomizedQueueIterator();
    }
    public static void main(String[] args){   // unit testing (optional)
    }
}
