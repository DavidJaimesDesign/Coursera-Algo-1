public class Merge {

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        assert isSorted(a, lo, mid); //precondition a[lo, mid] sorted
        assert isSorted(a, mid+1, hi); //precondition [mid+1, hi] sorted

        for(int k = lo; k <= hi; k++){
            aux[k] = a[k]
        }

        int i = lo;
        int j = mid + 1;
    
        for(int k = lo; k <= hi; k++){
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];  
        }
        assert isSorted(a, lo, hi);
    }
    
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){
        if (hi <= lo) return;//checks if we should return
        int mid = lo + (hi - lo)/2;//mid point
        sort(a, aux, lo, mid);//recursively call
        sort(a, aux, mid+1, hi);//recursively call
        merge(a, aux, lo, mid, hi);//merge return values
    }

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }
}
