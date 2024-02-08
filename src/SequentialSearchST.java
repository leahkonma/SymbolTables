public class SequentialSearchST<Key, Value> implements SymbolTable<Key, Value>{

    private Node head;
    private int size;
    private class Node{
        Key key;
        Value value;
        Node next;

        //constructor
        public Node(Key key, Value value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public SequentialSearchST(){
        head = null;
        size = 0;
    }

    @Override
    public void put(Key key, Value val) {
        //if the key is not in the list, put it up front at the head
        //if the key is already in the list, replace the value in that node

        //loop through the nodes to check if key exists
        Node current = head;
        while (current != null){
            //key already exists
            if (key.equals(current.key)){
                current.value = val;
                size ++;
                return;
            }
            current = current.next;
        }

        //the key doesn't exist so create a new node and place at front
        head = new Node(key, val, head);
        size++;
    }

    /**
     * Returns the value paired with the given key.
     *
     * @param key
     */
    @Override
    public Value get(Key key) {
        Node current = head;

        while (current != null){
            //if the key exists
            if (current.key == key){
                return current.value;
            }
            current = current.next;
        }

        //key is not in the list
        return null;
    }

    /**
     * Returns the number of key-value pairs in the table.
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns an iterator that refers to all the keys
     * in the table.
     */
    @Override
    public Iterable<Key> keys() {
        return null;
    }
}
