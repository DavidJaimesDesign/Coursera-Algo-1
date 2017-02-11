import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Comparator;
//I don't know if iterator, comparator, or comparable should be imported?

public class PointTest {
  @Test
  public void testSystemReady(){
    boolean yolo = true;
    assertTrue(yolo);
  }
  
  @Test
  public void pointConstructorWorks(){
    Point p = new Point(2, 3);
    assertNotNull("Point should not be null", p);
  }
  
  @Test
  public void slopeToNoDivideZeroNotZero(){
    Point p1 = new Point(1,1);
    Point p2 = new Point(3,9);
    Point p3 = new Point(9,27);
    Point p4 = new Point(4,4);
    
    assertEquals("Slope should be",p1.slopeTo(p4), 1.0, 0.001);
    assertEquals("Slope should be",p2.slopeTo(p3), 3.0, 0.001);
  }
  
  @Test 
  public void slopeToInfinites(){
    Point p1 = new Point(1,1);
    Point p2 = new Point(1, 10);
    
    assertEquals("Slope should be positive infinity", p1.slopeTo(p2), Double.POSITIVE_INFINITY, 0.001);
    assertEquals("Slope should be negative infinity", Double.NEGATIVE_INFINITY,p2.slopeTo(p1), 0.001);
  }
  
  @Test
  public void slopeToZeroSlope(){
    Point p1 = new Point(1,1);
    Point p2 = new Point(4,1);
    
    assertEquals("Slope should be positive 0", p1.slopeTo(p2), 0.0, 0.001);
    assertEquals("Slope should be positive 0", p2.slopeTo(p1), 0.0, 0.001);
  }
  
  @Test
  public void compareToTest(){
    Point p1 = new Point(1,1);
    Point p2 = new Point(3,1);
    Point p3 = new Point(2,4);
    Point p4 = new Point(1,1);
    
    assertEquals("Should return -1",  -1,  p1.compareTo(p3));
    assertEquals("Should return 0",   0,   p1.compareTo(p4));
    assertEquals("Should return 1",   1,   p3.compareTo(p1));
  }
  
  @Test
  public void slopeOrderNoZeroNoInfinity(){
    Point p1 = new Point(1,1);
    Point p2 = new Point(4,4);
    Point p3 = new Point(2,8);
  }
  
  @Test 
  public void slopeOrderWithZero(){
  }
  
  @Test
  public void slopeOrderWithInfinity(){
  }
}
