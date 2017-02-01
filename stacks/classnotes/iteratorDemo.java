import java.util.*;
public class IteratorDemo{
    public static void main(String args[]){
        ArrayList al = new ArrayList();

        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");

        //use iterator to display contents of al
        System.out.print("Original contents of al: ")
        Iterator itr = al.iterator();

        while(itr.hasNext()){
            Object element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();

        //modify elements being iterated
        ListIterator list = al.listIterator();

        while(ltr.hasNext()){
            Object element = ltr.next();
            ltr.set(element + "+")
        }
        System.out.print("Modified the contents of al:")
        itr = al.iterator();

        while(itr.hasNext()){
            Object element = itr.next();
            System.out.print(element + " ");
        }
        System.out.println();
        //display the list backwards
        System.out.print("Modified list backwards: ")
        while(ltr.hasPrevious()){
            Object element = ltr.previous();
            System.out.print(element + " ")
        }
        System.out.println();

    }
}
