import org.junit.Test;//import test class
import static org.junit.Assert.*;//import assert methods
import java.util.Iterator;//import iterator

public class dequeTest {
    @Test
    public void testDeque(){
        Deque<Double> d = new Deque<Double>();//initialize a new deque isntance
        assertTrue(d.isEmpty());//assert that d is empty
        d.addFirst(2.0);//add to the first in d
        assertFalse(d.isEmpty());//assert that d is not empty
        assertEquals(1, d.size());//test if size works 
    }

    @Test
    public void testAddFirstRemoveAndRepeat(){
        Deque<Double> d = new Deque<Double>();// new deque
        d.addFirst(1.0);
        assertEquals(Double.valueOf(1.0),d.removeFirst());
        d.addLast(2.0);
        assertEquals(Double.valueOf(2.0),d.removeLast());

        d.addFirst(3.0);
        assertEquals(Double.valueOf(3.0),d.removeLast());
        d.addLast(4.0);
        assertEquals(Double.valueOf(4.0),d.removeFirst());
    }

    @Test
    public void testIterator(){
        Deque<Double> d = new Deque<Double>();
        for(Double i = 0d; i < 10; i++){
            d.addLast(i);
        }

        int i = 0; 
        for(Double cur: d){
            System.out.println(i);
            assertEquals(Double.valueOf(i), Double.valueOf(cur));
            i++;
        }
        assertEquals(Double.valueOf(i), Double.valueOf(10));
    }
    @Test(expected=java.util.NoSuchElementException.class)
    public void testRemoveFirstOnEmpty(){
        Deque<Double> q = new Deque<Double>();
        q.removeFirst();
    }

    @Test(expected=java.util.NoSuchElementException.class)
    public void testRemoveLastOnEmpty(){
        Deque<Double> q = new Deque<Double>();
        q.removeLast();
    }

    @Test(expected=java.util.NoSuchElementException.class)
    public void testAddFirstWithNull(){
        Deque<Double> q = new Deque<Double>();
        q.addFirst(null);
    }

    @Test(expected=java.util.NoSuchElementException.class)
    public void testAddLastWithNull(){
        Deque<Double> q = new Deque<Double>();
        q.addLast(null);
    }
}

