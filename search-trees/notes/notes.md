#2-3 Trees
.costs are quaranteed to be no greater then 2lnN
.The key here is to allow our trees to hold more then one key

2-node is one keyval pair and 2 links
3-node has two keyvals and 3 links right left and middle

.A perfectly balanced 2-3 tree is one where the null links are all the 
same distance from the route

##search a 2-3 tree
we compare against the keys and depending on equality then we make moves
.note for the 2 key values check if the value is less then if larger then if it is between the 2 key values

##insertion

###insertion into a 2 node
    . you could do the regular thing like with BSTs and add to the end 
    . OR you could do one better turn the 2-node into a 3-node
    . add another key value

###insertion into a 3 node
    . temp create a 4node with 3 keysvals with the values in order
    . then create 2nodes out of the middle and have left and right be the nodes 

###insert into a 3-node whose parent is a 2-node
    . add a new key to the 3-node to create temp 4 node
    . move middle key in the 4-node into the parent
    . repeat up the tree as necessary
    . if you reach the root and it's a 4-node, split it into three 2 nodes
    . the only time the height of the tree increases is from condition above

###considerations about splitting a 4 node
    . it is a local transformation
    . constant number of operations

##global properties of a 2-3 tree

    . Always have symetric order
    . Always have perfect balance
    . Because each transformation is symetric and maintains perfect balance
    . there are a set number of transformations so this is provable

###performance

    . in the worst case its lg N
    . best case is .63 lg N
    . this is for the height
    . every operation is a constant c lg n

###implementation?
    . we arent going into that in this course
    . it is a pain to implement
    . there are a ton of cases
    . there are easier ways


