#Geometric BST applivations

. we are going to be talking about geometric objects not just keys and values
. how many points in the rectangle?

applications : CAD, Games, movies, VR, DBs

Efficent solutions: BSTs and extensions

##1d range search
. extension of the ordered symbol table
. we have only one key and the value assosiated
Things we want:
. Range search
. Range count

###implementation
unordered array
. not a good idea 

ordered array
. slow insert binary search for k1 and k2 to do range search
. slightly better

Our goal is time proportional to Log N
###BST implementation
. How many keys between lo and hi?
. we can use a rank tree
```
public int size(Key lo, Key hi){
    if(contains(hi)) return rank(hi) - rank(lo) + 1;
    else return rank(hi) - rank(lo);
}
```

do the practice problems!

## Line Segment Intersection

. Orthogonal line legment intersection search
. we could use a quadratic algo and have lower performanve
###sweep line algorithim
. we consider each x coordinate as an event
. we add the y coordinates into a binary search tree
. when we hit the end point remove the y from the bst
. when we hit a vertical line segment run a range search
. N log N + R

##KD trees whats your kd bro?

. we extend the api to 2d keys
. the keys are points in the plane
. this is just like the homework?

###grid implementation
. divide space into m by m grid
. not efficient at all M^2 + N for space
. 1 + N/M^2 
. most efficient is m = sqrt(N)
. ideal for randomly distributed
. constant time for range 
. sucks at clustering
. need a data structure that adapts well to the data
. example a gird implementation for the population density of the US
. typical in geometric data
. 2d tree, quadtree, bsp tree
. Doom is possible through space partitioning trees

##2d tree construction
. recursrively partion plane into two halfplanes
. start by partitioning from the veritcal then to the horizontal
. alternate between verical and horizontal through the partitioning

###range search for a 2d tree
. check if all points in a query axis-aligned rectangle
. recursively search left/bottom 
. recursively search right/top
###analysis
. typical case = R + Log N
. worst case is = R + sqrt(N)
##nearest neighbor search
. check the distance from poin in node to the query point
. recursively search left/bottom
. recursively search right/top
. sometimes you look at both subtrees but eventaully we only need to look at one
###analysis
.typical case = log N
.worst case = N
example:
. birds flocking
. use 3 simple rules to simulate it 
##KD tree
. recursively partitioning k-dimensional space into 2 half spaces
. BST but cycle through dimensions ala 2d treess
. discovered by an undergrad in an algorithm course!
. simple ideas solve complex problems
example N-body simulation:
    . simulate n particles mutually affected by gravity
    . galaxies colliding
    . you could brute force it but you would be very sad
    . another undergrad discovered this idea

#Interval Search Trees
. instead of points our data is in intervals
. insert an interval
. search for an interval
. delete an interval
##construction
. interval instersection query
. use one of teh endpoints as a key for the BST
. store the largest value in the nodes as well
##insertion 
. do a bst insertion
. for everynode that we encouter we need to check the maxes of each node
##search
. look to see if we have an intersection
. if intersect return it
. else if left subtree is null go right
. else if max endpoint in left tree is less then lo go right
. else go left
we havent done implementation lately sneaky sneak
. use a red-black bst to guarantee performance Log N

#Rectangle intersection Problem
. find all intersections among a set of N orthogonal rectangles
. brute force invovles checking every pair
. all x and y are distinct
. microprocessor design designing a computer was a geometric problem
. it helped for debugging 
. you cant use quadratic algos because it can take days
. XEROX PARC literally saved the day

##sweep line algo
. sweep a vertical line from left to right
. use the y coords and sweep then do range searches 
. NlogN + RLogN
. reduces it to a 1d interval search
. enabled progress in computer design

