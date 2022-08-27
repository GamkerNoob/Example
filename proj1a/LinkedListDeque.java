public class LinkedListDeque<T> {
    private TNode sentinel;
    private int size;
    public class TNode{
        public TNode prev;
        public T item;
        public TNode next;
        public TNode(T i,TNode m,TNode n) {
            item = i;
            prev = m;
            next = n;
        }
        public TNode(){
            prev = null;
            next = null;
        }
    }
    public LinkedListDeque(){
        size = 0;
        this.sentinel = new TNode();
        this.sentinel.prev = this.sentinel;
        this.sentinel.next = this.sentinel;
    }
    public void addFirst(T item){
        size += 1;
        TNode p = new TNode(item,this.sentinel,this.sentinel.next);
        this.sentinel.next.prev = p;
        this.sentinel.next = p;
    }
    public void addLast(T item){
        size += 1;
        TNode p = new TNode(item,this.sentinel.prev,this.sentinel);
        this.sentinel.prev.next = p;
        this.sentinel.prev = p;
    }
    public T removeFirst(){
        if(this.isEmpty()) {
            return null;
        }
        T item0 = this.sentinel.next.item;
        this.sentinel.next.next.prev = this.sentinel;
        this.sentinel.next = this.sentinel.next.next;
        size -= 1;
        return item0;
    }
    public T removeLast(){
        if(this.isEmpty()) {
            return null;
        }
        T item0 = this.sentinel.prev.item;
        this.sentinel.prev.prev.next = this.sentinel;
        this.sentinel.prev = this.sentinel.prev.prev;
        size -= 1;
        return item0;
    }
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        return false;
    }
    public int size(){
        return this.size;
    }
    public T get(int index){
        if(index >= size){
            return null;
        }
        TNode p = this.sentinel;
        while(index != 0){
            p = p.next;
            index -= 1;
        }
        return p.next.item;
    }
    public T getRecursive(int index){
        if(index >= size - 1){
            return null;
        }
        TNode p = this.sentinel.next;
        return recHelper(index,p).item;
    }
    public TNode recHelper(int index,TNode node){
        if(index == 0){
            return node;
        }
        return recHelper(index - 1,node.next);
    }
    public void printDeque(){
        TNode p = this.sentinel;
        while(size != 0){
            size -= 1;
            p = p.next;
            System.out.print(p.item);
        }
    }
}
