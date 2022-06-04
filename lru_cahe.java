//https://leetcode.com/problems/lru-cache/
class Node{
    int key;
    int value;
    Node pre ;
    Node next;

public Node(int key , int value){
    this.key = key ;
    this.value = value;
}
}

class LRUCache {
    private HashMap<Integer, Node> map ;
    private int capacity , count;
    private Node head ,tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
          map = new HashMap<>();
          head = new Node(0,0);
          tail = new Node(0,0);
          head.next = tail;
          tail.pre = head;
          head.pre = null;
          tail.next = null;
          count=0;
    }
    public void deleteNode(Node n){
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }

    public void addToHead(Node n ){
        n.next = head.next;
        n.next.pre = n;
        n.pre = head;
        head.next = n;
    }

    public int get(int key) {
            if (map.get(key) != null) { 
            Node node = map.get(key); 
            int result = node.value; 
            deleteNode(node); 
            addToHead(node); 

            return result; 
        } 

        return -1; 

    }

    public void put(int key, int value) {

        if (map.get(key) != null) { 
            Node node = map.get(key); 
            node.value = value; 
            deleteNode(node); 
            addToHead(node); 
        } 
        else { 
            Node node = new Node(key, value); 
            map.put(key, node); 
            if (count < capacity) { 
                count++; 
                addToHead(node); 
            } 
            else { 
                map.remove(tail.pre.key); 
                deleteNode(tail.pre); 
                addToHead(node); 
            } 
        } 
}
}

