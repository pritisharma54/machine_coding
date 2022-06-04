//https://leetcode.com/problems/design-hashset/
class MyHashSet {
    /** Initialize your data structure here. */
    //https://www.youtube.com/watch?v=NrMaQL_4Npo
		LinkedList<Integer>[] set;
		public static int SIZE = 769;
		

    public MyHashSet() {
        	set = new LinkedList[SIZE];
    }
    
    public void add(int key) {
        int bucket = key % SIZE;
			if(set[bucket] == null) {
				set[bucket] = new LinkedList<>();
				set[bucket].add(key);
			}
			else {
                if(!set[bucket].contains(key))
				    set[bucket].add(key);
			}
    }
    
    public void remove(int key) {
        int bucket = key % SIZE;
			
			if(set[bucket] != null) 
                set[bucket].remove(Integer.valueOf(key));
			
		}
    
    
    public boolean contains(int key) {
            int bucket = key % SIZE;
			LinkedList<Integer> entry = set[bucket];
			
            return entry!=null&&entry.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
