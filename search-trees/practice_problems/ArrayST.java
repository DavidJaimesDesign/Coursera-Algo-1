public class ArrayST<Key, Value>{
    private static final int INIT_SIZE = 8;

    private Value[] vals; //symbol table values
    private Key[] keys; //symbol table keys
    private int n = 0; //number of elements in symbol table

    public ArrayST(){
        keys = (Key[]) new Object[INIT_SIZE];
        vals = (Value[]) new Object[INIT_SIZE];
    }
    
    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    private void resize(int capacity){
        Key[] tempk = (Key[]) new Object[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for(int i = 0; i < n; n++)
            tempk[i] = keys[i];
        for(int i = 0; i < n; n++)
            tempv[i] = vals[i];
        keys = tempk;
        vals = tempv;
    }
    
    //insert the key-value pair into the symbol table
    public void put(Key key, Value val){
        //deal with potensh dublicates
        delete(key);
        //double the size of arrays if necessary
        if(n >= vals.length) resize(2*n);

        vals[n] = val;
        keys[n] = key;
        n++;
    }

    public Value get(Key key){
        for(int i = 0; i < n; i++)
            if( keys[i].equals(key) return vals[i];
        return null;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key> ();
        for( int i = 0; i < n; i++)
            queue.enqueue(keys[i]);
        return queue;
    }

    public void delete(Key key){
        for(int i = 0; i < n; i++){
            if(key.equals(keys[i])){
                keys[i] = keys[n-1];
                vals[i] = vals[n-1];
                keys[n-1] = null;
                vals[n-1] = null;
                n--;
                if( n > 0 && n == keys.length/4) resize(keys.length/2);
                return;
            }
        }
    }
}

