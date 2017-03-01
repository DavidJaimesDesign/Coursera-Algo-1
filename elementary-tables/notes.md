##ST test client for Analysis
use a frequency counter client

    1. takes command line arguments
    2. reads and updates frequency
    3. overrides old values with new value and updates frequency of occurance
    4. prints a string with the max freq.
    
    won't work well without an efficient table api

#Elementary Implementation

###not alot of detail
    1. we can create a linkedlist
    2. for search we have to scan through all keys same thing with insert
    3. if there is no match we can add it to the front

    possible to implement linked lists with duplicate keys but we are not gonna do dis

    note that the cost of implementing it: 
        n things are n/2 for search of random sorted
        n for insert
        search n
    We can use binary search to have a faster search time

    use an ordered array and parallel arrays

###get 
    check if empty
    
    problem with binary search is that when we add a value we have to move everything
    the nice thing is that binary search works with associative array because the keys
    are already ordered.

    time is Log N for search by implementing binary search
    works well for static datasets because the cost of insert is N/2
    we need efficient implementations fo both

#Advanced Implementations
.what if we want to know the min and max
.waht about iterating over all the keys in certain section
.generalized min or max
.find a key according to a selection
.closest time to x
.what is the first thing after x
.how many values after x

we can implement all of these efficiently

when keys are comporable we have a very wide interface

our implementations can use CompareTo this gives is a lot of things that we can do

we have ways to guarantee that all operations work efficiently

#Binary search tree
.binary tree in symmetric order
.either empty or two disjoint trees 

##symmertic order
.each node has a key
.larger than all keys in its left subtree
.smaller than all keys in its right subtree

###representation in Java?
.Node 
    . key and value
    . refernce to the right and left subtree

##search 
.if less go left, if greater go right if equal search is completed
.dynamic data structure

##insertion
.follow the same steps of search and when we hit a null value point replace with it

```
    public Value get(Key key){
        Node x = root;
        while(x != null){
            int cmp = key.compareTo(x.key)
            if (cmp < 0) x = x.left;
            else if(cmp > 0) x = x.right;
            else if(cmp == 0) return x.val;
        }
        return null;
    }
```
##recursive put
```
    public void put(Key key, Value val){
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val){
        if (x == null) return new Node(key, value);
        int cmp = key.compareTo(x.key)
        if(cmp < 0){
            x.left = put(x.left, key, val);
        }else if(cmp > 0){
            x.right = put(x.right, key, val);
        }else if(cmp == 0){
            x.val = val;
        } 
        return x;
    }
```
.the number of compare is going to depend on the order of the keys
.best case is when they are balanced
.ok case is sort of unbalanced
.worst case is when the keys come in natural order

.the length of the top to the bottom is usually pretty good
.the search and the put costs will be pretty low

##quick sort partiotioning and BST

.there is a direct correspondence 

##mathematical analysis
####Proposition
    .If N distince keys are inserted into a BST in random orfer the expected number
    of compares for a search/insert is ~2lnN 
    Pf. 1-1 correspondence with quicksort partitioning

####proposition
    .If N distict keys are inserted in random order expected hight is ~4.113lnN
####worst case
    .The time will be proportional to N
.The problem is that the client is the one adding them so we can add them randomly

##Ordered Operations in BSTs
    .min move left most
    .max move right most

    .floor the largest data key that is less then k
    ``` 
    public Key floor(Key key){
        Node x = floor(root, key);
        if(x == null) return null;
        return x.key
    }

    private Node floor(Node x, Key key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);

        if(cmp == 0) return x;
        if(cmp < 0) return floor(x.left, key);

        Node t = floor(x.right, key);
        if( t != null) return t;
        else return x;
    }
    ```
#Deletion in BST
.tombstones is common but it is unsatisfactory

###what about deleting the minimum
.remove the pointer to the minum and have it point to the right one 
.nothing points and caught by garbage collection

##Hilbard Deletion
.search for node that contains the key
.if no kids then just return null and update the counts
.if min or max return the link to the child if there are any
.problem when there are two children
    *find the next smallest node
    *delete the minimum and then move the t over 

.big problem is that it ends up being making the tree less balanced over time
.its a big issue and we still have not found a close one

delete is square root N time eventually everything becomes sqrt n time 
sad!


