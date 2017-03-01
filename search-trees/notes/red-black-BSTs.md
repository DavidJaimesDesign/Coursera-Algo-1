#Left leaning red-black BSTs
. sedgewick did a study on this and it was improved on later on
1. represent a 2-3 tree as a BST
2. use internal left leaning links as glue for 3-nodes

. any 2-3 tree can correspond to a red-black tree
. red links lean left
. everypath from root to a null link has the same number of black links

##Search implementation in red-black BSTs

public Val get(Key key){
    Node x = root;
    while( x != null){
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x = x.left;
        else if(cmp > 0) x = x.right;
        else if(cmp == 0) return x.vall
    }
    return null;
}

. it ignores the color or the link
. they dont need the colors but all benefit from the red colors 

##the red-black representation
```
private static final boolean RED = true;
private static final boolean BLACK = false;

private class Node{
    Key key;
    Value val;
    Node left, right;
    boolean color;
}

private boolean isRed(Node x){
    if (x == null) return false;
    return x.color == RED;
}
```

. adding a color bit to the Node class solves the implementation

##Elementary operations

###Left rotation 
```
private Node RotateLeft(Node h){
    assert isRed(h.right);
    Node x = h.right;
    h.right = x.left;
    x.left = h;
    x.color = h.color;
    h.color = RED;
    return x;
}
```

. Orients a temporarily right-leaning red link to lean left
. Invarients it maintains symmetric order and perfect black balance
. It needs to be a local operation that only affets the small part of the tree
. MAINTAINS THE SYMMETRIC ORDER AND MAINTAIN BLACK BALANCE

. paradoxicaly when we do some insertions we need to rotate to the right
. but we will rotate left to fix it

###Flip colors 

```
private void flipColors(Node h){
    assert !isRed(h);
    assert isRed(h.left);
    assert isRed(h.right);
    h.color = RED;
    h.left.color = BLACK;
    h.right.color = BLACK;
}
```
. This splits the 4 node
. and this is how you split a temp 4 node in red-bst
. maintains symetric order and balance

It's just like a regular tree but by adding red lines we can keep it nice
we can't have two links in a row

The key here is maintain the 2-3 equivalence with 

###Order of operations
1. do the std insertion and new link is red
2. rotate to balance the 4-node if needed
3. flip the colors to pass red link up one level
4. rotate colors to make lean left

you only really need 3 elementary operations

the rotation is an actal rotation!

##Java implementation
. the same code handles all of the cases
. we are always reducing on case to another more simpler case

```
private Node put(Node h, Key key, Value val){
    if( h == null) return new Node(key, val, RED);
    int cmp = key.compareTo(h.key);
    if (cmp < 0) h.left = put(h.left, key, val);
    else if(cmp > 0) h.right = put(h.right, key, val);
    else if(cmp == 0) h.val = val;

    if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);// lean left
    if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);// balance the 4 node
    if (isRed(h.left) && isRed(h.right)) flipColors(h);// split the 4-node

    return h;
}
```

. recursive implementation
. bottom up
. this way we dont have a ton of cases
. it used to be way more complex

####runthrough
. start by adding to the bottom and give it a red
. do our regular compares
. we need to do the practice problems in the book
. woah very cool

.the longest path cannot be more the twice as long as the shortest path

###Balance is LLRB trees
. is <= 2 lg N in the worst case
. never two red links in a row

###super cool stuff
. this was deved at xerox parc
. red becuase of the laser printers
. use the full algorithm dude!

