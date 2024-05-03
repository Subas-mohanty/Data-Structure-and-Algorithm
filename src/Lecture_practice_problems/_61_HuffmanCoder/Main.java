package Lecture_practice_problems._61_HuffmanCoder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
//        String message = "subas";
        System.out.println("Enter your message : ");
        Scanner sc = new Scanner(System.in);
        String message = sc.next();
        HuffmanCoder huffmanCoder = new HuffmanCoder(message);
        String encoded= huffmanCoder.encode(message);
        System.out.println(encoded);
        System.out.println(huffmanCoder.decode(encoded));
    }
}
