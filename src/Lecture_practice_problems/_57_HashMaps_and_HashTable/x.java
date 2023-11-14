package Lecture_practice_problems._57_HashMaps_and_HashTable;

public class x <K,V>{
//    private Entity[] entities;
    private Entity <K, V> [] entities;
    public x(){
//        entities = (Entity[]) new Object();
        entities = new Entity[100];
    }
    public void put(K key, V value){
        int hash=Math.abs(key.hashCode()%entities.length);
        entities[hash] = new Entity(key,value);
    }
    public V get(K key){
        int hash=Math.abs(key.hashCode()%entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)){
//            return (V)entities[hash].value; // when we don't specify the types at the time of array declaration , we have to explicitly declared the type like thi
            return entities[hash].value;
        }
        return null;
    }
    public K remove(K key){
        int hash=Math.abs(key.hashCode()%entities.length);
//        K removed=(K) entities[hash].key;
        K removed=entities[hash].key;
        if(entities[hash] != null && entities[hash].key.equals(key)){
            entities[hash].key=null;
        }
        return removed;
    }
    private static class Entity<K, V>{
        K key;
        V value;

        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public static void main(String[] args) {
            Entity<String, Integer> map = new Entity<>("subas",38);
            String name=map.key;
            System.out.println(name instanceof String );
        }
    }
}