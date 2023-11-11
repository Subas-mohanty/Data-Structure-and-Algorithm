package Lecture_practice_problems._54_FileHandling;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String name= scanner.next();
        System.out.println(name);

        // create
//        try {
//            File fo = new File("new-file.txt");
//            fo.createNewFile();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        // write in the file
//        try {
//            FileWriter fw = new FileWriter("new-file.txt");
//            fw.write("अधर्माभिभवात्कृष्ण प्रदुष्यन्ति कुलस्त्रिय: |\n" +
//                    "स्त्रीषु दुष्टासु वार्ष्णेय जायते वर्णसङ्कर:");
//            fw.close();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        // reading from a file
//        try (BufferedReader br = new BufferedReader(new FileReader("new-file.txt"))) {
//            while (br.ready()) {
//                System.out.println(br.readLine());
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        // create
//        try {
//            File fo = new File("random.txt");
//            fo.createNewFile();
//            if(fo.delete()) {
//                System.out.println(fo.getName());
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
