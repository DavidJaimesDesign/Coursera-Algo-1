public static int partition(Comparable[] a, int lo, int hi){
    int i = lo;
    int j = hi + 1;
    wile(true){
        while(less(a[++i], a[lo])){
            if( i == hi) break;
        }
        while(less(a[lo], a[--j])){
            if( j == lo) break;
        }

        if( i >= j ) break;
        exch(a, i, j)
    }

    exch(a, lo, j);
    return j;
}



