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
    public T getLast() {
        return items[size - 1];
    }
    public T getFIrst(){
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
    public void resize(int size){
        T[] a = (T []) new Object[size];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }
    public boolean too_many_free(){
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
