//test
import org.junit.Test;//import test class
import static org.junit.Assert.*;//import assert methods
import java.util.Iterator;//import iterator

public class RandomizedQueueTest {
    @Test
    public void testrandonQueue_basic_creation(){
        RandomizedQueue d = new RandomizedQueue();//initialize a new deque isntance
        assertTrue(d.isEmpty());//assert that d is empty
        d.enqueue(2);//add to the first in d
        assertFalse(d.isEmpty());//assert that d is not empty
        assertEquals(1, d.size());//test if size works 
    }

    @Test
    public void add_elements_then_deque_random_remove(){
         RandomizedQueue r = new RandomizedQueue();
         for(int i = 0; i < 10; i++){
           r.enqueue(i);  
         }
         assertEquals(10, r.size());//checks the size of the queue
         
         r.dequeue();
         assertEquals(9, r.size());//checks that the queue has had an item deleted
         
    }
    @Test
    public void test_sample(){
      RandomizedQueue r = new RandomizedQueue();
         for(int i = 0; i < 10; i++){
           r.enqueue(i);  
         }  
         
      r.sample();
      assertEquals(10, r.size());//checks to make sure sample did not delete a random feature
    }
    
    
    @Test
    public void testIterator(){

    }
    @Test(expected=java.util.NoSuchElementException.class)
    public void testDequeueOnEmpty(){
        RandomizedQueue r = new RandomizedQueue();
        r.dequeue();
    }

    @Test(expected=java.util.NoSuchElementException.class)
    public void testEnqueuesWithNull(){
        RandomizedQueue r = new RandomizedQueue();
        r.enqueue(null);
    }
}

