package Lecture_practice_problems._57_HashMaps_and_HashTable;

public class HashUsingMap{
    private Entity [] entities;
    public HashUsingMap(){
        entities = new Entity[100];
    }
    public void put(String key, int value){
        int hash=Math.abs(key.hashCode()%entities.length);
        entities[hash] = new Entity(key,value);
    }
    public int get(String key){
        int hash=Math.abs(key.hashCode()%entities.length);
        if(entities[hash] != null && entities[hash].key.equals(key)){
            return entities[hash].value;
        }
        return 0;
    }
    public void remove(String key){
        int hash=Math.abs(key.hashCode()%entities.length);

        if(entities[hash] != null && entities[hash].key.equals(key)){
            entities[hash]=null;
        }
    }
    private static class Entity{
        String key;
        int value;

        public Entity(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Entity entity = new Entity("subas",36);
        String name= entity.key;
        System.out.println(name instanceof String);
    }

}
