package Lecture_practice_problems._61_HuffmanCoder;

public class Main {
    public static void main(String[] args) throws Exception{
        String message = "subas";
        HuffmanCoder huffmanCoder = new HuffmanCoder(message);
        String encoded= huffmanCoder.encode(message);
        System.out.println(encoded);
        System.out.println(huffmanCoder.decode(encoded));
    }
}
