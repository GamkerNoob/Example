public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private static int RFACTOR = 2;
    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
    }
    public void addFirst(T item){
        if(size == items.length){
            resize(size * RFACTOR);
        }
        T[] a = (T []) new Object[items.length];
        System.arraycopy(items,0,a,1,size);
        items = a;
        items[0] = item;
        size += 1;
    }
    public void addLast(T item) {
        if(size == items.length){
            resize(size * RFACTOR);
        }
        items[size] = item;
        size += 1;
    }
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }
    private T getLast() {
        return items[size - 1];
    }
    private T getFIrst(){
        return items[0];
    }
    public T get(int index) {
        if(index >= size){
            return null;
        }
        return items[index];
    }
    public int size() {
        return size;
    }
    public T removeFirst(){
        if(this.isEmpty()){
            return null;
        }
        T x = getFIrst();
        size -= 1;
        if(this.too_many_free()){
            resize(size / 2);
        }
        return x;
    }
    public T removeLast() {
        if(this.isEmpty()){
            return null;
        }
        T x = getLast();
        size -= 1;
        if(this.too_many_free()){
            resize(size / 2);
        }
        return x;
    }
    private void resize(int size0){
        T[] a = (T []) new Object[size0];
        System.arraycopy(items,0,a,0,this.size);
        items = a;
    }
    private boolean too_many_free(){
        double x = size / items.length;
        if(x < 0.25){
            return true;
        }
        return false;
    }
    public void printDeque(){
        while(size != 0){
            size -= 1;
            System.out.print(items[size-1]);
        }
        System.out.print(items[0]);
    }
}
