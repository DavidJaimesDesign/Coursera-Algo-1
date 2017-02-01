//test
import org.junit.Test;//import test class
import static org.junit.Assert.*;//import assert methods
import java.util.Iterator;//import iterator

public class RandomizedQueueTest {
    @Test
    public void testrandonQueue_basic_creation(){
        RandomQueue<Int> d = new RandomQueue<Int>();//initialize a new deque isntance
        assertTrue(d.isEmpty());//assert that d is empty
        d.enqueue(2);//add to the first in d
        assertFalse(d.isEmpty());//assert that d is not empty
        assertEquals(1, d.size());//test if size works 
    }

    @Test
    public void add_elements_then_deque_random_remove(){

    }

    @Test
    public void testIterator(){

    }
    @Test(expected=java.util.NoSuchElementException.class)
    public void testDequeueOnEmpty(){

    }

    @Test(expected=java.util.NoSuchElementException.class)
    public void testEnqueuesWithNull(){

    }
}

