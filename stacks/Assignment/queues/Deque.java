import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
   private int size;
   public Deque() {                           // construct an empty deque
       this.size = 0;
   }
   public boolean isEmpty() {                // is the deque empty?
       return size == 0;
   }
   public int size() {                      // return the number of items on the deque
       return size;
   }
   public void addFirst(Item item) {         // add the item to the front
       if(item == null) throw new NoSuchElementException();
       this.size++;
   }
   public void addLast(Item item) {           // add the item to the end
       if(item == null) throw new NoSuchElementException();
       this.size++;
   }
   public Item removeFirst() {               // remove and return the item from the front
       if(size == 0) throw new NoSuchElementException();
       this.size--;
       return item;
   }
   public Item removeLast() {               // remove and return the item from the end
       if(size == 0) throw new NoSuchElementException();
       this.size--;
       return item;
   }
   public Iterator<Item> iterator() {        // return an iterator over items in order from front to end
   }
   public static void main(String[] args) {  // unit testing (optional)
   }
}
