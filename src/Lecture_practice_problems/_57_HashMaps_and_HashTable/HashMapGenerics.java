package Lecture_practice_problems._57_HashMaps_and_HashTable;

import java.util.ArrayList;
import java.util.LinkedList;

//https://chat.openai.com/c/dc47807e-0edc-4aff-8f44-159c26f619ec
public class HashMapGenerics<K, V> {
    ArrayList<LinkedList<Entity>> list;

    private float loadFactor=0.5f;
    private int size=0;
    public HashMapGenerics(){
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>()); // initial size of the arraylist is 10 , which has 10 linked list in its 10 indices
        }
    }
    public void put(K key, V value){
        int hash=Math.abs(key.hashCode()% list.size());

        LinkedList<Entity> entities = list.get(hash);
        for (Entity entity: entities){
            if(entity.key.equals(key)){
                entity.value=value;
                return;
            }
        }
        if ((float) size / list.size()> loadFactor) {
            // resizing the list
            reHash();
        }
        entities.add(new Entity(key,value));
        size++;
    }
    private void reHash() {
        System.out.println("we are reharsing!");
        ArrayList<LinkedList<Entity>> old=list;
        list=new ArrayList<>();
        int size = 0;
        for (int i = 0; i < old.size() *2 ; i++) {
            list.add(new LinkedList<>());
        }
        for (LinkedList<Entity> entities: old){
            for (Entity entity: entities){
                put(entity.key,entity.value);
            }
        }

    }

    public V get(K key){
        int hash = Math.abs(key.hashCode()%list.size());
        LinkedList<Entity> entities = list.get(hash);
        for (Entity entity: entities){
            if(entity.key.equals(key)){
                return entity.value;
            }
        }
        return null;
    }
    public V remove(K key){
        int hash = Math.abs(key.hashCode()%list.size());
        LinkedList<Entity> entities = list.get(hash);
        for (Entity entity: entities){
            if(entity.key.equals(key)){
                V removed = entity.value;
                entity.value=null;
                return removed;
            }
        }
        return null;
    }
    public boolean containKey(K key){
        return get(key) != null;
    }
    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer(); // we can use StringBuilder also
        buffer.append("{");
        for(LinkedList<Entity> entities: list){
            for(Entity entity: entities){
                buffer.append(entity.key);
                buffer.append(" = ");
                buffer.append(entity.value);
                buffer.append(", ");
            }
        }
        buffer.append("}");
        return buffer.toString();
    }
    private class Entity{
        K key;
        V value;

        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
